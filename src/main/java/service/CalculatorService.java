package service;
import java.lang.Exception;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalculatorService {
    private final static Log log = LogFactory.getLog(CalculatorService.class);
    public static String getResult(String arg1, String arg2, String oper, boolean full) {
        
        try {
            log.info("Start calculating arg1- "+arg1+", arg2- "+arg2+", operation- "+oper);
            String res = "";
            Operation _oper = Operation.valueOf(oper);//get an arithmetic operation by request string value 
            if (full) {
                log.info("Creating full result");
                //Creating string arithmetic expression for full result
                if (_oper.name().indexOf("_1arg") != -1) {
                    res = _oper.getText() + "(" + arg1 + ") = ";
                } else {
                    res = arg1 + _oper.getText() + arg2 + " = ";
                }
            }
            //select the arithmetic operation and execute it
            switch (_oper) {
                case plus:
                    return res + String.valueOf(Double.valueOf(arg1) + Double.valueOf(arg2));
                case minus:
                    return res + String.valueOf(Double.valueOf(arg1) - Double.valueOf(arg2));
                case multiply:
                    return res + String.valueOf(Double.valueOf(arg1) * Double.valueOf(arg2));
                case divide:
                    return res + String.valueOf(Double.valueOf(arg1) / Double.valueOf(arg2));
                case square_root_1arg:
                    return res + String.valueOf(Math.sqrt(Double.valueOf(arg1)));
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
