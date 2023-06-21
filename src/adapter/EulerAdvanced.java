package adapter;

import composite.Vertex;
import factoryMethod.Product;

import java.util.List;

public interface EulerAdvanced {
    List<Vertex> makeEulerPath(Product p);
}
