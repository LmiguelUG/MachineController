/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Luis Urbina
 */
public class Ventana_Resultados extends JFrame {
    
    Helpers helpers;
    Resultados resultados;
    JPanel panel;
    JButton btn_back, btn_exit;
    JLabel etiqueta_rollera;
    JLabel etiqueta_campanera;
    JLabel etiqueta_tenidora;
    JLabel etiqueta_planchadora, etiqueta_results, linea;
    Ventana_Resultados esta_ventana = this;
    
    
    public Ventana_Resultados (Rollera rollera, Campanera campanera, Tenidora tenidora, Planchadora planchadora, Resultados resultados) {
        
        this.resultados = resultados;
        
        // Propiedades de la ventana 
        this.setTitle("Controller Machine (3.2.2)");
        this.setResizable(false);
        this.setSize(800, 670);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25,5,750, 630);
        panel.setFocusable(true);
        
        this.getContentPane().add(panel);
        
        CreateComponents();
        AddComponents(panel);
        
        
        helpers = new Helpers(rollera, campanera, tenidora, planchadora, panel);         
        this.setVisible(true);
    }
    
    public void CreateComponents() {
        
        etiqueta_results = new JLabel("RESULTADOS GENERALES ");
        etiqueta_results.setBounds(325,5,180,30);
        
        etiqueta_rollera = new JLabel("ROLLERA: ");
        etiqueta_rollera.setBounds(5,60,100,30);
        
        etiqueta_campanera = new JLabel("CAMPANERA: ");
        etiqueta_campanera.setBounds(5,200,100,30);
        
        etiqueta_tenidora = new JLabel("TENIDORA: ");
        etiqueta_tenidora.setBounds(5,335,100,30);
        
        etiqueta_planchadora = new JLabel("PLANCHADORA: ");
        etiqueta_planchadora.setBounds(5,470,100,30);
        
        btn_back = new JButton("Atras");
        btn_back.setBounds(550,603,80,25);
        /* btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Ventana_Principal principal = new Ventana_Principal();
                esta_ventana.dispose();
            }
        });*/
        
        btn_exit = new JButton("Finalizar");
        btn_exit.setBounds(640,603,90,25);
        
        btn_exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        

    }
    
    
    public void AddComponents (JPanel panel) {
        panel.add(etiqueta_rollera);
        panel.add(etiqueta_campanera);
        panel.add(etiqueta_tenidora);
        panel.add(etiqueta_planchadora);
        panel.add(etiqueta_results);
        panel.add(btn_back);
        panel.add(btn_exit);
    }
    
    
}
