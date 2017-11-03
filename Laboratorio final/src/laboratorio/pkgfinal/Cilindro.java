
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
public class Cilindro extends Tanque
{
    //Atributos 
    protected double radio;
    protected double altura;

    public Cilindro(double radio, double altura, String identificacion, double porcentaje, int valvUso, double volumen, boolean enUso) {
        super(identificacion, porcentaje, valvUso, volumen, enUso);
        this.radio = radio;
        this.altura = altura;
    }
    
    public void volumen()
    {
        volumen=Math.PI*(radio*radio)*altura;
    }
    
    
    
    
}
