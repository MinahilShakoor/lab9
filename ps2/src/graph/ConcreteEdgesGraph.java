package graph;

import java.util.*;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {

    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();

    // Abstraction function:
    //   Represents a directed graph with labeled vertices and weighted edges.
    // Representation invariant:
    //   - Vertices in edges must be present in the set of vertices.
    //   - Edge weights must be non-negative.
    // Safety from rep exposure:
    //   - Fields are private.
    //   - Modifiable collections are defensively copied.

    // Check rep invariant
    private void checkRep() {
        for (Edge edge : edges) {
            assert vertices.contains(edge.getSource());
            assert vertices.contains(edge.getTarget());
            assert edge.getWeight() >= 0;
        }
    }

    // Constructor
    public ConcreteEdgesGraph() {
        checkRep();
    }

    @Override
    public boolean add(String vertex) {
        boolean added = vertices.add(vertex);
        checkRep();
        return added;
    }

    @Override
    public int set(String source, String target, int weight) {
        if (!vertices.contains(source) || !vertices.contains(target) || weight < 0) {
            throw new IllegalArgumentException("Invalid source, target, or weight");
        }

        int previousWeight = 0;
        Edge existingEdge = getEdge(source, target);
        if (existingEdge != null) {
            previousWeight = existingEdge.getWeight();
            existingEdge.setWeight(weight);
        } else {
            edges.add(new Edge(source, target, weight));
        }

        checkRep();
        return previousWeight;
    }

    @Override
    public boolean remove(String vertex) {
        boolean removed = vertices.remove(vertex);
        edges.removeIf(edge -> edge.getSource().equals(vertex) || edge.getTarget().equals(vertex));
        checkRep();
        return removed;
    }

    @Override
    public Set<String> vertices() {
        return new HashSet<>(vertices);
    }

    @Override
    public Map<String, Integer> sources(String target) {
        Map<String, Integer> sources = new HashMap<>();
        for (Edge edge : edges) {
            if (edge.getTarget().equals(target)) {
                sources.put(edge.getSource(), edge.getWeight());
            }
        }
        return sources;
    }

    @Override
    public Map<String, Integer> targets(String source) {
        Map<String, Integer> targets = new HashMap<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(source)) {
                targets.put(edge.getTarget(), edge.getWeight());
            }
        }
        return targets;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Edge edge : edges) {
            result.append(edge.toString()).append("\n");
        }
        return result.toString().trim();
    }

    /**
     * Internal class representing a directed edge with a weight.
     */
    private static class Edge {
        private final String source;
        private final String target;
        private int weight;

        // Abstraction function:
        //   Represents a directed edge with a weight from source to target.
        // Representation invariant:
        //   - Edge weight must be non-negative.
        // Safety from rep exposure:
        //   - Fields are private.

        // Check rep invariant
        private void checkRep() {
            assert weight >= 0;
        }

        // Constructor
        public Edge(String source, String target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
            checkRep();
        }

        public String getSource() {
            return source;
        }

        public String getTarget() {
            return target;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
            checkRep();
        }

        @Override
        public String toString() {
            return source + " -> " + target + " [" + weight + "]";
        }
    }
}
