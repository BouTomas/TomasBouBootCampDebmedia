package modules;

public abstract class Arma {

    int id;
    String nombre;
    double poderAtaque;

    public Arma(int id, String nombre, double poderAtaque) {
        this.id = id;
        this.nombre = nombre;
        this.poderAtaque = poderAtaque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(double poderAtaque) {
        this.poderAtaque = poderAtaque;
    }
}
