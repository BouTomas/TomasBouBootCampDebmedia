package main;

import javafx.scene.chart.ScatterChart;
import modules.*;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

    static ArrayList<Guerrero> guerreros = new ArrayList<>();
    static ArrayList<Arma> armas = new ArrayList<>();


    public static void main(String[] args) {

        //JDK 1.8


        try {
            cargarEjercito();
            cargarArmeria();
            // cargarArma(magos.get(0), arcos.get(0));

            mostrarEjercito();
            mostrarArmas();
            equiparEjercito(guerreros, armas);
            resultadoDeArmeria();
            System.out.println("Listo");
        } catch (RuntimeException r) {
            System.out.println("Hubo un error en el sistema");
        }



    }

    private static void resultadoDeArmeria() {
        // Este metodo se simplificaria mucho con lo comentado en cargar armas.
        // Por que las armas sin cargar la sacas facilmente con un armas.size()
        // Y despues solo loopearias sobre el array guerreros y contas los que en el
        // guerrero.getArma() te devuelve un null.
        System.out.println("Armas no asignadas");
        for (Arma a:armas) {
            System.out.println(a);

        }
        System.out.println("Guerreros desarmados");
        for (Guerrero g:guerreros) {
            if(g.getArma()==null){
                System.out.println(g);
            }

        }
    }

    private boolean matarEnemigo(Guerrero g, Enemigo e) {
        boolean loMata = false;
        int cero = 0;
        if (e.getVida() - g.ataqueBasico() <= cero) {
            loMata = true;
        }
        return loMata;
    }


    private static void equiparEjercito(ArrayList<Guerrero> guerreros, ArrayList<Arma> armas) {


        for(Guerrero guerrero:guerreros) {
            for(Arma arma:armas){
                if(guerrero.getClass()==Berzerker.class && guerrero.getArma()==null && arma.getClass()==Espada.class){
                    guerrero.setArma(arma);
                    armas.remove(arma);
                    break;
                }
                else if(guerrero.getClass()==Mago.class && guerrero.getArma()==null && arma.getClass()==Vaculo.class){
                    guerrero.setArma(arma);
                    armas.remove(arma);
                    break;
                }
                else if(guerrero.getClass()==Arquero.class && guerrero.getArma()==null && arma.getClass()==Arco.class){
                    guerrero.setArma(arma);
                    armas.remove(arma);
                    break;
                }
            }

        }

    }

    public static void cargarArma(Guerrero g, Arma a) {
        g.setArma(a);

    }

    //ARMERIA
    public static void cargarArmeria() {

        boolean continuaIngreso = true;
        try {
            while (continuaIngreso) {

                System.out.print("Que Arma desea ingresar? Espada, Arco o Vaculo :");
                String respuesta = teclado.next();
                if (!respuesta.equalsIgnoreCase("Espada") && !respuesta.equalsIgnoreCase("Arco") && !respuesta.equalsIgnoreCase("Vaculo")) {
                    System.out.print("Ingrese opcion correcta Espada, Arco o Vaculo :");
                    respuesta = teclado.next();
                }

                System.out.print("Id  :");
                int idArma = teclado.nextInt();
                System.out.print("Nombre :");
                String nombreArma = teclado.next();
                System.out.print("Fuerza(double) :");
                double fuerzaArma = teclado.nextDouble();


                switch (respuesta) {
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
                continuaIngreso = sigueONoingresando();
            }

        } catch (RuntimeException r) {
            System.out.print("Error al cargar Armas");
            cargarArmeria();
        }

    }

    public static void mostrarArmas() {
        System.out.println("Armas :");
        for (int i = 0; i < armas.size(); i++) {
            System.out.println(armas.get(i).getNombre());

        }
    }
   static Scanner teclado = new Scanner(System.in);

    //EJERCITO
    public static void cargarEjercito() {

        boolean continuaIngreso = true;

        try {
            while (continuaIngreso) {


                String respuesta;
                System.out.println("Que Guerrero desea ingresar? Berzerker, Arquero o Mago :");

                respuesta = teclado.next();
                if (!respuesta.equalsIgnoreCase("Berzerker") && !respuesta.equalsIgnoreCase("Arquero") && !respuesta.equalsIgnoreCase("Mago")) {
                    System.out.println("Ingrese opcion correcta Berzerker, Arquero o Mago :");
                    respuesta = teclado.next();
                }


                System.out.print("Id  :");
                int idGuerrero = teclado.nextInt();
                System.out.print("Nombre :");
                String nombreGuerrero = teclado.next();
                System.out.print("Fuerza(double) :");
                double fuerzaGuerrero = teclado.nextDouble();


                switch (respuesta) {
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
                continuaIngreso = sigueONoingresando();
            }

        } catch (RuntimeException e) {
            System.out.print("Error al cargar ejercito");
        }


    }

    private static boolean sigueONoingresando() {

        boolean sigue = true;
        System.out.print("Desea seguir ingresando? si/no :");
        String respuesta = teclado.next();
        if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
            System.out.print("Ingrese opcion correcta si o no :");
            respuesta = teclado.next();
        }
        if (respuesta.equalsIgnoreCase("no")) {
            sigue = false;
        }
        return sigue;
    }

        public  void agregarGuerrero (Guerrero g){

            guerreros.add(g);
        }

        public static void mostrarEjercito() {
            System.out.println("Ejercito : ");
            for (int i = 0; i < guerreros.size(); i++) {
                System.out.println(guerreros.get(i).getNombre());

            }
        }


    }


