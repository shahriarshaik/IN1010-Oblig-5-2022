public class Subsekvens {
    public final String subsekvens; 
    private int forekomster;
    

    public Subsekvens(String subsekvens, int forekomster){
        this.subsekvens = subsekvens;
        this.forekomster = forekomster;
    }

    public String hentSubsekvens() {
        return subsekvens;
    }
    
    public int hentforekomster() {
        return forekomster;
    }

    @Override
    public String toString() {
        return "(" + subsekvens +", " + forekomster + ")";
    }
}
