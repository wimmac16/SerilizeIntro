/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serilizeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class SchuelerBL extends AbstractListModel{

    private ArrayList<Schueler> klasse=new ArrayList<>();
    @Override
    public int getSize() {
        return klasse.size();
    }

    @Override
    public Object getElementAt(int index) {
        return klasse.get(index);
    }
    public void add(Schueler s){
        klasse.add(s);
    }
    public void load(File f)throws Exception{
        BufferedReader br=new BufferedReader(new FileReader (f));
        String line="";
        while((line=br.readLine())!=null){
            String[]parts=line.split(";");
            klasse.add(new Schueler(parts[0],LocalDate.parse(parts[1])));
        }
        
    }
    public void save(File f)throws Exception{
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
        for (Schueler s : klasse) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
    }
    public void print(){
        for (Schueler s : klasse) {
            System.out.format("%s %s\n", s.getName(),s.getBirthday());
        }
    }
    

    
}
