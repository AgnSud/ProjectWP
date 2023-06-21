package factoryMethod;

import composite.Vertex;

import java.util.List;

public class GraphCreator implements Creator{

    @Override
    public Product createProduct(List<Vertex> g) {
        return new Graph(g);
    }

}
