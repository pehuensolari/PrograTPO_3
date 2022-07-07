package ImpleAlgoritmos;

import clases.Arista;
import clases.GrafoNoDirigido;
import java.util.*;

public class Bfs {
    /*
    Breadth-first search: Dado un nodo inicial, se recorren sus adyacentes. Una vez hecho,
    se avanza desde el último nodo visitado a sus siguientes adyacentes hasta recorrer todo
    el grafo. (Búsqueda a lo ancho)
     */
    public void iniciar(GrafoNoDirigido<Integer> grafo, Integer nodoInicial) {

        Queue<Integer> cola = new LinkedList<>();
        cola.offer(nodoInicial);//Encolo el primer nodo
        Map<Integer, String> estadoVertices = new HashMap<>();
        List<Arista> conjuntoResultado = new ArrayList<>();
        conjuntoResultado.add(new Arista(null, nodoInicial));
        while (!cola.isEmpty()) {
            Integer verticePadre = cola.peek();//Traigo el primero
            List<Integer> adyacentes = grafo.obtenerAdyacentes(verticePadre);
            for (Integer adyacente : adyacentes) {
                if (estadoVertices.get(adyacente) == null || "BLANCO".equals(estadoVertices.get(adyacente))) {
                    estadoVertices.put(adyacente, "GRIS");
                    conjuntoResultado.add(new Arista(verticePadre, adyacente));
                    cola.offer(adyacente);//Voy agregando los nodos adyacentes a la cola
                }
            }
            cola.poll();//Elimino el nodo recorrido
            estadoVertices.put(verticePadre, "NEGRO");
        }
        imprimirGrafo(conjuntoResultado);
    }

    private void imprimirGrafo(List<Arista> arbol){
        for (int i =0; i <= arbol.size()-1; i++){
                System.out.print("Nodo: ");
                System.out.print(arbol.get(i).getHijo());
                System.out.print(" , ");
        }
    }

}