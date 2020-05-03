/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



/**
 *
 * @author 55419
 */
public class Usuario {
    String id;
    String nome;
    String email;
    String whatsapp;
    String cidade;
    String uf;
    
 public Usuario(String id, String nome, String email, String whatsapp, String cidade, String uf){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsapp;
        this.cidade = cidade;
        this.uf = uf;
    }
     
     public Usuario (String nome, String email, String whatsapp, String cidade, String uf){
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsapp;
        this.cidade = cidade;
        this.uf = uf;
    }
     
    public Usuario(String Id){
        this.id = id;
    }
    public Usuario(){
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the whatsapp
     */
    public String getWhatsapp() {
        return whatsapp;
    }

    /**
     * @param whatsapp the whatsapp to set
     */
    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
    
}
