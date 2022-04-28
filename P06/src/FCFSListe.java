import java.util.LinkedList;

public class FCFSListe implements WarteSchlange {
	
	//private LinkedList<ZPatient> list = new LinkedList<ZPatient>();
	
	private ZPatient anfang;
	private ZPatient ende;

	public static void main(String[] args) {
		
		FCFSListe fcfsListe = new FCFSListe();
		ZArztPraxis.warteZimmer(fcfsListe);

	}

	@Override
	public void anmelden(ZPatient p) {
		
		if (anfang == null) {
			anfang = p;
			ende = p;
		} else {
			ende.next = p;
			ende = p;
		}
		
	}

	@Override
	public ZPatient derNaechsteBitte() {
		
		ZPatient help = anfang;
		
		if(anfang != null) {
			anfang = anfang.next;
		}
		
		return help;
	}

}
