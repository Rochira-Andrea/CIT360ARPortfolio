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
                out.println("<html style=\"background-color:lightgrey\"><head><title>Answer Tab</title></head><header>");
                out.println("<h3 name=\"Output\"><font color=\"red\">" + message + "</font></h3>");
                out.println("</header><body>");
                out.println("<button type=\"button\" style=\"background-color:lightgreen\"><a style=\"text-decoration:none\" href=\"index.jsp\">Back</a></button><p></p><br><hr>");
                out.println("</body></html>");
                return;

                /* --- Alternative solution
                // RequestDispatcher requestDispatcher;
                // request.setAttribute("result",message);
                // requestDispatcher = request.getRequestDispatcher("index.jsp");
                // requestDispatcher.forward(request, response);
                */
        }

        if (solution == Integer.parseInt(userAnswer)) {
            message = "Correct! Good job.";
            out.println("<html style=\"background-color:lightgrey\"><head><title>Answer Tab</title><header>");
            out.println("<h3 name=\"Output\"><font color=\"blue\">" + message + "</font></h3>");
            out.println("</header><body>");
            out.println("<button type=\"button\" style=\"background-color:lightgreen\"><a style=\"text-decoration:none\" href=\"index.jsp\">Back</a></button><p></p><br><hr>");
            out.println("</body></html>");

            /* --- Alternative solution
                // request.setAttribute("result",message);
                // RequestDispatcher requestDispatcher;
                // requestDispatcher = request.getRequestDispatcher("index.jsp");
                // requestDispatcher.forward(request, response);
                */

        } else {
            message = "Incorrect. Try again!";
            out.println("<html style=\"background-color:lightgrey\"><head><title>Answer Tab</title><header>");
            out.println("<h3 name=\"Output\"><font color=\"red\">" + message + "</font></h3>");
            out.println("</header><body>");
            out.println("<button type=\"button\" style=\"background-color:lightgreen\"><a style=\"text-decoration:none\" href=\"index.jsp\">Back</a></button><p></p><br><hr>");
            out.println("</body></html>");

            /* --- Alternative solution
                // request.setAttribute("result",message);
                // RequestDispatcher requestDispatcher;
                // requestDispatcher = request.getRequestDispatcher("index.jsp");
                // requestDispatcher.forward(request, response);
                */
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Response from doGet method");

    }
}
