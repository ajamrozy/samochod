package samochod;

public class Zawody {


    private String nazwa;
    String data;
    Samochod uczestnicy;

    public void rozegrajZawody(){}
    public String getNazwa() {return nazwa;}

    public Zawody(String nazwa, String data, Samochod uczestnicy){
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = uczestnicy;
    }
}
