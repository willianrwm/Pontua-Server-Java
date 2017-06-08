package pontua.ws;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import com.pontua.filter.JWTSecurityFilter;


@ApplicationPath("/pontua")
public class Application extends ResourceConfig {
 
    public Application(){
        register(JWTSecurityFilter.class);
        
    }
}