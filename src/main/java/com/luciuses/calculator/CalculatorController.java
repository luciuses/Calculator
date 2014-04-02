package com.luciuses.calculator;

import service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.Operation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller

public class CalculatorController {

    private CalculatorService calculatorService;
// 
//initializing the logger
    private final static Log log = LogFactory.getLog(CalculatorController.class);

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
//@Controller

    @RequestMapping(value = "/calculator.htm", method = RequestMethod.POST)
    protected ModelAndView calculator(
            @RequestParam("argument1") String arg1,
            @RequestParam("argument2") String arg2,
            @RequestParam("oper") String oper
    ) {
        log.info("Request /calculator.htm POST: arg1- "+arg1+", arg2- "+arg2+", operation- "+oper);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("calculator");
        mav.addObject("full_result", calculatorService.getResult(arg1, arg2, oper, true));
        mav.addObject("result", calculatorService.getResult(arg1, arg2, oper, false));
        mav.addObject("arg1", arg1);
        mav.addObject("arg2", arg2);
        mav.addObject("oper", oper);
        mav.addObject("operations", Operation.values());
        log.info("Model calculated and created");
        return mav;
    }

    @RequestMapping("/calculator.htm")
    protected ModelAndView calculator() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("calculator");
        mav.addObject("result", "");
        mav.addObject("full_result", "");
        mav.addObject("arg1", "");
        mav.addObject("arg2", "");
        mav.addObject("oper", "");
        mav.addObject("operations", Operation.values());
        log.info("Model created");
        return mav;
    }
}
