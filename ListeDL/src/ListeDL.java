
public class ListeDL<T> {

	private static class ElementDL<E> {
		private E element; // Inhalt des Listenelements
		private ElementDL<E> next; // Verweis auf den Nachfolger
		private ElementDL<E> prev; // Verweis auf den Vorg�nger

		public ElementDL(E o) {
			element = o;
			next = null;
			prev = null;
		}
	}

	private ElementDL<T> head; // Referenz auf den Anfang der Liste
	private ElementDL<T> tail; // Referenz auf das Ende der Liste

	public ListeDL() {
		head = null;
		tail = null;
	}

	public ListeDL(T o) {
		head = new ElementDL<T>(o);
		tail = head;
	}

// NOCH NICHT FERTIG!!!

	// Methode, um o am Ende einzuf�gen
	public ElementDL<T> insert(T o) {
		ElementDL<T> newEl = new ElementDL<T>(o);
		if (head == null) {
			head = tail = newEl;
		} else {
			tail.next = newEl;
			newEl.prev = tail;
			tail = newEl;
		}
		return tail;
	}

	// Methode, um o an der Postion pos einf�gen
	public ElementDL<T> insert(T o, ElementDL<T> pos) {
		ElementDL<T> newEl = new ElementDL<T>(o);

		if (pos.prev == null) {

			head.prev = newEl;
			newEl.next = head;
			head = newEl;

		} else {

			newEl.next = pos;
			pos.prev.next = newEl;
			newEl.prev = pos.prev;
			pos.prev = newEl;

		}

		return newEl;
	}

	// Element e l�schen
	public void remove(ElementDL<T> e) {

		if (e == head) {
			head = e.next;
			head.prev = null;
		} else if (e == tail) {
			tail = e.prev;
			tail.next = null;
		} else {
			e.prev.next = e.next;
			e.next.prev = e.prev;
		}

	}

	public String toString() {
		String s = "(";
		ElementDL<T> help = head;
		while (help != null && help.next != null) {
			s = s + help.element + ", ";
			help = help.next;
		}
		if (help != null)
			s = s + help.element;
		return s + ")";
	}

	// Test

	public static void main(String[] args) {
		ListeDL<Integer> l = new ListeDL<Integer>();
		l.insert(new Integer(0));
		ElementDL<Integer> eins = l.insert(new Integer(1));
		l.insert(new Integer(3));
		System.out.println(l);
		l.insert(new Integer(2), eins); // vor eins einf�gen
		System.out.println(l);
		l.remove(eins); // Nachfolger von eins l�schen
		System.out.println(l);
	}

}
