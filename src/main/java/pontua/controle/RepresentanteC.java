package pontua.controle;

import com.google.gson.Gson;
import java.util.List;
import pontua.modelo.RepresentanteBD;
import pontua.objeto.Representante;


public class RepresentanteC {
    
    public String getRepresentantes(){
        Gson g = new Gson();
        RepresentanteBD rbd = new RepresentanteBD();
        List<Representante> representantes = rbd.buscarRepresentante();
        return g.toJson(representantes);
    }
    
    public boolean postRepresentantes(String representante){
        Gson g = new Gson();
        Representante rep = (Representante) g.fromJson(representante, Representante.class);
        RepresentanteBD rbd = new RepresentanteBD();
        return rbd.inserirRepresentante(rep);
    }
    
    public boolean deleteRepresentante(int id){
        RepresentanteBD rbd = new RepresentanteBD();
        return rbd.deletarRepresentante(id);
    }
    
    public boolean atualizarRepresentante(String representante){
        Gson g = new Gson();
        Representante rep = (Representante) g.fromJson(representante, Representante.class);
        RepresentanteBD rbd = new RepresentanteBD();
        return rbd.atualizarRepresentante(rep);
    }
    
    public String buscaRepresentante(int id){
        Gson g = new Gson();
        RepresentanteBD rbd = new RepresentanteBD();
        Representante representante = rbd.buscaRepresentante(id);
        
        if (representante==null){
            return "representante inexistente";
        }else{
            return g.toJson(representante);
        }
    }
    
}
