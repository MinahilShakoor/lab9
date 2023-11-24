/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

/**
 * Tests for static methods of Graph.
 * 
 * To facilitate testing multiple implementations of Graph, instance methods are
 * tested in GraphInstanceTest.
 */
public class GraphStaticTest {
    
    // Testing strategy
    //   empty()
    //     no inputs, only output is empty graph
    //     observe with vertices()
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyVerticesEmpty() {
        assertEquals("expected empty() graph to have no vertices",
                Collections.emptySet(), Graph.empty().vertices());
    }
    
     @Test
    public void testEmptyVerticesEmpty() {
        assertEquals("expected empty() graph to have no vertices",
                Collections.emptySet(), Graph.empty().vertices());
    }

    @Test
    public void testEmptyGraphEdgesEmpty() {
        assertEquals("expected empty() graph to have no edges",
                Collections.emptySet(), Graph.empty().edges());
    }

    @Test
    public void testEmptyGraphIsEmpty() {
        assertTrue("expected empty() graph to be empty", Graph.empty().isEmpty());
    }

    @Test
    public void testEmptyGraphVertexCountZero() {
        assertEquals("expected empty() graph to have zero vertices", 0, Graph.empty().vertexCount());
    }

    @Test
    public void testEmptyGraphEdgeCountZero() {
        assertEquals("expected empty() graph to have zero edges", 0, Graph.empty().edgeCount());
    }

    
}
