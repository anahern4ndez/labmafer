
package laboratorio.pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.mongodb.morphia.annotations.Embedded;


@Embedded
public class Registro 
{
    //Atributos 
    private int valvulas;// cuantas valvulas se abrieron o cerraron 
    private String fecha;
    private boolean abierto; //si es true se abrieron valvulas
    private String tanque;
     
    
    //private Date myDate = new Date();
    //String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
    public Registro(){}
    
    /**
     * Constructor for objects of class Registro
     * @param valvulas
     * @param fecha
     * @param abierto
     * @param tanque 
     */
    public Registro(int valvulas, String fecha, boolean abierto, String tanque) {
        this.valvulas = valvulas;
        this.fecha = fecha;
        this.abierto = abierto;
        this.tanque = tanque;
    }

    
    
    
    public String getDescripcion()
    {
        String x="";
        if (abierto) 
        {// sea brieron x valvulas
            x="Se abrieron "+valvulas+" del tanque "+tanque+" el "+fecha;
            
            
        }
        if(abierto==false)
        {
            x="Se cerraron "+valvulas+" valvula del tanque "+tanque+" el "+fecha;
        }
        
        
        
        
        
        return x;
        
    }
    
}
