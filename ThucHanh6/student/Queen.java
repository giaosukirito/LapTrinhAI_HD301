package n_queen.student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		// Enter your code here
		setRow(row++);
		if(row == Node.N) {
			row = 0;
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
		if(this.getRow() == q.getRow()) {
			return true;
		} else {
			int absRow = Math.abs(this.getRow() - q.getRow());
			int absCol = Math.abs(this.getColumn() - q.getColumn());
			if(absCol == absRow) {
				return true;
			}
		}
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
