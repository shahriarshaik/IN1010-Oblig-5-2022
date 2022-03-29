import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class SubsekvensRegister {
    
    ArrayList<HashMap<String, Subsekvens>> SubsekvensRegister = new ArrayList<>();
    private static String filnavn = "Fil2.txt";

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


    public static void lesFil() {
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
                        System.out.println(print);
                        print = "";
                        
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Fant ikke filen");
        }
    }

    
}
