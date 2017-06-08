package pontua.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost/projeto_ws";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    private static Connection con;
    
    public static Connection conectar(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USUARIO,SENHA);
        }catch (ClassNotFoundException ex){
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
        }catch (SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
    public static void desconectar(){
        try{
            con.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
