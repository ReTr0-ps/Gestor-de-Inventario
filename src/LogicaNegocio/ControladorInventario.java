package LogicaNegocio;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

import BasesDatos.BD;

public class ControladorInventario implements IControlador<Producto> {

	
	
	//comparador 
	
	static Comparator<Producto> comparadorprod = new Comparator<Producto>() {

		@Override
		public int compare(Producto p1, Producto p2) {

			return Integer.compare(p1.getIdProducto(), p2.getIdProducto());
		}
	};
	
	//lista de productos
		static PriorityQueue<Producto> ListaprodInventario = new PriorityQueue<>(comparadorprod);
	
	//Metodos
	
	//lista de productos
	public static void CargarProductosBD() {
		ListaprodInventario.clear();
		
		ResultSet productsRS = BD.realizarQuery("SELECT * FROM Productos");
		
		try {
			 int idProducto,stock;
			 float precio;
			 String nombre;
			 
			 while (productsRS.next()) {
				//Se obtienen los datos del resulset de la BBDD
				 idProducto = productsRS.getInt("idProductos");
				 nombre = productsRS.getString("Nombre_Producto");
				 precio = productsRS.getFloat("Precio");
				 stock = productsRS.getInt("Stock");
				 
				 Producto product = new Producto (idProducto, stock, precio, nombre);

				 ListaprodInventario.add(product);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
	
	@Override	
	public void agregar(Producto prod) {
		 String nombre = prod.getNombre();
		 int idProducto = prod.getIdProducto();
		 int stock = prod.getStock();
		 float precio = prod.getPrecio();
		
		 
		//BD.realizarUpdate("INSERT INTO Productos (`idProductos`, `Nombre_Producto`, `Precio`, `Stock`) VALUES ('"+ prod.getIdProducto() +"', '" + prod.getNombre() +"', '" + prod.getPrecio()+"', " +prod.getStock());
		//BD.realizarUpdate("INSERT INTO Productos (`idProductos`, `Nombre_Producto`, `Precio`, `Stock`) VALUES ('"+ idProducto +"', '" + nombre +"', '" + precio +"', '" + stock);
		
		 // Formatear la consulta SQL
		    String query = "INSERT INTO Productos (idProductos, Nombre_Producto, Precio, Stock) VALUES ("
		            + idProducto + ", '" + nombre + "', " + precio + ", " + stock + ")";
		    
		    // Ejecutar la consulta
		    BD.realizarUpdate(query);
	}
	
	 public void AgregarNuevoProducto(Producto prod) {
		
		 		 
		 String nombre = prod.getNombre();
		 int idProducto = prod.getIdProducto();
		 int stock = prod.getStock();
		 float precio = prod.getPrecio();
		 
		BD.realizarUpdate("INSERT INTO Productos (`idProductos`, `Nombre_Producto`, `Precio`, `Stock`) VALUES ('"+ idProducto +"', '" + nombre +"', '" + precio +"', '" + stock);

	}
	@Override
	 public void actualizar(Producto productoViejo, Producto productoNuevo) {
		String nombre = productoNuevo.getNombre();
		 int stock = productoNuevo.getStock();
		 float precio = productoNuevo.getPrecio();
		 
		 BD.realizarUpdate("UPDATE Productos SET Nombre_Producto = '"+nombre+"', Precio = '"+precio+"',  Stock = '"+stock+"'  WHERE idProductos = " + productoViejo.getIdProducto());
	}
	
	static public void VerificarExistencia(Producto prod) {
		try {
			
		
		if (prod.getStock() <= 0) {
			JOptionPane.showMessageDialog(null, "No hay articulo seleccionado disponible!");
		}
		else {
			JOptionPane.showConfirmDialog(null, "Existe el producto seleccionado, la cantidad es = " + prod.getStock());
		}
		
		} catch (Exception e) {
				System.out.println(e);
			}
		
	}

	@Override
	 public void eliminar(Producto prod) {
		
		int idproducto = prod.getIdProducto();
		
		BD.realizarUpdate("DELETE FROM Productos WHERE idProductos = " + idproducto);
		
	}
	
	//Get Lista
	public static PriorityQueue<Producto> getLista() {
		return ListaprodInventario;
	}

	// Método para buscar un producto por ID
    public Producto buscarProductoPorID(int id) {
        for (Producto producto : ListaprodInventario) {
            if (producto.getIdProducto() == id) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }
}