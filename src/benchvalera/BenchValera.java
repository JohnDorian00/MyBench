/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchvalera;

import matrix.Matrix;

/**
 *
 * @author remai
 */
public class BenchValera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        double []time = {0, 0, 0, 0};
        
        // Бенч1
         System.out.println("Запуск первого бенчмарка...");
         Matrix mt1 = Matrix.createMatrix(750, 750);
         for (int i = 0; i < 750; i++) {
            for (int j = 0; j < 750; j++) {
                mt1.setElem(i, j, 1);
            }
         }
        time[0] = BenchFirst.gauss(mt1); 
        
        // Бенч2
        System.out.println("Запуск второго бенчмарка...");
        time[1] = BenchSecond.openDoc(); 
        
        // Бенч3
        System.out.println("Запуск третьего бенчмарка...");
        BenchThird test = new BenchThird();
        while (test.getEndTime() == 0) {
            System.out.print("");
        }
        time[2] = test.getEndTime();
        test.dispose();
        
        time[3] = Math.pow( time[0] * time[1] * time[2] , (1.0/ 3.0));
        System.out.printf("index = %.8f", time[3]);
        
        MainWindow mainWindow = new MainWindow( time );
        mainWindow.setVisible(true);
        
    }
    
}
