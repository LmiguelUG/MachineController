/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ventana_Principal extends JFrame {

    // Vriables de los componentes
    JPanel main_panel, data_panel, industry_panel;
    Panel_Rollera rollera_panel;
    Panel_Campanera campanera_panel;
    Panel_Tenidora tenidora_panel;
    Panel_Planchadora planchadora_panel;

    JMenuBar barra_menu;
    JMenu menu_1, menu_2, menu_3;
    JMenuItem menu_1_1, menu_1_2, menu_2_1, menu_3_1, menu_3_2;

    JLabel etiqueta_campanera, etiqueta_rollera, etiqueta_tenidora, etiqueta_planchadora;
    JLabel title_seccion, linea_01, linea_02, linea_03;
    JLabel fondo, industry, time_actual, details, selection, time_solicitud;

    JComboBox options_01;
    JTextArea text_details;
    JTextField text_opmitizar, text_time;
    JButton btn_optimizar;
    JScrollPane scroll_details;

    ImageIcon icon_fondo = new ImageIcon(getClass().getResource("/Images/Background.jpg"));
    ImageIcon icon_industry = new ImageIcon(getClass().getResource("/Images/NameIndustre.png"));
    ImageIcon icon_linea = new ImageIcon(getClass().getResource("/Images/linea.png"));

    Rollera rollera;
    Campanera campanera;
    Tenidora tenidora;
    Planchadora planchadora;
    Ventana_Principal esta_ventana = this;

    // Constructor de la clase, necesario para la creación de objetos de esta clase
    public Ventana_Principal() {

        // Propiedades particulares de la esta ventana 
        this.setTitle("Controller Machine (3.2.2)");
        this.setResizable(false);
        this.setSize(800, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // habilitar cierre con la x 
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        /* El panel Princiapl (Lienzo), sobre el cual estarán los paneles de cada maquina */
        main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setBounds(0, 0, 400, 575);
        main_panel.setFocusable(true);
        this.getContentPane().add(main_panel);

        /* Componentes a agregar en el panel principal */
        rollera_panel = new Panel_Rollera(main_panel);
        campanera_panel = new Panel_Campanera(main_panel);
        tenidora_panel = new Panel_Tenidora(main_panel);
        planchadora_panel = new Panel_Planchadora(main_panel);

        main_panel.add(rollera_panel);
        main_panel.add(tenidora_panel);
        main_panel.add(campanera_panel);
        main_panel.add(planchadora_panel);

        /* El panel datos (lienzo), sobre el cual estarán los componentes para consultar y manejar resultados generales */
        data_panel = new JPanel();
        data_panel.setLayout(null);
        data_panel.setBounds(400, 0, 393, 571);
        data_panel.setBackground(Color.DARK_GRAY);
        data_panel.setFocusable(true);
        data_panel.setBackground(Color.red);
        this.getContentPane().add(data_panel);

        industry_panel = new JPanel();
        industry_panel.setLayout(null);
        industry_panel.setBounds(0, 490, 400, 90);
        industry_panel.setBackground(Color.WHITE);
        industry_panel.setFocusable(true);

        data_panel.add(industry_panel);

        /* */
        barra_menu = new JMenuBar();

        menu_1 = new JMenu("Archivo");
        menu_1_1 = new JMenuItem("Salir");
        menu_1_2 = new JMenuItem("Guardar");
        menu_1.add(menu_1_1);
        menu_1.add(menu_1_2);

        menu_2 = new JMenu("Historial");
        menu_2_1 = new JMenuItem("Operaciones");
        menu_2.add(menu_2_1);

        menu_3 = new JMenu("Identificación");
        menu_3_1 = new JMenuItem("Personal");
        menu_3_2 = new JMenuItem("otro");

        menu_3.add(menu_3_1);
        menu_3.add(menu_3_2);

        barra_menu.add(menu_1);
        barra_menu.add(menu_2);
        barra_menu.add(menu_3);
        this.setJMenuBar(barra_menu);

        // Agregando un escuchador de accion del mouse
        this.getContentPane().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                // Coloca el foco donde el usuario haga clic
                ((Component) me.getSource()).transferFocus();
            }
        });
        
        // Llamado automatico de los métodos de la clase
        Logo();
        AddComponentsLeft();
        AddComponentsRight();
        setVisible(true);
    }

    public void AddComponentsLeft() {

        /* LINEAS DIVISORAS DEL PANEL PRINCIPAL ( panel contenedor ) */
        linea_01 = new JLabel();
        linea_01.setBounds(0, 145, industry_panel.getWidth(), 5);
        linea_01.setIcon(icon_linea);

        linea_02 = new JLabel();
        linea_02.setBounds(0, 270, industry_panel.getWidth(), 5);
        linea_02.setIcon(icon_linea);

        linea_03 = new JLabel();
        linea_03.setBounds(0, 420, industry_panel.getWidth(), 5);
        linea_03.setIcon(icon_linea);

        
        etiqueta_rollera = new JLabel();
        etiqueta_rollera.setText("ROLLERA: ");
        etiqueta_rollera.setSize(60, 180);
        etiqueta_rollera.setLocation(30, -30);

        etiqueta_campanera = new JLabel();
        etiqueta_campanera.setText("CAMPANERA: ");
        etiqueta_campanera.setSize(100, 200);
        etiqueta_campanera.setLocation(30, 70);

        etiqueta_tenidora = new JLabel();
        etiqueta_tenidora.setText("TEÑIDORA: ");
        etiqueta_tenidora.setSize(100, 200);
        etiqueta_tenidora.setLocation(30, 200);

        etiqueta_planchadora = new JLabel();
        etiqueta_planchadora.setText("PLANCHADORA: ");
        etiqueta_planchadora.setSize(100, 200);
        etiqueta_planchadora.setLocation(30, 360);

        title_seccion = new JLabel();
        title_seccion.setText("CONTROLADORES");
        title_seccion.setBounds((main_panel.getWidth() / 2) - 50, 5, 150, 25);

        // AGREGANDO COMPONENTES AL PANEL PRINCIPAL (panel contenedor)
        main_panel.add(linea_01);
        main_panel.add(linea_02);
        main_panel.add(linea_03);

        main_panel.add(etiqueta_rollera);
        main_panel.add(etiqueta_tenidora);
        main_panel.add(etiqueta_campanera);
        main_panel.add(etiqueta_planchadora);
        main_panel.add(title_seccion);
    }

    /* Metodo para cambiar el icono de la ventana */
    public void Logo() {
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/Images/Industry_Name.png")).getImage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AddComponentsRight() {

        fondo = new JLabel();
        fondo.setBounds(0, 0, 393, 490);
        fondo.setIcon(icon_fondo);

        industry = new JLabel();
        industry.setBounds(33, 0, industry_panel.getWidth(), industry_panel.getHeight());
        industry.setIcon(icon_industry);

        time_actual = new JLabel("Tiempo Actual");
        time_actual.setBounds(33, 5, 150, 30);

        text_time = new JTextField("10");
        text_time.setBounds(120, 5, 150, 30);

        details = new JLabel("Tiempo Optimizado de Cada Controlador");
        details.setBounds(33, 60, 250, 30);

        options_01 = new JComboBox();
        options_01.setBounds(33, 100, 200, 30);
        options_01.setModel(new DefaultComboBoxModel<>(new String[]{"rollera time", "dyeing time", "ironer time", "bell time"}));
        options_01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                selection.setText(options_01.getSelectedItem().toString());

            }
        });

        selection = new JLabel();
        selection.setBounds(33, 140, 250, 30);

        text_details = new JTextArea();
        text_details.setBounds(33, 170, 330, 150);
        text_details.setEditable(false);
        text_details.setText(" OPTIMIZACION: EN FORMATO DD:MM:YY \n"
                + "   * TIEMPO ACTUAL EXPRESADO EN HH:MM:SS\n"
                + "   * TIEMPO NUEVO EXPRESADO EN HH:MM:SS\n"
                + "\n"
                + " OPTIMIZACION: EN FORMATO DD:MM:YY \n"
                + "   * TIEMPO ACTUAL EXPRESADO EN HH:MM:SS\n"
                + "   * TIEMPO ACTUAL EXPRESADO EN HH:MM:SS\n"
                + ".\n"
                + ".\n");

        text_opmitizar = new JTextField("");
        text_opmitizar.setBounds(165, 350, 200, 25);

        time_solicitud = new JLabel("Nuevo tiempo general");
        time_solicitud.setBounds(33, 350, 130, 25);
        time_solicitud.setForeground(Color.WHITE);

        btn_optimizar = new JButton("Optimizar");
        btn_optimizar.setBounds(265, 385, 100, 25);
        btn_optimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CreateObjets(rollera_panel, campanera_panel, tenidora_panel, planchadora_panel);
                Resultados resultados = new Resultados(rollera, campanera, tenidora, planchadora);
                resultados.Optimizar();

            }
        });

        scroll_details = new JScrollPane(text_details);
        scroll_details.setBounds(348, 170, 15, 150);
        scroll_details.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        data_panel.add(selection);
        data_panel.add(time_actual);
        data_panel.add(text_time);

        data_panel.add(details);
        data_panel.add(scroll_details);

        data_panel.add(text_details);
        data_panel.add(text_opmitizar);
        data_panel.add(time_solicitud);
        data_panel.add(btn_optimizar);
        data_panel.add(options_01);
        data_panel.add(fondo);

        industry_panel.add(industry);
    }

    public void CreateObjets(Panel_Rollera rollera_panel, Panel_Campanera campanera_panel, 
                             Panel_Tenidora tenidora_panel, Panel_Planchadora planchadora_panel) {

        int tiempo_rollera = Integer.parseInt(rollera_panel.text_3.getText());
        int num_rollos_proceso_rollera = Integer.parseInt(rollera_panel.text_1.getText());
        rollera = new Rollera(tiempo_rollera, num_rollos_proceso_rollera);

        int tiempo_campanera = Integer.parseInt(campanera_panel.text_3.getText());
        int num_campanas_proceso_campanera = Integer.parseInt(campanera_panel.text_1.getText());
        campanera = new Campanera(tiempo_campanera, num_campanas_proceso_campanera);

        int tiempo_planchadora = Integer.parseInt(planchadora_panel.text_1.getText());
        int num_campanas_proceso_planchadora = Integer.parseInt(planchadora_panel.text_2.getText());
        planchadora = new Planchadora(tiempo_planchadora, num_campanas_proceso_planchadora);

        int tiempo_tenidora = Integer.parseInt(tenidora_panel.text_3.getText());
        int num_campanas_proceso_tenidora = Integer.parseInt(tenidora_panel.text_1.getText());
        tenidora = new Tenidora(tiempo_tenidora, num_campanas_proceso_tenidora);
    }
}
