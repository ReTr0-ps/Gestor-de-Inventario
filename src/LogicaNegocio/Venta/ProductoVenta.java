package LogicaNegocio.Venta;

import LogicaNegocio.Producto;

public class ProductoVenta extends Producto {

	private int cantidad;
	private float precioTotal;
	
	public ProductoVenta(int idProducto, float precio, String nombre, int cantidad) {
		
		super(idProducto, precio, nombre);
		this.cantidad = cantidad;
		this.precioTotal = cantidad*precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		this.precioTotal = getPrecio() * cantidad;
		
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	
	

}
