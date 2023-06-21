package state;

import factoryMethod.Product;

import java.io.*;

public class WriteToFile implements State{
    private Product p;

    public WriteToFile(){}
    public WriteToFile(Product p){
        this.p = p;
    }

    public void doAction(Context context) {
        File file = new File("result.txt");
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            if (!context.isCorrect()){
                writer.write(context.getMessage());
            }
            else{
                if (p.getPruferCode()  != null){//drzewo
                    writer.append("W pliku było drzewo, o następujących własnościach:");
                    writer.newLine();
                    writer.append("Kod Prufera: ").append(String.valueOf(p.getPruferCode()));
                    writer.newLine();
                }
                else {//graf
                    writer.append("W pliku był graf, o następujących własnościach:");
                    writer.newLine();
                }
                writer.append("Liczba chromatyczna: ").append(String.valueOf(p.getChromaticNumber()));
                writer.newLine();

                writer.append("Przykladowe kolorowanie grafu: ");
                writer.newLine();
                p.getProduct().forEach(vertex -> {
                    try {
                        writer.append("\t wierzchołek '").append(String.valueOf(vertex.getVertexLabel())).append("' pokolorowany na kolor ").append(String.valueOf(vertex.getColor()));
                        writer.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                writer.append(p.isBipartite() ? "Jest dwudzielny" : "Nie jest dwudzielny");
                writer.newLine();

                writer.append(p.isHamiltonian() ? "Cykl Hamiltona: " : "Nie jest hamiltonowski");
                if (p.getHamiltonCycle() != null) {
                    p.getHamiltonCycle().forEach(vertex -> {
                        try {
                            writer.append(String.valueOf(vertex.getVertexLabel())).append(" ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                writer.newLine();

                writer.append(p.isEuler() ? "Cykl Eulera: " : (p.isSemiEulerButNotEuler() ? "Ścieżka Eulera: " : "Nie jest eulerowski ani semi-eulerowski"));
                if (p.getEulerCycleOrPath() != null) {
                    p.getEulerCycleOrPath().forEach(vertex -> {
                        try {
                            writer.append(String.valueOf(vertex.getVertexLabel())).append(" ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
            writer.newLine();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
