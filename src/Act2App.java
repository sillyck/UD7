/**
 * @author Jordi Ribellas
 */

import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act2App {

	static double precio=0, precioIVA=0, IVA=0;
	
	public static void main(String[] args) {
		
		int cont=0;
		
		Hashtable<String, Double> caja = new Hashtable<String,Double>(); //este es el diccionaria del pondremos el id del producto y el precio
		
		caja.put("260100", 20.00);
		caja.put("260101", 15.00);
		caja.put("260102", 1.50);
		caja.put("260103", 2.00);
		caja.put("260104", 7.25);
		caja.put("260105", 17.99);
		
		String quantS = JOptionPane.showInputDialog("Quantos productos lleva en el carro de la compra?");
		int cantTotal = Integer.parseInt(quantS);
		
		do {
			
			String cod = JOptionPane.showInputDialog("Cual es el codigo del producto que ha comprado?");
			String cant = JOptionPane.showInputDialog("Y quantos lleva?");
			int quant = Integer.parseInt(cant);
			
			calcularPrecio(caja, cod, quant);
			
			String IVAString = JOptionPane.showInputDialog("Que IVA tiene el el producto introducido?\n1 - 21%\n2 - 4%");
			IVA = Double.valueOf(IVAString);
			
			calcularIVA(precio, IVA);
			
			System.out.println(precioIVA);
			
			cont++;
		}while(cont!=cantTotal);
		
	}

	public static double calcularPrecio(Hashtable<String,Double> ref, String cod, int quant) { //Calculamos el precio sin IVA
		double precio=0;
		
		for(String i : ref.keySet()) {
			if(i.equals(cod)) {
				precio = ref.get(i);
				
			}		
		}
		precio = precio * quant;
		return precio;
		
	}
	
	public static double calcularIVA(double precio, double IVA) {
		
		if(IVA == 21.00) {
			precioIVA = precio + (precio * 21.00);
		}else {
			precioIVA = precio + (precio * 4.00);
		}
		
		return precioIVA;
	}
	
}
