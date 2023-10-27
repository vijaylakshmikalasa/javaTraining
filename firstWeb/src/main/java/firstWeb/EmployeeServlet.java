package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao=new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess=req.getSession(true);
			sess.setAttribute("current", dao.firstId());
//			req.setAttribute("emp", dao.getEmployee(dao.firstId()));
			sess.setAttribute("emp", dao.getEmployee(dao.firstId()));
			
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		int current=(Integer)sess.getAttribute("current");
		
		String submit=req.getParameter("action");
		
		try {
		if("First".equals(submit)) {
			current=dao.firstId();
		}
		else if("Last".equals(submit)) {
			current=dao.lastId();
		}
		else if("Next".equals(submit)) {
			current=dao.nextId(current);
		}
		else if("Previous".equals(submit)){
			current=dao.previousId(current);
		}
		sess.setAttribute("current", current);
//		req.setAttribute("emp",dao.getEmployee(current));
//		req.getRequestDispatcher("employee.jsp").forward(req, resp);
		
		
		//If we store the employee in session redirect works 
		sess.setAttribute("emp",dao.getEmployee(current));
		resp.sendRedirect("employee.jsp");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
