/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_Campanera extends JPanel {
    
    Campanera campanera;
    JLabel  etiqueta_tiempo, text_2;;
    JTextField text_1, text_3;
    JButton btn_01, btn_02, btn_optimizar;
    
    // Contructor de la clase
    public Panel_Campanera(JPanel main_panel) {
        this.setLayout(null);
        this.setBounds(125, 152, 270, 115);
        this.setFocusable(true);
        
        Createcomponents();
        addComponents(main_panel);
    }

    // Agregar componentes al panel
    public void Createcomponents() {
        
        ImageIcon icon_btn_up = new ImageIcon(getClass().getResource("/Images/btn_up.png"));
        ImageIcon icon_btn_down = new ImageIcon(getClass().getResource("/Images/btn_button.png"));
        
        // TODO PARA EL PANEL DE LA CAMPANERA
        
        // Nuero de campanas
        text_1 = new JTextField();
        text_1.setText("2"); // valores por defecto en la interfaz (modificables para el usuario)
        text_1.setBounds(90, 15, 120, 25);

        text_2 = new JLabel("N° Campanas ");
        text_2.setBounds(5, 15, 120, 25);

        btn_01 = new JButton();
        btn_01.setBounds(240, 15, 27, 25);
        btn_01.setIcon(icon_btn_up);

        btn_02 = new JButton();
        btn_02.setBounds(211, 15, 27, 25);
        btn_02.setIcon(icon_btn_down);

        // Tiempo
        etiqueta_tiempo = new JLabel("Tiempo");
        etiqueta_tiempo.setBounds(5, 40, 120, 25);
        
        text_3 = new JTextField();
        text_3.setText("4");
        text_3.setBounds(90, 40, 120, 25);

        btn_optimizar = new JButton();
        btn_optimizar.setSize(100, 27);
        btn_optimizar.setLocation(170, 75);
        btn_optimizar.setText("Automate");
        btn_optimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int tiempo             = Integer.parseInt(text_3.getText());
                int num_campanas_proceso = Integer.parseInt(text_1.getText());
                
                campanera = new Campanera(tiempo, num_campanas_proceso);
                campanera.Optimizar_Campanera();
            }
        });
    }
    
    public void addComponents (JPanel main_panel) {
            
        // AGREGANDO COMPONENTES AL PANEL DE LA ROLLERA
        this.add(text_1);    this.add(text_2);   this.add(btn_02);
        this.add(text_3);    this.add(btn_01);   this.add(btn_optimizar);
        this.add(etiqueta_tiempo);
               
        // AGREGANDO COMPONENTES AL PANEL PRINCIPAL (panel contenedor)
        main_panel.add(this);
    }   
}
