package ImpleAlgoritmos;

import clases.Arco;
import clases.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        //Grafo BFS//
        //Arcos del grafo
        List<Arco> arcos = new ArrayList<>();
        arcos.add(new Arco(1,2,0));
        arcos.add(new Arco(2,3,0));
        arcos.add(new Arco(3,5,0));
        arcos.add(new Arco(1,4,0));
        //Vertices del grafo
        List<Integer> vertices = new ArrayList<>();
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);
        vertices.add(5);
        //Armo el grafo
        GrafoNoDirigido grafoBfs = new GrafoNoDirigido(arcos,vertices);

        //Grafo DFS//
        //Arcos del grafo
        List<Arco> arcosDfs = new ArrayList<>();
        arcosDfs.add(new Arco(1,2,0));
        arcosDfs.add(new Arco(2,3,0));
        arcosDfs.add(new Arco(3,4,0));
        arcosDfs.add(new Arco(1,5,0));
        arcosDfs.add(new Arco(5,6,0));
        //Vertices del grafo
        List<Integer> verticesDfs = new ArrayList<>();
        verticesDfs.add(1);
        verticesDfs.add(2);
        verticesDfs.add(3);
        verticesDfs.add(4);
        verticesDfs.add(5);
        verticesDfs.add(6);
        //Armo el grafo
        GrafoNoDirigido grafoDfs = new GrafoNoDirigido(arcosDfs,verticesDfs);

        //**********************//
        //**Breadth-first search**//
        Bfs algoritmoBFS = new Bfs();
        int nodoInicial = 1;
        System.out.println("***Algoritmo BFS***");
        System.out.println("Nodo inicial --> " + nodoInicial);
        System.out.print("Nodos del grafo: ");
        algoritmoBFS.iniciar(grafoBfs,nodoInicial);


        //**********************//
        //**Depth-first search**//
        Dfs algoritmoDFS = new Dfs();
        int nodoInicialDfs = 1;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("***Algoritmo DFS***");
        System.out.println("Nodo inicial --> " + nodoInicialDfs);
        System.out.print("Nodos del grafo:" );
        algoritmoDFS.iniciar(grafoDfs,nodoInicialDfs);
        algoritmoDFS.imprimirGrafoDfs();
    }
}
