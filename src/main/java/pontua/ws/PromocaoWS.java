package pontua.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("promocao")
public class PromocaoWS {

    @Context
    private UriInfo context;

   
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void getJson() {
        System.out.println("promoções");
    }
    
    @Path("listar")
    public class Listar extends javax.ws.rs.core.Application {

        @PUT
        @Produces(MediaType.TEXT_HTML)

        public void listar(String login){
            System.out.println("lista");

        }

    }

}
