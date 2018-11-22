package model;


import java.util.Date;


public class Remedio {
    private int codBarras;
    private String nome;
    private String bula;
    private String fabricacao;
    private String validade;
    private int quantidade;
    
    public Remedio(){

        super();
    }
    public Remedio(int codBarras, String nome, String bula, String fabricacao, String validade, int quantidade){
        this.codBarras = codBarras;
        this.nome = nome;
        this.bula = bula;
        this.validade = validade;
        this.fabricacao = fabricacao;
        this.quantidade = quantidade;
        
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        if(codBarras != 0){
        this.codBarras = codBarras;
        }
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }
    }

    public String getBula() {
        return bula;
    }

    public void setBula(String bula) {
        if(bula != null){
            this.bula = bula;
        }
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String Validade) {
       if(validade != null){
           this.validade = validade;
       }
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
       if(fabricacao!= null){
           this.fabricacao = fabricacao;
       }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
       if(quantidade != 0){
           this.quantidade = quantidade;
       }
    }
    
    
    
}
