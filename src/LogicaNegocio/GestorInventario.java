package LogicaNegocio;

public class GestorInventario extends Usuario{


	private String areaEncargada;
	
	//Constructor
	public GestorInventario(int id, String nombreUsuario, String contrasena, int nivelDeAcceso) {
		super(id, nombreUsuario, contrasena, nivelDeAcceso);
	}
	
	public void setAreaEncargada(String areaEncargada) {
		this.areaEncargada = areaEncargada;
	}
	
	public String getAreaEncargada() {
		return areaEncargada;
	}
	
	
	
}
