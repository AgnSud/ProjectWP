package adapter;

import composite.Vertex;
import factoryMethod.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class EulerPath implements EulerAdvanced{

    public Vertex startVertex(List<Vertex> acc){
        Optional<Vertex> v = acc.stream().filter(vertex -> vertex.getNeighbours().size() % 2 == 1).findFirst();
        return v.orElse(null);
    }
    @Override
    public List<Vertex> makeEulerPath(Product p) {
        List<Vertex> path = new ArrayList<>();
        List<Vertex> acc = p.getProduct();
        Stack<Vertex> st = new Stack<>();
        st.push(startVertex(acc));
        while (!st.empty()){
            Vertex tmp = st.peek();
            List<Vertex> reducedList = tmp.getNeighbours().stream().filter(vertex -> !tmp.getTakenNeighbours().contains(vertex)).toList();
            if (!reducedList.isEmpty()){
                Vertex neighbour = reducedList.get(0);
                st.push(neighbour);
                tmp.addTakenNeighbour(neighbour);
                neighbour.addTakenNeighbour(tmp);
            } else {
                st.pop();
                path.add(tmp);
            }
        }
        acc.forEach(vertex -> vertex.setTakenNeighbours(new ArrayList<>()));
        return path;
    }
}
