/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
//import com.luciuses.calculator.CalculatorController;
//import com.luciuses.calculator.CalculatorController;
import java.lang.Exception;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author luciuses
 */
public class CalculatorService {
    private final static Log log = LogFactory.getLog(CalculatorService.class);
    public static String getResult(String arg1, String arg2, String oper, boolean full) {
        
        try {
            log.info("Start calculating arg1- "+arg1+", arg2- "+arg2+", operation- "+oper);
            String res = "";
            Operation _oper = Operation.valueOf(oper);
            if (full) {
                log.info("Creating full result");
                if (_oper.name().indexOf("_1arg") != -1) {
                    res = _oper.toString() + "(" + arg1 + ") = ";
                } else {
                    res = arg1 + _oper.toString() + arg2 + " = ";
                }
            }
            switch (_oper) {
                case plus:
                    return res + String.valueOf(Float.valueOf(arg1) + Float.valueOf(arg2));
                case minus:
                    return res + String.valueOf(Float.valueOf(arg1) - Float.valueOf(arg2));
                case multiply:
                    return res + String.valueOf(Float.valueOf(arg1) * Float.valueOf(arg2));
                case divide:
                    return res + String.valueOf(Float.valueOf(arg1) / Float.valueOf(arg2));
                case square_root_1arg:
                    return res + String.valueOf(Math.sqrt(Float.valueOf(arg1)));
                default:
                    return "Computing operation is not implemented!";
            }
        }
        catch (NumberFormatException ex) {
            log.error("Incorrect data format/NumberFormatException:"+ex.getMessage());
            return "Incorrect data format:" + ex.getMessage();
        }
        catch (IllegalArgumentException ex) {
            log.error("Invalid operation value/IllegalArgumentException:"+ex.getMessage());
            return "Invalid operation value:" + ex.getMessage();
        }
        catch (Exception ex) {
            log.error("Exception:"+ex.getMessage());
            return ex.toString();
        }
    }
}
