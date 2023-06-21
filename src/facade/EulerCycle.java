package facade;

import adapter.Euler;
import adapter.EulerAdapter;
import composite.Vertex;
import factoryMethod.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EulerCycle implements Profile, Euler {
    private EulerAdapter eulerAdapter;

    @Override
    public void getResult(Product p) {
        setEulerCycle(p);

        if (p.isEuler()){
            List<Vertex> eulerCycle = makeEulerCycleOrPath(p);
            p.setEulerCycleOrPath(eulerCycle);

        } else if (p.isSemiEulerButNotEuler()) {
            eulerAdapter = new EulerAdapter();
            List<Vertex> eulerPath = eulerAdapter.makeEulerCycleOrPath(p);
            p.setEulerCycleOrPath(eulerPath);
        }
    }

    public void setEulerCycle(Product p) {
        List<Vertex> acc = p.getProduct();
        boolean euler = false;
        boolean semiEuler = false;
        boolean isAllEven = acc.stream().allMatch(vertex -> vertex.getNeighbours().size() % 2 == 0);
        if (!isAllEven) {
            long vertexStream = acc.stream().filter(vertex -> vertex.getNeighbours().size() % 2 == 1).count();
            if (vertexStream == 2)
                semiEuler = true;
        }
        else {
            euler = true;
        }
        p.setEuler(euler);
        p.setSemiEulerButNotEuler(semiEuler);
    }

    @Override
    public List<Vertex> makeEulerCycleOrPath(Product p) {//tworzy cykl eulera
        List<Vertex> cycle = new ArrayList<>();
        List<Vertex> acc = p.getProduct();
        Stack<Vertex> st = new Stack<>();
        st.push(acc.get(0));
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
                cycle.add(tmp);
            }
        }
        acc.forEach(vertex -> vertex.setTakenNeighbours(new ArrayList<>()));
        return cycle;
    }
}
