package facade;

import decorator.ColorGraphDecorator;
import factoryMethod.Product;
public class ChromaticNumber implements Profile{

    @Override
    public void getResult(Product p) {
        int k = 1;
        Product colored;
        while (p.getChromaticNumber() == 0){
            p.setChromaticNumber(k);
            colored = new ColorGraphDecorator(p);
            colored.getProduct();
            k++;
        }
        if (p.show().equals("Tree")){
            colored = new ColorGraphDecorator(p);
            colored.getProduct();
        }
    }
}
