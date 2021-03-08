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

public class Panel_Planchadora extends JPanel {

    // Variables de los componentes
    Planchadora planchadora;
    JLabel etiqueta_tiempo, etiqueta_punto, etiqueta_num_campanas;;
    JTextField text_1, text_2;
    JButton btn_01, btn_02, btn_optimizar;
    JComboBox options_01;

    // Contructor de la clase
    public Panel_Planchadora(JPanel main_panel) {
        this.setLayout(null);
        this.setBounds(128, 435, 270, 130);
        this.setFocusable(true);

        // Llamado de los metodos de la clase
        Createcomponents();
        AddComponents(main_panel);
    }

    // Agregar componentes al panel
    public void Createcomponents() {

        ImageIcon icon_btn_up = new ImageIcon(getClass().getResource("/Images/btn_up.png"));
        ImageIcon icon_btn_down = new ImageIcon(getClass().getResource("/Images/btn_button.png"));

        // TODO PARA EL PANEL DE LA PLANCHADORA
        text_1 = new JTextField();
        text_1.setText("3"); // tiempo
        text_1.setBounds(90, 40, 120, 25);

        text_2 = new JTextField();
        text_2.setText("3");
        text_2.setBounds(90, 15, 120, 25);

        etiqueta_num_campanas = new JLabel("N° Campanas ");
        etiqueta_num_campanas.setBounds(5, 15, 120, 25);

        etiqueta_tiempo = new JLabel("Tiempo ");
        etiqueta_tiempo.setBounds(5, 40, 120, 25);

        btn_01 = new JButton();
        btn_01.setBounds(211, 15, 27, 25);
        btn_01.setIcon(icon_btn_up);

        btn_02 = new JButton();
        btn_02.setBounds(240, 15, 27, 25);
        btn_02.setIcon(icon_btn_down);

        etiqueta_punto = new JLabel("Planchar en ");
        etiqueta_punto.setBounds(5, 65, 120, 25);

        options_01 = new JComboBox();
        options_01.setBounds(90, 65, 120, 25);
        options_01.setModel(new DefaultComboBoxModel<>(new String[]{"Copa", "Ala Izquierda", "Ala Derecha"}));

        btn_optimizar = new JButton();
        btn_optimizar.setSize(100, 27);
        btn_optimizar.setLocation(170, 100);
        btn_optimizar.setText("Automate");
        btn_optimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int tiempo = Integer.parseInt(text_1.getText());
                int num_campanas_proceso = Integer.parseInt(text_2.getText());

                planchadora = new Planchadora(tiempo, num_campanas_proceso);
                planchadora.Optimizar_Planchadora();
            }
        });
    }

    public void AddComponents(JPanel main_panel) {

        // AGREGANDO COMPONENTES AL PANEL DE LA PLANCHADORA
        this.add(text_1);                 this.add(text_2);          this.add(btn_01);
        this.add(btn_02);                 this.add(etiqueta_punto);  this.add(etiqueta_tiempo);
        this.add(etiqueta_num_campanas);  this.add(btn_optimizar);   this.add(options_01);

        // AGREGANDO COMPONENTES AL PANEL PRINCIPAL (panel contenedor)
        main_panel.add(this);
    }
}
