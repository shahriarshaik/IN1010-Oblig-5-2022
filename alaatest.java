
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class alaatest {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        Monitor2 sykdomT = new Monitor2();
        Monitor2 sykdomF = new Monitor2();
        String lokasjon = "testdataliten";
        File filen = new File(lokasjon + "/metadata.csv");
        Scanner metaLeser = null;
        ArrayList<String> falseArr = new ArrayList<>();
        ArrayList<String> trueArr = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        try {
            metaLeser = new Scanner(filen);
        } catch (Exception e) {
            // TODO: handle exception
        }

        while (metaLeser.hasNextLine()) {
            String holder = metaLeser.nextLine();
            String[] split = holder.split(","); // 0 = fil1.csv, 1 = True / False
            System.out.println("leser fil: " + split[0] + " . . .");
            if (split[1].equals("True")) {
                trueArr.add(split[0]);
                LeseTrad testtrad = new LeseTrad(lokasjon + "/" + split[0], sykdomT);
                Thread trad = new Thread(testtrad);
                threads.add(trad);
                trad.start();
            } else if (split[1].equals("False")) {
                falseArr.add(split[0]);
                LeseTrad testtrad = new LeseTrad(lokasjon + "/" + split[0], sykdomF);
                Thread trad = new Thread(testtrad);
                threads.add(trad);
                trad.start();
            } else {
                System.out.println(split[0] + " Hadde ikke True / False i seg");
            }
        }

        for (Thread i : threads) {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
        System.out.println(sykdomF.subsekvensRegister.SubsekvensRegister.size());
        System.out.println(sykdomT.subsekvensRegister.SubsekvensRegister.size());



        //System.out.println(sykdomF.finnHøyestefremkomster(sykdomTmap));


    }

}
