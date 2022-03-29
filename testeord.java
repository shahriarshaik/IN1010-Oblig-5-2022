import java.util.Scanner;

public class testeord {

    public static void main(String[] args) {
        Scanner ord = new Scanner("ABCDBCD");
        String holder = ord.next();
        String[] fordeleOrd = holder.split("");
        int lengde = fordeleOrd.length;

        /*
        for(String i : fordeleOrd){
            System.out.println(i);
            try {
                System.out.println(i+1);
                System.out.println(i+2);
                
            } catch (Exception e) {
                break;
            }

        }
        */

        for(int i = 0; lengde > i; i++){
            String print;
            //System.out.println(fordeleOrd[i]);
            print = fordeleOrd[i];
            
            try {
                //System.out.print(fordeleOrd[i+1]);
                print = print + fordeleOrd[i+1];
                //System.out.print(fordeleOrd[i+2]);
                print = print + fordeleOrd[i+2];
                System.out.println(print);
                print = "";
                
            } catch (Exception e) {
                break;
            }
        }

        /*
        System.out.println(fordeleOrd.length);
        System.out.println(fordeleOrd[0]);
*/
        ord.close();
    }
    
}
