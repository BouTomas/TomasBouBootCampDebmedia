package modules;

public abstract class Guerrero {
    int id;
    String nombre;
    double fuerza;
    Arma arma;

    public Guerrero(int id, String nombre, double fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;

    }

    public Arma getArma() {
        return arma;
    }

    public abstract void setArma(Arma arma);

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

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double ataqueBasico(){
        return this.fuerza*arma.poderAtaque;
    }
}
