package clases;

public class Arista {

    public Arista(Integer padre, Integer hijo) {
        this.padre = padre;
        this.hijo = hijo;
    }

    public Integer getPadre() {
        return padre;
    }

    public Integer getHijo() {
        return hijo;
    }

    private Integer padre;
    private Integer hijo;

}