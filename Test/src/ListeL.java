public class ListeL<T> {
	
	static class ElementL<E> {
		
		private E element;
		private ElementL<E> next;
		
		public ElementL (E o) {
			element = o;
			next = null;
		}
		
	}
	
	private ElementL<T> head;
	
	public ListeL() {
		head = null;
	}
	
	public ElementL<T> insert(T o) {
		
		ElementL<T> newEl = new ElementL<T>(o);
		if(head == null) {
			head = newEl;
		} else {
			newEl.next = head;
			head = newEl;
		}
		return newEl;
		
	}

}
