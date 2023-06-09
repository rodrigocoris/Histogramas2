
package histograma;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import javax.swing.JPanel;


public class forkjoin extends RecursiveAction{
    
     private int[][] histograma;
    private JPanel rojo, verde, azul, alfa, gris;
    private int izq, der;
    
    
    
    public forkjoin(int[][] histograma, JPanel rojo, JPanel verde, JPanel azul, JPanel alfa, JPanel gris) {
        this.histograma = histograma;
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
        this.alfa = alfa;
        this.gris = gris;
        this.izq = 0;
        this.der = histograma.length;
        
    }
    
     
    @Override
    
    protected void compute(){
        if (der < 3) {
            ForkJoinTask.invokeAll(forkRodri());
        } else {
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
    
    private ArrayList<forkjoin> forkRodri() {
        ArrayList<forkjoin> proceso = new ArrayList<>();
        int mid = (der - izq) / 2;
        int[][] matriz1 = Arrays.copyOfRange(histograma, izq, mid);
        int[][] matriz2 = Arrays.copyOfRange(histograma, mid+1, der);
        proceso.add(new forkjoin(matriz1, rojo, verde, azul, alfa, gris));
        proceso.add(new forkjoin(matriz2, rojo, verde, azul, alfa, gris));
        return proceso;
    }
}
