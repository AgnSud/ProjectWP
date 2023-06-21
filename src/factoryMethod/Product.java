package factoryMethod;

import composite.Vertex;
import java.util.List;

public interface Product {
    List<Vertex> getProduct();
    String show();

    void setSemiEulerButNotEuler(boolean semiEulerButNotEuler);
    boolean isSemiEulerButNotEuler();

    void setEulerCycleOrPath(List<Vertex> eulerCycleOrPath);
    List<Vertex> getEulerCycleOrPath();

    default boolean isEuler() {//dla drzew, ktore nigdy nie sa eulerowskie
        return false;
    }
    default void setEuler(boolean euler) {}

    default int getChromaticNumber(){
        return 2;
    }
    default void setChromaticNumber(int chromaticNumber){}

    default boolean isBipartite() {
        return true;
    }
    default void setBipartite(boolean bipartite) {}

    default boolean isHamiltonian() {
        return false;
    }
    default void setHamiltonian(boolean hamiltonian) {}

    default List<Vertex> getHamiltonCycle() {
        return null;
    }
    default void setHamiltonCycle(List<Vertex> hamiltonCycle) {}

    default List<Integer> getPruferCode() {
        return null;
    }


}
