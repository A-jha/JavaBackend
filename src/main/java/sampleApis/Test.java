package sampleApis;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Test extends HttpServlet {
    public void init(){
        System.out.println("hello from Test Servlet");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//        super.doGet(req, resp);
        resp.setContentType("application/json");
        String name = req.getParameter("name");
        PrintWriter printWriter = resp.getWriter();
        try {
            printWriter.write("Hello "+name);
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e){
            printWriter.write(e.getLocalizedMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }finally {
            System.out.println("Method executed");
            printWriter.close();
        }
    }
}
