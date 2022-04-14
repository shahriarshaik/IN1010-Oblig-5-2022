import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class test {
    public static void main(String[] args) {
        String lokasjon = "testdata/metadata.csv";
        File filen = new File(lokasjon);
        Scanner metaLeser = null;
        ArrayList<String> falseArr = null;
        ArrayList<String> trueArr = null;

        try {
            metaLeser = new Scanner(filen);
        } catch (Exception e) {
        }

        while (metaLeser.hasNextLine()) {
            String holder = metaLeser.nextLine();
            String[] split = holder.split(",");
            System.out.println(split[0]);
        }
    }

}
