package searches;

import graphs.DirectedGraphNode;
import test.Test;

/**
 * Created by Chris Keyser on 3/18/2016.
 * Tests BFS and DFS
 */
public class UnguidedSearchTest extends Test {
    @Override
    public void run() {
        //initialize graph
        DirectedGraphNode root = new DirectedGraphNode(21);

        //this is going to be a bit of a mess because it's pre-planned
        //i'll include a scanned image of the graph later
        //it'll be hand drawn but should at least make this kinda legible
        DirectedGraphNode n1 = new DirectedGraphNode(14);
        DirectedGraphNode n2 = new DirectedGraphNode(18);
        DirectedGraphNode n3 = new DirectedGraphNode(39);
        DirectedGraphNode n4 = new DirectedGraphNode(51);
        DirectedGraphNode n5 = new DirectedGraphNode(63);
        DirectedGraphNode n6 = new DirectedGraphNode(16);
        DirectedGraphNode n7 = new DirectedGraphNode(27);
        DirectedGraphNode n8 = new DirectedGraphNode(84);
        DirectedGraphNode n9 = new DirectedGraphNode(30);
        DirectedGraphNode n10 = new DirectedGraphNode(33);
        DirectedGraphNode n11 = new DirectedGraphNode(36);
        DirectedGraphNode n12 = new DirectedGraphNode(11);

        root.addNeighbor(n1);
        root.addNeighbor(n2);
        root.addNeighbor(n3);
        n1.addNeighbor(n4);
        n2.addNeighbor(n1);
        n2.addNeighbor(n5);
        n3.addNeighbor(n6);
        n3.addNeighbor(n7);
        n5.addNeighbor(n8);
        n6.addNeighbor(n8);
        n6.addNeighbor(n12);
        n7.addNeighbor(n9);
        n9.addNeighbor(n10);
        n10.addNeighbor(n11);

        DepthFirstSearch dfs = new DepthFirstSearch();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        String expected;

        //DFS tests
        expect(dfs.contains(63, root, false));
        expect(!dfs.contains(60, root, false));

        //expected result string for DFS traversal on root
        expected = "21 39 27 30 33 36 16 11 84 18 63 14 51";

        expectEquals(dfs.traverse(root), expected);

        //BFS tests
        expect(bfs.contains(63, root, false));
        expect(!bfs.contains(60, root, false));

        //expected result string for BFS traversal on root
        expected = "21 14 18 39 51 63 16 27 84 11 30 33 36";

        expectEquals(bfs.traverse(root), expected);
    }
}
