package clases;

import java.util.List;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

    public GrafoNoDirigido(List<Arco<T>> arcos, List<Integer> vertices) {
        super(arcos, vertices);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        //Se agrega la arista de un lado a otro por ser no dirigido
        super.agregarArco(verticeId1, verticeId2, etiqueta);
        super.agregarArco(verticeId2, verticeId1, etiqueta);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

}
