/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.control;

import boletim.model.Aluno;
import boletim.model.Nota;
import boletim.view.Inicio;

/**
 *
 * @author Adm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        boletim.view.Inicio i = new Inicio();
        
        
        i.setVisible(true);
        
        // erro ao inserir status. TESTANDO:
        /*
        Nota n = new Nota();
                
                n.setAv1(8f);
                n.setAv2(3f);
                
                n.CalcMedia();
            
        Aluno a = new Aluno();
        
                a.GerarMatricula();
                
                
                
                System.out.println(n.getMedia()+" "+a.getStatus());
        */    
    }
    
}
