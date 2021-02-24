package samochod;

public class SkrzyniaBiegow extends Komponent{
    private int aktBieg;
    private int iloscbiegow;
    private int aktualnePrzelozenie;
    public Sprzeglo sprzeglo;

    public void zwiekszBieg(){this.aktBieg++;}
    public void zmniejszzBieg(){this.aktBieg--;}
    public int getAktBieg(){return aktBieg;}
    public int getAktPrzelozenie(){return aktualnePrzelozenie;}
    public int getIloscbiegow(){return iloscbiegow;}


    public SkrzyniaBiegow(int aktBieg, int iloscbiegow, int aktualnePrzelozenie, Sprzeglo sprzeglo, String nazwa, double waga, double cena){
        super(nazwa, waga, cena);
        this.aktBieg = aktBieg;
        this.iloscbiegow = iloscbiegow;
        this.aktualnePrzelozenie = aktualnePrzelozenie;
        this.sprzeglo = sprzeglo;
    }
}
