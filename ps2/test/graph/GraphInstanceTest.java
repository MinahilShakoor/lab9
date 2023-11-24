/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   TODO
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // TODO you may use, change, or remove this test
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    @Test
    public void testAddVertex() {
        Graph<String> graph = emptyInstance();
        String vertex = "A";

        graph.addVertex(vertex);

        assertTrue("graph should contain the added vertex", graph.vertices().contains(vertex));
    }

    @Test
    public void testAddEdge() {
        Graph<String> graph = emptyInstance();
        String vertex1 = "A";
        String vertex2 = "B";

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addEdge(vertex1, vertex2);

        assertTrue("graph should contain the added edge", graph.edges().contains(new Edge<>(vertex1, vertex2)));
    }

    @Test
    public void testRemoveVertex() {
        Graph<String> graph = emptyInstance();
        String vertex = "A";

        graph.addVertex(vertex);
        graph.removeVertex(vertex);

        assertFalse("graph should not contain the removed vertex", graph.vertices().contains(vertex));
    }

    @Test
    public void testRemoveEdge() {
        Graph<String> graph = emptyInstance();
        String vertex1 = "A";
        String vertex2 = "B";

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addEdge(vertex1, vertex2);
        graph.removeEdge(vertex1, vertex2);

        assertFalse("graph should not contain the removed edge", graph.edges().contains(new Edge<>(vertex1, vertex2)));
    }

    // ... (other tests)

}
    
}
