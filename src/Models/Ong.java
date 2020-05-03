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
public class Ong  {
    private String id;
    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;

     public Ong(String id, String nome, String email, String whatsapp, String city, String uf){
        this.id = id;
        this.name = nome;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city = city;
        this.uf = uf;
    }
     
     public Ong (String nome, String email, String whatsapp, String cidade, String uf){
        this.name = nome;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city= cidade;
        this.uf = uf;
    }
    public Ong(){
        
    }
        
     public void mostraOng(){
       //System.out.println("ID : " + getId());
       System.out.println("Nome : " + getName());
       System.out.println("Email : " + getEmail());
       System.out.println("WhatsApp : " + getWhatsapp());
       System.out.println("Cidade : " + getCity());
       System.out.println("UF : " + getUf());
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    public String getCity() {
        return city;
    }

    /**
     * @param city the cidade to set
     */
    public void setCity(String city) {
        this.city = city;
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
