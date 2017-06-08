package pontua.objeto;


import java.sql.Date;


public class Premio {
    
    private int ID;
    private String Nome;
    private String Descricao;
    private double Qtd_disponivel;
    private Date Validade;
    private double Valor_pontos;
    private int ID_Representante;

    public Premio() {
    }

    public Premio(int ID, String Nome, String Descricao, double Qtd_disponivel, Date Validade, double Valor_pontos, int ID_Representante) {
        this.ID = ID;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Qtd_disponivel = Qtd_disponivel;
        this.Validade = Validade;
        this.Valor_pontos = Valor_pontos;
        this.ID_Representante = ID_Representante;
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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double getQtd_disponivel() {
        return Qtd_disponivel;
    }

    public void setQtd_disponivel(double Qtd_disponivel) {
        this.Qtd_disponivel = Qtd_disponivel;
    }

    public Date getValidade() {
        return Validade;
    }

    public void setValidade(Date Validade) {
        this.Validade = Validade;
    }

    public double getValor_pontos() {
        return Valor_pontos;
    }

    public void setValor_pontos(double Valor_pontos) {
        this.Valor_pontos = Valor_pontos;
    }

    public int getID_Representante() {
        return ID_Representante;
    }

    public void setID_Representante(int ID_Representante) {
        this.ID_Representante = ID_Representante;
    }
}
