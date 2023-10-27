package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().print("User Name = "+request.getParameter("name")+" Password = "+request.getParameter("password"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if (name.length()<4) {
            request.setAttribute("nameerr", "Name should be at least 4 characters long");
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        }
		if(password.length()<8) {
			request.setAttribute("passworderr", "The password should be at least 8 characters long.");
		}
//		if(!"kruthik".equals(name) && !"kruthikb6".equals(password)) {
//			request.setAttribute("loginerr", "You are not a valid user . . . !");
//		}
		if (request.getAttribute("nameerr")!=null || request.getAttribute("passworderr")!=null || request.getAttribute("loginerr")!=null) {
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        }
		else /*if("kruthik".equals(name) && "kruthikb6".equals(password))*/{
            request.setAttribute("message", "Hi Kruthik, how are you doing . . . !");
            request.getRequestDispatcher("loginresults.jsp").forward(request, response);
        }
	}

}
