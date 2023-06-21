package adapter;

import composite.Vertex;
import factoryMethod.Product;

import java.util.List;

public interface Euler {
    List<Vertex> makeEulerCycleOrPath(Product p);
}
