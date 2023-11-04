package lab4.inform.student;

import java.util.Comparator;

public class NodeUniformComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        Double h1 = o1.getG();
        Double h2 = o2.getG();
        int result = h1.compareTo(h2);
        if (result == 0)
            return o1.getLabel().compareTo(o2.getLabel());
        else
            return result;
    }
}
