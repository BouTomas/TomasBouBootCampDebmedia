package modules;

public class Mago extends Guerrero{


    public Mago(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    @Override
    public void setArma(Arma arma) {

        if (arma.getClass().equals("Vaculo")){
            Vaculo v=(Vaculo) arma;
            System.out.print("Equipado con mi Vaculo!");

        }
        else {
            System.out.println("Soy un "+Mago.class +" y solo uso un Vaculo");

        }
    }


    public double ataqueMagico(){
        System.out.println("Tiro ataque magico");
        return 0;
    }

}
