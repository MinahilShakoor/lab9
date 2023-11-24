import static org.junit.Assert.*;
import org.junit.Test;

public class ConcreteVerticesGraphTest extends GraphInstanceTest {

    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override
    public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph();
    }

    /*
     * Testing ConcreteVerticesGraph...
     */

    // Testing strategy for ConcreteVerticesGraph.toString()
    //   TODO

    @Test
    public void testConcreteVerticesGraphToString() {
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.set("A", "B", 3);

        String expected = "A -> B [3]\nB";
        assertEquals("toString should represent the graph structure", expected, graph.toString());
    }

    // TODO other tests for ConcreteVerticesGraph.toString()

    /*
     * Testing Vertex...
     */

    // Testing strategy for Vertex
    //   TODO

    @Test
    public void testVertexToString() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.addEdge("B", 2);

        String expected = "A -> B [2]";
        assertEquals("toString should represent the vertex and its edges", expected, vertex.toString());
    }

    @Test
    public void testAddEdge() {
        Vertex<String> vertex = new Vertex<>("A");
        boolean added = vertex.addEdge("B", 3);

        assertTrue("Adding an edge should return true", added);
        assertTrue("Vertex should have the added edge", vertex.hasEdge("B"));
        assertEquals("Edge weight should be 3", 3, vertex.getEdgeWeight("B"));
    }

    @Test
    public void testRemoveEdge() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.addEdge("B", 2);
        boolean removed = vertex.removeEdge("B");

        assertTrue("Removing an existing edge should return true", removed);
        assertFalse("Vertex should not have the removed edge", vertex.hasEdge("B"));
    }

    @Test
    public void testRemoveNonexistentEdge() {
        Vertex<String> vertex = new Vertex<>("A");
        boolean removed = vertex.removeEdge("B");

        assertFalse("Removing a nonexistent edge should return false", removed);
    }

    // TODO other tests for operations of Vertex

}
