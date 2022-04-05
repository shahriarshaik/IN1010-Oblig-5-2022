import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class Oblig5Del1 {
    public static void main(String[] args) {
        File metadataFil = new File(args[0] + "/metadata.csv");
        String filen = null;
        File leseFil;
        SubsekvensRegister register = new SubsekvensRegister();

        Scanner metadataLeser = null;
        Scanner filLeser = null;

        try {
            metadataLeser = new Scanner(metadataFil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }
        while(metadataLeser.hasNextLine()){ //denne looper gjennom metadata eks. fil1 

            String nextLineHolder = metadataLeser.nextLine(); //peker på nextline eks. fil1 
            //System.out.println("\n" + nextLineHolder); //printer den ut slik vi vet hvilken fil vi leser
            filen = nextLineHolder; //bytter filnavn slik at filLeser åpner og leser riktig fil
            //System.out.println("sjekker om den har blitt oppdatert" + filen);
            String lokasjon = args[0] + "/" + filen;
            leseFil = new File(lokasjon);
            //System.out.println("dette er File objektet: " + leseFil);

            //flytta denne fra neste while loop
            HashMap<String, Subsekvens> tempHashMap;
            tempHashMap = SubsekvensRegister.lesFil(lokasjon);
            register.settInnHash(tempHashMap);
        }

        System.out.println(register.finnHøyestefremkomster(register.flettAlt()));
    }
}
