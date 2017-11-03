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
        
    }
    
    
    
    
}
