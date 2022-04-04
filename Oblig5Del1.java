import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Del1 {
    public static void main(String[] args) {
        File fil = new File(args[0] + "/metadata.csv");
        Scanner sc = null;

        try {
            sc = new Scanner(fil);
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }
    }
    
}
