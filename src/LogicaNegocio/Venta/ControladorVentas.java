package LogicaNegocio.Venta;

import java.util.PriorityQueue;

import javax.swing.JOptionPane;

import BasesDatos.BD;
import LogicaNegocio.*;


public class ControladorVentas implements IControlador<Venta>{
	
	static PriorityQueue<Venta> listaVentas = new PriorityQueue<>();

	@Override
	public void agregar(Venta parametro) {
	/*	String nombre = parametro.get);
		 int idVenta = parametro.getIdProducto();
		 int stock = prod.getStock();
		 float cambio = parametro.getcambio();
		
		 // Formatear la consulta SQL
		    String query = "INSERT INTO Productos (idProductos, Nombre_Producto, Precio, Stock) VALUES ("
		            + idProducto + ", '" + nombre + "', " + precio + ", " + stock + ")";
		    
		    // Ejecutar la consulta
		    BD.realizarUpdate(query);*/
		
		JOptionPane.showMessageDialog(null, "Se agregó correctamente la venta");
	}

	@Override
	public void eliminar(Venta parametro) {
		/*	String nombre = parametro.get);
		 int idVenta = parametro.getIdProducto();
		 int stock = prod.getStock();
		 float cambio = parametro.getcambio();
		
		 // Formatear la consulta SQL
		    String query = "INSERT INTO Productos (idProductos, Nombre_Producto, Precio, Stock) VALUES ("
		            + idProducto + ", '" + nombre + "', " + precio + ", " + stock + ")";
		    
		    // Ejecutar la consulta
		    BD.realizarUpdate(query);*/

		JOptionPane.showMessageDialog(null, "Registro de venta eliminada");
	}

	@Override
	public void actualizar(Venta parametro, Venta parametro2) {
		/*	String nombre = parametro.get);
		 int idVenta = parametro.getIdProducto();
		 int stock = prod.getStock();
		 float cambio = parametro.getcambio();
		
		 // Formatear la consulta SQL
		    String query = "INSERT INTO Productos (idProductos, Nombre_Producto, Precio, Stock) VALUES ("
		            + idProducto + ", '" + nombre + "', " + precio + ", " + stock + ")";
		    
		    // Ejecutar la consulta
		    BD.realizarUpdate(query);*/
		
		JOptionPane.showMessageDialog(null, "Actualizado correctamente");
	}

	
}
