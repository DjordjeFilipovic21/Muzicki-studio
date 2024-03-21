package muzika;

import java.util.List;

public class Main {

    public static void main(String[] args)  //static method
    {
        Studio s1 = new Studio("Glavni studio");
        Instrument i1 = new Instrument("Klavir", Klasa.AA, 30);
        Instrument i2 = new Instrument("Klavir", Klasa.AAA, 20);
        Instrument i3 = new Instrument("Violina", Klasa.AAA, 15);
        Ozvucenje o1 = new Ozvucenje("Sony", 20);
        Ozvucenje o2 = new Ozvucenje("JBL", 30);
        Ozvucenje o3 = new Ozvucenje("Bose", 30);
        Kamera k1 = new Kamera("Sony", "sirokougaona", 30);
        Kamera k2 = new Kamera("Canon", "teleskopska", 20);
        Orkestar orkestar = new Orkestar("Mladjac", true, Klasa.A);
        List<String> Instrumenti = List.of("Klavir", "Klavir", "Violina");
        List<String> Ozvucenje = List.of("Sony", "Bose", "Senheinser");
        orkestar.setInstrumenti(Instrumenti);
        orkestar.setOzvucenje(Ozvucenje);
        s1.dodajOpremu(i1);
        s1.dodajOpremu(i2);
        s1.dodajOpremu(i3);
        s1.dodajOpremu(o1);
        s1.dodajOpremu(o2);
        s1.dodajOpremu(o3);
        s1.dodajOpremu(k1);
        s1.dodajOpremu(k2);
        PonudaOpreme ponuda = s1.napraviPonuduOpreme(orkestar);
        System.out.println("Cena za iznajmljivanje opreme bez snimanja: " + ponuda.cena(4));
        PonudaOpreme ponudaSaSnimanjem = s1.ponudiSnimanjeSpota(orkestar);
        ponudaSaSnimanjem.ispisiOpreme();
        System.out.println("Cena za iznajmljivanje opreme sa snimanjem: " + ponudaSaSnimanjem.cena(4));






    }


}