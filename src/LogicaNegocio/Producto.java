package LogicaNegocio;

public class Producto  {

	private int idProducto,stock;
	private float precio;
	private String nombre;
	

	
	public Producto(int idProducto, String nombre) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
	}

	public Producto(int idProducto, int stock,
			float precio, String nombre) {
		//super(id, nombreUsuario, contrasena, nivelDeAcceso);
		this.idProducto = idProducto;
		this.stock = stock;
		this.precio = precio;
		this.nombre = nombre;
	}
	
	//SObrecarga sin stok
	public Producto(int idProducto, float precio, String nombre) {
		
		this.idProducto = idProducto;
		this.precio = precio;
		this.nombre = nombre;
	}


	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	

	
}