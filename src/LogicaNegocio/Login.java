package LogicaNegocio;

import java.util.Optional;

import javax.swing.JFrame;

import GUI.AdminitradorUI;
import GUI.CajeroUI;
import GUI.GestorInventarioUI;

public class Login {

	
	public static boolean validarSesion(String user, String pass) {
		
		boolean accesoValidado;
		
		//Buscar el usuario en la lista de usuarios a travez de la lamda
		Optional<Usuario> usuario = ControladorUsuarios.listaUsuarios.stream().filter(us -> us.getNombre().equals(user)).findFirst();
		
		if(!usuario.isEmpty()) {
			//Si el usuario existe (no está vacío)
			
			
			if(pass.equals(usuario.get().getContrasena())) {
				
				accesoValidado = true;
				
			}else {
				accesoValidado = false;
			}
			
		}else {
			//Si el usuario no existe
			accesoValidado = false;
		}
			
		return accesoValidado;
	}
	
	public static Optional<Usuario> ObtenerInfoUsuario(String user){
		return ControladorUsuarios.listaUsuarios.stream().filter(us -> us.getNombre().equals(user)).findFirst();
	}
	
	public static void VentanaCorrespondiente(Usuario usuario) {
		JFrame Ventana = null;
		switch (usuario.getNivelDeAcceso()) {
		case 1:
			Ventana = new CajeroUI();
			break;
		case 2:
			Ventana = new GestorInventarioUI();
			break;
		case 3:
			Ventana = new AdminitradorUI();
			break;
		default:
			System.out.println("Nivel de acceso no existe");
			break;
		}
		Ventana.setVisible(true);
	}
}
