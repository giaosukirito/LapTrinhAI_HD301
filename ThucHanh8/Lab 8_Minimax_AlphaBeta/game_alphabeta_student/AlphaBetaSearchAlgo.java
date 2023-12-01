package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int maxValue = Integer.MIN_VALUE;
		Node result = null;
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;

		for (Node successor : node.getChildren()) {
			int value = minValue(successor, alpha, beta);
			if (value > maxValue) {
				maxValue = value;
				result = successor;
			}
		}

		// Print or return the result based on your requirements
		System.out.println(result.getLabel());
		System.out.println (result.getValue ());
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		int v = Integer.MIN_VALUE;
		for (Node successor : node.getChildren()) {
			v = Math.max(v, minValue(successor, alpha, beta));
			if (v >= beta) {
				System.out.println ("Node cut: " + v);
				return v;  // Beta cut-off
			}
			alpha = Math.max(alpha, v);
		}
		System.out.println ("Node cut: " + v);
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		int v = Integer.MAX_VALUE;
		for (Node successor : node.getChildren()) {
			v = Math.min(v, maxValue(successor, alpha, beta));
			if (v <= alpha) {
				System.out.println ("Node cut: " + v);
				return v;  // Alpha cut-off
			}
			beta = Math.min(beta, v);
		}
		System.out.println ("Node cut: " + v);
		return v;
	}
}
