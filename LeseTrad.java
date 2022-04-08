public class LeseTrad implements Runnable{

    String lokasjon;
    Monitor2 monitor; //bytta fra monitor1 til 2 bytt tilbake til 1 før du leverer

    
    public LeseTrad(String fillokasjon, Monitor2 monitor){//bytta fra monitor1 til 2 bytt tilbake til 1 før du leverer
        lokasjon = fillokasjon;
        this.monitor = monitor;
    }
    @Override
    public void run() {
        monitor.settInnHash(monitor.lesFil(lokasjon));// implementer countdown?
    }

}
