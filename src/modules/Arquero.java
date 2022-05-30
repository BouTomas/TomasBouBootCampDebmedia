package modules;

public class Arquero extends Guerrero{



    public Arquero(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {
        if (arma.getClass().equals(Arco.class)){
            Arco a=(Arco)arma;
            System.out.println("Equipado!");

        }
        else {
            System.out.println("Soy un arquero y solo uso un Arco");
        }

    }


}
