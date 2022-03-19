public class ListeL<T> {
	
	static class ElementL<E> {
		
		@SuppressWarnings("unused")
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
	
	public ElementL<T> insert(T o, ElementL<T> pred) {
		
		ElementL<T> newEl = new ElementL<T>(o);
		if (pred == null) {
			newEl.next = head;
			head = newEl;
		} else {
			newEl.next = pred.next;
			pred.next = newEl;
		}
		return newEl;
	}
	
	public void remove(ElementL<T> pred) {
		
		if(pred == null && head != null) {
			head = head.next;
		} else if(pred.next != null) {
			pred.next = pred.next.next;
		}
		
	}

}
