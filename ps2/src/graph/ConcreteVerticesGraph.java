package graph;

import java.util.*;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteVerticesGraph implements Graph<String> {

    private final List<Vertex> vertices = new ArrayList<>();

    // Abstraction function:
    //   Represents a graph with labeled vertices and weighted edges.
    // Representation invariant:
    //   - Vertices must be distinct and non-null.
    //   - Edges must have non-null source and target vertices.
    // Safety from rep exposure:
    //   - Fields are private.
    //   - Modifiable collections are defensively copied.

    // Check rep invariant
    private void checkRep() {
        Set<String> seenVertices = new HashSet<>();
        for (Vertex vertex : vertices) {
            assert vertex.getLabel() != null;
            assert seenVertices.add(vertex.getLabel());
            vertex.checkRep();
        }
    }

    // Constructor
    public ConcreteVerticesGraph() {
        checkRep();
    }

    @Override
    public boolean add(String vertexLabel) {
        if (vertexLabel == null) {
            throw new IllegalArgumentException("Vertex label cannot be null");
        }

        if (containsVertex(vertexLabel)) {
            return false; // Vertex already exists
        }

        vertices.add(new Vertex(vertexLabel));
        checkRep();
        return true;
    }

    @Override
    public int set(String source, String target, int weight) {
        throw new UnsupportedOperationException("Method not supported in ConcreteVerticesGraph");
    }

    @Override
    public boolean remove(String vertexLabel) {
        Iterator<Vertex> iterator = vertices.iterator();
        while (iterator.hasNext()) {
            Vertex vertex = iterator.next();
            if (vertex.getLabel().equals(vertexLabel)) {
                iterator.remove();
                checkRep();
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> vertices() {
        Set<String> result = new HashSet<>();
        for (Vertex vertex : vertices) {
            result.add(vertex.getLabel());
        }
        return result;
    }

    @Override
    public Map<String, Integer> sources(String target) {
        throw new UnsupportedOperationException("Method not supported in ConcreteVerticesGraph");
    }

    @Override
    public Map<String, Integer> targets(String source) {
        throw new UnsupportedOperationException("Method not supported in ConcreteVerticesGraph");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Vertex vertex : vertices) {
            result.append(vertex.toString()).append("\n");
        }
        return result.toString().trim();
    }

    /**
     * Internal class representing a vertex.
     */
    private static class Vertex {
        private final String label;

        // Abstraction function:
        //   Represents a vertex with a label.
        // Representation invariant:
        //   - Vertex label must be non-null.
        // Safety from rep exposure:
        //   - Fields are private.

        // Check rep invariant
        private void checkRep() {
            assert label != null;
        }

        // Constructor
        public Vertex(String label) {
            this.label = label;
            checkRep();
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
