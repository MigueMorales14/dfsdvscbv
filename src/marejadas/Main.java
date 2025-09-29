package marejadas;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Main {
    public static void main(String[] args){
        /*LectorArchivo lector = new LectorArchivo();
        List<Dato> datos = lector.leer("C:\\Users\\Duoc\\Downloads\\NodoIquique.txt");
        
        for(Dato d : datos){
            //d.mostrar();
        }*/
        //Consulta directa al sitio web
        try{
            String urlStr = "https://fundacion-instituto-profesional-duoc-uc.github.io/ATY1102-Surf/Nodo%2010%20(-37,-75)%20-%20Talcahuano.txt";
            var url = new URL(urlStr);
            File tempFile = File.createTempFile("NodoTalcahuano", ".txt");
            tempFile.deleteOnExit();
            try(InputStream in = url.openStream()){
                Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            
            LectorArchivo lector = new LectorArchivo();
            List<Dato> datos = lector.leer(tempFile.getAbsolutePath());
            for(Dato d : datos){
                d.mostrar();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
