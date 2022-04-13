
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        /*DEAKTIVERT HERFRA

        //Monitor1 monitor1 = new Monitor1();
        Monitor2 monitor2 = new Monitor2();
        File metadataFil = new File("testdatalike" + "/metadata.csv");
        Scanner metadataLeser = null;
        ArrayList<Thread> tradarr = new ArrayList<>();
        FletteTrad fletteTrad = new FletteTrad(monitor2);

        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }

        while(metadataLeser.hasNextLine()){ //denne finner ut antall tråder

            String forkast = metadataLeser.nextLine();
            LeseTrad testtrad = new LeseTrad("testdatalike" + "/" + forkast, monitor2);
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
        
        tradarr.clear();


        for (int i = 0; i < 8; i++) {
            Thread fletteTradThread = new Thread(fletteTrad);
            tradarr.add(fletteTradThread);
            //fletteTradThread.start();
        }

        while(monitor2.hentStørrelse() != 1){
            for (Thread thread : tradarr) {
                try {
                    thread.start();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            for(Thread i : tradarr){
                try {
                    i.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
        for(Thread i : tradarr){
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         

        System.out.println(monitor2.hentStørrelse());
        */ //TIL HIT
    }
}

