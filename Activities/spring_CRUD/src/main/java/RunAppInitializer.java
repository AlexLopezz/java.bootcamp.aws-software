import controllers.HomeServlet;
import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class RunAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new HomeServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
