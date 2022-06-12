package main;

import modules.*;

import java.util.ArrayList;
import java.util.Scanner;


public class main {

    static ArrayList<Guerrero> guerreros = new ArrayList<>();
    static ArrayList<Arma> armas = new ArrayList<>();

    public static void main(String[] args) {

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
        int i = 0;
        int armasNoAsignadas = 0;
        int guerrerosNoAsignados = 0;
        while (i < guerreros.size() && i < armas.size()) {
            for (int j = 0; j < guerreros.size(); j++) {
                Class g1 = guerreros.get(j).getClass();
                if ("Berzerker".equals(g1)) {
                    if (!armas.get(j).equals("Espada")) {
                        armasNoAsignadas++;
                        System.out.println(g1 + " no se le asigno arma");
                    }
                } else if ("Arquero".equals(g1)) {
                    if (!armas.get(j).equals("Arco")) {
                        armasNoAsignadas++;
                        System.out.println(g1 + " no se le asigno arma");
                    }
                } else if ("Mago".equals(g1)) {
                    if (!armas.get(j).equals("Vaculo")) {
                        armasNoAsignadas++;
                        System.out.println(g1 + " no se le asigno arma");
                    }
                }
            }
            i++;
        }
    }

    // ESte metodo nunca lo usaste. Poner un ejemplo del mismo sobre el main.
    // Create un objeto a mano con los constructores que definiste y asi lo ejecutas.
    private boolean matarEnemigo(Guerrero g, Enemigo e) {
        boolean loMata = false;
        int cero = 0;
        if (e.getVida() - g.ataqueBasico() <= cero) {
            loMata = true;
        }
        return loMata;
    }


    private static void equiparEjercito(ArrayList<Guerrero> guerreros, ArrayList<Arma> armas) {

        // Este metodo va a rehacerse.
        // El punto de éste metodo es el hecho de que aprendas a manejar 2 litas en paralelo donde los indices de cada una puede ser variable
        // los objetos que hay dentro de ella pueden ser variables tambien.
        // Con el metodo definido por vos, tiene que existir la misma cantidad de guerreros, armas y estar ordenados.

        /*
        * Te dejo un lineamiento y una ayuda para éste ejercicio:
        * Podes usar 2 fors, donde en el primero loopees guerreros y en el segundo las armas.
        * for(Guerrero guerrero : guerreros){
        *   for(Arma arma : armas){
        *       Aca metes la logica de preguntar si el guerrero es X clase y el Arma es Y Clase.
        *       Si matchean usas el set, removes el objeto del array y rompes el loopeo de armas.
        *   }
        * }
        * */
        if (guerreros.size() == armas.size()) {
            for (int i = 0; i < guerreros.size(); i++) {
                guerreros.get(i).setArma(armas.get(i));
            }

        } else {
            System.out.println("No hay la misma cantidad de armas y guerreros");
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

                // Mismo comentario que en Cargar Ejercito.
                System.out.print("Que Arma desea ingresar? Espada, Arco o Vaculo :");
                String respuesta = teclado.next();
                if (!respuesta.equalsIgnoreCase("Espada") && !respuesta.equalsIgnoreCase("Arco") && !respuesta.equalsIgnoreCase("Vaculo")) {
                    System.out.print("Ingrese opcion correcta Espada, Arco o Vaculo :");
                    respuesta = teclado.next();
                }

                System.out.print("Id  :");
                // Acá a lo sumo, podrias haber hecho que el id se genere aleatoriamente. No pasaba nada.
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
                // Acá como algo mas sencillo, pudieras haber usado numeros en vez de escribir el texto completo
                // EJ: 1 - Berserker \n 2 \n - Arquero 3 - Mago (El \n en un string es un salto de linea)
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
        // Para evitarte cualquier tema de mayusculas y minusculas podias hacer un:
        // teclado.next().toLowerCas().
        String respuesta = teclado.next();
        // Con lo dicho arriba acá directamente hacias un respuesta.equals("si")
        // sigue = true; y list.
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


