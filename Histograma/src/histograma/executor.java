 
package histograma;

import static histograma.Formulario.jPanel_rojo;
import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

public class executor implements Runnable {
    private int[][] histograma;
    private JPanel rojo, verde, azul, alfa, gris;
    
    
     
    public executor(int[][] histograma, JPanel rojo, JPanel verde, JPanel azul, JPanel alfa, JPanel gris) {
        this.histograma = histograma;
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
        this.alfa = alfa;
        this.gris = gris;
        
    }
    
    
    public void run() {
        DibujarGrafico ObjDibujaHisto=new DibujarGrafico();
        for (int i = 0; i < 5; i++) {
                //extraemos un canal del histograma 
                int[] histogramaCanal=new int[256];
                System.arraycopy(histograma[i], 0, histogramaCanal, 0, histograma[i].length);
                //Dibujamos en el panel
                
                switch(i){
                    case 0:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, rojo, Color.red);
                        break;
                    case 1:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, verde, Color.green);
                        break;
                    case 2:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, azul, Color.blue);
                        break;
                    case 3:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, alfa, Color.black);
                        break;
                    case 4:
                        ObjDibujaHisto.crearHistograma(histogramaCanal, gris, Color.gray);
                        break;
                }
         
        }
   
 
    }
}
  