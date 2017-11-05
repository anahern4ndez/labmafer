package laboratorio.pkgfinal;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author jose
 */
@Entity
public class Ortogonal extends Tanque
{
     //Atributos 
    private double altura;
    private double ancho;
    private double largo;
    
    public Ortogonal(){}

    public Ortogonal(double altura, double ancho, double largo,String identificacion, double porcentaje, int valvUso, double volumen, boolean enUso) 
    {
        super(identificacion,porcentaje,valvUso,volumen,enUso);
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
    }
    
    public void volumen()
    {
        volumen=altura*ancho*largo;
    }
    
    
    
    
    
    
    
    
    
}
