/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JFrame;

public class Resultados {
   
    Rollera     rollera;
    Campanera   campanera;
    Tenidora    tenidora;
    Planchadora planchadora;
    
    public Resultados ( Rollera rollera, Campanera campanera, Tenidora tenidora, Planchadora planchadora){
        this.rollera     = rollera;
        this.campanera   = campanera;
        this.planchadora = planchadora;
        this.tenidora    = tenidora;
    }
    
    public void Optimizar() {
        Ventana_Resultados ventana = new Ventana_Resultados (rollera, campanera, tenidora, planchadora, this);
    }
}
