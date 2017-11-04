/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkgfinal;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Acueducto 
{

    public Acueducto() 
    {
    }
    
    
    
    public String infoTanque(ArrayList<Tanque> tanque, String id)
    {
        String mensaje="";
        
        for(Tanque i:tanque)
        {
            if (id.equals(i.getIde())) 
            {
                mensaje=i.toString();
                
            }
        
        }
        
        
        return mensaje;    
    }
    
    public String infoRegion(ArrayList<Region> region, String id)
    {
        String mensaje="";
        
        for(Region i:region)
        {
            if (id.equals(i.getIdentificacion())) 
            {
                mensaje=i.toString();
                
            }
        
        }
        
        
        return mensaje;    
    }
    
    
    public void simulacion(ArrayList<Region> region,ArrayList<Tanque> tanque,ArrayList<Registro> registro, int dia)
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
                    t.setOcupado(true);
                    
                    //sacamos la necesidad de la region y la multiplicamos por un Rnd para simular
                    necesidad=r.getNecesidad()*(Math.random() * 3) + 1; 
                    
                    //sacamos el agua que hay actualmente y lo convertimos a litros
                    agua=t.getVolumen()*t.getPorcentaje()*1000;
                    
                    //sacamos los litros que quedan luego de sacar los necesitados por la region
                    resultado=agua-necesidad;
                    
                    //sacamos el nuevo porcentaje de agua
                    porcentajeFinal=(resultado*t.getPorcentaje())/agua;
                    
                    //actualizamos el porcentaje del tanque
                    t.setPorcentaje(porcentajeFinal);
                    
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
                
                
                
                
                
                
            }//fin t
            
        
        }//fin r
        
        Lab5 l=new Lab5();
        l.regionL=region;
        l.tanqueL=tanque;
        l.registroL=registro;
        
        
        
    
    
    
    }
    
    
    
}
