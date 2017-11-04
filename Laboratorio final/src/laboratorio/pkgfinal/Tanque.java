/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkgfinal;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;

/**
 * @author Jose Pablo Cifuentes 17509
 * @author Maria Fernanda Lopez 17160
 */

@Entity
public class Tanque {
    //Atributos 
    protected String identificacion;
    protected double porcentaje;
    protected int valvUso;
    protected double volumen;
    protected boolean enUso;
    //atributo que se tiene que crear al usar persistencia
    @Id protected ObjectId id;
    
    public Tanque (){}
    
    public Tanque (String identificacion, double porcentaje, int valvUso, double volumen, boolean enUso){
        this.identificacion=identificacion;
        this.porcentaje=porcentaje;
        this.valvUso=valvUso;
        this.volumen=volumen;
        this.enUso=enUso;
    }
    
    public void llenarTanque(){
        porcentaje = 100;
    }
    
    public void volumen(){
    
    }
    public double getPorcentaje()
    {
        return porcentaje;
    }
    
    public void setValvulas(int n){
        valvUso = n;
    }
    
    public int getValvulas(){
        return valvUso;
    }
    
    public void setPorcentaje(double n){
        porcentaje = n;
    }
    
    public void setOcupado(boolean x){
        enUso = x;
    }
    
    public boolean getOcupado(){
        return enUso;
    }
    
    public double getVolumen(){
        return volumen;
    }
    
    public String getIde(){
        return identificacion;
    }
    
    @Override
    public String toString()
    {
        String x;
        if (enUso==true) 
        {
            x="Estado: En uso";
            
            
        }
        else
        {
            x="Estado: Sin uso";
        }
        return "Identificacion tanque: "+identificacion +"\n" + " Volumen: "+volumen+"\n"+ " Valvulas abiertas: "+valvUso+"\n"+x
                +"\n"+"Porcentaje de agua: "+porcentaje+"%";
    }
    
    
    
    
}
