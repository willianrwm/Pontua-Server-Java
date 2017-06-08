package pontua.objeto;


import java.sql.Date;


public class Promocao {

    private int ID;
    private String Nome;
    private int Qtd_pontos;
    private Date Inicio_vigencia;
    private Date Final_vigencia;
    private Date Validade;
    private int ID_Representante;

    public Promocao() {
    }

    public Promocao(int ID, String Nome, int Qtd_pontos, Date Inicio_vigencia, Date Final_vigencia, Date Validade, int ID_Representante) {
        this.ID = ID;
        this.Nome = Nome;
        this.Qtd_pontos = Qtd_pontos;
        this.Inicio_vigencia = Inicio_vigencia;
        this.Final_vigencia = Final_vigencia;
        this.Validade = Validade;
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

    public int getQtd_pontos() {
        return Qtd_pontos;
    }

    public void setQtd_pontos(int Qtd_pontos) {
        this.Qtd_pontos = Qtd_pontos;
    }

    public Date getInicio_vigencia() {
        return Inicio_vigencia;
    }

    public void setInicio_vigencia(Date Inicio_vigencia) {
        this.Inicio_vigencia = Inicio_vigencia;
    }

    public Date getFinal_vigencia() {
        return Final_vigencia;
    }

    public void setFinal_vigencia(Date Final_vigencia) {
        this.Final_vigencia = Final_vigencia;
    }

    public Date getValidade() {
        return Validade;
    }

    public void setValidade(Date Validade) {
        this.Validade = Validade;
    }

    public int getID_Representante() {
        return ID_Representante;
    }

    public void setID_Representante(int ID_Representante) {
        this.ID_Representante = ID_Representante;
    }
    
}
