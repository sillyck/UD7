/**
 * @author Jordi Ribellas
 */

import java.util.Hashtable;
import javax.swing.JOptionPane;
public class Act2App {

	static double precioSIVA=0, precioIVA=0, precioTotalSIVA=0, precioTotalIVA=0, cambio=0;
	static String IVA;
	
	public static void main(String[] args) {
		
		int cont=0;
		
		Hashtable<String, Double> caja = new Hashtable<String,Double>(); //este es el diccionaria del pondremos el id del producto y el precio
		
		caja.put("260100", 20.00);
		caja.put("260101", 15.00);
		caja.put("260102", 1.50);
		caja.put("260103", 2.00);
		caja.put("260104", 7.25);
		caja.put("260105", 17.99);
		
		String quantS = JOptionPane.showInputDialog("Quantos productos diferentes lleva en el carro de la compra?");
		int cantTotal = Integer.parseInt(quantS);
		
		do {
			
			String cod = JOptionPane.showInputDialog("Cual es el codigo del producto que ha comprado?");
			String cant = JOptionPane.showInputDialog("Y quantos lleva?");
			int quant = Integer.parseInt(cant);
			
			precioSIVA = calcularPrecio(caja, cod, quant);
			
			precioTotalSIVA += precioSIVA;
			
			String IVA = JOptionPane.showInputDialog("Que IVA tiene el el producto introducido?\n1 - 21%\n2 - 4%");
			
			precioIVA = calcularIVA(precioSIVA, IVA);
			
			precioTotalIVA += precioIVA;
			
			cont++;
		}while(cont!=cantTotal);
		
		System.out.println("Usted ha comprado un total de " + cont + " articulo/s");
		System.out.println("El precio total sin IVA es de " + precioSIVA);
		System.out.println("El precio total con IVA es de " + precioIVA);
		
		String cantPag = JOptionPane.showInputDialog("Usted tiene que pagar " + precioIVA + "€ cuanto va a pagar?");
		double pagado = Double.valueOf(cantPag);
		
		cambio = cambioPag(pagado, precioIVA);
		
		System.out.println("El cambio es de " + cambio + "€");
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
	
	public static double calcularIVA(double precio, String IVA) {
		double resultado = 0;
		
		if(IVA == "1") {
			resultado = precio + (precio * 0.21);
		}else {
			resultado = precio + (precio * 0.04);
		}
		
		return resultado;
	}
	
	public static double cambioPag(double pagado, double precioIVA) {
		double cambio=0;
		
		cambio = pagado - precioIVA;
		
		return cambio;
	}
	
}
