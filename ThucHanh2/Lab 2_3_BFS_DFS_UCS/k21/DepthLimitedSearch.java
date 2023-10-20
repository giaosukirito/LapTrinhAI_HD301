package k21;

import java.util.*;

public class DepthLimitedSearch {
    public Node execute(Node root, String goal, int limitedDepth) {
        Stack<Node> frontier = new Stack<Node>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.pop();
            if (current.getLabel().equals(goal)) {
                return current;
            } else if (current.getDepth() < limitedDepth) {
                List<Node> childNodes = current.getChildrenNodes();
                Collections.sort(childNodes, new Comparator<Node>() {
                    @Override
                    public int compare(Node node1, Node node2) {
                        return node2.getLabel().compareTo(node1.getLabel());
                    }
                });

                for (Node child : childNodes) {
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        frontier.add(child);
                        child.setParent(current);
                        child.setDepth(current.getDepth() + 1);
                    }
                }
            }
        }
        return null;
    }
}
