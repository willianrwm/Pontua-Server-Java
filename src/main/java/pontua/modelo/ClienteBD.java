package pontua.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pontua.objeto.Cliente;


public class ClienteBD {
    
    private PreparedStatement pst;
    private ResultSet resultado;
    private Connection con;
    private String sql;
    
    public List<Cliente> buscarCliente(){
        try{
            List<Cliente> clientes = new ArrayList<>();
            Cliente c;

            sql = "SELECT * FROM cliente;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            resultado = pst.executeQuery();

            while(resultado.next()){
                c = new Cliente();

                c.setID(resultado.getInt("ID"));
                c.setNome(resultado.getString("nome"));
                c.setCPF(resultado.getString("CPF"));
                c.setEmail(resultado.getString("email"));
                c.setNascimento(resultado.getDate("nascimento"));
                c.setSexo(resultado.getString("sexo"));
                c.setSenha(resultado.getString("senha"));

                clientes.add(c);
            }
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean inserirCliente(Cliente c){
        try {
        /*
        sql = "update cliente "
            + "set nome = '" + c.getNome() + "', "
            + "telefone = '" + c.getTelefone() + "', "
            + "where idcliente = '" + c.getCodigo() + "'";
        */
        
            sql = "INSERT INTO cliente (nome, CPF, email, nascimento, sexo, senha) VALUES (?,?,?,?,?,?);";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setString(1,c.getNome());
            pst.setString(2,c.getCPF());
            pst.setString(3,c.getEmail());
            pst.setDate(4,c.getNascimento());
            pst.setString(5,c.getSexo());
            pst.setString(6,c.getSenha());
            
            pst.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean atualizarCliente(Cliente c){
        try {
            sql = "UPDATE cliente SET nome=?, CPF=?, email=?, nascimento=?, sexo=?, senha=? WHERE id = ?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setString(1,c.getNome());
            pst.setString(2,c.getCPF());
            pst.setString(3,c.getEmail());
            pst.setDate(4,c.getNascimento());
            pst.setString(5,c.getSexo());
            pst.setString(6,c.getSenha());
            pst.setInt(7,c.getID());
            
            pst.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public boolean deletarCliente(Cliente c){
        try {
            sql = "DELETE FROM cliente WHERE id = ?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setInt(1,c.getID());
            
            pst.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
    
    public Cliente buscaCliente(int id){
        try{
        
            Cliente c = new Cliente();

            sql = "SELECT * FROM cliente WHERE id=?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);

            pst.setInt(1,id);

            resultado = pst.executeQuery();

            if(resultado.next()){

                c.setID(resultado.getInt("ID"));
                c.setNome(resultado.getString("nome"));
                c.setCPF(resultado.getString("CPF"));
                c.setEmail(resultado.getString("email"));
                c.setNascimento(resultado.getDate("nascimento"));
                c.setSexo(resultado.getString("sexo"));
                c.setSenha(resultado.getString("senha"));
                return c;
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
