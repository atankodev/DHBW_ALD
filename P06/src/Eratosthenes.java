import java.util.*;

public class Eratosthenes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bitte n eingeben: ");
		int n = scanner.nextInt();
		scanner.close();
		
		Collection<Integer> tIntegers = new HashSet<Integer>();
		
		for(int i = 2; i <= n; i++) {
			tIntegers.add(i);
		}
		
		Collection<Integer> sIntegers = new HashSet<Integer>();
		
		int p = 2;
		
		do {
			
			for(int i = 2; i*p <= n; i++) {
				sIntegers.add(p*i);
			}
			
			if(p == 2) {
				p = 3;
			} else {
				do {
					p = p + 2;
				} while(sIntegers.contains(p));
			}
			
			
		} while(p*p <= n);
		
		tIntegers.removeAll(sIntegers);
		
		Iterator<Integer> it = tIntegers.iterator();
		
		while (it.hasNext()) {
			for(int i = 0; i < 10 && it.hasNext(); i++) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}

	}

}
