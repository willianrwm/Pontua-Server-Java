package pontua.objeto;

public class Login {
    
    private String email;
    private String senha;

    public Login() {
    }

    public Login(String Email, String Senha) {
        this.email = Email;
        this.senha = Senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    
}
