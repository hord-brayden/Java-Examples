/*
This was easily the most difficult one to get working, and it is still a work in progress! 

Any help would be great, but still trying to hit Basic at this point.
*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServTown", urlPatterns = {"/ServTown"})
 public class ServTown extends HttpServlet {

    private String chupaCabra;
    public void init() throws ServletException {
        chupaCabra = "This is a Servlet with teeth and a tongue!";}

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // Set response content type
        response.setContentType("text/html");



        //This is where we put everything into printWriter and strings. 
        PrintWriter out = response.getWriter();
        String title = "This is servtown which is filled with chupacabras!";
        String setType ="<!doctype html>";
        out.println(setType + "<html>\n" +"<head> <title>" + title + "</title> </head>\n" + "<body>\n" 
                            + "<h1>" + title + "</h1>\n" + "<ul>\n" + request.getParameter("name") 
                            + "\n" + request.getParameter("class") + "\n" + chupaCabra + "</ul>\n" 
                            + "</body>\n" + "</html>");
            }       
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {ProcessRequest(request, response);}
/*
Unsure how to properly implement the destroy just yet. 
I know that they're supposed to be destroyed or closed when you're done with them. 

    protected void destroy
*/
}


