/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Helpers {

    JPanel panel_1, panel_2, panel_3, panel_4, panel_5;
    JLabel linea_01, linea_02, linea_03;
    ImageIcon icon_linea = new ImageIcon(getClass().getResource("/Images/linea.png"));

    public Helpers(Rollera rollera, Campanera campanera, Tenidora tenidora, 
                   Planchadora planchadora, JPanel panel_1) {
        
        this.panel_1 = panel_1;
        
        Panel_optimizacion(rollera, campanera, tenidora, planchadora, panel_1, 1, panel_2);
        Panel_optimizacion(rollera, campanera, tenidora, planchadora, panel_1, 2, panel_3);
        Panel_optimizacion(rollera, campanera, tenidora, planchadora, panel_1, 3, panel_4);
        Panel_optimizacion(rollera, campanera, tenidora, planchadora, panel_1, 4, panel_5);

    }

    public void Panel_optimizacion(Rollera rollera, Campanera campanera, Tenidora tenidora, 
                                   Planchadora planchadora, JPanel panel_1, int N, JPanel panel_x) {

        panel_x = new JPanel();
        panel_x.setLayout(null);
        panel_x.setFocusable(true);
        
        if (N == 1) {
            panel_x.setBounds(120, 60, 600, 130);
            Panel_Plantilla(rollera, campanera, tenidora, planchadora, panel_x, 1);
        } else if (N == 2) { // campanera
            panel_x.setBounds(120, 205, 600, 130);
            Panel_Plantilla(rollera, campanera, tenidora, planchadora, panel_x, 2);
        } else if (N == 3) { // tenidora
            panel_x.setBounds(120, 345, 600, 130);
            Panel_Plantilla(rollera, campanera, tenidora, planchadora, panel_x, 3);
        } else if (N == 4) {
            panel_x.setBounds(120, 480, 600, 130);
            Panel_Plantilla(rollera, campanera, tenidora, planchadora, panel_x, 4);
        }

        panel_1.add(panel_x);
        /* LINEAS DIVISORAS DEL PANEL PRINCIPAL ( panel contenedor ) */
        linea_01 = new JLabel();
        linea_01.setBounds(0, 190, panel_1.getWidth(), 5);
        linea_01.setIcon(icon_linea);

        linea_02 = new JLabel();
        linea_02.setBounds(0, 333, panel_1.getWidth(), 5);
        linea_02.setIcon(icon_linea);

        linea_03 = new JLabel();
        linea_03.setBounds(0, 470, panel_1.getWidth(), 5);
        linea_03.setIcon(icon_linea);

        panel_1.add(linea_01);
        panel_1.add(linea_02);
        panel_1.add(linea_03);

    }

    public void Panel_Plantilla(Rollera rollera, Campanera campanera, Tenidora tenidora, 
                                Planchadora planchadora, JPanel panel, int N) {

        /* Creación  los componentes JLabel */
        JLabel num_dias_laborados = new JLabel("Dias laborados: ");
        num_dias_laborados.setBounds(5, 5, 100, 18);

        JLabel num_horas_laboradas = new JLabel("Horas laboradas: ");
        num_horas_laboradas.setBounds(5, 23, 100, 18);

        JLabel sueldo = new JLabel("Sueldo: ");
        sueldo.setBounds(5, 41, 100, 18);

        JLabel valor_mano_obra_dia = new JLabel("Valor de mano de Obra: ");
        valor_mano_obra_dia.setBounds(5, 59, 180, 18);

        JLabel valor_maquina_hora = new JLabel("Valor de maquina por hora: ");
        valor_maquina_hora.setBounds(5, 77, 180, 18);

        JLabel porcentaje_opt = new JLabel("Porcentaje de optimización en el costos: ");
        porcentaje_opt.setBounds(5, 100, 250, 18);

        JLabel valor_maquina_dia = new JLabel("Valor maquina por dia: ");
        valor_maquina_dia.setBounds(260, 5, 180, 18);

        JLabel costo_proceso_dia = new JLabel("Costo proceso por día: ");
        costo_proceso_dia.setBounds(260, 23, 180, 18);

        JLabel costo_proceso_mes = new JLabel("Costo proceso por mes: ");
        costo_proceso_mes.setBounds(260, 41, 180, 18);

        JLabel productos_dia = null;
        if (N > 1) {

            productos_dia = new JLabel("N° Campanas: ");
            productos_dia.setBounds(260, 59, 120, 18);
        } else if (N == 1) {

            productos_dia = new JLabel("N° rollos: ");
            productos_dia.setBounds(260, 59, 120, 18);
        }

        JLabel produccion_mensual = new JLabel("Producción mensual: ");
        produccion_mensual.setBounds(260, 77, 180, 18);

        /* Creación de los componentes JTextField */
        JTextField text_num_dias_laborados = new JTextField();
        text_num_dias_laborados.setBounds(165, 5, 80, 18);
        if (N == 1) {
           text_num_dias_laborados.setText(String.valueOf(rollera.dias_laborales));
        } else if (N == 2) {
           text_num_dias_laborados.setText(String.valueOf(campanera.dias_laborales));
        } else if (N == 3) {
           text_num_dias_laborados.setText(String.valueOf(tenidora.dias_laborales));
        } else if (N == 4) {
            text_num_dias_laborados.setText(String.valueOf(planchadora.dias_laborales));
        }
        

        JTextField text_num_horas_laboradas = new JTextField();
        text_num_horas_laboradas.setBounds(165, 23, 80, 18);
        if (N == 1) {
           text_num_horas_laboradas.setText(String.valueOf(rollera.horas_laborales));
        } else if (N == 2) {
           text_num_horas_laboradas.setText(String.valueOf(campanera.horas_laborales));
        } else if (N == 3) {
           text_num_horas_laboradas.setText(String.valueOf(tenidora.horas_laborales));
        } else if (N == 4) {
            text_num_horas_laboradas.setText(String.valueOf(planchadora.horas_laborales));
        }

        JTextField text_sueldo = new JTextField();
        text_sueldo.setBounds(165, 41, 80, 18);
        if (N == 1) {
           text_sueldo.setText(String.valueOf(rollera.sueldo));
        } else if (N == 2) {
           text_sueldo.setText(String.valueOf(campanera.sueldo));
        } else if (N == 3) {
           text_sueldo.setText(String.valueOf(tenidora.sueldo));
        } else if (N == 4) {
            text_sueldo.setText(String.valueOf(planchadora.sueldo));
        }

        JTextField text_valor_mano_obra_dia = new JTextField();
        text_valor_mano_obra_dia.setBounds(165, 59, 80, 18);
        if (N == 1) {
           text_valor_mano_obra_dia.setText(String.valueOf(rollera.valor_mano_obra_dia));
        } else if (N == 2) {
           text_valor_mano_obra_dia.setText(String.valueOf(campanera.valor_mano_obra_dia));
        } else if (N == 3) {
           text_valor_mano_obra_dia.setText(String.valueOf(tenidora.valor_mano_obra_dia));
        } else if (N == 4) {
            text_valor_mano_obra_dia.setText(String.valueOf(planchadora.valor_mano_obra_dia));
        }
        
        JTextField text_valor_maquina_hora = new JTextField();
        text_valor_maquina_hora.setBounds(165, 77, 80, 18);
        if (N == 1) {
           text_valor_maquina_hora.setText(String.valueOf(rollera.valor_maquina_hora));
        } else if (N == 2) {
           text_valor_maquina_hora.setText(String.valueOf(campanera.valor_maquina_hora));
        } else if (N == 3) {
           text_valor_maquina_hora.setText(String.valueOf(tenidora.valor_maquina_hora));
        } else if (N == 4) {
            text_valor_maquina_hora.setText(String.valueOf(planchadora.valor_maquina_hora));
        }

        JTextField text_porcentaje_opt = new JTextField();
        text_porcentaje_opt.setBounds(250, 100, 80, 18);
        
        DecimalFormat formato1 = new DecimalFormat("#.00");
        if (N == 1) {
            text_porcentaje_opt.setText(String.valueOf(formato1.format(rollera.porcentaje_opt*100)+" %"));
        } else if (N == 2) {
           text_porcentaje_opt.setText(String.valueOf(formato1.format(campanera.porcentaje_opt*100)+" %"));
        } else if (N == 3) {
           text_porcentaje_opt.setText(String.valueOf(formato1.format(tenidora.porcentaje_opt*100)+" %"));
        } else if (N == 4) {        
            text_porcentaje_opt.setText(String.valueOf(formato1.format(planchadora.porcentaje_opt*100)+" %"));
        }

        JTextField text_valor_maquina_dia = new JTextField();
        text_valor_maquina_dia.setBounds(410, 5, 80, 18);
        if (N == 1) {
           text_valor_maquina_dia.setText(String.valueOf(rollera.valor_maquina_dia));
        } else if (N == 2) {
           text_valor_maquina_dia.setText(String.valueOf(campanera.valor_maquina_dia));
        } else if (N == 3) {
           text_valor_maquina_dia.setText(String.valueOf(tenidora.valor_maquina_dia));
        } else if (N == 4) {
            text_valor_maquina_dia.setText(String.valueOf(planchadora.valor_maquina_dia));
        }
        
        JTextField text_costo_proceso_dia = new JTextField();
        text_costo_proceso_dia.setBounds(410, 23, 80, 18);
        if (N == 1) {
           text_costo_proceso_dia.setText(String.valueOf(rollera.costo_proceso_dia));
        } else if (N == 2) {
           text_costo_proceso_dia.setText(String.valueOf(campanera.costo_proceso_dia));
        } else if (N == 3) {
           text_costo_proceso_dia.setText(String.valueOf(tenidora.costo_proceso_dia));
        } else if (N == 4) {
            text_costo_proceso_dia.setText(String.valueOf(planchadora.costo_proceso_dia));
        }
        
        JTextField text_costo_proceso_mes = new JTextField();
        text_costo_proceso_mes.setBounds(410, 41, 80, 18);
        if (N == 1) {
           text_costo_proceso_mes.setText(String.valueOf(rollera.costo_proceso_mes));
        } else if (N == 2) {
           text_costo_proceso_mes.setText(String.valueOf(campanera.costo_proceso_mes));
        } else if (N == 3) {
           text_costo_proceso_mes.setText(String.valueOf(tenidora.costo_proceso_mes));
        } else if (N == 4) {
            text_costo_proceso_mes.setText(String.valueOf(planchadora.costo_proceso_mes));
        }

        JTextField text_productos_dia = new JTextField();
        text_productos_dia.setBounds(410, 59, 80, 18);
        if (N == 1) {
            text_productos_dia.setText(String.valueOf(rollera.rollos_dia));
        } else if (N == 2) {
            text_productos_dia.setText(String.valueOf(campanera.campanas_dia));
        } else if (N == 3) {
            text_productos_dia.setText(String.valueOf(tenidora.campanas_dia));
        } else if (N == 4) {
            text_productos_dia.setText(String.valueOf((int)planchadora.campanas_dia));
        }
        

        JTextField text_produccion_mensual = new JTextField();
        text_produccion_mensual.setBounds(410, 77, 80, 18);
        if (N == 1) {
            text_produccion_mensual.setText(String.valueOf(rollera.produccion_mensual));
        } else if (N == 2) {
            text_produccion_mensual.setText(String.valueOf(campanera.produccion_mensual));
        } else if (N == 3) {
            text_produccion_mensual.setText(String.valueOf(tenidora.produccion_mensual));
        } else if (N == 4) {
            text_produccion_mensual.setText(String.valueOf(planchadora.produccion_mensual));
        }
        
        /* Agregando los componentes JLabel al panel */
        panel.add(num_dias_laborados);    panel.add(num_horas_laboradas);  panel.add(valor_maquina_dia);
        panel.add(sueldo);                panel.add(valor_mano_obra_dia);  panel.add(valor_maquina_hora);
        panel.add(costo_proceso_dia);     panel.add(productos_dia);        panel.add(costo_proceso_mes);
        panel.add(produccion_mensual);    panel.add(porcentaje_opt);

        /* Agregando los componentes JTextField al panel */
        panel.add(text_num_dias_laborados);     panel.add(text_num_horas_laboradas);  panel.add(text_valor_maquina_hora);
        panel.add(text_sueldo);                 panel.add(text_valor_mano_obra_dia);  panel.add(text_costo_proceso_dia);
        panel.add(text_valor_maquina_dia);      panel.add(text_productos_dia);        panel.add(text_costo_proceso_mes);
        panel.add(text_produccion_mensual);     panel.add(text_porcentaje_opt);
    }

}
