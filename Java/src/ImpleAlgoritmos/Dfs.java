package ImpleAlgoritmos;


import clases.Arista;
import clases.GrafoNoDirigido;
import java.util.*;

public class Dfs {

    //Uso un conjunto para almacenar los nodos encontrados
    Set<Integer> arbol = new HashSet<>();
    public void iniciar(GrafoNoDirigido<Integer> grafo, Integer nodoInicial) {

        Queue<Integer> cola = new LinkedList<>();
        Map<Integer, String> estadoVertices = new HashMap<>();
        arbol.add(nodoInicial);
        Integer verticePadre = nodoInicial;
        estadoVertices.put(verticePadre, "GRIS");
        List<Integer> adyacentes = grafo.obtenerAdyacentes(verticePadre);
        for (Integer adyacente : adyacentes) {
            if (estadoVertices.get(adyacente) == null || "BLANCO".equals(estadoVertices.get(adyacente))) {
                arbol.add(adyacente);
                this.iniciar(grafo,adyacente);
            }
        }
        estadoVertices.put(verticePadre, "NEGRO");
    }

    public void imprimirGrafoDfs() {
        Iterator itr = arbol.iterator();
        while (itr.hasNext()) {
            System.out.print("Nodo: ");
            System.out.print(itr.next());
            System.out.print(" , ");
        }

    }

}