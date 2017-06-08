package pontua.objeto;


import java.sql.Date;


public class Representante {
    
    private int ID;
    private String Nome;
    private String Fantasia;
    private String CNPJ_CPF;
    private String End_logradouro;
    private String End_numero;
    private String End_complemento;
    private String End_bairro;
    private String End_cidade;
    private String End_estado;
    private String End_CEP;
    private String Email;
    private Date Validade_pontos;
    private String Senha;

    public Representante() {
    }

    public Representante(int ID, String Nome, String Fantasia, String CNPJ_CPF, String End_logradouro, String End_numero, String End_complemento, String End_bairro, String End_cidade, String End_estado, String End_CEP, String Email, Date Validade_pontos, String Senha) {
        this.ID = ID;
        this.Nome = Nome;
        this.Fantasia = Fantasia;
        this.CNPJ_CPF = CNPJ_CPF;
        this.End_logradouro = End_logradouro;
        this.End_numero = End_numero;
        this.End_complemento = End_complemento;
        this.End_bairro = End_bairro;
        this.End_cidade = End_cidade;
        this.End_estado = End_estado;
        this.End_CEP = End_CEP;
        this.Email = Email;
        this.Validade_pontos = Validade_pontos;
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

    public String getFantasia() {
        return Fantasia;
    }

    public void setFantasia(String Fantasia) {
        this.Fantasia = Fantasia;
    }

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
    }

    public String getEnd_logradouro() {
        return End_logradouro;
    }

    public void setEnd_logradouro(String End_logradouro) {
        this.End_logradouro = End_logradouro;
    }

    public String getEnd_numero() {
        return End_numero;
    }

    public void setEnd_numero(String End_numero) {
        this.End_numero = End_numero;
    }

    public String getEnd_complemento() {
        return End_complemento;
    }

    public void setEnd_complemento(String End_complemento) {
        this.End_complemento = End_complemento;
    }

    public String getEnd_bairro() {
        return End_bairro;
    }

    public void setEnd_bairro(String End_bairro) {
        this.End_bairro = End_bairro;
    }

    public String getEnd_cidade() {
        return End_cidade;
    }

    public void setEnd_cidade(String End_cidade) {
        this.End_cidade = End_cidade;
    }

    public String getEnd_estado() {
        return End_estado;
    }

    public void setEnd_estado(String End_estado) {
        this.End_estado = End_estado;
    }

    public String getEnd_CEP() {
        return End_CEP;
    }
    
    public void setEnd_CEP(String End_CEP) {
        this.End_CEP = End_CEP;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getValidade_pontos() {
        return Validade_pontos;
    }

    public void setValidade_pontos(Date Validade_pontos) {
        this.Validade_pontos = Validade_pontos;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
