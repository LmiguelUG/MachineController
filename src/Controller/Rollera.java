package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Rollera {
    
    //Atributos constantes
    int tiempo_prestablecido = 10;
    int num_rollos_proceso_establecido = 1;
    double costo_proceso_mes_establecido = 1343.10;
    int dias_laborales = 22;      // dias
    double horas_laborales = 520; // minutos   
    double sueldo = 1000;
    ImageIcon icon_message = new ImageIcon(getClass().getResource("/Images/Logo.jpg"));
    String[] options = {"Aceptar", "Cancelar"};
    
    // Atributos determinantes
    double valor_mano_obra_dia, valor_maquina_hora, valor_maquina_dia, porcentaje_opt;
    double costo_proceso_dia, costo_proceso_mes, rollos_dia, produccion_mensual;
    
    // Atributos parametricos
    int tiempo_proceso;     // minutos
    int num_rollos_proceso;

    
    // Constructor de la clase
    public Rollera(int tiempo_proceso, int num_rollos_proceso) {

        this.num_rollos_proceso = num_rollos_proceso;
        this.tiempo_proceso = tiempo_proceso;

        // Calculando las variables que son de analisis
        rollos_dia = (horas_laborales / tiempo_proceso) * num_rollos_proceso;

        produccion_mensual = dias_laborales * rollos_dia;
        BigDecimal bd = new BigDecimal(produccion_mensual).setScale(2, RoundingMode.HALF_UP);
        produccion_mensual = bd.doubleValue();

        valor_mano_obra_dia = sueldo / dias_laborales;
        bd = new BigDecimal(valor_mano_obra_dia).setScale(2, RoundingMode.HALF_UP);
        valor_mano_obra_dia = bd.doubleValue();

        valor_maquina_hora = (800 / 8.56) / rollos_dia;
        bd = new BigDecimal(valor_maquina_hora).setScale(2, RoundingMode.HALF_UP);
        valor_maquina_hora = bd.doubleValue();

        valor_maquina_dia = valor_maquina_hora * (horas_laborales / 60);
        bd = new BigDecimal(valor_maquina_dia).setScale(2, RoundingMode.HALF_UP);
        valor_maquina_dia = bd.doubleValue();

        costo_proceso_dia = valor_mano_obra_dia + valor_maquina_dia;
        bd = new BigDecimal(costo_proceso_dia).setScale(2, RoundingMode.HALF_UP);
        costo_proceso_dia = bd.doubleValue();

        costo_proceso_mes = costo_proceso_dia * dias_laborales;
        bd = new BigDecimal(costo_proceso_mes).setScale(2, RoundingMode.HALF_UP);
        costo_proceso_mes = bd.doubleValue();
        
        porcentaje_opt = (costo_proceso_mes_establecido-costo_proceso_mes)/costo_proceso_mes;
        bd = new BigDecimal(porcentaje_opt).setScale(4, RoundingMode.HALF_UP);
        porcentaje_opt = bd.doubleValue();

    }
    
    // Llamada de la Ventana_Optimizar_Rollera 
    public void Optimizar_Rollera() {
        Ventana_Optimizar_Rollera ventana = new Ventana_Optimizar_Rollera(this);
    }
}
