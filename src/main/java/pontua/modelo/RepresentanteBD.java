package pontua.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pontua.objeto.Representante;


public class RepresentanteBD {
    
    private PreparedStatement pst;
    private ResultSet resultado;
    private Connection con;
    private String sql;
    
    public List<Representante> buscarRepresentante(){
        try{
            List<Representante> representantes = new ArrayList<>();
            Representante r;

            sql = "SELECT * FROM representante;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            resultado = pst.executeQuery();

            while(resultado.next()){
                r = new Representante();

                r.setID(resultado.getInt("ID"));
                r.setNome(resultado.getString("nome"));
                r.setFantasia(resultado.getString("fantasia"));
                r.setCNPJ_CPF(resultado.getString("cnpj_cpf"));
                r.setEnd_logradouro(resultado.getString("end_logradouro"));
                r.setEnd_numero(resultado.getString("end_numero"));
                r.setEnd_complemento(resultado.getString("end_complemento"));
                r.setEnd_bairro(resultado.getString("end_bairro"));
                r.setEnd_cidade(resultado.getString("end_cidade"));
                r.setEnd_estado(resultado.getString("end_estado"));
                r.setEnd_CEP(resultado.getString("end_cep"));
                r.setEmail(resultado.getString("email"));
                r.setValidade_pontos(resultado.getDate("validade_pontos"));
                r.setSenha(resultado.getString("senha"));

                representantes.add(r);
            }
            return representantes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean inserirRepresentante(Representante r){
        try {
            sql = "INSERT INTO representante (nome, fantasia, cnpj_cpf, end_logradouro, end_numero, end_complemento, end_bairro, end_cidade, end_estado"
                    + "end_cep, email, validade_pontos, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setString(1,r.getNome());
            pst.setString(2,r.getFantasia());
            pst.setString(3,r.getCNPJ_CPF());
            pst.setString(4,r.getEnd_logradouro());
            pst.setString(5,r.getEnd_numero());
            pst.setString(6,r.getEnd_complemento());
            pst.setString(7,r.getEnd_bairro());
            pst.setString(8,r.getEnd_cidade());
            pst.setString(9,r.getEnd_estado());
            pst.setString(10,r.getEnd_CEP());
            pst.setString(11,r.getEmail());
            pst.setDate(12,r.getValidade_pontos());
            pst.setString(13,r.getSenha());
            
            pst.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean atualizarRepresentante(Representante r){
        try {
            sql = "UPDATE representante SET nome=?, fantasia=?, cnpj_cpf=?, end_logradouro=?, end_numero=?, end_complemento=?, end_bairro=?, end_cidade=?,"
                    + "end_estado=?, end_cep=?, email=?, validade_pontos=?, senha WHERE id = ?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setString(1,r.getNome());
            pst.setString(2,r.getFantasia());
            pst.setString(3,r.getCNPJ_CPF());
            pst.setString(4,r.getEnd_logradouro());
            pst.setString(5,r.getEnd_numero());
            pst.setString(6,r.getEnd_complemento());
            pst.setString(7,r.getEnd_bairro());
            pst.setString(8,r.getEnd_cidade());
            pst.setString(9,r.getEnd_estado());
            pst.setString(10,r.getEnd_CEP());
            pst.setString(11,r.getEmail());
            pst.setDate(12,r.getValidade_pontos());
            pst.setString(13,r.getSenha());
            pst.setInt(14,r.getID());
            
            pst.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean deletarRepresentante(int id){
        try {
            sql = "DELETE FROM representante WHERE id = ?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setInt(1,id);
            
            pst.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
        
    public Representante buscaRepresentante(int id){
        try{
        
            Representante r = new Representante();

            sql = "SELECT * FROM representante WHERE id=?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);

            pst.setInt(1,id);

            resultado = pst.executeQuery();

            if(resultado.next()){

                r.setID(resultado.getInt("ID"));
                r.setNome(resultado.getString("nome"));
                r.setFantasia(resultado.getString("fantasia"));
                r.setCNPJ_CPF(resultado.getString("cnpj_cpf"));
                r.setEnd_logradouro(resultado.getString("end_logradouro"));
                r.setEnd_numero(resultado.getString("end_numero"));
                r.setEnd_complemento(resultado.getString("end_complemento"));
                r.setEnd_bairro(resultado.getString("end_bairro"));
                r.setEnd_cidade(resultado.getString("end_cidade"));
                r.setEnd_estado(resultado.getString("end_estado"));
                r.setEnd_CEP(resultado.getString("end_cep"));
                r.setEmail(resultado.getString("email"));
                r.setValidade_pontos(resultado.getDate("validade_pontos"));
                r.setSenha(resultado.getString("senha"));
                return r;
            }else{
                return null;
            }
        
        }catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
            Conexao.desconectar();
        }
    }
       
}
