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
            System.out.println("\n" + nextLineHolder); //printer den ut slik vi vet hvilken fil vi leser
            filen = nextLineHolder; //bytter filnavn slik at filLeser åpner og leser riktig fil
            //System.out.println("sjekker om den har blitt oppdatert" + filen);
            String lokasjon = args[0] + "/" + filen;
            leseFil = new File(lokasjon);
            //System.out.println("dette er File objektet: " + leseFil);

            try {
                //System.out.println(leseFil);
                filLeser = new Scanner(leseFil);
            } catch (FileNotFoundException e) {
                System.out.println("Fant ikke filen!");
            }

            while(filLeser.hasNextLine()){ // denne looper gjennom filene i metadata
                HashMap<String, Subsekvens> tempHashMap;
                tempHashMap = SubsekvensRegister.lesFil(lokasjon);
                register.settInnHash(tempHashMap);
                //System.out.println(tempNestelinje);
                //System.out.println("siste while loop: " + tempNestelinje);
            }
            //System.out.println(register);

        }
        //System.out.println(register);

        try {
            System.out.println("\n\nprøver å hente 0");
            System.out.println(register.SubsekvensRegister.get(0));
        } catch (Exception e) {
            System.out.println("feil ved 0");
        }

        try {
            System.out.println("prøver å hente 1");
            System.out.println(register.SubsekvensRegister.get(1));
        } catch (Exception e) {
            System.out.println("feil ved 1");
        }

        try {
            System.out.println("prøver å hente 2");
            System.out.println(register.SubsekvensRegister.get(2));
        } catch (Exception e) {
            System.out.println("feil ved 2");

        }

    }
    
}
