package modules;

public class Mago extends Guerrero{


    public Mago(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {

        if (arma.getClass().equals("Vaculo")){
            Vaculo v=(Vaculo) arma;
            System.out.print("Ya tengo mi arma!");


        }
        else {
            System.out.println("Soy un mago y solo uso un Vaculo ");

        }
    }


    public double ataqueMagico(){
        return 0;
    }

}
