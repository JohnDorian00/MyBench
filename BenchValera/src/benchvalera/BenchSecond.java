/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchvalera;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author remai
 */
public class BenchSecond {

     
    public static double openDoc() {
        // Начало времени
        long time = System.nanoTime();
        double endTime;
        
        File f = new File("test.doc");
        for (int i = 0; i < 50000; i++) {
                try { 
                FileReader fr = new FileReader(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BenchSecond.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // Конец времени
        time = System.nanoTime() - time;
        //System.out.println(time);
        
        // Перевод в секунды
        endTime = time / 1000000000.0;
        System.out.printf("Bench2 = %.8f sec\n\n", endTime);

        return endTime;
    }      
}
