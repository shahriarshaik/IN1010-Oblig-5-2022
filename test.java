import java.util.HashMap;

public class test {
    

    public static void main(String[] args) {
        Subsekvens test = new Subsekvens("ABC");
        SubsekvensRegister reg = new SubsekvensRegister();


        System.out.println("Størrelse: " + SubsekvensRegister.flett(SubsekvensRegister.lesFil("Fil1.txt"), SubsekvensRegister.lesFil("Fil2.txt")).size());

        System.out.println(SubsekvensRegister.flett(SubsekvensRegister.lesFil("Fil1.txt"), SubsekvensRegister.lesFil("Fil2.txt")));

        /*
        reg.settInnHash(SubsekvensRegister.lesFil("Fil1.txt"));
        reg.settInnHash(SubsekvensRegister.lesFil("Fil2.txt"));
        
        int i = 0;

        
        for(HashMap<String, Subsekvens> map : SubsekvensRegister.SubsekvensRegister ){
            System.out.println(map.size());
            System.out.println("mapnr. " + i);
            System.out.println(map);
            i++;
        }
        */

        /*
        System.out.println("Størrelse på fil1: " + SubsekvensRegister.SubsekvensRegister.get(0).size() + "\n" + "Innhold: " + "\n" + SubsekvensRegister.SubsekvensRegister.get(0) + "\n");
        System.out.println("Størrelse på fil2: " + SubsekvensRegister.SubsekvensRegister.get(1).size() + "\n" + "Innhold: " + "\n" + SubsekvensRegister.SubsekvensRegister.get(1) + "\n");
        System.out.println();

        System.out.println(SubsekvensRegister.SubsekvensRegister.get(0).size());
        System.out.println(SubsekvensRegister.SubsekvensRegister.get(1).size());
        System.out.println(SubsekvensRegister.SubsekvensRegister.get(2).size());

        System.out.println("Størrelse på fil2: " + SubsekvensRegister.SubsekvensRegister.get(2).size() + "\n" + "Innhold: " + "\n" + SubsekvensRegister.SubsekvensRegister.get(2) + "\n");
        */
        
    }
    
}
