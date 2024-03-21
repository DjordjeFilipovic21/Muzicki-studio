package muzika;

import java.util.ArrayList;
import java.util.List;

public class Orkestar {
    private String naziv;
    private List<String> Instrumenti = new ArrayList<>();
    private List<String> Ozvucenje = new ArrayList<>();
    private boolean prvoBolji;
    private Klasa minimalnaKlasa;

    public Orkestar(String naziv, boolean prvoBolji, Klasa minimalnaKlasa) {
        this.naziv = naziv;
        this.prvoBolji = prvoBolji;
        this.minimalnaKlasa = minimalnaKlasa;
    }

    @Override
    public String toString() {
        return "Orkestar" + naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<String> getInstrumenti() {
        return Instrumenti;
    }

    public void setInstrumenti(List<String> instrumenti) {
        Instrumenti = instrumenti;
    }

    public List<String> getOzvucenje() {
        return Ozvucenje;
    }

    public void setOzvucenje(List<String> ozvucenje) {
        Ozvucenje = ozvucenje;
    }

    public boolean isPrvoBolji() {
        return prvoBolji;
    }

    public void setPrvoBolji(boolean prvoBolji) {
        this.prvoBolji = prvoBolji;
    }

    public Klasa getMinimalnaKlasa() {
        return minimalnaKlasa;
    }

    public void setMinimalnaKlasa(Klasa minimalnaKlasa) {
        this.minimalnaKlasa = minimalnaKlasa;
    }
}
