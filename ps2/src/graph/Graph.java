package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A mutable weighted directed graph with labeled vertices.
 * Vertices have distinct labels of an immutable type {@code L} when compared
 * using the {@link Object#equals(Object) equals} method.
 * Edges are directed and have a positive weight of type {@code int}.
 * 
 * <p>PS2 instructions: this is a required ADT interface.
 * You MUST NOT change the specifications or add additional methods.
 * 
 * @param <L> type of vertex labels in this graph, must be immutable
 */
public class GraphImplementation<L> implements Graph<L> {

    private Map<L, Map<L, Integer>> adjacencyMap;

    /**
     * Create an empty graph.
     * 
     * @param <L> type of vertex labels in the graph, must be immutable
     * @return a new empty weighted directed graph
     */
    public static <L> Graph<L> empty() {
        return new GraphImplementation<>();
    }

    /**
     * Constructs an empty graph.
     */
    public GraphImplementation() {
        this.adjacencyMap = new HashMap<>();
    }

    @Override
    public boolean add(L vertex) {
        if (!adjacencyMap.containsKey(vertex)) {
            adjacencyMap.put(vertex, new HashMap<>());
            return true;
        }
        return false;
    }

    @Override
    public int set(L source, L target, int weight) {
        add(source);
        add(target);

        Map<L, Integer> sourceEdges = adjacencyMap.get(source);
        int previousWeight = sourceEdges.getOrDefault(target, 0);
        if (weight != 0) {
            sourceEdges.put(target, weight);
        } else {
            sourceEdges.remove(target);
        }
        return previousWeight;
    }

    @Override
    public boolean remove(L vertex) {
        if (adjacencyMap.containsKey(vertex)) {
            // Remove edges to the vertex
            for (Map<L, Integer> edges : adjacencyMap.values()) {
                edges.remove(vertex);
            }

            // Remove edges from the vertex
            adjacencyMap.remove(vertex);
            return true;
        }
        return false;
    }

    @Override
    public Set<L> vertices() {
        return adjacencyMap.keySet();
    }

    @Override
    public Map<L, Integer> sources(L target) {
        Map<L, Integer> sources = new HashMap<>();
        for (L source : adjacencyMap.keySet()) {
            if (adjacencyMap.get(source).containsKey(target)) {
                sources.put(source, adjacencyMap.get(source).get(target));
            }
        }
        return sources;
    }

    @Override
    public Map<L, Integer> targets(L source) {
        return adjacencyMap.getOrDefault(source, new HashMap<>());
    }
}
