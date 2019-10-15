/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad2_simulacion;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ARCHIVO_S {

    public ARCHIVO_S() {
    }
    
    private Integer prueba;

    public ARCHIVO_S(Integer prueba) {
        this.prueba = prueba;

    }

    float datos[] = new float[35];

    public void leerTxt(String direccion, double prueba) { //direccion del archivo

        try {
            File archivo = new File(direccion);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            for (int i = 0; i <= 35; i++) {
                datos[i] = Float.parseFloat(br.readLine());
            }

            fr.close();

        } catch (Exception e) {
            System.err.println("");
        }

        //return matrix;
        final double confianza = (prueba);
        double alfa = 1 - confianza;

        ArrayList<Integer> bits = new ArrayList<>();
        int i, corridas, dato;
        double media, varianza, z;
        //Revisa si cada dato actual es menor al dato anterior. 
        //Si es así, se guarda un 0, de lo contrario, se guarda un 1
        for (i = 1; i < datos.length; i++) {
            if (datos[i] <= datos[i - 1]) {
                bits.add(0);
            } else {
                bits.add(1);
            }
        }

        //Contamos las corridas. 
        corridas = 1;
        //Comenzamos observando el primer dígito
        dato = bits.get(0);
        //Comparamos cada dígito con el observado, cuando cambia es 
        //una nueva corrida
        for (i = 1; i < bits.size(); i++) {
            if (bits.get(i) != dato) {
                corridas++;
                dato = bits.get(i);
            }
        }

        String corrd = String.valueOf(corridas);
media = (2 * datos.length - 1) / (double) 3;
        varianza = (16 * datos.length - 29) / (double) 90;

        z = Math.abs((corridas - media) / Math.sqrt(varianza));
        double zn = (1 - (alfa / 2));
        String mdia = String.valueOf(media);
        String varian = String.valueOf(varianza);

        //Comparamos: si es mayor mi valor Z al de la tabla, no pasa
        String respuesta;
        if(z < zn){
            respuesta = "No se puede rechazar la hipotesis de independencia. ";

        }else{
            respuesta = "No Pasa la prueba de corridas";

        }
        //return corridas;

        JOptionPane.showMessageDialog(null, "Corridas Obtenidas: " + bits + " \n Total Corridas: " + corridas + "\n Media: " + media + "\nVarianza = " + varianza + "\nConclusion: " + respuesta);

        
    }
    
}
