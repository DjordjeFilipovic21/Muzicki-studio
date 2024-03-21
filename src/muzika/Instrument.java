package muzika;

public class Instrument extends Oprema {
    private double osnovnaCena;
    private Klasa klasa;

    public Instrument(String naziv, Klasa klasa,double osnovnaCena) {
        super(naziv);
        this.osnovnaCena = osnovnaCena;
        this.klasa = klasa;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    @Override
    public double cena(int brojSati) {
        double K;
        if(klasa == Klasa.AAA)
            K = 1.8;
        else if(klasa == Klasa.AA)
            K = 1.4;
        else
            K = 1;
        return osnovnaCena * brojSati * K;
    }

    @Override
    public String toString() {
        return getNaziv() + " " + klasa + " klase";
    }
}
