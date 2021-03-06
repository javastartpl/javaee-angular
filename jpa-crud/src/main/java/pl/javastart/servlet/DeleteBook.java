package pl.javastart.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.BookDao;

@WebServlet("/delete")
public class DeleteBook extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private BookDao bookDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        bookDao.remove(id);
        response.sendRedirect(request.getContextPath());
    }
}
