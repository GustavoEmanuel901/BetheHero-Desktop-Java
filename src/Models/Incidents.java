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
public class Incidents {
    private String id;
    private String title;
    private String description;
    private float value;
    private String ong_id;
    
    public Incidents(String id, String title, String description, float value, String ong_id){
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
        this.ong_id = ong_id;
    }
    
     public Incidents(String title, String description, float value, String ong_id){
        this.title = title;
        this.description = description;
        this.value = value;
        this.ong_id = ong_id;
     }
    
    public Incidents(){
        
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

    /**
     * @return the ong_id
     */
    public String getOng_id() {
        return ong_id;
    }

    /**
     * @param ong_id the ong_id to set
     */
    public void setOng_id(String ong_id) {
        this.ong_id = ong_id;
    }
    
    public void mostraIncident(){
       //System.out.println("ID: " + getId());
       System.out.println("Titulo: " + getTitle());
       System.out.println("Descrição: " + getDescription());
       System.out.println("Valor: " + getValue());
       //System.out.println("ID da Ong : " + getOng_id());
   }
     
  
}
