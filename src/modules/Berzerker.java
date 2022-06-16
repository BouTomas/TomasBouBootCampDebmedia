package modules;

public class Berzerker extends Guerrero{


    String apellido;

    public Berzerker(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);

    }


    @Override
    public void setArma(Arma arma) {

        if (arma.getClass().equals(Espada.class)){
            Espada e=(Espada)arma;

            System.out.print("Ya tengo mi arma!");


            }
        else {
            System.out.println("Soy un berzerker y solo uso una Espada");
        }
    }


}
