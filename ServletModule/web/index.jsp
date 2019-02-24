<%--
  Created by IntelliJ IDEA.
  User: Andrea
  Date: 2019-02-16
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Math Tab</title>
  </head>
  <body style="background-color:lightgrey">
    <div>
      <h3>Test Your Math Skills with integers</h3>
      <form action="Servlet" method="post">
        <input style="border-color:black" type="text" placeholder="first value" name="firstOperand" required="required" size="10">
        <input style="border-color:black" type="text" placeholder="operator" name="operator" required="required" size="10">
        <input style="border-color:black" type="text" placeholder="second value" name="secondOperand" required="required" size="10">
        = <input style="border-color:black" type="text" placeholder="your answer" name="answer" required="required" size="10"><br><br>
        <button type="submit" style="background-color:lightgreen">Check</button>
        <input type="reset" style="background-color:lightgreen" value="Reset" onClick="window.location.href=window.location.href">
      </form><br>
    </div>

    <div style="color:blue; font-weight:bold" name="Output">${result}</div>

    <hr>
  </body>
</html>
