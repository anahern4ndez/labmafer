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
    MongoClient mongo = new MongoClient();
    Morphia morphia = new Morphia();
    morphia.map(Hotel.class).map(Address.class); // clases a guardar
    Datastore ds = morphia.createDatastore(mongo, "Acueducto"); // Base Datos
    
    
    
}