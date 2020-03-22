import java.util.Arrays;

public class State {
	public char[][] Board = new char[4][4];
	
	public State() {
		
	}

	public State(char[][] board) {
		Board = board;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Board[0][0];
		result = prime * result + Board[0][1];
		result = prime * result + Board[0][2];
		result = prime * result + Board[0][3];
		result = prime * result + Board[1][0];
		result = prime * result + Board[1][1];
		result = prime * result + Board[1][2];
		result = prime * result + Board[1][3];
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (Board[0][0] != other.Board[0][0])
			return false;
		if (Board[0][1] != other.Board[0][1])
			return false;
			if (Board[0][2] != other.Board[0][2])
			return false;
			if (Board[0][3] != other.Board[0][3])
			return false;
			if (Board[1][0] != other.Board[1][0])
			return false;
			if (Board[1][1] != other.Board[1][1])
			return false;
			if (Board[1][2] != other.Board[1][2])
			return false;
			if (Board[1][3] != other.Board[1][3])
			return false;
		return true;
	}
}
