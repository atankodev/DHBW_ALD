import java.util.Collection;
import java.util.TreeSet;

public class Lottozahlen {

	public static void main(String[] args) {
		
		Collection<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size() < 7) {
			lotto.add((int) (Math.random()*49+1));
		}
		
		lotto.stream().forEach(System.out::println);

	}

}
