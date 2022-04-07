import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class Oblig5Del1 {
    public static void main(String[] args) {
        File metadataFil = new File(args[0] + "/metadata.csv");
        String filen = null;
        SubsekvensRegister register = new SubsekvensRegister();

        Scanner metadataLeser = null;

        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }
        while(metadataLeser.hasNextLine()){ //denne looper gjennom metadata eks. fil1 

            String nextLineHolder = metadataLeser.nextLine(); //peker på nextline eks. fil1 
            filen = nextLineHolder; //bytter filnavn slik at filLeser åpner og leser riktig fil
            String lokasjon = args[0] + "/" + filen;
            HashMap<String, Subsekvens> tempHashMap;
            tempHashMap = SubsekvensRegister.lesFil(lokasjon);
            register.settInnHash(tempHashMap);
        }

        System.out.println(register.finnHøyestefremkomster(register.flettAlt()));

    }
}
