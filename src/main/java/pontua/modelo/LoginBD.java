package pontua.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pontua.objeto.Login;

public class LoginBD {
    
    private PreparedStatement pst;
    private ResultSet resultado;
    private Connection con;
    private String sql;
    
    public boolean login(Login l){
        try {
            sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?;";
            con = Conexao.conectar();
            pst = con.prepareStatement(sql);
            
            pst.setString(1,l.getEmail());
            pst.setString(2,l.getSenha());
            
            resultado = pst.executeQuery();
            return resultado.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
            Conexao.desconectar();
        }
    }
}
