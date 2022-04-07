import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class test {

    public static void main(String[] args) {

        /* setter dissse på pause, for å sette de inn i while loopen nede 
        Monitor1 monitor = new Monitor1();
        LeseTrad testtrad = new LeseTrad("fil1.txt", monitor);
        Thread trad = new Thread(testtrad);
        */
        Monitor1 monitor = new Monitor1();



        int nodvendigeTrader = 0;
        File metadataFil = new File("testdatalike" + "/metadata.csv");
        String filen = null;
        SubsekvensRegister register = new SubsekvensRegister();
        Scanner metadataLeser = null;
        CountDownLatch minBariere = new CountDownLatch(6);
        ArrayList<Thread> tradarr = new ArrayList<>();


        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }


        while(metadataLeser.hasNextLine()){ //denne finner ut antall tråder
            String forkast = metadataLeser.nextLine();
            nodvendigeTrader++;

            LeseTrad testtrad = new LeseTrad("testdatalike/"+forkast, monitor);
            Thread trad = new Thread(testtrad);
            tradarr.add(trad);
            trad.start();
            //minBariere.countDown();
        }

        for(Thread i : tradarr){
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Thread idkThread = new Thread(System.out.println("noe"));

        //idkThread.join();
        System.out.println(monitor.finnHøyestefremkomster(monitor.flettAlt()));



    }
    
}
