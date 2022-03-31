import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class SubsekvensRegister {
    
    public static ArrayList<HashMap<String, Subsekvens>> SubsekvensRegister = new ArrayList<>();
    private static ArrayList<String> tempSubsekvensHolder = new ArrayList<>();
    private static boolean finnes = false;

    public static void settInnHash(HashMap<String, Subsekvens> hashMap) {
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

    public static void lesFil(String filnavn) {
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
            settInnHash(tempHash);
            lesefil.close();
        } catch (Exception e) {
            System.out.println("Fant ikke filen");
        }
    }

    
}
