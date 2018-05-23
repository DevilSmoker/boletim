/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.model;

/**
 *
 * @author Adm
 */
public class Nota {
    
    private String id; 
    
    private Float av1;
    private Float av2;
    private Float media;
    private Float notaFinal;

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
     * @return the av1
     */
    public Float getAv1() {
        return av1;
    }

    /**
     * @param av1 the av1 to set
     */
    public void setAv1(Float av1) {
        this.av1 = av1;
    }

    /**
     * @return the av2
     */
    public Float getAv2() {
        return av2;
    }

    /**
     * @param av2 the av2 to set
     */
    public void setAv2(Float av2) {
        this.av2 = av2;
    }

    /**
     * @return the media
     */
    public Float getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Float media) {
        this.media = media;
    }

    /**
     * @return the notaFinal
     */
    public Float getNotaFinal() {
        return notaFinal;
    }

    /**
     * @param notaFinal the notaFinal to set
     */
    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    
    public void CalcMedia(){
        
        this.media = (this.av1+this.av2) / 2;
        
    }
}
