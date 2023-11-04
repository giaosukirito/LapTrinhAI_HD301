package lab4.inform.student;

import java.util.*;

public class AStarSearch implements IInformedSearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier  = new PriorityQueue<>(new NodeAStarComparator());
        frontier.add(root);
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if(current.getLabel().equals(goal)) {
                return current;
            } else {
                explored.add(current);
                List<Edge> childEdges = current.getChildren();
                for (Edge child : childEdges) {
                    Node n = child.getEnd();
                    if(!explored.contains(n)  || frontier.contains(n)) {
                        n.setG(current.getG() + child.getWeight());
                        frontier.add(n);
                        n.setParent(current);
                    } else if(frontier.contains(n) && n.getG() > current.getH() + child.getWeight() ) {
                        frontier.remove(n);
                        n.setG(current.getH() + child.getWeight());
                        n.setParent(current);
                        frontier.add(n);
                    }
                }
            }
        }
        return null;

    }

    @Override
    public Node execute(Node root, String start, String goal) {
        PriorityQueue<Node> frontier  = new PriorityQueue<>(new NodeAStarComparator());
        frontier.add(root);
        List<Node> explored = new ArrayList<>();
        boolean started = false;
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if(current.getLabel().equals(goal) && started) {
                return current;
            } else {
                if(current.getLabel().equals(start)) {
                    frontier.clear();
                    explored.clear();
                    started = true;
                }
                explored.add(current);
                List<Edge> childEdges = current.getChildren();
                for (Edge child : childEdges) {
                    Node n = child.getEnd();
                    if(!explored.contains(n)  || frontier.contains(n)) {
                        n.setG(current.getG() + child.getWeight());
                        frontier.add(n);
                        n.setParent(current);
                    } else if(frontier.contains(n) && n.getG() > current.getH() + child.getWeight() ) {
                        frontier.remove(n);
                        n.setG(current.getH() + child.getWeight());
                        n.setParent(current);
                        frontier.add(n);
                    }
                }
            }
        }
        return null;

    }
}
