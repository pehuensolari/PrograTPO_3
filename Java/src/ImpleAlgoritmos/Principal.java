package ImpleAlgoritmos;

import clases.Arco;
import clases.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        //Arcos del grafo
        List<Arco> arcos = new ArrayList<>();
        arcos.add(new Arco(1,2,0));
        arcos.add(new Arco(2,3,0));
        arcos.add(new Arco(3,4,0));

        //Vertices del grafo
        List<Integer> vertices = new ArrayList<>();
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);

        //Armo el grafo
        GrafoNoDirigido grafo = new GrafoNoDirigido(arcos,vertices);

        //**********************//
        //**Breadth-first search**//
        Bfs algoritmoBFS = new Bfs();
        int nodoInicial = 1;
        System.out.println("***Algoritmo BFS***");
        System.out.println("Nodo inicial --> " + nodoInicial);
        System.out.println("Nodos del grafo:");
        algoritmoBFS.iniciar(grafo,nodoInicial);
    }
}
