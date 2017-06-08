package com.pontua.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ContainerRequest;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;


@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTSecurityFilter implements ContainerRequestFilter {
    
    @Inject
    javax.inject.Provider<UriInfo> uriInfo;

    public void VerificaToken(String token){
        System.out.println("DEU");
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("pontua")
                .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            
        } catch (UnsupportedEncodingException uee){
            //UTF-8 encoding not supported
            Response.status(UNAUTHORIZED).build();
        } catch (JWTVerificationException jve){
            //Invalid signature/claims
            Response.status(UNAUTHORIZED).build();
        } catch (WebApplicationException wae){
            Response.status(UNAUTHORIZED).build();
        }
        return;
    }
    
    public static String extractJwtTokenFromAuthorizationHeader(String auth) {
        //Replacing "Bearer Token" to "Token" directly
        System.out.println("DEU");
        return auth.replaceFirst("[B|b][E|e][A|a][R|r][E|e][R|r] ", "").replace(" ", "");
    }
    /*
    private Principal convertLambda(){
	return (Principal) "anonymous";
    }
    */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        System.out.println("DEU");
        String method = requestContext.getMethod().toLowerCase();
        String path = ((ContainerRequest)requestContext).getPath(true).toLowerCase();
     
        System.out.println("METODO: " + method);
        System.out.println("PATH: " + path);

        if("/swagger.json".equals(path)){
            // pass through the filter.
            requestContext.setSecurityContext(new SecurityContextAuthorizer(uriInfo, () -> "anonymous", "anonymous"));
            return;
        }

        if ((("options".equals(method) || "post".equals(method)) && ("/login".equals(path)))) {
            // pass through the filter.
            requestContext.setSecurityContext(new SecurityContextAuthorizer(uriInfo, () -> "anonymous", "anonymous"));
            return;
        }
        
        //verifica se o authorization esta preesente
        requestContext.getUriInfo().getPathParameters();
        String authorizationHeaderAuth = null;
        authorizationHeaderAuth = ((ContainerRequest) requestContext).getHeaderString("authorization");
        System.out.println("auth:" + authorizationHeaderAuth);
        
        String strToken;
        if(authorizationHeaderAuth == null) {
            System.out.println("TOKEN NULO");
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        else{
            //pega o auth correto
            strToken = extractJwtTokenFromAuthorizationHeader(authorizationHeaderAuth);
            VerificaToken(strToken);
        }
    }
}