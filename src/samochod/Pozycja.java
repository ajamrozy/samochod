package samochod;

public class Pozycja {
    private double x;
    private double y;
    private String nazwaSamochodu;
    public double getY() {return y;}
    public double getX() {return x;}
    public void setNazweSamochodu(String nazwaSamochodu){
        this.nazwaSamochodu = nazwaSamochodu;
    }

    public String getNazwaSamochodu() {
        return nazwaSamochodu;
    }

    public Pozycja(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pozycja{" +
//                "samochod=" + nazwaSamochodu +
                " x=" + x +
                ", y=" + y +
                '}';
    }

    public void przeniesc(Pozycja cel, double czas, double predkosc){
        double delta_x = (predkosc * czas /1000 * (cel.x-this.x))/(Math.sqrt(Math.pow((cel.x-this.x), 2) + Math.pow((cel.y-this.y), 2)));
        double delta_y = (predkosc * czas /1000 * (cel.y-this.y))/(Math.sqrt(Math.pow((cel.x-this.x), 2) + Math.pow((cel.y-this.y), 2)));
        if (cel.x - this.x > 0) {
            if (delta_x >= cel.x - this.x) {
                this.x = cel.x;
            } else
                this.x += delta_x;
        }
        else{
            if (delta_x <= cel.x - this.x) {
                this.x = cel.x;
            } else
                this.x += delta_x;
        }
        if (cel.y - this.y > 0){
            if (delta_y >= cel.y - this.y){
                this.y = cel.y;
            }
            else
                this.y += delta_y;
        }
        else{
            if (delta_y <= cel.y - this.y) {
                this.y = cel.y;
            } else
                this.y += delta_y;
        }



    }
}
