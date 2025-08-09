package BasesDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class BD {

	private static final String URL = "jdbc:mysql://uxmy8xrrw8skqppp:fAYtwsba6Hx4ZxJPFpve@b0fupum6ndhzxnqjbtm5-mysql.services.clever-cloud.com:3306/b0fupum6ndhzxnqjbtm5";
	private static final String USUARIO = "uxmy8xrrw8skqppp";
	private static final String CONTRASEÑA = "fAYtwsba6Hx4ZxJPFpve";

	private static Connection conexion;

	// Constructor privado para evitar instanciación
	private BD() {
	}

	// Método para obtener la conexión
	public static Connection obtenerConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conexion;
	}

	// RealiarConsulta
	public static void realizarUpdate(String consulta) {

		try {

			Statement statement = obtenerConexion().createStatement();
			statement.executeUpdate(consulta);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
		}
	}

	public static ResultSet realizarQuery(String consulta) {
		
		ResultSet resultset = null;
		
		try {

			Statement statement = obtenerConexion().createStatement();
			
			 resultset =  statement.executeQuery(consulta);
			 
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (resultset);
		
	}
}

/*
 * // Método para cerrar la conexión public static void cerrarConexion() throws
 * SQLException { if (conexion != null && !conexion.isClosed()) {
 * conexion.close();        }     }
 */
