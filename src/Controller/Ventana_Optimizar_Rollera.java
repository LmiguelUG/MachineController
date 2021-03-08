/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ventana_Optimizar_Rollera extends JFrame {
    
    // Vriables de los componentes
    Rollera rollera;
           
    JPanel panel;
    
    JLabel LDL, LHL, LPM, LS;
    JLabel LCPM, LCPD, controller;
    JLabel LVMOD, LVMH, LVMD;
          
    JTextField   TFDL;  // dias laborados
    JTextField   TFHL;  // horas laboradas
    JTextField   TFPM;  // producción mensual
    JTextField   TFS;   // sueldo
    JTextField   TFCPM;  // costos proceso al mes
    JTextField   TFCPD;  // costos proceso al día
    JTextField   TFVMOD; // valor mano de obra al dia
    JTextField   TFVMH;  //valor maquina hora
    JTextField   TFVMD;  // valor maquina al día
    
    JButton btn_aceptar;
    
    public Ventana_Optimizar_Rollera(Rollera rollera) {
        
        this.rollera = rollera;
        
        // Propiedades de la ventana 
        this.setTitle("Automatización de Rollera");
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        

        CreateComponents();
        AddComponents();
            
        setVisible(true);
    }
    
    public void CreateComponents() {
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25, 0, 350, 400);
        panel.setFocusable(true);
            
        LDL = new JLabel("Dias laborados: ");
        LDL.setBounds(5, 50, 200, 25);
        
        LHL = new JLabel("Horas laboradas: ");
        LHL.setBounds(5, 80, 200, 25);
        
        LPM = new JLabel("Producción mensual: ");
        LPM.setBounds(5, 110, 200, 25);
        
        LS = new JLabel("sueldo: ");
        LS.setBounds(5, 140, 200, 25);
        
        LVMOD = new JLabel("Valor mano de obra: ");
        LVMOD.setBounds(5, 170, 200, 25);
        
        LVMH = new JLabel("Valor de maquina por hora: ");
        LVMH.setBounds(5, 200, 200, 25);
        
        LVMD = new JLabel("Valor de maquina por día: ");
        LVMD.setBounds(5, 230, 200, 25);
        
        LCPD = new JLabel("Costo del Proceso por día: ");
        LCPD.setBounds(5, 260, 200, 25);
        
        LCPM = new JLabel("Costo del proceso por mes: ");
        LCPM.setBounds(5, 290, 200, 25);
        
        TFDL   = new JTextField();
        TFDL.setBounds(180, 50, 150, 25);
        TFDL.setText(String.valueOf(rollera.dias_laborales));
        
        TFHL   = new JTextField();
        TFHL.setBounds(180, 80, 150, 25);
        TFHL.setText(String.valueOf(rollera.horas_laborales));
        
        TFPM   = new JTextField();
        TFPM.setBounds(180, 110, 150, 25);
        TFPM.setText(String.valueOf(rollera.produccion_mensual));
        
        TFS    = new JTextField();
        TFS.setBounds(180, 140, 150, 25);
        TFS.setText(String.valueOf(rollera.sueldo));
        
        TFVMOD = new JTextField();
        TFVMOD.setBounds(180, 170, 150, 25);
        TFVMOD.setText(String.valueOf(rollera.valor_mano_obra_dia));
        
        TFVMH  = new JTextField();
        TFVMH.setBounds(180, 200, 150, 25);
        TFVMH.setText(String.valueOf(rollera.valor_maquina_hora));
        
        TFVMD  = new JTextField();
        TFVMD.setBounds(180, 230, 150, 25);
        TFVMD.setText(String.valueOf(rollera.valor_maquina_dia));
        
        TFCPD  = new JTextField();
        TFCPD.setBounds(180, 260, 150, 25);
        TFCPD.setText(String.valueOf(rollera.costo_proceso_dia));
        
        TFCPM  = new JTextField();
        TFCPM.setBounds(180, 290, 150, 25);
        TFCPM.setText(String.valueOf(rollera.costo_proceso_mes));
        
        controller = new  JLabel("OPTIMIZACIÓN ROLLERA");
        controller.setBounds(100, 5, 200, 25);
        
        btn_aceptar = new JButton();
        btn_aceptar.setSize(100, 27);
        btn_aceptar.setLocation(125, 330);
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        
        this.getContentPane().add(panel);
    }
    
    public void AddComponents () {
        
        panel.add(LDL);
        panel.add(LCPM);
        panel.add(LVMD);
        panel.add(LVMH);
        panel.add(LVMOD);
        panel.add(LS);
        panel.add(LPM);
        panel.add(LHL);
        panel.add(LCPD);
        panel.add(TFDL);
        panel.add(TFCPM);
        panel.add(TFVMD);
        panel.add(TFVMH);
        panel.add(TFVMOD);
        panel.add(TFS);
        panel.add(TFPM);
        panel.add(TFHL);
        panel.add(TFCPD);
        panel.add(btn_aceptar);
        panel.add(controller);
    }
    
}
