package facade;

import composite.Vertex;
import factoryMethod.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite implements Profile{

    public boolean isBipartite(List<Vertex> acc){
        Queue<Vertex> queue = new LinkedList<>();
        Vertex v = acc.get(0);
        v.setLabel(1);
        queue.add(v);
        while(!queue.isEmpty()){
            v = queue.remove();
            for (Vertex u : v.getNeighbours()){
                if (u.getLabel() == v.getLabel())
                    return false;
                if (u.getLabel() == 0){
                    u.setLabel(3 - v.getLabel());
                    queue.add(u);
                }
            }
        }
        return true;
    }

    @Override
    public void getResult(Product p) {
        List<Vertex> acc = p.getProduct();
        p.setBipartite(isBipartite(acc));
    }
}
