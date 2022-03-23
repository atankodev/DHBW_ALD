import java.lang.reflect.AnnotatedArrayType;

public class ArrayRing<T> {
	
	private T[] ringarray;
	private int first;
	private int count;
	
	public ArrayRing(int len) {
		
		ringarray = (T[]) new Object[len];
		count = 0;
		first = -1;
		
	}
	
	public void insert(T in) {
		
		if(first == -1) {
			
			first = 0;
			count++;
			ringarray[0] = in;
			
		} else if(count < ringarray.length) {
			
			int pos = (first+count) % ringarray.length;
			count++;
			ringarray[pos] = in;
			
		} else {
			throw new ArrayIndexOutOfBoundsException("Liste voll!");
		}
		
	}
	
	public void remove() {
		
		if(first == -1) {
			throw new ArrayIndexOutOfBoundsException("Liste hat keine Elemente");
		} else {
			ringarray[first] = null;
			count--;
			if(count < 1) {
				first = -1;
			} else {
				first = (first+1)%ringarray.length;	
			}
		}
		
	}
	
	public String basictoString() {
		
		String string = "";
		
		for(int i = 0; i < ringarray.length; i++) {
			if(ringarray[i] == null) {
				string = string + "n";
			} else {
				string = string + ringarray[i].toString();
			}
			
		}
		
		return string;
		
	}
	
	public String toString() {
		
		String string = "";
		
		for(int i = first; i < first+count; i++) {
			if(ringarray[i%ringarray.length] == null) {
				string = string + "n";
			} else {
				string = string + ringarray[i%ringarray.length].toString();
			}
		}
		
		return string;
		
	}

	public static void main(String[] args) {
		
		ArrayRing<String> ar = new ArrayRing<String>(5);
		
		ar.insert("1");
		ar.insert("2");
		ar.insert("3");
		ar.insert("4");
		ar.insert("5");
		ar.remove();
		ar.remove();
		ar.insert("6");
		ar.insert("7");
		ar.remove();
		ar.remove();
		
		System.out.println(ar.basictoString());
		System.out.println(ar.toString());

	}

}
