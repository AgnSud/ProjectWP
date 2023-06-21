package state;

import composite.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Checking {
    public boolean checkIfTree(List<Vertex> graph){
        Queue<Vertex> queue = new LinkedList<>();
        Vertex s = graph.get(0);
        queue.add(s);
        s.visited(true);
        while (!queue.isEmpty()){
            Vertex acc = queue.remove();
            acc.visited(true);
            List<Vertex> neighbours = acc.getNeighbours();
            for (Vertex neighbour : neighbours) {
                if (neighbour.isVisited() && acc.getPrev() != neighbour){
                    return false;
                }
                else if (!neighbour.isVisited()) {
                    queue.add(neighbour);
                    neighbour.setPrev(acc);
                }
            }
        }
        for (Vertex v : graph) {
            if (!v.isVisited())
                return false;
        }
        graph.forEach(vertex -> vertex.visited(false));
        return true;
    }

    public boolean checkIfConnected(List<Vertex> graph){
        boolean result;
        DFS(graph.get(0));
        result = graph.stream().allMatch(Vertex::isVisited);
        graph.forEach(vertex -> vertex.visited(false));
        return result;
    }

    public void DFS(Vertex v){
        v.visited(true);
        for (Vertex u : v.getNeighbours()){
            if (!u.isVisited())
                DFS(u);
        }
    }
}
