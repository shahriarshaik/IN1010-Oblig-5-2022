import java.util.ArrayList;
import java.util.HashMap;

public class FletteTrad implements Runnable{
    Monitor2 monitor2;
    HashMap<String, Subsekvens> runMap;

    public FletteTrad(Monitor2 monitor2){
        this.monitor2 = monitor2;
    }

    public HashMap<String, Subsekvens> fletteTo(HashMap<String, Subsekvens> map1, HashMap<String, Subsekvens> map2) {
        /*
        if(monitor2.hentStørrelse() > 2){
            HashMap<String, Subsekvens> returnMap = monitor2.flett(map1, map2);
            return returnMap;
        }
        else{
            System.out.println("fletteTo(): ikke nok maps, denne skulle ikke ha kjørt");
            return null;
        }
        */
        HashMap<String, Subsekvens> returnMap = monitor2.flett(map1, map2);
        return returnMap;

    }

    int hentet = 0;

    HashMap<String, Subsekvens> en = null; 
    HashMap<String, Subsekvens> to = null;


    @Override
    public void run() {



        /*

        for (int i = 0; i < monitor2.hentStørrelse(); i++) {
            HashMap<String, Subsekvens> remove=null;
            try {
                remove = monitor2.hentHash();
                monitor2.subsekvensRegister.SubsekvensRegister.remove(remove);
                hentet++;
            } catch (Exception e) {}


            if(hentet == 1){
                en = remove;
            }
            else if(hentet == 2){
                to = remove;
                hentet = 0;
                break;
            }
        }

        */
        //HashMap<String, Subsekvens> en = monitor2.subsekvensRegister.SubsekvensRegister.get(0); HashMap<String, Subsekvens> to = monitor2.subsekvensRegister.SubsekvensRegister.get(1);
        //monitor2.subsekvensRegister.SubsekvensRegister.remove(0); monitor2.subsekvensRegister.SubsekvensRegister.remove(1);

        /*
        runMap = fletteTo(en, to);
        monitor2.settInnHash(runMap);
        */
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
