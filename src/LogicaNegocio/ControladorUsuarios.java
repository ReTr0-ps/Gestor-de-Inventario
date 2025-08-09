package LogicaNegocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import BasesDatos.BD;

public class ControladorUsuarios implements IControlador<Usuario> {

	// NIVELES DE ACCESO:
	// 1 = Cajero
	// 2 = GestorInventario
	// 3 = Administrador
	
	//Comparador de la Priority Queue
	static Comparator<Usuario> comparador = new Comparator<Usuario>() {

		@Override
		public int compare(Usuario o1, Usuario o2) {

			return Integer.compare(o1.getNivelDeAcceso(), o2.getNivelDeAcceso());
		}
	};

	// Lista de Usuarios
	static PriorityQueue<Usuario> listaUsuarios = new PriorityQueue<>(comparador);

	public static void cargarUsuariosBD() { // Cargar Usuarios de la BD

		listaUsuarios.clear();
		//Consulta a la base de datos almacenada en unResulset
		ResultSet usuariosRS = BD.realizarQuery("SELECT * FROM Usuarios");

		try {

			int id;
			String nombre;
			String contrasena;
			int nivelDeAcceso;

			while (usuariosRS.next()) {

				//Se van a obtener los datos del resulset (De la consulta de la base de datos)
				id = usuariosRS.getInt("idUsuario");
				nombre = usuariosRS.getString("nombre");
				contrasena = usuariosRS.getString("contrasena");
				nivelDeAcceso = usuariosRS.getInt("nivelAcceso");
		
				//Por nivel de acceso, se hará la instancia de un tipo de usuario
				switch (nivelDeAcceso) {
				case 1:
					Cajero cajero = new Cajero(id, nombre, contrasena, nivelDeAcceso);
					listaUsuarios.add(cajero);
					break;

				case 2:
					GestorInventario gestorInventario = new GestorInventario(id, nombre, contrasena, nivelDeAcceso);
					listaUsuarios.add(gestorInventario);
					break;

				case 3:
					Admin administrador  = new Admin(id, nombre, contrasena, nivelDeAcceso);
					listaUsuarios.add(administrador);
					break;

				}
				

			}

		} catch (SQLException e) {

			System.out.println(e);
		}
	}

	@Override
	public void agregar(Usuario usuario) {
		
		String nombre = usuario.getNombre();
		String contrasena = usuario.getContrasena();
		int nivelAcceso = usuario.getNivelDeAcceso();
		
		BD.realizarUpdate("insert INTO Usuarios(nombre, contrasena, nivelacceso) VALUES('"+nombre+"', '"+contrasena+"', "+nivelAcceso+")");
		cargarUsuariosBD();
		
	}

	@Override
	public void eliminar(Usuario usuario) {
		
		BD.realizarUpdate("DELETE from usuarios WHERE id = " + usuario.getId());
		
	}

	@Override
	public void actualizar(Usuario usuarioViejo, Usuario usuarioNuevo) {
		
		String nombre = usuarioNuevo.getNombre();
		String contrasena = usuarioNuevo.getContrasena();
		int nivelAcceso = usuarioNuevo.getNivelDeAcceso();
		
		
		BD.realizarUpdate("UPDATE usuarios SET nombre = '"+nombre+"', contrasena = '"+contrasena+"',  nivelAcceso = '"+nivelAcceso+"'  WHERE id = " + usuarioViejo.getId() );
	}
	
	public static PriorityQueue<Usuario> getLista() {
		return listaUsuarios;
	}

}
