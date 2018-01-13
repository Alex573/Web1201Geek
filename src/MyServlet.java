import com.muy.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MyServlet",urlPatterns = "/posts")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("posts", DAO.getPost());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //response.sendRedirect("http://ya.ru");

        request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request,response);
    }
}
