import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class SubsekvensRegister {
    
    public ArrayList<HashMap<String, Subsekvens>> SubsekvensRegister = new ArrayList<>();
    private static ArrayList<String> tempSubsekvensHolder = new ArrayList<>();
    private static boolean finnes = false;

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

    public static HashMap<String, Subsekvens> lesFil(String filnavn) {
        HashMap<String, Subsekvens> tempHash = new HashMap<>();
        File filen = new File(filnavn);
        String holder;
        String ordholder;
        try {
            Scanner lesefil = new Scanner(filen);
            while(lesefil.hasNext()){
                holder = lesefil.nextLine();
                Scanner ord = new Scanner(holder);
                ordholder = ord.next();
                String[] fordeleBokstaver = ordholder.split("");

                for(int i = 0; fordeleBokstaver.length > i; i++){
                    String print;
                    print = fordeleBokstaver[i];
                    
                    try { 
                        print = print + fordeleBokstaver[i+1];
                        print = print + fordeleBokstaver[i+2];
                        tempHash.put(print, new Subsekvens(print));
                        /*
                        if(tempSubsekvensHolder.size() == 0){ //denne delen legger Subsekvensene til i en array
                            tempSubsekvensHolder.add(print);
                        }
                        else{
                            try {
                                for(String x : tempSubsekvensHolder){
                                    if(x.equals(print)){
                                        finnes = true; 
                                    }
                                }
                                if(finnes){
                                    finnes = false;
                                }
                                else if(!finnes){
                                tempSubsekvensHolder.add(print);
                                }
                            } catch (Exception e) {
                            }
                        }
                        */
                        print = "";
                        
                    } catch (Exception e) {
                        break;
                    }
                }
                //System.out.println(tempHash);

                /*
                for(String sub : tempSubsekvensHolder){
                    tempHash.put(sub, new Subsekvens(sub));
                    //tempSubsekvensHolder.remove(sub);
                }
                */

                //tempSubsekvensHolder = null;
                //System.out.println(tempSubsekvensHolder);
                //System.out.println("\n" + tempHash.size() + "\n" + tempHash);
                ord.close();
            }
            //settInnHash(tempHash);
            lesefil.close();
        } catch (Exception e) {
            System.out.println("Fant ikke filen");
        }
        return tempHash;
    }

    public static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> map1, HashMap<String, Subsekvens> map2) {
        HashMap<String, Subsekvens> tempHash = new HashMap<>();
        boolean finnes = false;

        //denne delen looper gjennom map1 og setter d i temp 
        for(Subsekvens sub : map1.values()){
            tempHash.put(sub.subsekvens, sub);
        }
        /* denne testen forteller at vi kan bruke stringen for å hente subsekvensen
        System.out.println("Her håper vi å få Strings tilbake");
        for(Subsekvens sub1 : tempHash.values()){
            System.out.println(tempHash.get(sub1));
        }

        System.out.println("Her håper vi å få Subsekvenser tilbake");
        for(Subsekvens sub1 : tempHash.values()){
            System.out.println(tempHash.get(sub1.subsekvens));
        }
        */
        //denne skal drive å loope gjennom begge og adde til. 
        for(Subsekvens sub1 : map2.values()){ //dette er mappet som skal settes inn
            for (String sub : tempHash.keySet()){ //dette er mappet som vurderes
                if(sub.equals(sub1.subsekvens)){
                    finnes=true;
                    break;
                }
            }
            if(finnes){
                finnes=false; //setter finnes tilbake til false
                //går inn i temp henter
                // tror denne vil fakke opp grunnet at den ikke vil finne sub1 i hashmappet må finne ut hvordan jeg kan hente value
                tempHash.get(sub1.subsekvens)/**denne delen henter en subsekvens */.forekomster = tempHash.get(sub1.subsekvens).forekomster + map2.get(sub1.subsekvens).forekomster;
            }
            else{
                tempHash.put(sub1.subsekvens, sub1);
            }
        }
        return tempHash;
    }

    public HashMap<String, Subsekvens> flettAlt() {
        HashMap<String, Subsekvens> finalMap = null;
        HashMap<String, Subsekvens> førsteMap;
        try {
            finalMap = flett(SubsekvensRegister.get(0), SubsekvensRegister.get(1));
        } catch (Exception e) {
            System.out.println("Enten første eller andre map eksisterer ikke!");
        }
        int arrstorrelse = SubsekvensRegister.size();

        for(int i = 2; arrstorrelse<i; i++){
            finalMap = flett(finalMap, SubsekvensRegister.get(i));
        }

        return finalMap;
    }

    @Override
    public String toString() {
        String print = ""; 
        for(HashMap<String, Subsekvens> map : SubsekvensRegister){
            for(Subsekvens sub : map.values()){
                print = print + " " + sub;
            }
        }
        return print;
    }

}
