import java.util.HashMap;

public class test {
    

    public static void main(String[] args) {
        Subsekvens test = new Subsekvens("ABC");
        SubsekvensRegister reg = new SubsekvensRegister();


        System.out.println("Størrelse: " + SubsekvensRegister.flett(SubsekvensRegister.lesFil("Fil1.txt"), SubsekvensRegister.lesFil("Fil2.txt")).size());

        System.out.println(SubsekvensRegister.flett(SubsekvensRegister.lesFil("Fil1.txt"), SubsekvensRegister.lesFil("Fil2.txt")));
        
    }
    
}
