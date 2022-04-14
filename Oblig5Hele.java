import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Oblig5Hele {
    public static void main(String[] args) {
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
        System.out.println("Antall maps i sykdomT: " + sykdomT.antallMaps());
        System.out.println("Antall maps i sykdomF: " + sykdomF.antallMaps());

        CountDownLatch nedtellingsykdomT = new CountDownLatch(sykdomT.hentStørrelse() - 1);
        CountDownLatch nedtellingsykdomF = new CountDownLatch(sykdomF.hentStørrelse() - 1);
        // fletting av sykdomT
        for (int i = 0; i < 8; i++) {
            FletteTrad fletteTrad = new FletteTrad(sykdomT, nedtellingsykdomT);
            Thread traad = new Thread(fletteTrad);
            threads.add(traad);
            traad.start();
        }
        // fletting av sykdomF
        for (int i = 0; i < 8; i++) {
            FletteTrad fletteTrad = new FletteTrad(sykdomF, nedtellingsykdomF);
            Thread traad = new Thread(fletteTrad);
            threads.add(traad);
            traad.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
        System.out.println("\nsykdomT forekomst:"
                + sykdomT.finnHøyestefremkomster(sykdomT.subsekvensRegister.SubsekvensRegister.get(0)));
        System.out.println("\nsykdomF forekomst:"
                + sykdomF.finnHøyestefremkomster(sykdomF.subsekvensRegister.SubsekvensRegister.get(0)));
        HashMap<String, Subsekvens> sykdomTmap = sykdomT.hentHash();
        HashMap<String, Subsekvens> sykdomFmap = sykdomF.hentHash();

        /*
         * System.out.println("\n\nsykdomTmap" + sykdomTmap);
         * System.out.println("\n\nsykdomFmap" + sykdomFmap);
         */

        boolean finnes = false;
        ArrayList<Subsekvens> tempSubHolder = new ArrayList<>();
        // for loopene nede finner hvilken Subsekvenser en frisk person har som en

        for (Subsekvens subF : sykdomFmap.values()) {
            tempSubHolder.add(subF);
        }

        for (Subsekvens subT : sykdomTmap.values()) {
            Subsekvens SubHolder = null;
            for (Subsekvens subF : tempSubHolder) {
                if (subF.subsekvens.equals(subT.subsekvens)) {
                    finnes = true;
                }
            }
            if (finnes) {
                finnes = false;
                // tempSubHolder.add(subT);
            } else if (!finnes) {
                finnes = false;
                Subsekvens nullSub = new Subsekvens(subT.subsekvens);
                nullSub.settnullForekomst();
                tempSubHolder.add(nullSub);
            }

        }

        for (Subsekvens sub : tempSubHolder) {
            if (sub.forekomster > 0) {
                System.out.println("mer enn 0 forekomst: " + sub);
            }
        }

        System.out.println("\nAntall subT i sykdomTmap: " + sykdomTmap.size());
        System.out.println("\nAntall subF i sykdomFmap: " + sykdomFmap.size());
        System.out.println("\nAntall forskjellige sub i sykdomTmap + sykdomFmap: " + tempSubHolder.size());

        System.out.println("\nAlle forskjellige Subsekvenser (subF + subT): \n" + tempSubHolder);

    }
}
