/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_Tenidora extends JPanel {

    Tenidora tenidora;
    JLabel etiqueta_tiempo, etiqueta_color, text_2;
    JTextField text_1, text_3;   
    JButton btn_01, btn_02, btn_optimizar;
    JComboBox options_01;
    
    // Contructor de la clase
    public Panel_Tenidora(JPanel main_panel) {
        this.setLayout(null);
        this.setBounds(125, 285, 270, 130);
        this.setFocusable(true);

        // Llamando los metodos metodos de la clase
        Createcomponents();
        addComponents(main_panel);
    }

    // Agregar componentes al panel
    public void addComponents(JPanel main_panel) {
       // AGREGANDO COMPONENTES AL PANEL DE LA TEÑIDORA
        this.add(text_1);          this.add(text_2);           this.add(text_3);
        this.add(etiqueta_tiempo); this.add(etiqueta_color);   this.add(btn_01);
        this.add(btn_02);          this.add(btn_optimizar);    this.add(options_01); 
        
    }

    private void Createcomponents() {
        ImageIcon icon_btn_up = new ImageIcon(getClass().getResource("/Images/btn_up.png"));
        ImageIcon icon_btn_down = new ImageIcon(getClass().getResource("/Images/btn_button.png"));
        
        text_3 = new JTextField();
        text_3.setText("60");
        text_3.setBounds(90, 40, 120, 25);

        etiqueta_tiempo = new JLabel("Tiempo ");
        etiqueta_tiempo.setBounds(5, 40, 120, 25);
        
        text_1 = new JTextField();
        text_1.setText("260");
        text_1.setBounds(90, 15, 120, 25);

        text_2 = new JLabel("N° Campanas ");
        text_2.setBounds(5, 15, 120, 25);
        
        etiqueta_color = new JLabel("Color ");
        etiqueta_color.setBounds(5, 65, 120, 25);

        options_01 = new JComboBox();
        options_01.setBounds(90, 65, 120, 25);
        options_01.setModel(new DefaultComboBoxModel<>(new String[]{"Color 1", "Color_2", "Color_3", 
                                                                    "Color 4", "Color 5"}));

        btn_01 = new JButton();
        btn_01.setBounds(211, 15, 27, 25);
        btn_01.setIcon(icon_btn_up);

        btn_02 = new JButton();
        btn_02.setBounds(240, 15, 27, 25);
        btn_02.setIcon(icon_btn_down);

        btn_optimizar = new JButton();
        btn_optimizar.setSize(100, 27);
        btn_optimizar.setLocation(170, 100);
        btn_optimizar.setText("Automate");
        btn_optimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int tiempo               = Integer.parseInt(text_3.getText());
                int num_campanas_proceso = Integer.parseInt(text_1.getText());
                
                tenidora = new Tenidora(tiempo, num_campanas_proceso);
                tenidora.Optimizar_Tenidora();
            }
        });
    }
}
