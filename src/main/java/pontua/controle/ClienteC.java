package pontua.controle;

import com.google.gson.Gson;
import java.util.List;
import pontua.modelo.ClienteBD;
import pontua.objeto.Cliente;


public class ClienteC {
    
    public String getClientes(){
        Gson g = new Gson();
        ClienteBD cbd = new ClienteBD();
        List<Cliente> clientes = cbd.buscarCliente();
        return g.toJson(clientes);
    }
    
    public boolean postClientes(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        return cbd.inserirCliente(cli);
    }
    
    public boolean deleteCliente(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        return cbd.deletarCliente(cli);
    }
    
    public boolean atualizarCliente(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        ClienteBD cbd = new ClienteBD();
        return cbd.atualizarCliente(cli);
    }
    
    public String buscaCliente(int id){
        Gson g = new Gson();
        ClienteBD cbd = new ClienteBD();
        Cliente clientes = cbd.buscaCliente(id);
        
        if (clientes==null){
            return "cliente inexistente";
        }else{
            return g.toJson(clientes);
        }
    }
    
    
    public String testarCliente(String cliente){
        Gson g = new Gson();
        Cliente cli = (Cliente) g.fromJson(cliente, Cliente.class);
        return (cli.getNome());
    }
    
}
