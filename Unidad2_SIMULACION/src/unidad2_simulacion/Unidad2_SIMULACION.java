/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad2_simulacion;

import javax.swing.JOptionPane;


public class Unidad2_SIMULACION {

 public static void main(String[] args) {
        // TODO code application logic here
        
  
      ARCHIVO_S prueba = new ARCHIVO_S();
      
      
      double entero;
      
      entero = Double.parseDouble(JOptionPane.showInputDialog("Digite la prueba que desea en decimal ya sea .90, .95, o .99"));
      prueba.leerTxt("C:/Users/Hyundai/Desktop/ejercicios simulacion/ProyectU2/simulacionunidad2/archivo.txt", entero);
    }
    
}
