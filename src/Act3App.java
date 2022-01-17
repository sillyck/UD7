/**
 * @author Jordi Ribellas
 */
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act3App {
		
	public static void main(String[] args) {
		
		String respuesta;
		int opcion;
		
		
		Hashtable<String, Double> stock = new Hashtable<String,Double>(); //este es el diccionaria del pondremos el id del producto y el precio
		
		stock.put("zapatos", 20.00);
		stock.put("chanclas", 15.00);
		stock.put("calcetines", 25.00);
		stock.put("medias", 30.00);
		stock.put("zapatilla", 50.00);
		stock.put("sombrero", 10.00);
		stock.put("bufanda", 20.00);
		stock.put("guantes", 40.00);
		stock.put("sudadera", 60.00);
		stock.put("pantalones", 60.00);
		
		do {
			
			respuesta = JOptionPane.showInputDialog("Que quieres hacer?\n1- Introducir elemento\n2- Listar uno o varios elementos\n3- Salir");
			opcion = Integer.parseInt(respuesta);
			
			switch(opcion) {
			
			case 1:
				introElem(stock);
			break;
			case 2:
				String unoVar = JOptionPane.showInputDialog("Uno o varios?");
				
				if(unoVar.equals("uno")) {
					String art = JOptionPane.showInputDialog("Cual quieres mostrar?");
					
					listarUno(art, stock);
					
				}else{
					listarTodos(stock);
					
				}
				
			case 3:
				break;
			
			}
		
		}while(opcion!=3);
		
	}
	
	public static void introElem(Hashtable<String,Double> stock) {
		String articulo, valor;
		double cantidad;
		
		articulo = JOptionPane.showInputDialog("Como se llama el objeto que quere introducir? (introduce 0 para salir)");
		valor = JOptionPane.showInputDialog("Y que cantidad hay de este articulo?");
		cantidad = Double.valueOf(valor);
		
		stock.put(articulo, cantidad);
	}
	
	public static void listarUno(String art ,Hashtable<String,Double> almacen) {
		
		System.out.println("Objeto - Cantidad");
		
		for(String i : almacen.keySet()) {
			if(i.equals(art)) {
				System.out.println(i + " - " + almacen.get(i));
			}
		}
	}

	public static void listarTodos(Hashtable<String,Double> almacen) {
		
		System.out.println("Objeto - Cantidad");
		
		for(String i : almacen.keySet()) {
				System.out.println(i + " - " + almacen.get(i));
		}
	}
}
