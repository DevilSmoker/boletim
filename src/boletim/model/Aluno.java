/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.model;

/**
 *
 * @author mircio
 */
public class Aluno extends Entidade{
    private String matricula;
    private String Status;
    

    /**
     * @return the matricula
     */
    
    

    @Override
    public void setNome(String nome) {
        super.setNome(nome); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String GerarMatricula(){
        
        
        
        return matricula;
    }
    
    
    //PROBLEMA: NÃO ESTA GERANDO O STATUS!
    public void GerarStatus(){
        Nota n = new Nota();
        
        float media = n.getMedia();
        
        if(media >= 7 ){
                 this.setStatus("APROVADO!");
        }if ( media > 4  && media < 7){
             this.setStatus("FINAL");
        }else{
             this.setStatus("REPROVADO!");
            }
        
    }
    
   
    
}
