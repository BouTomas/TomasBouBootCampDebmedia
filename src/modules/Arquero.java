package modules;

public class Arquero extends Guerrero{



    public Arquero(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {
        if (arma.getClass().equals("Arco")){
            Arco a=(Arco)arma;
            System.out.print("Ya tengo mi arma!");

        }
        else {
            System.out.println("Soy un "+this.getClass()+" y solo uso un Arco");
        }

    }


}
