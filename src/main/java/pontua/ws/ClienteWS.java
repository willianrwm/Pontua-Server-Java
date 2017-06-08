package pontua.ws;

import pontua.controle.ClienteC;
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

@Path("cliente")
public class ClienteWS extends Application {

    @Context
    private UriInfo context;

    
    public ClienteWS() {
    }
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Teste";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/ler")
    public Response getClientes(){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.getClientes()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/criar")
    public Response postClientes(String cliente){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.postClientes(cliente)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/atualizar")
    public Response atualizarClientes(String cliente){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.atualizarCliente(cliente)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/deletar")
    public Response deleteClientes(String cliente){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.deleteCliente(cliente)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/buscar/{id}")
    public Response buscaCliente(@PathParam("id") int id){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.buscaCliente(id)).build();
    }
    
    
    @Path("/testar")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @POST
    public Response testar(String cliente){
        ClienteC cc = new ClienteC();
        return Response.ok(cc.testarCliente(cliente)).build();
    }
   
    /**
     * PUT method for updating or creating an instance of ClienteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
}
