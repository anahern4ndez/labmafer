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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Maria Fernanda Lopez 17160
 * @author Jose Pablo Cifuentes 17509
 * @version 3/11/2017
 */
public class Conexion {
    private Datastore ds;
    
    
    public Conexion(){
        MongoClient mongo = new MongoClient();
        Morphia morphia = new Morphia();
        morphia.map(Tanque.class).map(Registro.class).map(Region.class).map(Cilindro.class).map(Ortogonal.class).map(Cubico.class);
        ds = morphia.createDatastore(mongo, "Acueducto"); // Base Datos
    }   
    
    public void addCilindro(Cilindro cili){
        ds.save(cili);
    }
    
    public void addOrtogonal(Ortogonal orto){
        
        ds.save(orto);
        
    }
    
    public void addCubo(Cubico cubo){
        
        ds.save(cubo);
       
    }
    
    public Cubico[] mostrarCubos(){
        Cubico[] arreglo = new Cubico[10];
        Query<Cubico> query = ds.createQuery(Cubico.class); // todos los hoteles
        
        List<Cubico> todos = query.asList();
        System.out.println("Todos los Hoteles");
        for (Cubico miHotel: todos){
            for(int i = 0; i<todos.size(); i++){
                arreglo[i] = todos.get(i);
            }
        }
        return arreglo;
    }
    
    public Cilindro[] mostrarCilindro(){
        Cilindro[] arreglo = new Cilindro[10];
        Query<Cilindro> query = ds.createQuery(Cilindro.class); // todos los hoteles
        
        List<Cilindro> redondos = query.asList();
        System.out.println("Todos los Hoteles");
        for (Cilindro miHotel: redondos){
            for(int i = 0; i<redondos.size(); i++){
                arreglo[i] = redondos.get(i);
            }
        }
        return arreglo;
    }
    
    public Ortogonal[] mostrarOrto(){
        Ortogonal[] arreglo = new Ortogonal[10];
        Query<Ortogonal> query = ds.createQuery(Ortogonal.class); // todos los hoteles
        
        List<Ortogonal> ortos = query.asList();
        System.out.println("Todos los Hoteles");
        for (Ortogonal miHotel: ortos){
            for(int i = 0; i<ortos.size(); i++){
                arreglo[i] = ortos.get(i);
            }
        }
        return arreglo;
    }
    
    
    
}
