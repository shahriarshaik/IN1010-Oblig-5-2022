import java.util.ArrayList;
import java.util.HashMap;

public class FletteTrad implements Runnable{
    Monitor2 monitor2;
    HashMap<String, Subsekvens> runMap;

    public FletteTrad(Monitor2 monitor2){
        this.monitor2 = monitor2;
    }

    public HashMap<String, Subsekvens> fletteTo(HashMap<String, Subsekvens> map1, HashMap<String, Subsekvens> map2) {

        HashMap<String, Subsekvens> returnMap = monitor2.flett(map1, map2);
        return returnMap;

    }

    int hentet = 0;

    HashMap<String, Subsekvens> en = null; 
    HashMap<String, Subsekvens> to = null;

    @Override
    public void run() {


        ArrayList<HashMap<String, Subsekvens>> oppdeling = monitor2.hentToHash();

        try {
            System.out.println("Størrelsen: " + monitor2.hentStørrelse());
        } catch (Exception e) {}

        try {
            en = oppdeling.get(0); to = oppdeling.get(1);
            runMap = fletteTo(en, to);
            monitor2.settInnHash(runMap);
        } catch (NullPointerException e) {
        }

    }


}
