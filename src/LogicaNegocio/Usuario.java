package LogicaNegocio;


public abstract class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private int nivelDeAcceso;
	
	//Constructor
	public Usuario(int id, String nombre, String contrasena, int nivelDeAcceso) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.nivelDeAcceso = nivelDeAcceso;
	}
	
	//Getters

		public int getId() {
			return id;
		}
		
		public String getNombre() {
			return nombre;
		}

		public String getContrasena() {
			return contrasena;
		}

		public int getNivelDeAcceso() {
			return nivelDeAcceso;
		}
		
	//Setters
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		
		public void setNivelDeAcceso(int nivelDeAcceso) {
		    this.nivelDeAcceso = nivelDeAcceso;
			}
}


