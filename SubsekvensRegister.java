import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class SubsekvensRegister {

    public ArrayList<HashMap<String, Subsekvens>> SubsekvensRegister = new ArrayList<>();

    public void settInnHash(HashMap<String, Subsekvens> hashMap) {
        SubsekvensRegister.add(hashMap);
    }

    public HashMap<String, Subsekvens> hentHash() {
        int index = 0;
        try {
            return SubsekvensRegister.get(index);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<HashMap<String, Subsekvens>> hentToHash() {
        ArrayList<HashMap<String, Subsekvens>> retur = new ArrayList<>();
        HashMap<String, Subsekvens> en, to;

        try {
            en = SubsekvensRegister.get(0);
            to = SubsekvensRegister.get(1);
            SubsekvensRegister.remove(en);
            SubsekvensRegister.remove(to);
            retur.add(en);
            retur.add(to);
            return retur;
        } catch (Exception e) {
            // System.out.println("hentToHash(): ikke nok maps");
            return null;
        }
    }

    public int antallMaps() {
        int maps = SubsekvensRegister.size();
        return maps;
    }

    public static HashMap<String, Subsekvens> lesFil(String filnavn) {
        HashMap<String, Subsekvens> tempHash = new HashMap<>();
        File filen = new File(filnavn);
        String holder;
        String ordholder;
        try {
            Scanner lesefil = new Scanner(filen);
            while (lesefil.hasNext()) {
                holder = lesefil.nextLine(); // eksempel: CASSRQGFLDEQYF
                Scanner ord = new Scanner(holder);
                ordholder = ord.next();
                String[] fordeleBokstaver = ordholder.split("");

                for (int i = 0; fordeleBokstaver.length > i; i++) {
                    String print;
                    print = fordeleBokstaver[i];

                    try {
                        print = print + fordeleBokstaver[i + 1];
                        print = print + fordeleBokstaver[i + 2];
                        tempHash.put(print, new Subsekvens(print));

                        print = "";

                    } catch (Exception e) {
                        break;
                    }
                }
                ord.close();
            }
            System.out.println("Lest ferdig: " + filnavn);
            lesefil.close();
        } catch (Exception e) {
            System.out.println("Subsekvensregister.java, lesfil(): Fant ikke filen");
        }
        return tempHash;
    }

    public static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> map1,
            HashMap<String, Subsekvens> map2) {
        HashMap<String, Subsekvens> tempHash = new HashMap<>();
        boolean finnes = false;

        // denne delen looper gjennom map1 og setter d i temp
        for (Subsekvens sub : map1.values()) {
            tempHash.put(sub.subsekvens, sub);
        }
        // denne skal drive å loope gjennom begge og adde til.
        for (Subsekvens sub1 : map2.values()) { // dette er mappet som skal settes inn
            for (String sub : tempHash.keySet()) { // dette er mappet som vurderes
                if (sub.equals(sub1.subsekvens)) {
                    finnes = true;
                    break;
                }
            }
            if (finnes) {
                finnes = false; // setter finnes tilbake til false
                // går inn i temp henter
                // tror denne vil fakke opp grunnet at den ikke vil finne sub1 i hashmappet må
                // finne ut hvordan jeg kan hente value
                tempHash.get(sub1.subsekvens)/** denne delen henter en subsekvens */
                        .forekomster = tempHash.get(sub1.subsekvens).forekomster
                                + map2.get(sub1.subsekvens).forekomster;
            } else {
                tempHash.put(sub1.subsekvens, sub1);
            }
        }
        System.out.println("flettet ferdig 2 stykker . . . ");
        return tempHash;
    }

    public HashMap<String, Subsekvens> flettAlt() {
        HashMap<String, Subsekvens> finalMap = null;
        try {
            finalMap = flett(SubsekvensRegister.get(0), SubsekvensRegister.get(1));
        } catch (Exception e) {
            System.out.println("Enten første eller andre map eksisterer ikke!");
        }
        int arrstorrelse = SubsekvensRegister.size();

        for (int i = 2; arrstorrelse > i; i++) {
            finalMap = flett(finalMap, SubsekvensRegister.get(i));
        }

        return finalMap;
    }

    public String finnHøyestefremkomster(HashMap<String, Subsekvens> map) {
        String print = "";
        int forekmst = 0;
        for (Subsekvens sub : map.values()) {
            if (sub.forekomster > forekmst) {
                forekmst = sub.forekomster;
            }
        }
        for (Subsekvens sub : map.values()) {
            if (sub.forekomster == forekmst) {
                print = print + sub.subsekvens + " ";
            }
        }
        return "Forekomster: " + forekmst + "\n" + "Subsekvenser: " + print;
    }

    public int hentStørrelse() {
        return SubsekvensRegister.size();

    }

    @Override
    public String toString() {
        String print = "";
        for (HashMap<String, Subsekvens> map : SubsekvensRegister) {
            for (Subsekvens sub : map.values()) {
                print = print + " " + sub;
            }
        }
        return print;
    }

}
