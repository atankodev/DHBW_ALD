public class ListeF<T> {

	private T[] element;
    private int lastIndex;

    @SuppressWarnings("unchecked")
	public ListeF (int len) {
        element = (T[]) new Object[len];
        lastIndex = -1;
    }

    public void insert(T o) {
        if(lastIndex == element.length - 1) {
            throw new RuntimeException("Liste ist bereits voll");
        } else {
            lastIndex ++;
            element[lastIndex] = o;
        }
    }

    public void instert(T o, int k) {
        if(lastIndex == element.length - 1) {
            throw new RuntimeException("Liste ist bereits voll");
        }
        if(k < 0 || k >= element.length) {
            throw new RuntimeException("Position ausserhalb des Listenbereichs");
        } 
        if(k > lastIndex) {
            insert(o);
        } else {
            lastIndex++;
            for(int i = lastIndex; i > k; i--) {
                element[i] = element[i-1];
            }
            element[k] = o;
        }  
    }

    public void remove(int k) {
        if(k < 0 || k >= element.length) {
            throw new RuntimeException("Ungueltige Position");
        } 
        if(k <= lastIndex){
            for(int i = k; i < lastIndex; i++) {
                element[i] = element[i + 1];
            }
            element[lastIndex] = null;
            lastIndex--;
        }  
    }
	
}
