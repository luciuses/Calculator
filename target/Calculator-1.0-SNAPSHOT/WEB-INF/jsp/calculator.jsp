


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
        <link href="css/calculatorcss.css" rel="stylesheet" type="text/css"/>
        <script src="js/libs/jquery/jquery.js" type="text/javascript"></script>
        <script src="js/libs/jquery.maskedinput/jquery.inputmask.js" type="text/javascript"></script>
        <script src="js/libs/jquery.maskedinput/jquery.inputmask-regex.js" type="text/javascript"></script>
        <script>
            
            jQuery(function() {
                /* Masked input arguments, */
                $("#arg1id").inputmask('Regex', {regex: "[-+]?[0-9]+\\.?[0-9]*"});
                $("#arg2id").inputmask('Regex', {regex: "[-+]?[0-9]+\\.?[0-9]*"});
                /* Show or hide the input field depending on the operation , */
                $("#operid").val().indexOf('_1arg') != -1 ? $("#arg2id").hide() : $("#arg2id").show();
                $("#operid").change(function() {
                    $(this).val().indexOf('_1arg') != -1 ? $("#arg2id").hide() : $("#arg2id").show();
                });
            });
        </script>
    </head>
    <body>
        <table align="center" >
            <tbody>
                <tr>
                    <td></td>
                    <td>
                        <div class="bord">
                            <div class="header">
                                <h1>Calculator</h1>
                            </div>

                            <form id="form" action="" method="post">
                                <div class="arg">
                                    <input type="text" size="20px" name="argument1" value="${arg1}" id="arg1id">
                                    <select id="operid" name="oper">
                                        <c:forEach items="${operations}" var="_operation">
                                            <option value="${_operation.name()}" ${_operation.name()==oper?'selected':''}>${_operation.toString()}</option>
                                        </c:forEach>
                                    </select>
                                    <input  type="text" size="20px" name="argument2" value="${arg2}" id="arg2id">
                                    <input type="submit" id="submit" value="  =  " />
                                    <input name="result" size="20" type="text" value="${result}"/>
                                </div>
                                <br>
                                <div class="result">
                                    <b>${full_result}</b>
                                </div>
                            </form>
                        </div>
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>

</html>

