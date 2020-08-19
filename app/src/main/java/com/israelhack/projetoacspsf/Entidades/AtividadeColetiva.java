package com.israelhack.projetoacspsf.Entidades;

import java.sql.Date;
/**
 *
 * @author Israel
 */

public class AtividadeColetiva {

    // atributos atend individual
    private int id;
    private String cnesUnidade;
    private String cnsProfissional;
    private String cboProfissional;
    private String cnsProfissional2;
    private String cboProfissional2;
    private int idProntuario;
    private int idLocalDeAtendimento;
    private int idTipoDeAtendimento;
    private int idTurno;
    private float pesoAcompanhemento;
    private float alturaAcompanhamento;
    private int idAleitoamentoMaterno;
    private int idadeGestacional;
    private int atencaoDomicModalidade;
    private int idPraticasIntegrativasComp;
    private int ficouObservacao;
    private int gravidezPlanejada;
    private int nuGestasprevias;
    private int nuPartos;
    private Date dtAtendimento;
    private int vacinaEmDia;
    private Date dumDaGestante;
    private int stEnvio;
    private Date dtEnvio;

    //contrutor vazio
    public AtividadeColetiva(){}

    //get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnesUnidade() {
        return cnesUnidade;
    }

    public void setCnesUnidade(String cnesUnidade) {
        this.cnesUnidade = cnesUnidade;
    }

    public String getCnsProfissional() {
        return cnsProfissional;
    }

    public void setCnsProfissional(String cnsProfissional) {
        this.cnsProfissional = cnsProfissional;
    }

    public String getCboProfissional() {
        return cboProfissional;
    }

    public void setCboProfissional(String cboProfissional) {
        this.cboProfissional = cboProfissional;
    }

    public String getCnsProfissional2() {
        return cnsProfissional2;
    }

    public void setCnsProfissional2(String cnsProfissional2) {
        this.cnsProfissional2 = cnsProfissional2;
    }

    public String getCboProfissional2() {
        return cboProfissional2;
    }

    public void setCboProfissional2(String cboProfissional2) {
        this.cboProfissional2 = cboProfissional2;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public int getIdLocalDeAtendimento() {
        return idLocalDeAtendimento;
    }

    public void setIdLocalDeAtendimento(int idLocalDeAtendimento) {
        this.idLocalDeAtendimento = idLocalDeAtendimento;
    }

    public int getIdTipoDeAtendimento() {
        return idTipoDeAtendimento;
    }

    public void setIdTipoDeAtendimento(int idTipoDeAtendimento) {
        this.idTipoDeAtendimento = idTipoDeAtendimento;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public float getPesoAcompanhemento() {
        return pesoAcompanhemento;
    }

    public void setPesoAcompanhemento(float pesoAcompanhemento) {
        this.pesoAcompanhemento = pesoAcompanhemento;
    }

    public float getAlturaAcompanhamento() {
        return alturaAcompanhamento;
    }

    public void setAlturaAcompanhamento(float alturaAcompanhamento) {
        this.alturaAcompanhamento = alturaAcompanhamento;
    }

    public int getIdAleitoamentoMaterno() {
        return idAleitoamentoMaterno;
    }

    public void setIdAleitoamentoMaterno(int idAleitoamentoMaterno) {
        this.idAleitoamentoMaterno = idAleitoamentoMaterno;
    }

    public int getIdadeGestacional() {
        return idadeGestacional;
    }

    public void setIdadeGestacional(int idadeGestacional) {
        this.idadeGestacional = idadeGestacional;
    }

    public int getAtencaoDomicModalidade() {
        return atencaoDomicModalidade;
    }

    public void setAtencaoDomicModalidade(int atencaoDomicModalidade) {
        this.atencaoDomicModalidade = atencaoDomicModalidade;
    }

    public int getIdPraticasIntegrativasComp() {
        return idPraticasIntegrativasComp;
    }

    public void setIdPraticasIntegrativasComp(int idPraticasIntegrativasComp) {
        this.idPraticasIntegrativasComp = idPraticasIntegrativasComp;
    }

    public int getFicouObservacao() {
        return ficouObservacao;
    }

    public void setFicouObservacao(int ficouObservacao) {
        this.ficouObservacao = ficouObservacao;
    }

    public int getGravidezPlanejada() {
        return gravidezPlanejada;
    }

    public void setGravidezPlanejada(int gravidezPlanejada) {
        this.gravidezPlanejada = gravidezPlanejada;
    }

    public int getNuGestasprevias() {
        return nuGestasprevias;
    }

    public void setNuGestasprevias(int nuGestasprevias) {
        this.nuGestasprevias = nuGestasprevias;
    }

    public int getNuPartos() {
        return nuPartos;
    }

    public void setNuPartos(int nuPartos) {
        this.nuPartos = nuPartos;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public int getVacinaEmDia() {
        return vacinaEmDia;
    }

    public void setVacinaEmDia(int vacinaEmDia) {
        this.vacinaEmDia = vacinaEmDia;
    }

    public Date getDumDaGestante() {
        return dumDaGestante;
    }

    public void setDumDaGestante(Date dumDaGestante) {
        this.dumDaGestante = dumDaGestante;
    }

    public int getStEnvio() {
        return stEnvio;
    }

    public void setStEnvio(int stEnvio) {
        this.stEnvio = stEnvio;
    }

    public Date getDtEnvio() {
        return dtEnvio;
    }

    public void setDtEnvio(Date dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

}


