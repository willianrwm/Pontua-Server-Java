package pontua.objeto;


import java.sql.Date;


public class Cliente {
    
    private int ID;
    private String Nome;
    private String CPF;
    private String Email;
    private Date Nascimento;
    private String Sexo;
    private String Senha;

    public Cliente() {
    }

    public Cliente(int ID, String Nome, String CPF, String Email, Date Nascimento, String Sexo, String Senha) {
        this.ID = ID;
        this.Nome = Nome;
        this.CPF = CPF;
        this.Email = Email;
        this.Nascimento = Nascimento;
        this.Sexo = Sexo;
        this.Senha = Senha;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
