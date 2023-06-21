package adapter;

import composite.Vertex;
import factoryMethod.Product;

import java.util.List;

public class EulerAdapter implements Euler{
    private final EulerAdvanced eulerAdvanced;

    public EulerAdapter(){
        eulerAdvanced = new EulerPath();
    }
    @Override
    public List<Vertex> makeEulerCycleOrPath(Product p) {
        return eulerAdvanced.makeEulerPath(p);
    }

}
