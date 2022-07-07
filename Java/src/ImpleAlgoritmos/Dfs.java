package ImpleAlgoritmos;


import clases.Arista;
import clases.GrafoNoDirigido;
import java.util.*;

public class Dfs {
    Set<Integer> arbol = new HashSet<>();
    public void iniciar(GrafoNoDirigido<Integer> grafo, Integer nodoInicial) {

        Queue<Integer> cola = new LinkedList<>();
        //cola.offer(nodoInicial);

        Map<Integer, String> estadoVertices = new HashMap<>();
        //Set<Integer> arbol = new HashSet<>();
        //List<Integer> arbol = new ArrayList<>();
        arbol.add(nodoInicial);

        //while (!cola.isEmpty()) {
            //Integer verticePadre = cola.peek();
            Integer verticePadre = nodoInicial;
            estadoVertices.put(verticePadre, "GRIS");
            List<Integer> adyacentes = grafo.obtenerAdyacentes(verticePadre);
            for (Integer adyacente : adyacentes) {
                if (estadoVertices.get(adyacente) == null || "BLANCO".equals(estadoVertices.get(adyacente))) {
                    arbol.add(adyacente);
                    this.iniciar(grafo,adyacente);
                    //cola.offer(adyacente);
                }
            }
            //cola.poll();
            estadoVertices.put(verticePadre, "NEGRO");
        //}
        //imprimirGrafo(arbol);
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