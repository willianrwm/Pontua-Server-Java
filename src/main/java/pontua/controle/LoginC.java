package pontua.controle;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import pontua.modelo.LoginBD;
import pontua.objeto.Login;

public class LoginC {
    
    public String login(String login) {
        try{
            Gson g = new Gson();
            Login l = (Login) g.fromJson(login, Login.class);
            LoginBD lbd = new LoginBD();
            boolean result = lbd.login(l);

            if (result){
                Algorithm algorithm = Algorithm.HMAC256("pontua");
                return JWT.create().withIssuer(login).sign(algorithm);
            }else{
                return "";
            }
        }catch(IllegalArgumentException ie){
            return "Argumento inválido";
        }catch(UnsupportedEncodingException uee){
            return "Algoritmo inválido";
        }
    }
}
