public class Operator {
	private int hanyadik;
	private int mit;
	
	public Operator(int hanyadik, int mit) {
		this.hanyadik = hanyadik;
		this.mit = mit;
	}

	public boolean preconditionFulfilled(State state) {
		return true;
	}
	

	public State Flip(Operator o, State state){
		for(int i = 0; i<=3; i++){
			for(int j=0; j<=3; j++){
				if((state.Board[i][j] == 'P') && (o.mit == 0) && (i == o.hanyadik)){
					state.Board[i][j] = 'K';
				}else{
					if(o.mit == 0 && i == o.hanyadik){
						state.Board[i][j] = 'P';
					}
				}
				
				if((state.Board[i][j] == 'P') && (o.mit == 1) && (j == o.hanyadik)){
					state.Board[i][j] = 'K';
				}else{
					if(o.mit == 1 && j == o.hanyadik){
						state.Board[i][j] = 'P';
					}
				}
			}
		}
		return state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hanyadik;
		result = prime * result + mit;
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
		Operator other = (Operator) obj;
		if (hanyadik != other.hanyadik)
			return false;
		if (mit != other.mit)
			return false;
		return true;
	}
	
	
}