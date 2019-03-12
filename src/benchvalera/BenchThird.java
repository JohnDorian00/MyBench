/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchvalera;

import javax.swing.*;
import java.awt.*;

//Drawing bench
public class BenchThird extends JFrame {
    
    double endTime = 0;
    
    public BenchThird() {
       
        setSize(400, 500);
        setLocation(1050, 300);
        getContentPane().setLayout(null);
        setTitle("Bench third");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
  
    public double getEndTime() {
        //System.out.printf("Bench3 from 3becnh = %.8f\n", endTime);
        return endTime;
    }
    
    
    @Override
    public void paint(Graphics g ) {
        
         // Начало времени
        long time = System.nanoTime();

        Graphics2D g2 = (Graphics2D) g;
        
        int xPoly[] = {50, 350, 200};
        int yPoly[] = {450, 450, 50};
        Color[] colors = {Color.RED, Color.BLUE, Color.PINK};
        
        for (int i= 0; i < 30000; i++) {
            for (int j = 0; j < 3; j++ ) {
                g2.setPaint(colors[j]);
                g2.fillPolygon(xPoly, yPoly, 3);
            }
        }
        
         // Конец времени
        time = System.nanoTime() - time;
        
        // Перевод в секунды
        endTime += time / 1000000000.0;
        System.out.printf("Bench3 = %.8f sec\n\n", endTime);
        setVisible(false);
        
    }
}


