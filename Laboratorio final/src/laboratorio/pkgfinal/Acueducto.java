/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkgfinal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Acueducto {
    private ArrayList<Tanque> tanques;
    private ArrayList<Region> region;
    private Conexion cc;

    public Acueducto(){
        tanques = new ArrayList<Tanque>();
        region = new ArrayList<Region>();
        cc = new Conexion();
    }
    
   public void addCilindro(Cilindro c){
       tanques.add(c);
   }
   
   public void addOrtogonal(Ortogonal c){
       tanques.add(c);
   }
   
   public void addCubo(Cubico c){
       tanques.add(c);
   }
   
   public ArrayList<Tanque> getList(){
       return tanques;
   }
   
   public void addRegion(Region r){
       region.add(r);
   }
   
   public ArrayList<Region> getRegion(){
       return region;
   }
   
   /**
    * metodo para verificar si el tanque que se desea crear ya existe o no
    * @param identificacion
    * @return 
    */
   public boolean repeticionTanques(String identificacion){
       List<Tanque> guardados = new ArrayList<Tanque>();
       guardados = cc.mostrarGuardados();
       Iterator<Tanque> it = guardados.iterator();
       while(it.hasNext()){
           Tanque tanque = it.next();
           if(tanque.getIde().equals(identificacion)){
               return false;
           }
       }
       return true;
   }
   
   /**
    * metodo para verificar si la region que se desea ingresar ya existe o no
    * @param identificacion
    * @return 
    */
   public boolean repeticionRegion(String identificacion){
       List<Region> todos = cc.mostrarRegiones();
       Iterator<Region> it = todos.iterator();
       while(it.hasNext()){
           Region region = it.next();
           if(region.getIdentificacion().equals(tanques)){
               return false;
           }
       }
       
       return true;
               
   }
   
  
   
   
    
    
    public String infoTanque(String id)
    {
        String mensaje="";
        List<Tanque> tanque = cc.mostrarGuardados();
        for(Tanque i:tanque)
        {
            if (id.equals(i.getIde())) 
            {
                mensaje=i.toString();
                
            }
        
        }
        
        
        return mensaje;  
    }
    
    public double volumenRegion(String id){
        double mensaje=0;
        List<Tanque> tanque = cc.mostrarGuardados();
        for(Tanque i:tanque)
        {
            if (id.equals(i.getIde())) 
            {
                mensaje= i.getVolumen();
                
            }
        
        }
        
        
        return mensaje; 
        
    }
    public String infoRegion(String id)
    {
        String mensaje="";
        List<Region> region = cc.mostrarRegiones();
        for(Region i:region)
        {
            if (id.equals(i.getIdentificacion())) 
            {
                mensaje=i.toString();
                
            }
        
        }
        
        
        return mensaje;    
    }
    
    
    public void simulacion(List<Region> region, List<Tanque> tanque,ArrayList<Registro> registro, int dia, String alerta)
    {
        double necesidad;
        double agua;
        double porcentajeFinal;
        double resultado;
        int valvulasactuales;
        int valvulasnuevas;
        
        for(Region r:region)
        {//inicio r
            
            for(Tanque t: tanque)
            {//inicio t
                
                    
                
                
                if (r.getIdentificacion().equals(t.getIde())) 
                {
                    if (t.porcentaje==100) 
                    {
                        t.setOcupado(true);
                        
                    }
                    
                    if (t.enUso) 
                    {//inicio en uso
                        
                    
                    
                    if ((t.porcentaje<25)) 
                    {
                        // si el porcentaje de agua es menor a 25%
                        alerta+="El tanque "+t.getIde()+" llego a menos del 25% de su capacidad "+"\n";
                        
                    }
                    
                    if ((t.porcentaje<10)&&(t.enUso==true)) 
                    {
                        alerta+="Se cerro automaticamente el tanque "+t.getIde()+"\n";
                        t.setOcupado(false);
                        System.out.println(t.getOcupado());
                        
                        break;                        
                    }
                    
                    
                    
                    t.setOcupado(true);
                    
                    //sacamos la necesidad de la region y la multiplicamos por un Rnd para simular
                    necesidad=r.getNecesidad()*(Math.random() * 3) + 1; 
                    
                    //sacamos el agua que hay actualmente y lo convertimos a litros
                    agua=t.getVolumen()*(t.getPorcentaje()/100)*1000;
                    
                    //sacamos los litros que quedan luego de sacar los necesitados por la region
                    resultado=agua-necesidad;
                    
                    //sacamos el nuevo porcentaje de agua
                    porcentajeFinal=(resultado*t.getPorcentaje())/agua;
                    
                    //actualizamos el porcentaje del tanque
                    t.setPorcentaje(porcentajeFinal);
                    System.out.println(porcentajeFinal);
                    //recojemos las valvulas que estan abiertas hasta el momento
                    valvulasactuales=t.getValvulas();
                    
                    //calculamos cuantas valvulas hay que abrir
                    //redondeamos el resultado y lo convertimos en int
                    valvulasnuevas=(int) Math.ceil((t.getPorcentaje()*10)/100);
                    
                    
                    //actualizamos las valvulas abiertas
                    t.setValvulas(valvulasnuevas);
                    
                    //comparamos si se abrieron o cerraron valvulas
                    if (valvulasnuevas<valvulasactuales) 
                    {
                        //entonces se cerraron valvulas
                        Registro reg=new Registro((valvulasactuales-valvulasnuevas), "dia "+dia, false, t.getIde());
                        registro.add(reg);
                        
                    }
                    
                }
                
                
                
                
                }//fin en uso
                
                
                
            }//fin t
            
        
        }//fin r
        
        
      
        
        
        
    
    
    
    }
    
    public void revisarIde(String ide){
        
    }
    
   }
