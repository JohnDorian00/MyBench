package MyBench;

import javax.swing.*;
import java.awt.*;

//Drawing bench
public class bench3 extends JFrame {

    private long drawTime;
    private long calculateTime;
    private int[] array = test();

    public long getCalculateTime() {
        return calculateTime;
    }

    public long getDrawTime(){
        return drawTime;
    }

    public long getTime() {
        long time = 0;
        time = drawTime - calculateTime;
        return time;
    }

    public bench3() {
        setSize(800, 600);
        setLocation(1050, 300);
        getContentPane().setLayout(null);
        setTitle("bench3");
    }

    public int[] test() {

        //Start calculate time
        long startTime = System.nanoTime();

        int[] array = new int[5000000];

        for (int i = 0; i < 5000000; i++) {
            array[i] = i * 2;
        }

        //End calculate time
        calculateTime = (System.nanoTime() - startTime);

        return array;
    }

    public void paint(Graphics g ) {

        //Start draw time
        long startTime = System.nanoTime();

        for (int i = 0; i < 3000000; i++ ) {
            g.drawRect(20, 50, array[i], array[i]);
        }

        //End calculate time
        drawTime = (System.nanoTime() - startTime);
    }
}

