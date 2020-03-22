import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Main {

	static boolean isGoalState(char[][] state){

		int numberOfK = 0;
		int numberOfP = 0;
	
	
		for(int i = 0; i<=3; i++){
			for(int j = 0; j <=3; j++){
				if(state[i][j] == 'P'){
					numberOfP++;
				}else{
					numberOfK++;
				}
			}
		}
	
		if((state[1][1] == 'K') && (state[1][2] == 'K') && (state[2][1] == 'K') && (state[2][2] == 'K') && (numberOfK == 4) && (numberOfP == 12)){
			return true;
		}
		return false;
	}

	
	static char kezdo[][] =  {{'P','P','P','P'},{'P','P','P','P'},{'P','P','P','P'},{'P','P','P','P'}};

	public static void main(String[] args) {
			State startState = new State(kezdo);

			
			List<Operator> operators = Arrays.asList(
				new Operator(0, 1),
				new Operator(1, 1),
				new Operator(2, 1),
				new Operator(3, 1),
				new Operator(0, 0),
				new Operator(1, 0),
				new Operator(2, 0),
				new Operator(3, 0)
			);
			Node actualNode = new Node(startState, null, null, new HashSet<Operator>());

			Set<State> testedStates = new HashSet<State>();
			
			while(true){
				actualNode.kiir();
				if(actualNode == null) {
					break;
				}
				
				System.out.println(actualNode);

				
				if(isGoalState(actualNode.getState().Board)) {
					break;
				}

				if(testedStates.contains(actualNode.getState()) ){
					actualNode = actualNode.getParent();
					System.out.println("vmi");
				}
				
				List<Operator> availableOperators = new LinkedList<>();
				
				for(int i = 0; i < operators.size(); i++) {
					if(operators.get(i).preconditionFulfilled(actualNode.getState())
							&&  ! actualNode.getUsedOperators().contains(operators.get(i)))
						availableOperators.add(operators.get(i));
				}


				if(availableOperators.size() > 0) {
					Operator operator = availableOperators.get(0);

					Node newNode = new Node();
					
					System.out.println();
					newNode.setState(operator.Flip(operator, actualNode.getState()));
					newNode.setParent(new Node(actualNode));
					Set<Operator> set = new HashSet<>();
					set.add(operator);
					newNode.setUsedOperators(set);
					newNode.setOperator(operator);
					actualNode = newNode;
					testedStates.add(actualNode.getState());
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				}
				else {
					actualNode = actualNode.getParent();
				}	
			}
				//actualNode.kiir();
			if(isGoalState(actualNode.getState().Board)) {
				System.out.println("Találtunk megoldást.");
				actualNode.kiir();
			}
			else {
				System.out.println("Keresek.");
			}
		
	}
}
