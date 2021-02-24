package samochod;

public class Silnik extends Komponent{
    private double maxObroty;
    private double obroty = 2;

    public void uruchom(){}
    public void zatrzymaj(){}
    public void zmniejszzObroty(){
        obroty -= 100;
    }
    public void zwiekszObroty(){
        obroty += 100;
    }

    public void setObroty(double obroty) {
        this.obroty = obroty;
    }
    public double getObroty() {return obroty;}



    public Silnik(double maxObroty, double obroty, String nazwa, double waga, double cena){
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;

    }
}
