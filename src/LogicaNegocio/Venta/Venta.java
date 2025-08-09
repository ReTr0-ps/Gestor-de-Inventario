package LogicaNegocio.Venta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import LogicaNegocio.Producto;

public class Venta {

	private LocalDateTime fecha;
	private int idVenta;
	private float total;
	private float subtotal;
	private float descuento;
	private float efectivo;
	private float cambio;
	public ArrayList<ProductoVenta> productos;

	public Venta(LocalDateTime fecha, ArrayList<ProductoVenta> productos, float subtotal, float total, float descuento,
			float efectivo, float cambio) {
		this.fecha = fecha;
		this.productos = productos;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
		this.efectivo = efectivo; 
		this.cambio = cambio;
	}
	
	//Constructor sobrecargado
	public Venta(LocalDateTime fecha, ArrayList<ProductoVenta> productos, float subtotal, float total) {
		this.fecha = fecha;
		this.productos = productos;
		this.subtotal = subtotal;
		this.descuento = 0;
		this.total = total;
		this.efectivo = 0; 
	}

	public float getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	public float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	public float getEfectivo() {
		return efectivo;
	}
	
	public void setEfectivo(float efectivo) {
		this.efectivo = efectivo;
	}
	
	public float getCambio() {
		return cambio;
	}
	
	public void setCambio(float cambio) {
		this.cambio = cambio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
