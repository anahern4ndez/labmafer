/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkgfinal;

import java.util.Date;

/**
 *
 * @author Mafer
 */

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Region {
    //Atributos 
    private String munis[];
    private double prom[];
    private String identificacion;
    
    public Region(){}
    
    public Region(String identificacion, String m1, String m2, String m3, String m4, String m5, String m6, String m7, String m8, String m9, String m10, double p1, double p2, double p3, double p4, double p5, double p6, double p7, double p8, double p9, double p10){
        this.identificacion=identificacion;
        munis = new String[10];
        prom = new double[10];
        munis[0] = m1;
        munis[1] = m2;
        munis[2] = m3;
        munis[3] = m4;
        munis[4] = m5;
        munis[5] = m6;
        munis[6] = m7;
        munis[7] = m8;
        munis[8] = m9;
        munis[9] = m10;
        
        prom[0] = p1;
        prom[1] = p2;
        prom[2] = p3; 
        prom[3] = p4;
        prom[4] = p5;
        prom[5] = p6;
        prom[6] = p7;
        prom[7] = p8;
        prom[8] = p9;
        prom[9] = p10;
               
    }
    
    public double getNecesidad(){
        double suma =0;
        double promedio = 0;
        for(int i=0; i<prom.length; i++ ){
            suma = suma + prom[i];
            promedio = suma/10;
        }
        return promedio;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    
    public String toString()
    {
        String x="Nombre del municipio --- Promedio de Habitantes"+"\n";
        
        for (int i = 0; i < 10; i++) 
        {
            x+=munis[i]+" --- "+prom[i]+"\n";
            
        }
        
        
        return x;
    
    }

    
    
    
    
    
    
    
    
    
    
}
