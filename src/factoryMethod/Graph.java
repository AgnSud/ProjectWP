package factoryMethod;

import composite.Vertex;

import java.util.Comparator;
import java.util.List;

public class Graph implements Product{
    private final List<Vertex> graph;
    private boolean isEuler;
    private boolean isSemiEulerButNotEuler;
    private boolean isBipartite;
    private boolean isHamiltonian;
    private List<Vertex> hamiltonCycle = null;
    private List<Vertex> eulerCycleOrPath = null;
    private int chromaticNumber;

    public Graph(List<Vertex> graph){
        Comparator<Vertex> vertexLabelSorter = Comparator.comparing(Vertex::getVertexLabel);
        this.graph = graph;
        this.graph.sort(vertexLabelSorter);
        chromaticNumber = 0;
    }


    public boolean isBipartite() {
        return isBipartite;
    }
    public void setBipartite(boolean bipartite) {
        isBipartite = bipartite;
    }

    public int getChromaticNumber() {
        return chromaticNumber;
    }
    public void setChromaticNumber(int chromaticNumber) {
        this.chromaticNumber = chromaticNumber;
    }

    public void setEuler(boolean euler) {
        isEuler = euler;
    }
    public boolean isEuler() {
        return isEuler;
    }

    public void setSemiEulerButNotEuler(boolean semiEulerButNotEuler) {
        isSemiEulerButNotEuler = semiEulerButNotEuler;
    }
    public boolean isSemiEulerButNotEuler() {
        return isSemiEulerButNotEuler;
    }

    public void setEulerCycleOrPath(List<Vertex> eulerCycleOrPath) {
        this.eulerCycleOrPath = eulerCycleOrPath;
    }
    public List<Vertex> getEulerCycleOrPath() {
        return eulerCycleOrPath;
    }

    public boolean isHamiltonian() {
        return isHamiltonian;
    }
    public void setHamiltonian(boolean hamiltonian) {
        isHamiltonian = hamiltonian;
    }

    public List<Vertex> getHamiltonCycle() {
        return hamiltonCycle;
    }
    public void setHamiltonCycle(List<Vertex> hamiltonCycle) {
        this.hamiltonCycle = hamiltonCycle;
    }

    public List<Vertex> getProduct() {
        return graph;
    }

    public String show(){
        return "Graph";
    }
}
