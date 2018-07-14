import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int itr = 1;
		Scanner sc = new Scanner(System.in);
		while(true) {
			int t = sc.nextInt();
			if(t == 0) {
				break;
			}
			System.out.println("Scenario #" + itr);
			itr++;
			
			HashMap<Integer, Integer> people = new HashMap<Integer, Integer>();
			LinkedList<Integer> queue = new LinkedList<Integer>(); 
			HashMap<Integer, LinkedList<Integer>> team = new HashMap<Integer, LinkedList<Integer>>(); 
			
			for(int i = 0; i < t; ++i) {
				int n = sc.nextInt();
				for(int j = 0; j < n; j++) {
					people.put(sc.nextInt(), i);
				}
				team.put(i, new LinkedList<Integer>());
			}
			
			while(true) {
				String choice=sc.next();
				if(choice.equals("STOP")) {
					break;
				}else if(choice.equals("ENQUEUE")) {
					int person_id = sc.nextInt();
					int team_id = people.get(person_id);
					if(team.get(team_id).isEmpty()) {
						queue.add(team_id);
					}
					team.get(team_id).add(person_id);
				}else {
					while(queue.size() != 0 && team.get(queue.get(0)).size() == 0) {
						queue.removeFirst();
					}
					if(queue.size() != 0) {
						System.out.println(team.get(queue.get(0)).removeFirst());
					}
				}
			}
			
			System.out.println();
		}
	}
}
