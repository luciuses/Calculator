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
    
//initializing the logger
    private final static Log log = LogFactory.getLog(CalculatorController.class);
//initializing the service for calculating
    private CalculatorService calculatorService;
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
//Processing request method POST
    @RequestMapping(value = "/calculator.htm", method = RequestMethod.POST)
    protected ModelAndView calculator(
            @RequestParam("argument1") String arg1,
            @RequestParam("argument2") String arg2,
            @RequestParam("oper") String oper
    ) {
        log.info("Request /calculator.htm POST: arg1- "+arg1+", arg2- "+arg2+", operation- "+oper);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("calculator");
        mav.addObject("full_result", calculatorService.getResult(arg1, arg2, oper, true));//for display the full arithmetic expression
        mav.addObject("result", calculatorService.getResult(arg1, arg2, oper, false));//for display the result arithmetic operation in out field
        mav.addObject("arg1", arg1);//for display the first argument
        mav.addObject("arg2", arg2);//for display a second argument
        mav.addObject("oper", oper);//arithmetic operation for displaying
        mav.addObject("operations", Operation.values());//for fill the available arithmetic operations
        log.info("Model calculated and created");
        return mav;
    }
//Initial processing of the request page
    @RequestMapping("/calculator.htm")
    protected ModelAndView calculator() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("calculator");
        mav.addObject("result", "");//display empty field in the output result
        mav.addObject("full_result", "");//display empty field in the output full arithmetic expression
        mav.addObject("arg1", "");//displaying in the input field empty argument1
        mav.addObject("arg2", "");//displaying in the input field empty argument2
        mav.addObject("oper", "");
        mav.addObject("operations", Operation.values());//for fill the available arithmetic operations
        log.info("Model created");
        return mav;
    }
}
