package n_queen.student;

public class Main {
    public static void main(String[] args) {
//        Node node = new Node();
//        node.generateBoard();
//        node.generateAllCandidates();
//        node.displayBoard();
        GA_NQueenAlgo test = new GA_NQueenAlgo ();
        Node node =  test.execute ();
        node.displayBoard ();
        System.out.println (node.getH ());
    }
}
