import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2B {
    public static void main(String[] args) {

        String filen = "testdataliten";

        Monitor2 monitor = new Monitor2();
        File metadataFil = new File(filen + "/metadata.csv");
        Scanner metadataLeser = null;
        ArrayList<Thread> tradarr = new ArrayList<>();

        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }

        while (metadataLeser.hasNextLine()) { // denne finner ut antall tråder

            String forkast = metadataLeser.nextLine(); // eksempel fil1.csv,false
            String[] split = forkast.split(",");
            LeseTrad testtrad = new LeseTrad(filen + "/" + split[0], monitor);
            Thread trad = new Thread(testtrad);
            tradarr.add(trad);
            trad.start();
        }

        for (Thread i : tradarr) {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tradarr.clear();

        CountDownLatch nedtelling = new CountDownLatch(monitor.hentStørrelse() - 1);
        for (int i = 0; i < 8; i++) {
            FletteTrad fletteTrad = new FletteTrad(monitor, nedtelling);
            Thread traad = new Thread(fletteTrad);
            tradarr.add(traad);
            traad.start();
            // System.out.println("størrelse inni forloop: " + monitor.hentStørrelse());
        }

        for (Thread thread : tradarr) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tradarr.clear();

        // System.out.println(monitor.subsekvensRegister.SubsekvensRegister.size());

        System.out.println(monitor.finnHøyestefremkomster(monitor.subsekvensRegister.SubsekvensRegister.get(0)));
        // System.out.println(monitor.finnHøyestefremkomster(monitor.flettAlt()));
    }
}
