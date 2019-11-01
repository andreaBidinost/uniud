package uniud.lombok;

public class User {
	public static void main(String[] args) {
		Quadro q = new Quadro();
		Persona p = new Persona("Pippo", "Pluto");
		
		q.setPittore(p);
		
		System.out.println(q.toString());
	}
}
