/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procesos;

import java.util.ArrayList;

/**
 *
 * @author Angela
 */
public class Algoritmos {

    static int np = 0;
    static Procesos p[];
    static int te = 0; //Tiempo de ejecucion total
    static int q = 2;

    private static void setProcesos() {
        np = 5;
        p = new Procesos[np];

        p[0] = new Procesos(0, 0, 5);
        p[1] = new Procesos(1, 1, 3);
        p[2] = new Procesos(2, 2, 10);
        p[3] = new Procesos(3, 3, 1);
        p[4] = new Procesos(4, 4, 2);
    }

    public static void fifo() {
        setProcesos();

        Logger.log("Algoritmo Fifo");

        Procesos paux[] = new Procesos[np];
        ArrayList<Integer> cola = new ArrayList<Integer>();
        
        for (int i = 0; i < np; i++) {
            paux[i] = p[i];//Copiamos P a un Pauxiliar
            te = te + paux[i].getEjecucion();//Calculo el tiempo final
        }

        for (int i = 0; i < te; i++) {
            for (int j = 0; j < np; j++) {
                if (paux[j].getLlegada() == i) {
                    int e = paux[j].getEjecucion();
                    for (int k = 0; k < paux[j].getEjecucion(); k++) {
                        cola.add(j);
                        //Logger.log(j); Para saber en que momento entran en cola
                        e--;
                    }
                    paux[j].setEjecucion(e);
                }

            }
            int proceso = cola.get(0);
            cola.remove(0);
            Logger.log("Tiempo --> " + i + "   Proceso--> " + proceso);
        }
    }

    public static void sjf() {
        setProcesos();

        Logger.log("Algoritmo SJF");

        Procesos paux[] = new Procesos[np];
        ArrayList<Integer> cola = new ArrayList<Integer>();
        
        for (int i = 0; i < np; i++) {
            paux[i] = p[i];//Copiamos P a un Pauxiliar
            te = te + paux[i].getEjecucion();//Calculo el tiempo final
        }

        //Algortimo burbuja
        for (int i = 0; i < np - 1; i++) {
            for (int j = 0; j < np - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (paux[j].getEjecucion() > paux[j + 1].getEjecucion()) {
                    // Intercambiar arr[j] y arr[j+1]
                    Procesos temp = paux[j];
                    paux[j] = paux[j + 1];
                    paux[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < te; i++) {
            if (cola.isEmpty()) {
                for (int j = 0; j < np; j++) {
                    if (paux[j].getLlegada() <= i) {
                        int e = paux[j].getEjecucion();
                        for (int k = 0; k < paux[j].getEjecucion(); k++) {
                            cola.add(paux[j].getId());
                            //Logger.log(j); Para saber en que momento entran en cola
                            e--;
                        }
                        paux[j].setEjecucion(e);
                    }

                }
            }

            if (!cola.isEmpty()) {
                int proceso = cola.get(0);
                cola.remove(0);
                Logger.log("Tiempo --> " + i + "   Proceso--> " + proceso);
            }
        }
    }

    public static void srtf() {
        setProcesos();
        Logger.log("Algoritmo SJF");

        
    }

    public static void roundrobin(int quantum) {
        setProcesos();

        Logger.log("Algoritmo Round Robin");

        q = quantum;
        ArrayList<Procesos> paux = new ArrayList<Procesos>();
        ArrayList<Integer> cola = new ArrayList<Integer>();
        
        for (int i = 0; i < np; i++) {
            paux.add(p[i]);//Copiamos P a un Pauxiliar
            te = te + p[i].getEjecucion();//Calculo el tiempo final
        }

        for (int i = 0; i < te; i++) {

            Procesos pro = paux.get(0);
            if (pro.getLlegada() <= i) {
                int e = pro.getEjecucion();
                for (int j = 0; j < quantum; j++) {
                    if (e >= 0) {
                        cola.add(pro.getId());
                        e--;
                    }
                }
                pro.setEjecucion(e);
                paux.remove(0);
                paux.add(pro);
            }

            if (!cola.isEmpty()) {
                int proceso = cola.get(0);
                cola.remove(0);
                Logger.log("Tiempo --> " + i + "   Proceso--> " + proceso);
            }
        }
    }
}
