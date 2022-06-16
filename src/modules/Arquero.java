package modules;

public class Arquero extends Guerrero{


    int edad;


    public Arquero(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {
        if (arma.getClass().equals(Arco.class)){
            Arco a=(Arco)arma;

            System.out.print("Ya tengo mi arma!");


        }
        else {
            System.out.println("Soy un arquero y solo uso un Arco");
        }

    }


}
