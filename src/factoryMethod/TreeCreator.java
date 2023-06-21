package factoryMethod;

import composite.Vertex;

import java.util.List;

public class TreeCreator implements Creator{

    @Override
    public Product createProduct(List<Vertex> g) {
        return new Tree(g);
    }
}
