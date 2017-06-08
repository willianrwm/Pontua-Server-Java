package pontua.ws;

import pontua.controle.LoginC;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("login")
public class LoginWS extends Application {

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Produces(MediaType.TEXT_HTML)
    
    public Response login(String login){
        System.out.println("DADOS RECEBIDOS: "+ login);
        
        LoginC lc = new LoginC();
        String token = lc.login(login);
        if(!token.isEmpty()){
            return Response.ok(token).build();
        }
        return  Response.status(401).build();
        
    }

}
