/**
 * @author Jordi Ribellas
 */
import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act4App {

	static double precio=0, precioIVA=0, precioSIVA=0, totalSinIVA=0, totalConIVA=0, resultado=0, cambio=0;
	
	public static void main(String[] args) {
		
		String respuesta;
		int opcion;
		
		
		Hashtable<String, Double> stock = new Hashtable<String,Double>(); //diccionario del inventario
		
		stock.put("zapatos", 50.80); // producto - precio
		stock.put("chanclas", 20.99);
		stock.put("calcetines", 2.99);
		stock.put("medias", 4.89);
		stock.put("zapatilla", 10.99);
		stock.put("sombrero", 7.99);
		stock.put("bufanda", 4.99);
		stock.put("guantes", 8.00);
		stock.put("sudadera", 20.00);
		stock.put("pantalones", 15.00);
		
		do {
			
			respuesta = JOptionPane.showInputDialog("Que quieres hacer?\n1 - Introducir elemento\n2 - Listar uno o todos los elementos\n3 - Calcular el precio\n4 - Pagar\n5 - Salir");
			opcion = Integer.parseInt(respuesta);
			
			switch(opcion) {
			
			case 1:
				introElem(stock);
			break;
			case 2:
				String unoVar = JOptionPane.showInputDialog("Quieres mostrar uno o todos los productos?");
				
				if(unoVar.equals("uno")) {
					String art = JOptionPane.showInputDialog("Cual quieres mostrar?");
					
					listarUno(art, stock);
					
				}else{
					listarTodos(stock);
					
				}
			break;
			case 3:
				String que = JOptionPane.showInputDialog("Que lleva?");
				String cant = JOptionPane.showInputDialog("Y quantos lleva?");
				int quant = Integer.parseInt(cant);
				
				precioSIVA = calcularPrecio(stock, que, quant);
			
				totalSinIVA += precioSIVA;
				
				String IVA = JOptionPane.showInputDialog("De cuanto es el IVA?\n1- 21%\n2- 4%");
				
				precioIVA = calcularIVA(precioSIVA, IVA);
								
				totalConIVA += precioIVA;
				
				System.out.println("Producto - Precio");
				System.out.println(que + " " + precioIVA);
				
			break;
			
			case 4:
				String aPagar = JOptionPane.showInputDialog("El total serian " + totalConIVA + "€\nCuanto va a pagar?");
				int pagado = Integer.parseInt(aPagar);
				cambio = cambioPag(pagado, totalConIVA);
				
				JOptionPane.showMessageDialog(null, "El cambio es de: " + cambio + "€");
			
			break;
			
			case 5: //salir del do while
			break;
			
			}
		
		}while(opcion!=5);
		
	}

	//Aqui el usuario podra introducir elementos al diccionario
	public static void introElem(Hashtable<String,Double> stock) {
		String articulo, valor;
		double cantidad;
		
		articulo = JOptionPane.showInputDialog("Como se llama el producto que quere introducir?");
		valor = JOptionPane.showInputDialog("Y cuanto cuesta ese producto?");
		cantidad = Double.valueOf(valor);
		
		stock.put(articulo, cantidad);
	}
	
	//Aqui le mostrara el objeto deseado
	public static void listarUno(String art ,Hashtable<String,Double> almacen) {
		
		System.out.println("Objeto - Precio");
		
		for(String i : almacen.keySet()) {
			if(i.equals(art)) {
				System.out.println(i + " - " + almacen.get(i));
			}
		}
	}

	//Aqui muestra todos los objetos
	public static void listarTodos(Hashtable<String,Double> almacen) {
		
		System.out.println("Objeto - Cantidad");
		
		for(String i : almacen.keySet()) {
				System.out.println(i + " - " + almacen.get(i));
		}
	}
	
	//Calcularemos el precio del producto sin IVA
	public static double calcularPrecio(Hashtable<String,Double> almacen, String cod, int quant) { //Calculamos el precio sin IVA
		double precio=0;
		
		for(String i : almacen.keySet()) {
			if(i.equals(cod)) {
				precio = almacen.get(i);
				
			}		
		}
		precio = precio * quant;
		
		return precio;
	}
	
	//Calculamos el IVA del producto
	public static double calcularIVA(double precio, String IVA) {
		double resultado = 0;
		
		if(IVA == "1") {
			resultado = precio + (precio * 0.21);
		}else {
			resultado = precio + (precio * 0.04);
		}
		
		return resultado;
	}
	
	//Calculamos el cambio que daremos a la hora de pagar
	public static double cambioPag(double pagado, double precioTotalIVA) {
		double vuelta=0;
		
		vuelta = pagado - precioTotalIVA;
		
		return vuelta;
	}
	
	
}
