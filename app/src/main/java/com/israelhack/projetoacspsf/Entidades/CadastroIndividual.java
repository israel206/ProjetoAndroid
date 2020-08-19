package com.israelhack.projetoacspsf.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Israel
 */

public class CadastroIndividual {

    // atributos cds individual

    private String idProntuario;
    private String cnsCidadao;
    private String cidadaoResponsavelFamiliar;
    private String cnsResponsavelFamiliar;
    private String nomeCompleto;
    private String nomeSocial;
    private String racaCor;
    private String dataNascimento;
    private String sexo;
    private String dadosPis;
    private String nomeMae;
    private String nomePai;
    private String nacionalidade;
    private String paizNascimento;
    private String dataNaturalizacao;
    private String portariaNaturalizacao;
    private String municipioNascimento;
    private String dataEntradaBrasil;
    private String telCelular;
    private String email;

    private String relacaoParentesco;
    private String frequentouEscola;
    private String situacaoMercado;
    private String deficiencia;
    private String gestante;
    private String peso;
    private String respiratorioPulmao;
    private String fumante;
    private String alcool;
    private String outraDrogas;
    private String hipertensao;
    private String diabete;
    private String avcDerrame;
    private String infarto;
    private String cardiaca;
    private String hanseniase;
    private String tuberculose;
    private String cancer;
    private  String rins;



    //Construtor vazio
    public CadastroIndividual(){}

    public CadastroIndividual(String idProntuario, String cnsCidadao, String cidadaoResponsavelFamiliar, String cnsResponsavelFamiliar,
                              String nomeCompleto, String nomeSocial, String racaCor, String dataNascimento, String sexo, String dadosPis,
                              String nomeMae, String nomePai, String nacionalidade, String paizNascimento, String dataNaturalizacao,
                              String portariaNaturalizacao, String municipioNascimento, String dataEntradaBrasil, String telCelular, String email,
                              String relacaoParentesco, String frequentouEscola, String situacaoMercado, String deficiencia, String gestante, String peso,
                              String respiratorioPulmao, String fumante, String alcool, String outraDrogas, String hipertensao, String diabete, String avcDerrame,
                              String infarto, String cardiaca,
                              String hanseniase, String tuberculose, String cancer, String rins) {
        this.idProntuario = idProntuario;
        this.cnsCidadao = cnsCidadao;
        this.cidadaoResponsavelFamiliar = cidadaoResponsavelFamiliar;
        this.cnsResponsavelFamiliar = cnsResponsavelFamiliar;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.racaCor = racaCor;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.dadosPis = dadosPis;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.nacionalidade = nacionalidade;
        this.paizNascimento = paizNascimento;
        this.dataNaturalizacao = dataNaturalizacao;
        this.portariaNaturalizacao = portariaNaturalizacao;
        this.municipioNascimento = municipioNascimento;
        this.dataEntradaBrasil = dataEntradaBrasil;
        this.telCelular = telCelular;
        this.email = email;
        this.relacaoParentesco = relacaoParentesco;
        this.frequentouEscola = frequentouEscola;
        this.situacaoMercado = situacaoMercado;
        this.deficiencia = deficiencia;
        this.gestante = gestante;
        this.peso = peso;
        this.respiratorioPulmao = respiratorioPulmao;
        this.fumante = fumante;
        this.alcool = alcool;
        this.outraDrogas = outraDrogas;
        this.hipertensao = hipertensao;
        this.diabete = diabete;
        this.avcDerrame = avcDerrame;
        this.infarto = infarto;
        this.cardiaca = cardiaca;
        this.hanseniase = hanseniase;
        this.tuberculose = tuberculose;
        this.cancer = cancer;
        this.rins = rins;
    }

    /**
    // CRIANDO METODO SALVA
    public void Salva(){
        //salva auteticacao, e cria um db
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("individual").child(String.valueOf(getIdProntuario())).setValue(this);
    }

    @Exclude

    public Map<String, Object> toMap2() {
        HashMap<String, Object> hashMapcadastroIndividual = new HashMap<>();

        hashMapcadastroIndividual.put("idProntuario",getIdProntuario());
        hashMapcadastroIndividual.put("cnsCidadao",getCnsCidadao());
        hashMapcadastroIndividual.put("cidadaoResponsavelFamiliar",getCidadaoResponsavelFamiliar());
        hashMapcadastroIndividual.put("cnsResponsavelFamiliar",getCnsResponsavelFamiliar());
        hashMapcadastroIndividual.put("nomeCompleto",getNomeCompleto());
        hashMapcadastroIndividual.put("nomeSocial",getNomeSocial());
        hashMapcadastroIndividual.put("racaCor",getRacaCor());
        hashMapcadastroIndividual.put("dadosPis",getDadosPis());
        hashMapcadastroIndividual.put("dataNascimento",getDataNascimento());
        hashMapcadastroIndividual.put("sexo",getSexo());
        hashMapcadastroIndividual.put("nomeMae",getNomeMae());
        hashMapcadastroIndividual.put("nomePai",getNomePai());
        hashMapcadastroIndividual.put("nacionalidade",getNacionalidade());
        hashMapcadastroIndividual.put("paizNascimento",getPaizNascimento());
        hashMapcadastroIndividual.put("dataNaturalizacao",getDataNaturalizacao());
        hashMapcadastroIndividual.put("portariaNaturalizacao",getPortariaNaturalizacao());
        hashMapcadastroIndividual.put("municipioNascimento",getMunicipioNascimento());
        hashMapcadastroIndividual.put("dataEntradaBrasil",getDataEntradaBrasil());
        hashMapcadastroIndividual.put("telCelular",getTelCelular());
        hashMapcadastroIndividual.put("email",getEmail());
        hashMapcadastroIndividual.put("relacaoParentesco",getRelacaoParentesco());
        hashMapcadastroIndividual.put("frequentaEscolaCreche",getFrequentouEscola());
        hashMapcadastroIndividual.put("situacaoMercado",getSituacaoMercado());
        hashMapcadastroIndividual.put("Deficiencia",getDeficiencia());
        hashMapcadastroIndividual.put("Gestante",getGestante());
        hashMapcadastroIndividual.put("respiratorioPumao",getRespiratorioPulmao());
        hashMapcadastroIndividual.put("Fumante",getFumante());
        hashMapcadastroIndividual.put("Alcool",getAlcool());
        hashMapcadastroIndividual.put("dependeDroga",getOutraDrogas());
        hashMapcadastroIndividual.put("hipertenso",getHipertensao());
        hashMapcadastroIndividual.put("diabete",getDiabete());
        hashMapcadastroIndividual.put("avcDerrame",getAvcDerrame());
        hashMapcadastroIndividual.put("infarto",getInfarto());
        hashMapcadastroIndividual.put("hanseniase",getHanseniase());
        hashMapcadastroIndividual.put("tuberculose",getTuberculose());
        hashMapcadastroIndividual.put("cancer",getCancer());
        hashMapcadastroIndividual.put("rins",getRins());

        return hashMapcadastroIndividual;
    }
**/

