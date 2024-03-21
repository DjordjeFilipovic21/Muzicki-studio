package muzika;

import java.util.*;

public class Studio {
    private String naziv;
    private ArrayList<Oprema> opreme = new ArrayList<>();

    public ArrayList<Oprema> getOpreme() {
        return opreme;
    }

    public void setOpreme(ArrayList<Oprema> opreme) {
        this.opreme = opreme;
    }

    public Studio(String naziv) {
        this.naziv = naziv;
    }
    public void dodajOpremu(Oprema o){
        opreme.add(o);
    }
    public ArrayList<Ozvucenje> filtrirajOzvucenja(){
        ArrayList<Ozvucenje> filtriranaOzvucenja = new ArrayList<>();
        for(Oprema o : opreme)
        {
            if(o instanceof Ozvucenje)
                filtriranaOzvucenja.add((Ozvucenje)o);

        }
        return filtriranaOzvucenja;
    }

    public ArrayList<Instrument> filtrirajInstrumente(Klasa minKlasa){
        ArrayList<Instrument> filtriraniInstrumenti = new ArrayList<>();

        for(Oprema o : opreme)
        {

            if(o instanceof Instrument i)
            {
                if(i.getKlasa().ordinal() < minKlasa.ordinal())
                    filtriraniInstrumenti.add(i);
            }

        }
        return filtriraniInstrumenti;
    }
    public PonudaOpreme napraviPonuduOpreme(Orkestar orkestar) {

        ArrayList<Oprema> opreme = new ArrayList<>();
        ArrayList<String> nedostajucaOprema = new ArrayList<>();
        List<String> zeljeniInstrumenti = orkestar.getInstrumenti();
        List<String> zeljenoOzvucenje = orkestar.getOzvucenje();
        ArrayList<Instrument> dostupniInstrumenti = filtrirajInstrumente(orkestar.getMinimalnaKlasa());
        ArrayList<Ozvucenje> dostupnaOzvucenja = filtrirajOzvucenja();

        Map<String, Integer> kolicinaInstrumenata = new HashMap<>();
        Map<String, Integer> kolicinaOzvucenja = new HashMap<>();
        for(Instrument i : dostupniInstrumenti){
            if(kolicinaInstrumenata.get(i.getNaziv()) == null)
                kolicinaInstrumenata.put(i.getNaziv(), 1);
            else
                kolicinaInstrumenata.put(i.getNaziv(), kolicinaInstrumenata.get(i.getNaziv())+1);

        }
        for(String str : zeljeniInstrumenti) {
            if(kolicinaInstrumenata.get(str) == null || kolicinaInstrumenata.get(str) == 0){
                nedostajucaOprema.add(str);

            }
            else{
                kolicinaInstrumenata.put(str, kolicinaInstrumenata.get(str)-1);
                for(Instrument i : dostupniInstrumenti){
                    if(i.getNaziv().equals(str))
                    {
                        dostupniInstrumenti.remove(i);
                        opreme.add(i);
                        break;
                    }
                }

            }
        }
        return new PonudaOpreme(nedostajucaOprema, opreme);
    }
    public PonudaOpreme ponudiSnimanjeSpota(Orkestar orkestar){
        PonudaOpreme ponuda = napraviPonuduOpreme(orkestar);
        ArrayList<Oprema> sveOpreme = ponuda.getOpreme();
        ArrayList<String> nedostajucaOprema = ponuda.getNedostajucaOprema();
        if(ponuda.isKompletirana()){
            HashSet<String> Set = new HashSet<>();
            boolean sirokougaona = false;
            boolean teleskopska = false;
            for(Oprema o : sveOpreme){
                if(o instanceof Instrument){
                    Set.add(o.getNaziv());
                }
            }
            int brojTeleskopskih = (Set.size() + 1) / 2;
            int br = 0;
            for(Oprema o : opreme) {
                if (o instanceof Kamera k) {
                    if(k.getTip().equals("sirokougaona") && !sirokougaona) {
                        sirokougaona = true;
                        sveOpreme.add(k);
                    }
                    else if(k.getTip().equals("teleskopska") && !teleskopska) {
                        br++;
                        if(br == brojTeleskopskih)
                            teleskopska = true;
                        sveOpreme.add(k);
                    }
                    else if(sirokougaona && teleskopska)
                        break;
                }
            }
            if(!sirokougaona)
                nedostajucaOprema.add("Sirokougaona");
            if(!teleskopska){
                for (int i = 0; i < brojTeleskopskih - br; i++)
                    nedostajucaOprema.add("Teleskopska");

            }




        }
        return new PonudaOpreme(nedostajucaOprema, sveOpreme);
    }



    @Override
    public String toString() {
        return "Studio: " + naziv;
    }
}
