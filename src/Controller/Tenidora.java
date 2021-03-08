/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.ImageIcon;

public class Tenidora {

    int tiempo_prestablecido = 60;
    int num_campanas_proceso_establecido = 260;
    double costo_proceso_mes_establecido = 440;

    //  Atributos constantes
    int dias_laborales = 22;  // dias
    double horas_laborales = 120; // minutos   
    double sueldo = 1000;
    ImageIcon icon_message = new ImageIcon(getClass().getResource("/Images/Logo.jpg"));
    String[] options = {"Aceptar", "Cancelar"};

    // Atributos determinantes
    double valor_mano_obra_dia, valor_maquina_hora, valor_maquina_dia, costo_proceso_dia;
    double costo_proceso_mes, campanas_dia, produccion_mensual, porcentaje_opt;

    // Atributos parametricos
    int tiempo_proceso;              // minutos
    int num_campanas_proceso;

    // Constructor de la clase
    public Tenidora(int tiempo_proceso, int num_campanas_proceso) {

        this.num_campanas_proceso = this.num_campanas_proceso;
        this.tiempo_proceso = tiempo_proceso;

        // Calculando variables a analizar
        campanas_dia = (horas_laborales / tiempo_proceso) * num_campanas_proceso;
        
        produccion_mensual = dias_laborales * campanas_dia;
        BigDecimal bd = new BigDecimal(produccion_mensual).setScale(2, RoundingMode.HALF_UP);
        produccion_mensual = bd.doubleValue();

        valor_mano_obra_dia = sueldo / dias_laborales;
        bd = new BigDecimal(valor_mano_obra_dia).setScale(2, RoundingMode.HALF_UP);
        valor_mano_obra_dia = bd.doubleValue();

        valor_maquina_hora = (double) (1000 / 8.56) / campanas_dia;
        bd = new BigDecimal(valor_maquina_hora).setScale(2, RoundingMode.HALF_UP);
        valor_maquina_hora = bd.doubleValue();

        valor_maquina_dia = valor_maquina_hora * (horas_laborales / 60);
        bd = new BigDecimal(valor_maquina_dia).setScale(2, RoundingMode.HALF_UP);
        valor_maquina_dia = bd.doubleValue();

        costo_proceso_dia = valor_mano_obra_dia * valor_maquina_dia;
        bd = new BigDecimal(costo_proceso_dia).setScale(2, RoundingMode.HALF_UP);
        costo_proceso_dia = bd.doubleValue();

        costo_proceso_mes = costo_proceso_dia * dias_laborales;
        bd = new BigDecimal(costo_proceso_mes).setScale(2, RoundingMode.HALF_UP);
        costo_proceso_mes = bd.doubleValue();
        
        porcentaje_opt = (costo_proceso_mes_establecido-costo_proceso_mes)/costo_proceso_mes;
        bd = new BigDecimal(porcentaje_opt).setScale(4, RoundingMode.HALF_UP);
        porcentaje_opt = bd.doubleValue();
    }

    public void Optimizar_Tenidora() {
        Ventana_Optimizar_Tenidora ventana = new Ventana_Optimizar_Tenidora(this);
    }
}
