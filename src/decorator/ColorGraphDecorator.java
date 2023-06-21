package decorator;

import composite.Vertex;
import factoryMethod.Product;

import java.util.List;

public class ColorGraphDecorator extends ProductDecorator{

    public ColorGraphDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public List<Vertex> getProduct() {
        isColorable(decoratedProduct);
        return decoratedProduct.getProduct();
    }
    public void isColorable(Product decoratedProduct){
        List<Vertex> acc = decoratedProduct.getProduct();
        acc.get(0).setColor(0);
        acc.subList(1, decoratedProduct.getChromaticNumber()).forEach(vertex -> vertex.setColor(-1));

        if (!colorGraph(1, decoratedProduct))
            decoratedProduct.setChromaticNumber(0);
    }

    public boolean colorGraph(int k, Product decoratedProduct){
        List<Vertex> acc = decoratedProduct.getProduct();
        if (k == acc.size())
            return true;
        for (int col = 0; col < decoratedProduct.getChromaticNumber(); col++){
            int finalCol = col;
            if (acc.get(k).getNeighbours().stream().filter(vertex -> vertex.getColor() == finalCol).toList().isEmpty()){
                acc.get(k).setColor(col);
                if (colorGraph(k+1, decoratedProduct))
                    return true;
                acc.get(k).setColor(-1);
            }
        }
        return false;
    }

    @Override
    public String show() {
        return decoratedProduct.show();
    }
    @Override
    public void setSemiEulerButNotEuler(boolean semiEulerButNotEuler) {
        decoratedProduct.setSemiEulerButNotEuler(semiEulerButNotEuler);
    }
    @Override
    public boolean isSemiEulerButNotEuler() {
        return decoratedProduct.isSemiEulerButNotEuler();
    }
    @Override
    public void setEulerCycleOrPath(List<Vertex> eulerCycleOrPath) {
        decoratedProduct.setEulerCycleOrPath(eulerCycleOrPath);
    }
    @Override
    public List<Vertex> getEulerCycleOrPath() {
        return decoratedProduct.getEulerCycleOrPath();
    }
}
