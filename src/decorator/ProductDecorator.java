package decorator;

import composite.Vertex;
import factoryMethod.Product;

import java.util.List;

public abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct){
        this.decoratedProduct = decoratedProduct;
    }

    public List<Vertex> getProduct() {
        return decoratedProduct.getProduct();
    }
}
