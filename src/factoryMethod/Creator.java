package factoryMethod;

import composite.Vertex;

import java.util.List;

public interface Creator {

    Product createProduct(List<Vertex> g);
}
