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

}