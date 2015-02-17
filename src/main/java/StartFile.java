
import com.servlet.CompressServlet;
import com.servlet.CropServlet;
import com.servlet.ScaleServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class StartFile  {


    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new ScaleServlet()),"/image/scale/*");
        context.addServlet(new ServletHolder(new CropServlet()),"/image/crop/*");
        context.addServlet(new ServletHolder(new CompressServlet()),"/image/compress/*");
        server.start();
        server.join();   
    }
}
