package modules;

public class Arquero extends Guerrero{


    int edad;


    public Arquero(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {
        if (arma.getClass().equals("Arco")){
            Arco a=(Arco)arma;
            System.out.print("Equipado!");

        }
        else {
            System.out.println("Soy un "+this.getClass()+" y solo uso un Arco");
        }

    }


}
