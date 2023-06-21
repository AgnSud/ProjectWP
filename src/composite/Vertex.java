package composite;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final Integer vertex; //wierzcholek konkretny
    private final List<Vertex> neighbours; //lista jego sasiadow
    private List<Vertex> takenNeighbours;
    private boolean visited;
    private int label;
    private Vertex prev;
    private int color;

    public Vertex(Integer vertex){
        color = -1; //zaczynam od koloru -1 - oznaczenie, ze nie jest pokolorowany
        prev = null;
        label = 0; //nie oznaczony wierzcholek
        visited = false;
        this.vertex = vertex;
        neighbours = new ArrayList<>();
        takenNeighbours = new ArrayList<>();
    }

    public int getLabel() {
        return label;
    }
    public void setLabel(int label) {
        this.label = label;
    }

    public void addTakenNeighbour(Vertex takenNeighbour) {
        takenNeighbours.add(takenNeighbour);
    }
    public List<Vertex> getTakenNeighbours(){
        return takenNeighbours;
    }
    public void setTakenNeighbours(List<Vertex> takenNeighbours) {
        this.takenNeighbours = takenNeighbours;
    }

    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }

    public void addNeighbour(Vertex neighbour){
        neighbours.add(neighbour);
    }
    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }
    public Vertex getPrev() {
        return prev;
    }

    public void visited(boolean visited) {
        this.visited = visited;
    }
    public boolean isVisited() {
        return visited;
    }

    public Integer getVertexLabel() {
        return vertex;
    }
}
