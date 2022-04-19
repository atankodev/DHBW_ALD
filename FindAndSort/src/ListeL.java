public class ListeL<I extends Comparable<I>> {

	static class ElementL<K> {
		private K inhalt; // Inhalt des Listenelements
		private ElementL<K> next; // Verweis auf den Nachfolger

		public ElementL(K o) {
			inhalt = o;
			next = null;
		}
	}

	private ElementL<I> head; // Referenz auf den Anfang der Liste

	public ListeL() {
		head = null;
	}

	public ListeL(I o) {
		head = new ElementL<I>(o);
	}

	public ElementL<I> insert(I o) { // am Anfang einfuegen
		ElementL<I> newEl = new ElementL<I>(o);
		if (head == null) { // Liste ist noch leer
			head = newEl;
		} else {
			newEl.next = head;
			head = newEl;
		}
		return newEl;
	}

	public ElementL<I> insert(I o, ElementL<I> pred) { // nach pred (Vorgaenger) einfuegen
		ElementL<I> newEl = new ElementL<I>(o);
		if (pred == null) { // am Anfang einfuegen
			newEl.next = head;
			head = newEl;
		} else { // nach pred (Vorgaenger) einfuegen
			newEl.next = pred.next;
			pred.next = newEl;
		}
		return newEl;
	}

	public int find1(I o) {

		ElementL<I> findEl = head;
		int pos = 0;

		while (findEl.next != null) {
			if (findEl.inhalt.equals(o)) {
				return pos;
			}
			findEl = findEl.next;
			pos++;
		}
		return -1;

	}

	public void sort1() {

		ElementL<I> pos = head;

		while (pos != null) {

			ElementL<I> min = pos;
			ElementL<I> help = pos.next;

			while (help != null) {

				if (help.inhalt.compareTo(min.inhalt) < 0) {
					min = help;
				}

				help = help.next;

			}

			I temp = pos.inhalt;
			pos.inhalt = min.inhalt;
			min.inhalt = temp;

			pos = pos.next;
		}

	}

	public void sort2() {

		ElementL<I> pos = head;

		while (pos != null) {

			ElementL<I> help = pos;

			while (help.next != null) {

				if (help.inhalt.compareTo(help.next.inhalt) > 0) {

					I temp = help.next.inhalt;
					help.next.inhalt = help.inhalt;
					help.inhalt = temp;

				}

				help = help.next;

			}

			pos = pos.next;

		}

	}

	public void sort22() {

		ElementL<I> help = head;
		boolean getauscht = true;

		while (getauscht) {

			getauscht = false;

			while (help.next != null) {

				if (help.inhalt.compareTo(help.next.inhalt) > 0) {

					I temp = help.next.inhalt;
					help.next.inhalt = help.inhalt;
					help.inhalt = temp;
					getauscht = true;

				}

				help = help.next;

			}

		}

	}

	public ElementL<I> insertBefore(I o, ElementL<I> suc) {
		ElementL<I> newEl = new ElementL<I>(o);
		ElementL<I> help = head;
		ElementL<I> before = head;

		if (suc == head) {
			newEl.next = head;
			head = newEl;
		} else {
			while (help != suc) {
				before = help;
				help = help.next;
			}
			newEl.next = help;
			before.next = newEl;
		}

		return newEl;
	}

	public void remove(ElementL<I> pred) { // Element nach pred (Vorg�nger) l�schen
		if (pred == null) // erstes Element l�schen
			head = head.next;
		else if (pred.next != null) // Element nach pred (Vorg�nger) l�schen
			pred.next = pred.next.next;
	}

	public String toString() {
		String s = "(";
		ElementL<I> help = head;
		while (help != null && help.next != null) {
			s = s + help.inhalt + ", ";
			help = help.next;
		}
		if (help != null)
			s = s + help.inhalt;
		return s + ")";
	}

	// Test

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		ListeL<Integer> l = new ListeL<Integer>();
		ElementL<Integer> nul = l.insert(new Integer(0));
		ElementL<Integer> eins = l.insert(new Integer(1));
		ElementL<Integer> drei = l.insert(new Integer(3));
		l.insert(new Integer(6));
		l.insert(new Integer(4));
		l.insert(new Integer(7));
		l.insert(new Integer(9));
		l.insert(new Integer(0));
		l.insert(new Integer(8));
		l.insert(new Integer(1));
		System.out.println(l);
		l.insertBefore(5, drei); // vor eins einf�gen
		l.insertBefore(0, drei);
		System.out.println(l);
		l.remove(eins); // Nachfolger von eins l�schen
		System.out.println(l);
		l.sort1();
		System.out.println(l);
		l.sort22();
		System.out.println(l);
	}

}
