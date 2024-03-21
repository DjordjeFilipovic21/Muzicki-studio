package muzika;

import java.util.ArrayList;

public class PonudaOpreme implements Procenjivo{
    private ArrayList<String> nedostajucaOprema = new ArrayList<>();
    private boolean kompletirana;
    private boolean moguceSnimanje;

    public boolean isMoguceSnimanje() {
        return moguceSnimanje;
    }

    public void setMoguceSnimanje(boolean moguceSnimanje) {
        this.moguceSnimanje = moguceSnimanje;
    }

    public ArrayList<String> getNedostajucaOprema() {
        return nedostajucaOprema;
    }

    public void setNedostajucaOprema(ArrayList<String> nedostajucaOprema) {
        this.nedostajucaOprema = nedostajucaOprema;
    }


    public boolean isKompletirana() {
        return kompletirana;
    }
    private ArrayList<Oprema> opreme = new ArrayList<>();

    public ArrayList<Oprema> getOpreme() {
        return opreme;
    }

    public PonudaOpreme(ArrayList<String> nedostajucaOprema, ArrayList<Oprema> opreme) {
        this.nedostajucaOprema = nedostajucaOprema;
        this.opreme = opreme;
        kompletirana = nedostajucaOprema.isEmpty();
        moguceSnimanje = nedostajucaOprema.isEmpty();
    }

    public void ispisiOpreme(){
        System.out.println("Dostupna oprema:");
        for(Oprema o : opreme)
            System.out.println(o);
        System.out.println("Nedostajuca oprema:");
        for(String o : nedostajucaOprema)
            System.out.println(o);
    }

    @Override
    public double cena(int brojSati) {
        double sum = 0;
        for(Oprema o : opreme) {
            sum += o.cena(brojSati);
        }
        return sum;
    }
}
