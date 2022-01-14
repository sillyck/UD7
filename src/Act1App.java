
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act1App {
	
	static ArrayList<String> alumnos = new ArrayList<>();
	static Hashtable<String,String> alumnoNota = new Hashtable<String,String>();
	
	public static void main(String[] args) {
		
		String res = JOptionPane.showInputDialog("Que quieres hacer?\n1-Introducir el nombre de un alumno\n2-Introducir notas\n3-Salir");
		int opcio = Integer.parseInt(res);
		
		switch(opcio) {
		case 1:
			listaAlumnos();
		break;
		case 2:
			notasAlumnos();
		break;
		case 3:
			break;
		}

	}
	
	public static void listaAlumnos() {
			
			int nota=0;
			String nombre = JOptionPane.showInputDialog("Como se llama el alumno?");
			
			do {
				String n = JOptionPane.showInputDialog("Nota del alumno");
				alumnoNota.put(nombre, n);
				nota = Integer.parseInt(n);
				
			}while(nota!=0);
			
	}

	public static void notasAlumnos() {
		/*String res = JOptionPane.showInputDialog("A que alumno le quieres poner nota?");
		do {
			String nota = JOptionPane.showInputDialog("Quina ");
			
		}while(nota!="0");*/
	}
}
