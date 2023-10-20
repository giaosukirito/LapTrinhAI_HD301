package k21;

public class Main {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A"); Node nodeB = new Node("B");
        Node nodeC = new Node("C"); Node nodeD = new Node("D");
        Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeG = new Node("G"); Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
        ISearchAlgo bfs = new BreadthFirstSearchAlgo();
        ISearchAlgo dfs = new DepthFirstSearchAlgo();
        ISearchAlgo ucs = new UniformCostSearchAlgo();
        DepthLimitedSearch dls = new DepthLimitedSearch();
        Node result = dls.execute(nodeS,"G",2);
        System.out.println(NodeUtils.printPath(result) + " " + result.getPathCost());
    }
}
