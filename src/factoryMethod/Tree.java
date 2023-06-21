package factoryMethod;

import composite.Vertex;
import singleton.PruferCode;

import java.util.*;

public class Tree implements Product{
    private final List<Vertex> tree;
    private boolean isSemiEuler;
    private List<Vertex> eulerCycleOrPath = null;
    private final PruferCode pruferCode;

    public Tree(List<Vertex> tree){
        Comparator<Vertex> vertexLabelSorter = Comparator.comparing(Vertex::getVertexLabel);
        this.tree = tree;
        this.tree.sort(vertexLabelSorter);
        pruferCode = PruferCode.getInstance(this);
    }
    public List<Vertex> getProduct(){
        return tree;
    }
    public String show(){
        return "Tree";
    }

    public List<Integer> getPruferCode() {
        return pruferCode.getPruferCode();
    }

    @Override
    public void setSemiEulerButNotEuler(boolean semiEulerButNotEuler) {
        isSemiEuler = semiEulerButNotEuler;
    }
    @Override
    public boolean isSemiEulerButNotEuler() {
        return isSemiEuler;
    }

    public void setEulerCycleOrPath(List<Vertex> eulerCycleOrPath) {
        this.eulerCycleOrPath = eulerCycleOrPath;
    }
    public List<Vertex> getEulerCycleOrPath() {
        return eulerCycleOrPath;
    }
}
