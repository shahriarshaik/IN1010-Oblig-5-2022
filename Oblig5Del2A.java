import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblig5Del2A {
    public static void main(String[] args) {

        Monitor1 monitor = new Monitor1();
        File metadataFil = new File(args[0] + "/metadata.csv");
        Scanner metadataLeser = null;
        ArrayList<Thread> tradarr = new ArrayList<>();

        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }

        while(metadataLeser.hasNextLine()){ //denne finner ut antall tråder

            String forkast = metadataLeser.nextLine();
            LeseTrad testtrad = new LeseTrad(args[0] + "/" + forkast, monitor);
            Thread trad = new Thread(testtrad);
            tradarr.add(trad);
            trad.start();
        }
        for(Thread i : tradarr){
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(monitor.finnHøyestefremkomster(monitor.flettAlt()));
    }
}
