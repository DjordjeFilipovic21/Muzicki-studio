package muzika;

public abstract class Oprema implements Procenjivo, Comparable<Oprema>{
    private String naziv;

    public Oprema(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int compareTo(Oprema o) {
        return naziv.compareToIgnoreCase(o.naziv);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
