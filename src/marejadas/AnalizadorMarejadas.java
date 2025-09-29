package marejadas;
import java.util.*;

/**
 *
 * @author Duoc
 */
public class AnalizadorMarejadas {
    private List<DatoOceano> datos;
    
    public AnalizadorMarejadas(List<Dato> lista){
        this.datos = new ArrayList<>();
        for(Dato d: lista){
            if(d instanceof DatoOceano){
                this.datos.add((DatoOceano) d);
        }
        }
        
    }
    public void olaMasAlta(){
        if(datos.isEmpty()) return;
        
        DatoOceano max = datos.get(0);
        for(DatoOceano d : datos){
            if(d.getHm0() > max.getHm0()){
                max = d;
            }
                
                }
        System.out.println("\nOla mas alta registrada");
        max.mostrar();
    }
}
