package com.israelhack.projetoacspsf.Entidades;

/**
 *
 * @author Israel
 */

public class VisitaDomiciliar {

    //metodos
    private String idProntuarioVisita;
    private String Turno;
    private String dtAtendimento;
    private String motivoVisita;
    private String tipoMovel;
    private String numCartaoSus;
    private String dtNascimento;
    private String Sexo;
    private String stVisitaCompartilhada;
    private String controleVetorial;
    private String Desfecho;

    //construtor vazio
    public VisitaDomiciliar(){}

    public VisitaDomiciliar(String idProntuarioVisita, String turno, String dtAtendimento, String motivoVisita,
                            String tipoMovel, String numCartaoSus, String dtNascimento, String sexo, String stVisitaCompartilhada,
                            String controleVetorial, String desfecho) {
        this.idProntuarioVisita = idProntuarioVisita;
        this.Turno = turno;
        this.dtAtendimento = dtAtendimento;
        this.motivoVisita = motivoVisita;
        this.tipoMovel = tipoMovel;
        this.numCartaoSus = numCartaoSus;
        this.dtNascimento = dtNascimento;
        this.Sexo = sexo;
        this.stVisitaCompartilhada = stVisitaCompartilhada;
        this.controleVetorial = controleVetorial;
        this.Desfecho = desfecho;
    }
//getters and setters

    public String getIdProntuarioVisita() {
        return idProntuarioVisita;
    }

    public void setIdProntuarioVisita(String idProntuarioVisita) {
        this.idProntuarioVisita = idProntuarioVisita;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String turno) {
        Turno = turno;
    }

    public String getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(String dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getTipoMovel() {
        return tipoMovel;
    }

    public void setTipoMovel(String tipoMovel) {
        this.tipoMovel = tipoMovel;
    }

    public String getNumCartaoSus() {
        return numCartaoSus;
    }

    public void setNumCartaoSus(String numCartaoSus) {
        this.numCartaoSus = numCartaoSus;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getStVisitaCompartilhada() {
        return stVisitaCompartilhada;
    }

    public void setStVisitaCompartilhada(String stVisitaCompartilhada) {
        this.stVisitaCompartilhada = stVisitaCompartilhada;
    }

    public String getControleVetorial() {
        return controleVetorial;
    }

    public void setControleVetorial(String controleVetorial) {
        this.controleVetorial = controleVetorial;
    }

    public String getDesfecho() {
        return Desfecho;
    }

    public void setDesfecho(String desfecho) {
        Desfecho = desfecho;
    }

    @Override
    public String toString() {
        return "VisitaDomiciliar{" +
                "motivoVisita='" + motivoVisita + '\'' +
                '}';
    }
}
