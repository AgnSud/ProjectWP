package facade;

import composite.Vertex;
import factoryMethod.Product;

import java.util.ArrayList;
import java.util.List;

public class HamiltonCycle implements Profile{
    private List<Vertex> hamilton;

    public boolean hamiltonCycle(List<Vertex> acc, int k){
        if (k == acc.size())
            return hamilton.get(0).getNeighbours().contains(hamilton.get(acc.size()-1));
        for (Vertex u : hamilton.get(k - 1).getNeighbours()){
            if (!u.isVisited()){
                hamilton.add(u);
                u.visited(true);
                if (hamiltonCycle(acc, k + 1))
                    return true;
                u.visited(false);
                hamilton.remove(u);
            }
        }
        return false;
    }
    @Override
    public void getResult(Product p) {
        hamilton = new ArrayList<>();
        Vertex start = p.getProduct().get(0);
        hamilton.add(start);
        start.visited(true);
        p.setHamiltonian(hamiltonCycle(p.getProduct(), 1));
        if (p.isHamiltonian()) {
            hamilton.add(start);
            p.setHamiltonCycle(hamilton);
        }
        p.getProduct().forEach(vertex -> vertex.visited(false));
    }
}
