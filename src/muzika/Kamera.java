package muzika;

public class Kamera extends Oprema{
    private String tip;
    private double cena;
    public Kamera(String naziv, String tip, double cena) {
        super(naziv);
        this.tip = tip;
        this.cena = cena;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public double cena(int brojSati) {
        return cena;
    }

    @Override
    public String toString() {
        return "Kamera " + getNaziv();
    }
}
