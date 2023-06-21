package state;
import composite.Vertex;
import exceptions.WrongInputDataException;
import factoryMethod.Creator;
import factoryMethod.GraphCreator;
import factoryMethod.Product;
import factoryMethod.TreeCreator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadFile implements State{
    private Creator creator;
    private List<Vertex> graph;
    private final Checking checker = new Checking();

    public void convert(List<List<Integer>> g){
        graph = new ArrayList<>();
        for (List<Integer> v : g) {
            graph.add(new Vertex(v.get(0)));

        }
        for (List<Integer> l : g) {
            Vertex find = null;
            for (Vertex i : graph) {
                if (Objects.equals(i.getVertexLabel(), l.get(0))){
                    find = i;
                    break;
                }
            }
            for (Integer n : l.subList(1, l.size())) {
                Vertex tmp = null;
                for (Vertex i : graph) {
                    if (Objects.equals(i.getVertexLabel(), n)) {
                        tmp = i;
                        break;
                    }
                }
                if (tmp != null)
                    Objects.requireNonNull(find).addNeighbour(tmp);
                else {
                    throw new NullPointerException();
                }
            }
        }
    }

    public Creator read(Context context) throws WrongInputDataException {
        List<List<Integer>> l = new ArrayList<>();
        String path = context.getPath();

        try{
            FileInputStream fis = new FileInputStream(path);
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if (!line.isBlank()) {
                    List<String> listString = Arrays.asList(line.split("\\s+"));
                    List<Integer> ls = listString
                            .stream()
                            .map(Integer::parseInt)
                            .toList();
                    l.add(ls);
                }
            }
            sc.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            return creator;
        }
        if (l.isEmpty())
            throw new WrongInputDataException();
        convert(l);
        if (checker.checkIfConnected(graph)) {
            if (checker.checkIfTree(graph))
                return new TreeCreator();
            return new GraphCreator();
        }
        throw new WrongInputDataException("Podany graf nie jest spojny");
    }

    public void doAction(Context context) {
        try{
            creator = read(context);
            if (creator == null)
                throw new WrongInputDataException("Nieprawidlowe dane w pliku wejsciowym");
            Product p = creator.createProduct(graph);
            p.getProduct().forEach(vertex -> vertex.visited(false));
            p.show();
            context.setState(new Characterise(p));
        }catch (WrongInputDataException e){
            context.setCorrect(false);
            context.setMessage(e.getMessage());
            context.setState(new WriteToFile()); //zmiana stanu
        }
    }
}
