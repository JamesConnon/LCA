import static org.junit.Assert.*;
import org.junit.Test;

public class DAGTest
{

        @Test
        public void directedGraphTest()
        {
            LCADag test1 = new LCADag(10);
            test1.addEdge(1, 2);
            test1.addEdge(1, 3);
            test1.addEdge(3, 4);
            test1.addEdge(4, 5);
            test1.addEdge(4, 6);

            assertEquals("", 5, test1.E());
            assertEquals("", 10, test1.V());
            String ans = "[5, 6]";
            assertEquals("",ans, test1.adj(4).toString());
        }

        @Test
        public void inDegreeTest(){
            LCADag test2 = new LCADag(5);
            assertEquals("", -1, test2.indegree(-3));
        }

        @Test
        public void outDegreeTest(){
            LCADag test3 = new LCADag(5);
            assertEquals("", -1, test3.outdegree(8));
        }

        @Test
        public void addEdgeTest(){
            LCADag test4 = new LCADag(5);
            test4.addEdge(3, 9);
            test4.addEdge(0, 1);

            //Doesn't add an edge
            test4.addEdge(-2, -5);
            assertEquals("Testing edge count is 1", 1, test4.E());

            test4.addEdge(1, 2);

            assertEquals("Testing edge count is 2", 2, test4.E());
        }

        //Directed graph isnt necessary directed acyclic graph, so will need to ensure it is a DAG.
        @Test
        public void testsForCycle(){
            LCADag cyclic = new LCADag(20);
            cyclic.addEdge(0, 1);
            cyclic.addEdge(1, 2);
            cyclic.addEdge(2, 0);

            //Parameter is first vertex
            cyclic.findCycle(0);

            //Cycle from 0 - 1 - 2 - 0, should return true.
            assertTrue(cyclic.hasCycle());

            LCADag acyclic = new LCADag(20);
            acyclic.addEdge(0, 1);
            acyclic.addEdge(1, 3);
            acyclic.addEdge(2, 4);
            //Parameter is first vertex
            acyclic.findCycle(0);
            //No Cycle,return false
            assertFalse(acyclic.hasCycle());
        }


    @Test
    public void testV()
    {
        LCADag graph = new LCADag(6);
        assertEquals(6, graph.V());
    }

    @Test
    public void testE(){

        LCADag graph = new LCADag(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 3);

        assertEquals(3, graph.E());
    }

    @Test
    public void testAdj()
    {
        LCADag graph = new LCADag(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 3);
        graph.addEdge(4, 3);

        String adj = "[4]";
        assertEquals(adj, graph.adj(2).toString());
    }


    //Future Tests for LCA function
    @Test
    public void testLCA(){
        LCADag lca = new LCADag(10);

        //--------2---5----7--
        //---0--1-------6----8
        //--------3---4-------
        lca.addEdge(0, 1);
        lca.addEdge(1, 2);
        lca.addEdge(1, 3);
        lca.addEdge(2, 5);
        lca.addEdge(3, 4);
        lca.addEdge(4, 6);
        lca.addEdge(5, 6);
        lca.addEdge(6, 8);
        lca.addEdge(5, 7);
        lca.addEdge(7, 8);
        lca.addEdge(8, 9);

        assertEquals("Finding LCA for 4 and 5", 1, lca.findLCA(5, 4));
        assertEquals("Finding LCA for 7 and 8", 7, lca.findLCA(8, 7));
        assertEquals("Finding LCA for 6 and 8", 6, lca.findLCA(6, 8));
        assertEquals("Special case where both parameters are same vertex", 2, lca.findLCA(2,2));
    }

    @Test
    public void testLCAForNoCommonAncestors(){
        LCADag lca2 = new LCADag(11);
        //-----1----5----
        //---0-|---/-----
        //-----2--3---4--
        lca2.addEdge(0, 1);
        lca2.addEdge(0, 2);
        lca2.addEdge(1, 2);
        lca2.addEdge(2, 3);
        lca2.addEdge(3, 4);
        lca2.addEdge(1, 5);
        lca2.addEdge(3, 5);

        //Check that it works
        assertEquals("", 0, lca2.findLCA(3, 1));
        assertEquals("Finding LCA when there is no LCA", 0, lca2.findLCA(3, 1));
        assertEquals("", 2, lca2.findLCA(3, 2));
        assertEquals("", 3, lca2.findLCA(4, 5));

        //Check for no common ancestors
        assertEquals("", -1, lca2.findLCA(7, 3));
        assertEquals("Finding LCA when one node doesnt exist", -1, lca2.findLCA(7, 3));
    }

    //tests unique case in which graph is not acyclic, just a digraph
    @Test
    public void testLCAForNonDAG(){
        LCADag lca3 = new LCADag(11);

        lca3.addEdge(0, 1);
        lca3.addEdge(0, 2);
        lca3.addEdge(2, 3);
        lca3.addEdge(3, 0);
        lca3.addEdge(3, 4);

        //Should return -1 if graph is not a DAG
        assertEquals("", -1, lca3.findLCA(2, 3));
        assertEquals("", -1, lca3.findLCA(3, 4));
        assertEquals("", -1, lca3.findLCA(1, 2));
        assertEquals("", -1, lca3.findLCA(0, 3));
        assertEquals("", -1, lca3.findLCA(1, 3));

    }

    @Test
    public void testLCAforEmptyDAG() {
        LCADag lca = new LCADag(10);
        assertEquals("Testing LCA is -1", -1, lca.findLCA(1, 2));
    }

    @Test
    public void testLCAForSameVertex()
    {
        LCADag graph = new LCADag(10);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);

        assertEquals(3, graph.findLCA(3, 3));

    }


}