package singleton;

import composite.Vertex;
import factoryMethod.Tree;

import java.util.ArrayList;
import java.util.List;

public class PruferCode {
    public static PruferCode instance;
    private final List<Integer> pruferCode;
    private PruferCode(Tree tree){
        pruferCode = new ArrayList<>();

        List<Vertex> tmp = tree.getProduct();
        int numberOfEdges = 0;
        for (Vertex v : tmp) {
            numberOfEdges += v.getNeighbours().size();
        }
        numberOfEdges /= 2;
        while (numberOfEdges >= 2){
            Vertex v = find(tmp);
            pruferCode.add(v.getNeighbours().get(0).getVertexLabel());
            v.visited(true);
            numberOfEdges -= v.getNeighbours().size();
        }
        tmp.forEach(vertex -> vertex.visited(false));
    }

    public Vertex find(List<Vertex> list){
        for (Vertex v : list.stream().filter(vertex -> !vertex.isVisited()).toList()) {
            if (v.getNeighbours().stream().filter(vertex -> !vertex.isVisited()).count() == 1)
                return v;
        }
        return null;
    }

    public static synchronized PruferCode getInstance(Tree tree){
        if (instance == null)
            instance = new PruferCode(tree);
        return instance;
    }

    public List<Integer> getPruferCode(){
        return pruferCode;
    }
}
