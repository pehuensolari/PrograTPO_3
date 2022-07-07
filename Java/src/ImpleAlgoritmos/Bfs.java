package ImpleAlgoritmos;

import clases.Arista;
import clases.GrafoNoDirigido;
import java.util.*;

public class Bfs {

    public void iniciar(GrafoNoDirigido<Integer> grafo, Integer nodoInicial) {

        Queue<Integer> cola = new LinkedList<>();
        cola.offer(nodoInicial);

        Map<Integer, String> estadoVertices = new HashMap<>();
        List<Arista> arbol = new ArrayList<>();
        arbol.add(new Arista(null, nodoInicial));

        while (!cola.isEmpty()) {
            Integer verticePadre = cola.peek();
            List<Integer> adyacentes = grafo.obtenerAdyacentes(verticePadre);
            for (Integer adyacente : adyacentes) {
                if (estadoVertices.get(adyacente) == null || "BLANCO".equals(estadoVertices.get(adyacente))) {
                    estadoVertices.put(adyacente, "GRIS");
                    arbol.add(new Arista(verticePadre, adyacente));
                    cola.offer(adyacente);
                }
            }
            cola.poll();
            estadoVertices.put(verticePadre, "NEGRO");
        }
        imprimirGrafo(arbol);
    }

    private void imprimirGrafo(List<Arista> arbol){
        for (int i =0; i <= arbol.size()-1; i++){
                System.out.print("Nodo: ");
                System.out.print(arbol.get(i).getHijo());
                System.out.print(" , ");
        }
    }

}