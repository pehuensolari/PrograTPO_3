package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrafoDirigido<T> implements Grafo<T> {

    List<Arco<T>> arcos = new ArrayList<Arco<T>>();
    List<Integer> vertices = new ArrayList<Integer>();

    public GrafoDirigido(List<Arco<T>> arcos, List<Integer> vertices) {
        this.arcos = arcos;
        this.vertices = vertices;
    }

    @Override
    public void agregarVertice(int verticeId) {
        this.vertices.add(verticeId);

    }

    @Override
    public void borrarVertice(int verticeId) {
        this.vertices.remove(verticeId);

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));

    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        this.arcos = this.arcos.stream().filter(
                a -> a.getVerticeOrigen() != verticeId1 && a.getVerticeDestino() != verticeId2)
                .collect(Collectors.toList());
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.contains(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return this.arcos.stream().anyMatch(
                a -> a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        return this.arcos.stream().filter(
                a -> a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2).findFirst().get();
    }

    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        return this.arcos.size();
    }

    @Override
    public List<Integer> obtenerVertices() {
        return this.vertices;
    }

    @Override
    public List<Integer> obtenerAdyacentes(int verticeId) {
        return this.arcos.stream().filter(
                a -> a.getVerticeOrigen() == verticeId)
                .map(a-> a.getVerticeDestino())
                .collect(Collectors.toList());
    }

    @Override
    public List<Arco<T>> obtenerArcos() {
        return this.arcos;
    }

    @Override
    public List<Arco<T>> obtenerArcos(int verticeId) {
        return this.arcos.stream().filter(
                a -> a.getVerticeOrigen() == verticeId).collect(Collectors.toList());
    }

}