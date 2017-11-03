/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkgfinal;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import com.mongodb.MongoClient;
import java.util.List;

/**
 * @author Maria Fernanda Lopez 17160
 * @author Jose Pablo Cifuentes 17509
 * @version 3/11/2017
 */
public class Conexion {
    private Datastore ds;
    
    
    public void morphia(){
        MongoClient mongo = new MongoClient();
        Morphia morphia = new Morphia();
        morphia.map(Tanque.class).map(Registro.class).map(Region.class).map(Cilindro.class).map(Ortogonal.class).map(Cubico.class);
        ds = morphia.createDatastore(mongo, "Acueducto"); // Base Datos
    }   
    
    public void addCilindro(){
        Cilindro cilindro = new Cilindro(5, 10, "001", 100, 5, 201, true);
        ds.save(cilindro);
    }
    
    
}
