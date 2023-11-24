import static org.junit.Assert.*;
import org.junit.Test;

public class ConcreteEdgesGraphTest extends GraphInstanceTest {

    /*
     * Provide a ConcreteEdgesGraph for tests in GraphInstanceTest.
     */
    @Override
    public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph();
    }

    /*
     * Testing ConcreteEdgesGraph...
     */

    // Testing strategy for ConcreteEdgesGraph.toString()
    //   TODO

    @Test
    public void testConcreteEdgesGraphToString() {
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.set("A", "B", 3);

        String expected = "A -> B [3]";
        assertEquals("toString should represent the graph structure", expected, graph.toString());
    }

    // TODO other tests for ConcreteEdgesGraph.toString()

    /*
     * Testing Edge...
     */

    // Testing strategy for Edge
    //   TODO

    @Test
    public void testEdgeToString() {
        Edge<String> edge = new Edge<>("A", "B", 2);

        String expected = "A -> B [2]";
        assertEquals("toString should represent the edge", expected, edge.toString());
    }

    @Test
    public void testSetWeight() {
        Edge<String> edge = new Edge<>("A", "B", 2);
        edge.setWeight(5);

        assertEquals("Edge weight should be updated to 5", 5, edge.getWeight());
    }

    // TODO other tests for operations of Edge

}
