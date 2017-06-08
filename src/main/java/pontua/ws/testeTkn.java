package pontua.ws;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;


public class testeTkn {
    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws IllegalArgumentException, UnsupportedEncodingException {
        /*
        Key key = MacProvider.generateKey();
        Date dateNow = new Date(0);
        Date expires = new Date(dateNow.getTime() + 86400000);

        String string = "{'Email':'willian_rwm@hotmail.com','Senha':'8790'}";

        String token = Jwts.builder().setSubject(string).signWith(SignatureAlgorithm.HS256, key).setExpiration(expires).compact();
        System.out.println(token);
        */
        //JWT.create() - instancia
        //withIssuer() - string a ser codificada
        //sign(algorithm) - tipo do algoritimo
        String palavra = "testanildo";
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withIssuer(palavra).sign(algorithm);
        System.out.println(token);
        
        verificar(token);
    }
    
    private static void verificar(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("testanildo").build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("\n\n"+jwt);
            
            decodif();
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            System.out.println("nao deu boa");
        }
    }
    
    private static void decodif(){
        try {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJFbWFpbCI6IndpbGxpYW5fcndtQGhvdG1haWwuY29tIiwiU2VuaGEiOiIxMjM0NSJ9.8Xp0pAZd1fzknbDR61Db2HQtX7a2VjxnLSZu00RqEbk";
            DecodedJWT jwt = JWT.decode(token);
            String tal = String.valueOf(jwt);
            System.out.println(tal);
            
        } catch (JWTDecodeException exception){
            System.out.println("nao decodificou");
        }
    }
}
