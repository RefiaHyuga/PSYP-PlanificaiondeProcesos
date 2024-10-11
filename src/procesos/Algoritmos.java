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

    int np = 0;
    Procesos p[];
    int te = 0; //Tiempo de ejecucion total
    int q = 2;

    public Algoritmos() {
        np = 5;
        p = new Procesos[np];

        p[0] = new Procesos(0, 0, 5);
        p[1] = new Procesos(1, 1, 3);
        p[2] = new Procesos(2, 2, 10);
        p[3] = new Procesos(3, 3, 1);
        p[4] = new Procesos(4, 4, 2);

    }

    public void fifo() {

        System.out.println("Algoritmo Fifo");

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
                        //System.out.println(j); Para saber en que momento entran en cola
                        e--;
                    }
                    paux[j].setEjecucion(e);
                }

            }
            int proceso = cola.getFirst();
            cola.removeFirst();
            System.out.println("Tiempo -->" + i + "   Proceso-->" + proceso);
        }
    }

    public void sjf() {

        System.out.println("Algoritmo SJF");

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
                            //System.out.println(j); Para saber en que momento entran en cola
                            e--;
                        }
                        paux[j].setEjecucion(e);
                    }

                }
            }
            int proceso = cola.getFirst();
            cola.removeFirst();
            System.out.println("Tiempo -->" + i + "   Proceso-->" + proceso);
        }
    }

    public void srtf() {
        System.out.println("Algoritmo SJF");

        
    }

    public void roundrobin(int q) {

        System.out.println("Algoritmo Round Robin");

        this.q = q;
        ArrayList<Procesos> paux = new ArrayList<Procesos>();
        ArrayList<Integer> cola = new ArrayList<Integer>();
        
        for (int i = 0; i < np; i++) {
            paux.add(p[i]);//Copiamos P a un Pauxiliar
            te = te + p[i].getEjecucion();//Calculo el tiempo final
        }

        for (int i = 0; i < te; i++) {

            Procesos pro = paux.getFirst();
            if (pro.getLlegada() <= i) {
                int e = pro.getEjecucion();
                for (int j = 0; j < q; j++) {
                    if (e >= 0) {
                        cola.add(pro.getId());
                        e--;
                    }
                }
                pro.setEjecucion(e);
                paux.removeFirst();
                paux.addLast(pro);
            }

            int proceso = cola.getFirst();
            cola.removeFirst();
            System.out.println("Tiempo -->" + i + "   Proceso-->" + proceso);
        }
    }

}
