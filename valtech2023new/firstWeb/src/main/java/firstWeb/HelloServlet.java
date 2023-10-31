package firstWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	private int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init of the Hello Servlet");
		System.out.println("Driver Class = "+config.getInitParameter("driver-class"));
		System.out.println("JDBC Url = "+config.getInitParameter("jdbc-url"));
		System.out.println("Username = "+config.getInitParameter("username"));
		System.out.println("Password = "+config.getInitParameter("password"));
	}
	
	@Override
	public void destroy() {
		System.out.println("Destory the Hello Servlet Count "+count);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
//		resp.getWriter().print("Hello Servlet "+count++);
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Displaying through Servlet</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("Hi <b>"+name+"</b><br/>");
		out.print("You are visitor no. "+count+++" for this website . . .!");
		out.print("</body>");
		out.print("</html>");
	}
}
