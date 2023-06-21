package state;

import composite.Vertex;
import facade.*;
import factoryMethod.Product;

import java.util.List;

public class Characterise implements State {
    private final HamiltonCycle hamiltonCycle;
    private final Bipartite bipartite;
    private final ChromaticNumber chromaticNumber;
    private final EulerCycle eulerCycle;
    private final Product p;

    public Characterise(Product p){
        this.p = p;
        hamiltonCycle = new HamiltonCycle();
        eulerCycle = new EulerCycle();
        bipartite = new Bipartite();
        chromaticNumber = new ChromaticNumber();
    }

    public void getBipartite(){
        bipartite.getResult(p);
    }

    public void getChromaticNumber() {
        chromaticNumber.getResult(p);
    }
    public void getEulerCycle() {
        eulerCycle.getResult(p);
    }
    public void getHamiltonCycle() {
        hamiltonCycle.getResult(p);
    }

    public void doAction(Context context) {
        getEulerCycle();
        getChromaticNumber();
        getBipartite();
        getHamiltonCycle();
        context.setState(new WriteToFile(p)); //zmiana stanu
    }

}
