package modules;

public class Berzerker extends Guerrero{


    public Berzerker(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);

    }


    @Override
    public void setArma(Arma arma) {

        if (arma.getClass().equals(Espada.class)){
            Espada e=(Espada)arma;
            System.out.println("Equipado!");

            }
        else {
            System.out.println("Soy un berzerker y solo uso una Espada");
        }
    }


}
