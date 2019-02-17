package ServletContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstOperand = request.getParameter("firstOperand");
        String operator = request.getParameter("operator");
        String secondOperand = request.getParameter("secondOperand");
        String userAnswer = request.getParameter("answer");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        int solution = 0;
        String message;

        switch (operator) {
            case "+":
                solution = Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
                break;
            case "-":
                solution = Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand);
                break;
            case "*":
                solution = Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand);
                break;
            case "/":
                solution = Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand);
                break;
            case "%":
                solution = Integer.parseInt(firstOperand) % Integer.parseInt(secondOperand);
                break;
            default:
                message = "Missing or mispelled operator, please use one of the following: +, −, *, / or %";
                out.println("<div name=\"Output\">"+message+"</div>");
                break;
        }

        if (solution == Integer.parseInt(userAnswer)) {
            message = "Correct! Good job.";
            out.println("<div name=\"Output\">"+message+"</div>");
        }
        else {
            message = "Incorrect. Try again!";
            out.println("<div name=\"Output\">"+message+"</div>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
