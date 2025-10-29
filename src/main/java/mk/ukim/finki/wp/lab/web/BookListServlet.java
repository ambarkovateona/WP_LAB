package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name="BookListServlet",urlPatterns = "")
public class BookListServlet extends HttpServlet {
    private final BookService bookService;
    private final TemplateEngine templateEngine;
    public BookListServlet(BookService bookService,TemplateEngine templateEngine) {
        this.bookService = bookService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webcontext=new WebContext(exchange,exchange.getLocale());
        List<Book> books = null;


        String filterName = req.getParameter("filterName");
        double filterRating = -1;

        try {
            filterRating = Double.parseDouble(req.getParameter("filterRating"));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(filterName != null && !filterName.isEmpty() && filterRating != -1) {
            books = bookService.searchBooks(filterName, filterRating);
        } else {
            books = bookService.listAll();
        }

        WebContext context = new WebContext(exchange);
        context.setVariable("books", books);


        templateEngine.process("listBooks.html", context, resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterName = request.getParameter("filterName");
        String filterRating = request.getParameter("filterRating");
        String params = String.format("filterName=%s&filterRating=%s", filterName, filterRating);
        response.sendRedirect("/?" + params);
    }

}

