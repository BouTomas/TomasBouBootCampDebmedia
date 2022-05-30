package main;

import modules.*;

import java.util.ArrayList;
import java.util.Scanner;


public class main {




    static  ArrayList<Guerrero>guerreros=new ArrayList<>();
    static ArrayList<Arma>armas=new ArrayList<>();




    public static void main(String[] args) {

        cargarEjercito();
        cargarArmeria();


               mostrarEjercito();
               mostrarArmas();
               equiparEjercito(guerreros,armas);
              System.out.print("Terminado en rama TomasBou");



    }

    private boolean matarEnemigo(Guerrero g, Enemigo e){
        boolean loMata=false;
        int cero=0;
        if(e.getVida()-g.ataqueBasico()<=cero){
            loMata=true;
            System.out.print("Te mate");
        }
        return loMata;
    }


    //CONSULTAR

    private static  void equiparEjercito(ArrayList<Guerrero>guerreros,ArrayList<Arma>armas) {
        int i=0;
        while(i<guerreros.size() && i<armas.size()){
            for (int j = 0; j < guerreros.size(); j++) {
                guerreros.get(j).setArma(armas.get(j));
            }
            i++;
        }

    }

    public static void cargarArma(Guerrero g, Arma a){
        g.setArma(a);

    }

    //ARMERIA
    public static void cargarArmeria() {
        boolean continuaIngreso=true;
        while (continuaIngreso){

            System.out.print("Que Arma desea ingresar? Espada, Arco o Vaculo :");
            String respuesta= teclado.next();

            System.out.print("Id  :");
            int idArma= teclado.nextInt();
            System.out.print("Nombre :");
            String nombreArma= teclado.next();
            System.out.print("Fuerza(double) :");
            double fuerzaArma= teclado.nextDouble();


            switch (respuesta){
                case "Espada":
                    armas.add(new Espada(idArma, nombreArma, fuerzaArma));
                    break;
                case "Arco":
                    armas.add(new Arco(idArma, nombreArma, fuerzaArma));

                    break;
                case "Vaculo":
                    armas.add(new Vaculo(idArma, nombreArma, fuerzaArma));
                    break;
            }

            // PREGUNTAR POR continuaIngreso=sigueOnoIngresando()
            continuaIngreso= sigueONoingresando();
        }
    }
    public static void mostrarArmas(){
        System.out.println("Armas");
        for (int i=0;i< armas.size();i++) {
            System.out.println(armas.get(i).getNombre());

        }
    }




    //EJERCITO
    public static void cargarEjercito(){
        boolean continuaIngreso=true;
        while (continuaIngreso){


            String respuesta;
            System.out.print("Que Guerrero desea ingresar? Berzerker, Arquero o Mago :");
            respuesta= teclado.next();

            System.out.print("Id  :");
            int idGuerrero= teclado.nextInt();
            System.out.print("Nombre :");
            String nombreGuerrero= teclado.next();
            System.out.print("Fuerza(double) :");
            double fuerzaGuerrero= teclado.nextDouble();

            switch (respuesta){
                case "Berzerker":
                    guerreros.add(new Berzerker(idGuerrero, nombreGuerrero, fuerzaGuerrero));
                    break;
                case "Arquero":
                    guerreros.add(new Arquero(idGuerrero, nombreGuerrero, fuerzaGuerrero));

                    break;
                case "Mago":
                    guerreros.add(new Mago(idGuerrero, nombreGuerrero, fuerzaGuerrero));
                    break;
            }

            // PREGUNTAR POR continuaIngreso=sigueOnoIngresando()
            continuaIngreso= sigueONoingresando();
        }

    }

    private static boolean sigueONoingresando() {

        boolean sigue=true;
        System.out.print("Desea seguir ingresando? si/no :");
        String respuesta= teclado.next();
        if (respuesta.equalsIgnoreCase("no")){
            sigue=false;
        }
        return sigue;
    }



    static Scanner teclado = new Scanner(System.in);

    public void agregarGuerrero(Guerrero g){
        guerreros.add(g);
    }

    public static void mostrarEjercito(){
        System.out.println("Ejercito");
        for (int i=0;i< guerreros.size();i++) {
            System.out.println(guerreros.get(i).getNombre());

        }
    }





}
