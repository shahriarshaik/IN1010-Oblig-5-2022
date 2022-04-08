import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

////////////////////////////////////////
//jeg gjorde noen static metoder til non-static, vet ikke om det kommer til å beate meg
////////////////////////////////////////
//virker som at monitor virker hvis man bytter ut SubsekvensRegister med monitor1 i Oblig5del1 
////////////////////////////////////////

public class Monitor2 {
    SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
    private  Lock lock= new ReentrantLock();

    public void settInnHash(HashMap<String, Subsekvens> hashMap){

        lock.lock();
        try{
            subsekvensRegister.settInnHash(hashMap);
        }
        finally{
            lock.unlock();
        }
    }

    public HashMap<String, Subsekvens> hentHash(){
        lock.lock();
        try{
            return subsekvensRegister.hentHash();
        }
        finally{
            lock.unlock();
        }
    }

    public ArrayList<HashMap<String, Subsekvens>> hentToHash() {
        lock.lock();
        try{
            return subsekvensRegister.hentToHash();
        }
        finally{
            lock.unlock();
        }
    }

    public int antallMaps() {
        lock.lock();
        try{
            return subsekvensRegister.antallMaps();
        }
        finally{
            lock.unlock();
        }
    }

    public HashMap<String, Subsekvens> lesFil(String filnavn) {
        lock.lock();
        try{
            return SubsekvensRegister.lesFil(filnavn);
        }
        finally{
            lock.unlock();
        }
    }

    public HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> map1, HashMap<String, Subsekvens> map2){
        lock.lock();
        try{
            return SubsekvensRegister.flett(map1, map2);
        }
        finally{
            lock.unlock();
        }
    }

    public HashMap<String, Subsekvens> flettAlt(){
        lock.lock();
        try{
            return subsekvensRegister.flettAlt();
        }
        finally{
            lock.unlock();
        }
    }

    public String finnHøyestefremkomster(HashMap<String, Subsekvens> map){
        lock.lock();
        try{
            return subsekvensRegister.finnHøyestefremkomster(map);
        }
        finally{
            lock.unlock();
        }
    }

    public int hentStørrelse(){
        lock.lock();
        try{
            return subsekvensRegister.hentStørrelse();
        }
        finally{
            lock.unlock();
        }
    }

    public String toString(){
        lock.lock();
        try{
            return subsekvensRegister.toString();
        }
        finally{
            lock.unlock();
        }
    }
}
