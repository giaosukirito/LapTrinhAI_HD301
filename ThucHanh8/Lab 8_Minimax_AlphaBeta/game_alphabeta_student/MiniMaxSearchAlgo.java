package game_alphabeta_student;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int maxValue = maxValue (node);
		Node result = null;

		for (Node successor : node.getChildren()) {
			int value = minValue(successor);
			if (value > maxValue) {
				maxValue = value;
				result = successor;
			}
		}

		System.out.println(result.getLabel());
	}


	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if(node.isTerminal ()) {
			return node.getValue ();
		}

		int v = Integer.MIN_VALUE;
		for (Node successor : node.getChildren ()) {
			v = Math.min (v, minValue (successor));
		}

		return v;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if(node.isTerminal ()) {
			return node.getValue ();
		}

		int v = Integer.MAX_VALUE;
		for (Node successor : node.getChildren ()) {
			v = Math.min (v, maxValue (successor));
		}

		return v;
	}
}
