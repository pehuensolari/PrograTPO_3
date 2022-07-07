package ImpleAlgoritmos;


import clases.GrafoNoDirigido;
import java.util.*;

public class Dfs {
    /*
    Depth-first search: Dado un nodo inicial, se recorre de manera recursiva
    para obtener sus adyacentes y de esa manera devolver el total de nodos alcanzables
    (búsqueda en profundidad)
     */

    //Uso un conjunto para almacenar los nodos encontrados
    Set<Integer> conjuntoResultado = new HashSet<>();
    public void iniciar(GrafoNoDirigido<Integer> grafo, Integer nodoInicial) {

        Map<Integer,String> estadoVertices = new HashMap<>();
        conjuntoResultado.add(nodoInicial);
        estadoVertices.put(nodoInicial, "GRIS");
        List<Integer> adyacentes = grafo.obtenerAdyacentes(nodoInicial);
        for (Integer adyacente : adyacentes) {
            if (estadoVertices.get(adyacente) == null || "BLANCO".equals(estadoVertices.get(adyacente))) {
                conjuntoResultado.add(adyacente);
                this.iniciar(grafo,adyacente);
            }
        }
        estadoVertices.put(nodoInicial, "NEGRO");//Nodo ya recorrido junto con sus adyacentes
    }

    public void imprimirGrafoDfs() {
        Iterator itr = conjuntoResultado.iterator();
        while (itr.hasNext()) {
            System.out.print("Nodo: ");
            System.out.print(itr.next());
            System.out.print(" , ");
        }

    }

}