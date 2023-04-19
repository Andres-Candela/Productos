import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Procesos {
	
	ArrayList<Double> total = new ArrayList<Double>();
	Double precioTotal;
	String Precio;
	double PrTot;
	String tot;
	int Cant;

	public void comprar(JTextField campoNomProducto, JTextField campoCodigo, JTextField campoCantidad, JTextField campoPrecio, Hashtable<String, Persona> clientes, JTextArea resultado) {
		Persona miPersona = new Persona();
//		PrecioTotal miPrecioTotal = new PrecioTotal();
		String Nombre = campoNomProducto.getText();
		String Codigo = campoCodigo.getText();
		String Cantidad = campoCantidad.getText();
		Precio = campoPrecio.getText();
		precioTotal = Double.parseDouble(Precio);
		Cant = Integer.parseInt(Cantidad);
		PrTot = precioTotal * Cant;
		tot= String.valueOf(PrTot);
		
		miPersona.setNombrepro(Nombre);
		miPersona.setCodigo(Codigo);
		miPersona.setCantidad(Cantidad);
		miPersona.setPrecio(Precio);
//		PrecioTotal.setprecioTotal(precioTotal);
		total.add(precioTotal);
		
		if (clientes.containsKey(miPersona.getCodigo())==false) {
			clientes.put(miPersona.getCodigo(),miPersona);
			JOptionPane.showMessageDialog(null, "¡Compra Exitosa!");
			JOptionPane.showMessageDialog(null, "Su total a pagar de la compra es: "+ tot);
		}else{
			JOptionPane.showMessageDialog(null, "La compra ya existe!!!","Advertencia",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void mostrar(Hashtable<String, Persona> clientes, JTextArea resultado) {
		
		if (clientes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "¡No Hay Compras Realizadas!");
		}else {
			resultado.setText(clientes.toString());
		}
	}	
}
