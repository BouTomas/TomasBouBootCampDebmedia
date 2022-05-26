package modules;

public class Berzerker extends Guerrero{


    public Berzerker(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);

    }


    @Override
    public void setArma(Arma arma) {

        if (arma.getClass().equals("Espada")){
            Espada e=(Espada)arma;
            System.out.print("Equipado!");

            }
        else {
            System.out.println("Soy un "+this.getClass()+" y solo uso una Espada");
        }
    }


}
