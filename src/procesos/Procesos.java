/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procesos;

/**
 *
 * @author Angela
 */
public class Procesos {

    /**
     * @param args the command line arguments
     */
    private int llegada;
    private int ejecucion;
    private int id;

    public Procesos(int id, int llegada, int ejecucion) {
        this.id = id;
        this.llegada = llegada;
        this.ejecucion = ejecucion;
    }

    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public int getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(int ejecucion) {
        this.ejecucion = ejecucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
         
}