    //get e set

    public String getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(String idProntuario) {
        this.idProntuario = idProntuario;
    }

    public String getCnsCidadao() {
        return cnsCidadao;
    }

    public void setCnsCidadao(String cnsCidadao) {
        this.cnsCidadao = cnsCidadao;
    }

    public String getCidadaoResponsavelFamiliar() {
        return cidadaoResponsavelFamiliar;
    }

    public void setCidadaoResponsavelFamiliar(String cidadaoResponsavelFamiliar) {
        this.cidadaoResponsavelFamiliar = cidadaoResponsavelFamiliar;
    }

    public String getCnsResponsavelFamiliar() {
        return cnsResponsavelFamiliar;
    }

    public void setCnsResponsavelFamiliar(String cnsResponsavelFamiliar) {
        this.cnsResponsavelFamiliar = cnsResponsavelFamiliar;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDadosPis() {
        return dadosPis;
    }

    public void setDadosPis(String dadosPis) {
        this.dadosPis = dadosPis;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPaizNascimento() {
        return paizNascimento;
    }

    public void setPaizNascimento(String paizNascimento) {
        this.paizNascimento = paizNascimento;
    }

    public String getDataNaturalizacao() {
        return dataNaturalizacao;
    }

    public void setDataNaturalizacao(String dataNaturalizacao) {
        this.dataNaturalizacao = dataNaturalizacao;
    }

    public String getPortariaNaturalizacao() {
        return portariaNaturalizacao;
    }

    public void setPortariaNaturalizacao(String portariaNaturalizacao) {
        this.portariaNaturalizacao = portariaNaturalizacao;
    }

    public String getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public String getDataEntradaBrasil() {
        return dataEntradaBrasil;
    }

    public void setDataEntradaBrasil(String dataEntradaBrasil) {
        this.dataEntradaBrasil = dataEntradaBrasil;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacaoParentesco() {
        return relacaoParentesco;
    }

    public void setRelacaoParentesco(String relacaoParentesco) {
        this.relacaoParentesco = relacaoParentesco;
    }

    public String getFrequentouEscola() {
        return frequentouEscola;
    }

    public void setFrequentouEscola(String frequentouEscola) {
        this.frequentouEscola = frequentouEscola;
    }

    public String getSituacaoMercado() {
        return situacaoMercado;
    }

    public void setSituacaoMercado(String situacaoMercado) {
        this.situacaoMercado = situacaoMercado;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRespiratorioPulmao() {
        return respiratorioPulmao;
    }

    public void setRespiratorioPulmao(String respiratorioPulmao) {
        this.respiratorioPulmao = respiratorioPulmao;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public String getOutraDrogas() {
        return outraDrogas;
    }

    public void setOutraDrogas(String outraDrogas) {
        this.outraDrogas = outraDrogas;
    }

    public String getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    public String getDiabete() {
        return diabete;
    }

    public void setDiabete(String diabete) {
        this.diabete = diabete;
    }

    public String getAvcDerrame() {
        return avcDerrame;
    }

    public void setAvcDerrame(String avcDerrame) {
        this.avcDerrame = avcDerrame;
    }

    public String getInfarto() {
        return infarto;
    }

    public void setInfarto(String infarto) {
        this.infarto = infarto;
    }

    public String getCardiaca() {
        return cardiaca;
    }

    public void setCardiaca(String cardiaca) {
        this.cardiaca = cardiaca;
    }

    public String getHanseniase() {
        return hanseniase;
    }

    public void setHanseniase(String hanseniase) {
        this.hanseniase = hanseniase;
    }

    public String getTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(String tuberculose) {
        this.tuberculose = tuberculose;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getRins() {
        return rins;
    }

    public void setRins(String rins) {
        this.rins = rins;
    }

    @Override
    public String toString() {
        return "CadastroIndividual{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}