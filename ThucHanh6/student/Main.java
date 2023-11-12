package n_queen.student;

public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        node.generateBoard();
        node.generateAllCandidates();
        node.displayBoard();
    }
}
