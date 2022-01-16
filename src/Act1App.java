/**
 * @author Jordi Ribellas
 */
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act1App {
	
	static Hashtable<String,String> alumnoNota = new Hashtable<String,String>();
	static int totalAlumnos=0;
	
	public static void main(String[] args) {
		
		int opcio=0;
		
		do {
			String res = JOptionPane.showInputDialog("Que quieres hacer?\n1-Introducir el nombre de un alumno\n2-Mostrar alumnos y notas\n3-Salir");
			opcio = Integer.parseInt(res);
			
			switch(opcio) {
			case 1:
				listaAlumnos();
			break;
			case 2:
				mostrarAlumnos();
			break;
			case 3:
				break;
			}
		}while(opcio!=3);
	}
	
	public static void listaAlumnos() {
		
		//En esta funcion meteremos los nombres de los alumnos sus notas y sus medias
	
		double media=0, nota=0, suma=0, i=0;
		String nombre = JOptionPane.showInputDialog("Como se llama el alumno?"); //Pedimos el nombre del alumno
		
		do {
			
			String n = JOptionPane.showInputDialog("Nota del alumno (Para salir introduce 0)"); // introducimos la nota del mismo
			alumnoNota.put(nombre, n); //metemos la nota al alumno indicado antes del do while
			nota = Double.parseDouble(n); //Canviamos nota de string a double
			suma=suma+nota; //sumamos todas las notas
			i++; //calculamos cuantas notas introduce
			
		}while(nota!=0);
		i--;
		media = suma/i; // calculamos la media
		String mediaS = String.valueOf(media); //pasamos la media a String
		alumnoNota.put(nombre, mediaS);
		
		totalAlumnos ++;
		
	}

	public static void mostrarAlumnos() {
		//En esta funcion mostraremos el nombre de los alumnos con sus medias
		
		System.out.println("Alumno - Nota");
		
		for(String i : alumnoNota.keySet()) {	
			System.out.println(i + " - " + alumnoNota.get(i));
			
		}
		
	}
}
