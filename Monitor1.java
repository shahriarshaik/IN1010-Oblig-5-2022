import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
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

}
