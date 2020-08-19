package com.israelhack.projetoacspsf.Entidades;

/**
 *
 * @author Israel
 */

public class CadastroDomiciliar {

    //Atributos de cadastro Domiciliar
    private String idprotuarioDomiciliar;
    private String cep;
    private String nomeMunicipio;
    private String nomeBairro;
    private String nomeEstado;
    private String nomeLogradouro;
    private String numero;
    private String nomeComplemento;
    private String pontoReferencia;
    private String numeroResidencia;
    private String numeroCelular;
    private String situacaoMoradia;
    private String localizacao;
    private String tipoDomicilio;

    private String tipoAcessoDomicilio;
    private String condicaoPosseTerra;
    private String materialConstrucao;
    private String energia;
    private String abastecimentoAgua;
    private String aguaConsumoDomicilio;
    private String escoamentoSanitario;
    private String destinoLixo;
    private String animaisDomicilio;


    //contrutor vazio
    public CadastroDomiciliar() {
    }
    public CadastroDomiciliar(String idprotuarioDomiciliar, String cep, String nomeMunicipio, String nomeBairro, String nomeEstado,
                              String nomeLogradouro, String numero, String nomeComplemento, String pontoReferencia, String numeroResidencia,
                              String numeroCelular, String situacaoMoradia, String localizacao, String tipoDomicilio, String tipoAcessoDomicilio,
                              String condicaoPosseTerra, String materialConstrucao, String energia, String abastecimentoAgua,
                              String aguaConsumoDomicilio, String escoamentoSanitario, String destinoLixo, String animaisDomicilio) {
        this.idprotuarioDomiciliar = idprotuarioDomiciliar;
        this.cep = cep;
        this.nomeMunicipio = nomeMunicipio;
        this.nomeBairro = nomeBairro;
        this.nomeEstado = nomeEstado;
        this.nomeLogradouro = nomeLogradouro;
        this.numero = numero;
        this.nomeComplemento = nomeComplemento;
        this.pontoReferencia = pontoReferencia;
        this.numeroResidencia = numeroResidencia;
        this.numeroCelular = numeroCelular;
        this.situacaoMoradia = situacaoMoradia;
        this.localizacao = localizacao;
        this.tipoDomicilio = tipoDomicilio;
        this.tipoAcessoDomicilio = tipoAcessoDomicilio;
        this.condicaoPosseTerra = condicaoPosseTerra;
        this.materialConstrucao = materialConstrucao;
        this.energia = energia;
        this.abastecimentoAgua = abastecimentoAgua;
        this.aguaConsumoDomicilio = aguaConsumoDomicilio;
        this.escoamentoSanitario = escoamentoSanitario;
        this.destinoLixo = destinoLixo;
        this.animaisDomicilio = animaisDomicilio;
    }

    //get e set

    public String getIdprotuarioDomiciliar() {
        return idprotuarioDomiciliar;
    }

    public void setIdprotuarioDomiciliar(String idprotuarioDomiciliar) {
        this.idprotuarioDomiciliar = idprotuarioDomiciliar;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeComplemento() {
        return nomeComplemento;
    }

    public void setNomeComplemento(String nomeComplemento) {
        this.nomeComplemento = nomeComplemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getSituacaoMoradia() {
        return situacaoMoradia;
    }

    public void setSituacaoMoradia(String situacaoMoradia) {
        this.situacaoMoradia = situacaoMoradia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoDomicilio() {
        return tipoDomicilio;
    }

    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    public String getTipoAcessoDomicilio() {
        return tipoAcessoDomicilio;
    }

    public void setTipoAcessoDomicilio(String tipoAcessoDomicilio) {
        this.tipoAcessoDomicilio = tipoAcessoDomicilio;
    }

    public String getCondicaoPosseTerra() {
        return condicaoPosseTerra;
    }

    public void setCondicaoPosseTerra(String condicaoPosseTerra) {
        this.condicaoPosseTerra = condicaoPosseTerra;
    }

    public String getMaterialConstrucao() {
        return materialConstrucao;
    }

    public void setMaterialConstrucao(String materialConstrucao) {
        this.materialConstrucao = materialConstrucao;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(String abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public String getAguaConsumoDomicilio() {
        return aguaConsumoDomicilio;
    }

    public void setAguaConsumoDomicilio(String aguaConsumoDomicilio) {
        this.aguaConsumoDomicilio = aguaConsumoDomicilio;
    }

    public String getEscoamentoSanitario() {
        return escoamentoSanitario;
    }

    public void setEscoamentoSanitario(String escoamentoSanitario) {
        this.escoamentoSanitario = escoamentoSanitario;
    }

    public String getDestinoLixo() {
        return destinoLixo;
    }

    public void setDestinoLixo(String destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public String getAnimaisDomicilio() {
        return animaisDomicilio;
    }

    public void setAnimaisDomicilio(String animaisDomicilio) {
        this.animaisDomicilio = animaisDomicilio;
    }

    @Override
    public String toString() {
        return "CadastroDomiciliar{" +
                "nomeMunicipio='" + nomeMunicipio + '\'' +
                '}';
    }
}