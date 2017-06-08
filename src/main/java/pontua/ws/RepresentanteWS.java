package pontua.ws;

import pontua.controle.RepresentanteC;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("representante")
public class RepresentanteWS extends Application {

    @Context
    private UriInfo context;

    
    public RepresentanteWS() {
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Teste";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/ler")
    public Response getRepresentante(){
        RepresentanteC rc = new RepresentanteC();
        return Response.ok(rc.getRepresentantes()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/criar")
    public Response postRepresentante(String representante){
        RepresentanteC rc = new RepresentanteC();
        return Response.ok(rc.postRepresentantes(representante)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/atualizar")
    public Response atualizarRepresentante(String representante){
        RepresentanteC rc = new RepresentanteC();
        return Response.ok(rc.atualizarRepresentante(representante)).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/deletar")
    public Response deleteRepresentante(@PathParam("id") int id){
        RepresentanteC rc = new RepresentanteC();
        return Response.ok(rc.deleteRepresentante(id)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/buscar/{id}")
    public Response buscaRepresentante(@PathParam("id") int id){
        RepresentanteC rc = new RepresentanteC();
        return Response.ok(rc.buscaRepresentante(id)).build();
    }
    
    /**
     * PUT method for updating or creating an instance of RepresentnteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
