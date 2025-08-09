package Main;

import javax.swing.SwingUtilities;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;

import GUI.*;
import LogicaNegocio.*;

public class Main {
	
	public static void main(String[] args) {
		
		//Cargar Usuario BD
		ControladorUsuarios.cargarUsuariosBD();
		ControladorInventario.CargarProductosBD();
		
		//Cargar tema
		FlatLightOwlIJTheme.setup();
		
		/*Cargar Interefaz Login
		 * actualizar y  sincronización el LoginUI*/
		
		
		SwingUtilities.invokeLater(() -> {
            LoginUI window = new LoginUI();
            window.frame.setVisible(true);
        });
		
	}
}
