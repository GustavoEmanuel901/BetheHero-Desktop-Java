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
public class Listagem {
    private String name;
    private String email;
    private String whatsapp;
    private String title;
    private String description;
    private float value;

    /**
     * @return the nome
     */
    
    public Listagem(String title, String name, String email, String whatsapp, String description, float value){
        this.name = name;
        this.email = email;
        this.whatsapp = whatsapp;
        this.title = title;
        this.description = description;
        this.value = value;
    }
     
     
    public Listagem(){
        
    }
    public String getName() {
        return name;
    }

    /**
     * @param nome the nome to set
     */
    public void setName(String nome) {
        this.name = nome;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }
}
