package MyBench;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.*;

public class Main {

    private long readTime;
    private long writeTime;

    /////////////////////////////////////////
    //calculate числовой ряд         //////
    private long bench1() {
        System.out.println("bench1 starting...");
        long outTime;

        //Start calculate time
        long startTime = System.nanoTime();
        double sum = 0;
        for (double x = 0; x < 2500000; x++) {

            sum += pow( ((Math.cos(Math.toRadians(x)) * Math.sin(Math.toRadians(x))) * PI * Math.cos(Math.toRadians(pow(x, x))) * 1024), ( x * x * Math.log(x) + Math.sin(x) ));

        }
        //System.out.println(System.nanoTime() - startTime);

        //End calculate time
        outTime = (System.nanoTime() - startTime);

        return outTime ;
    }

    private void createCopyOfImages() {

        try {
            BufferedImage img = ImageIO.read(new File("image.jpg"));
            for (int i = 0; i < 20; i++) {
                //Read in image
                ImageIO.write(img, "jpeg", new File("image" + i + ".jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////
    //Open jpeg                       ///////
    private long bench2() {
        System.out.println("bench2 starting...");
        createCopyOfImages();
        long outTime;
        BufferedImage imgBuf = null;




        try
        {
            //Start read time
            long startTime = System.nanoTime();

            for (int i = 0; i < 20; i++) {
                //Read in image
                imgBuf = ImageIO.read(new File("image" + i + ".jpg"));
            }

            //End read time
            readTime = (System.nanoTime() - startTime);

            //Start write time
            startTime = System.nanoTime();

            for (int i = 0; i < 20; i++) {
                //Write image
                ImageIO.write(imgBuf, "jpeg", new File("image_new" + i + ".jpg"));
            }

            //End read time
            writeTime = (System.nanoTime() - startTime);
        }
        catch(IOException ignored){}

        //End open time
        outTime = writeTime + readTime;

        return outTime ;
    }

    private static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("cls");
        } catch (IOException | InterruptedException ignored) {}
    }

    public static void main(String[] args) throws InterruptedException {

        Main test = new Main();
        long time1, time2, time3;

        //first bench
        time1 = test.bench1();
        System.out.printf("|bench1 result| ---> %d nanoSec or %.9f Sec\n\n", time1, time1 / 1000000000.0);
        //second bench
        time2 = test.bench2();
        System.out.printf("|bench2 read result| ---> %d nanoSec or %.9f Sec\n", test.readTime, test.readTime / 1000000000.0);
        System.out.printf("|bench2 write result| ---> %d nanoSec or %.9f Sec\n", test.writeTime, test.writeTime / 1000000000.0);
        System.out.printf("|bench2 all result| ---> %d nanoSec or %.9f Sec\n\n", time2, time2 / 1000000000.0);

        //third bench
        System.out.println("bench3 starting...");

        bench3 window = new bench3();
        for (;;) {
            //System.out.println(window.getCalculateTime());
            if (window.getCalculateTime() != 0) {
                break;
            }
        }

        time3 = window.getCalculateTime();
        System.out.printf("|bench3 calculate result| ---> %d nanoSec or %.9f Sec\n", time3, time3 / 1000000000.0);

        window.setVisible(true);
        while (window.getDrawTime() == 0) {
            System.out.print("");
        }

        time3 = window.getDrawTime();
        //window.setVisible(false);
        System.out.printf("|bench3 draw result| ---> %d nanoSec or %.9f Sec\n", time3, time3 / 1000000000.0);

        time3 = window.getTime();
        System.out.printf("|bench3 result| ---> %d nanoSec or %.9f Sec\n\n", time3, time3 / 1000000000.0);


        System.out.print("Press enter to continue\n");
        System.console().readLine();
        window.dispose();
        Thread.sleep(1500);
        clrscr();

         System.out.print("|   |\tbench1\t\t|\tbench2\t\t|\tbench3\t\t|\tscore\t\t|\n");
        System.out.print("---------------------------------------------------------------------------------------------------------\n");
        System.out.print("| 1 |\t2295835685\t|\t3275144216\t|\t3197557981\t|\tscore\t|\n");
        System.out.print("---------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| 2 |\t%d\t|\t%d\t|\t%d\t|\tscore\t|\n", time1, time2, time3);
        System.out.print("---------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| 3 |\t%d\t|\t%d\t|\t%d\t|\tscore\t|\n", time1, time2, time3);
        System.out.print("---------------------------------------------------------------------------------------------------------\n\n");

        System.out.print("Press enter to continue\n");
        System.console().readLine();

    }

}
