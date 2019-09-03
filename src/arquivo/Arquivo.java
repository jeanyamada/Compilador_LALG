/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivo;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ruimnodota
 */
public class Arquivo {

    public static String readFileImage(JFrame pai){
        
        Scanner scanner;
        
        JFileChooser jFileChooser = new JFileChooser();      
        
        jFileChooser.setAcceptAllFileFilterUsed(false);
        
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Txt file", "txt"));  
        
        if(jFileChooser.showOpenDialog(pai) == JFileChooser.APPROVE_OPTION){

            try {
                scanner = new Scanner(jFileChooser.getSelectedFile());
                String code = new String();
                
                while(scanner.hasNext()){
                    code+= scanner.nextLine();
                    code+="\n";
                }
                scanner.close();
                
                return code;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        
        return null;
    }
    
    public static void writeFileImage(JFrame pai,String code){
        
        PrintWriter printWriter;
        
        JFileChooser jFileChooser = new JFileChooser();        

        jFileChooser.setAcceptAllFileFilterUsed(false);
        
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Txt file", "txt"));
               
        if(jFileChooser.showSaveDialog(pai) == JFileChooser.APPROVE_OPTION){
            try {        
                printWriter = new PrintWriter(jFileChooser.getSelectedFile());
                
                printWriter.write(code);
                
                printWriter.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            }  
        }
    }
}
