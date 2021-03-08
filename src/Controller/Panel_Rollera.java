package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.JSType;

public class Panel_Rollera extends JPanel {

    Rollera rollera;
    JTextField text_1, text_3;
    JLabel text_2, etiqueta_tiempo;
    JButton btn_01, btn_02, btn_optimizar;

    // Contructor de la clase
    public Panel_Rollera(JPanel main_panel) {
        this.setLayout(null);
        this.setBounds(150, 40, 248, 85);
        this.setFocusable(true);

        Createcomponents();
        addComponentes(main_panel);
    }

    //Agregar componentes al panel
    public void Createcomponents() {

        ImageIcon icon_btn_up = new ImageIcon(getClass().getResource("/Images/btn_up.png"));
        ImageIcon icon_btn_down = new ImageIcon(getClass().getResource("/Images/btn_button.png"));

        // TODO PARA EL PANEL DE LA ROLLERA 
        text_1 = new JTextField();
        text_1.setText("1");
        text_1.setBounds(65, 1, 120, 25);

        text_2 = new JLabel("N° rollos ");
        text_2.setBounds(5, 1, 120, 25);

        btn_01 = new JButton();
        btn_01.setBounds(190, 2, 27, 25);
        btn_01.setIcon(icon_btn_up);

        btn_02 = new JButton();
        btn_02.setBounds(218, 2, 27, 25);
        btn_02.setIcon(icon_btn_down);

        etiqueta_tiempo = new JLabel("Tiempo");
        etiqueta_tiempo.setBounds(5, 25, 120, 25);

        text_3 = new JTextField();
        text_3.setText("10");
        text_3.setBounds(65, 25, 120, 25);

        btn_optimizar = new JButton();
        btn_optimizar.setSize(100, 27);
        btn_optimizar.setLocation(145, 55);
        btn_optimizar.setText("Automate");

        // Agregando escuchador al botón para accionarlo 
        btn_optimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int tiempo = Integer.parseInt(text_3.getText());
                int num_rollos_proceso = Integer.parseInt(text_1.getText());

                rollera = new Rollera(tiempo, num_rollos_proceso);
                rollera.Optimizar_Rollera();
            }
        });
    }

    public void addComponentes(JPanel main_panel) {

        // AGREGANDO COMPONENTES AL PANEL DE LA ROLLERA
        this.add(text_1);       this.add(text_2);
        this.add(text_3);       this.add(btn_01);
        this.add(btn_02);       this.add(btn_optimizar);
        this.add(etiqueta_tiempo);

        // AGREGANDO COMPONENTES AL PANEL PRINCIPAL (panel contenedor)
        main_panel.add(this);
    }
}
