/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serilizeintro;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author mwimm
 */
public class SaveTester {
    public static void main (String[]args){
        Schueler s1=new Schueler("Hans",LocalDate.of(1999,10,10));
        Schueler s2=new Schueler("Grete",LocalDate.of(2000,10,10));
                
                SchuelerBL bl=new SchuelerBL();
                bl.add(s2);
                bl.add(s1);
                
                try{
                    bl.save(new File("./klasse.csv"));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
    }
}
