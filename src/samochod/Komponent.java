package samochod;

public class Komponent {
    private String nazwa;
    private double waga;
    private double cena;

    public String getNazwa(){return nazwa;}
    public double getWaga(){return waga;}
    public double getCena(){return cena;}

    public Komponent(String nazwa, double waga, double cena){
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }
}
