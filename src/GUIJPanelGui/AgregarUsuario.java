package GUIJPanelGui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import LogicaNegocio.*;

public class AgregarUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
    private JButton agregarButton;
    private JTextField textPrecioProducto;
    private JTextField textIDUsuario;
    private JTextField textStockProducto;
    private JTextField nombreUsuarioTF;
    JComboBox<String> accesoComboBox ;
    private JTextField contrasenaTF;

       
  
	public AgregarUsuario() {
	        agregarButton = new JButton("Añadir Usuario");
	        agregarButton.setForeground(new Color(255, 255, 255));
	        agregarButton.setBackground(new Color(18, 128, 129));
	        agregarButton.setBounds(402, 173, 307, 45);
	        setLayout(null);
	        setPreferredSize(new Dimension(1104, 241)); 
	        JLabel label_4 = new JLabel("");
	        label_4.setBounds(0, 244, 516, 61);
	        add(label_4);
	        add(agregarButton);
	        
	        JLabel lblID = new JLabel("Nombre Usuario");
	        lblID.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblID.setBounds(98, 70, 152, 13);
	        add(lblID);
	        
	        JLabel lblPrecioProducto = new JLabel("Acceso del Usuario");
	        lblPrecioProducto.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblPrecioProducto.setBounds(98, 120, 152, 13);
	        add(lblPrecioProducto);
	        
	        accesoComboBox = new JComboBox<String>(new String[] {"Administrador", "Gestor Inventario", "Cajero"});
	        
	       
	        
	        accesoComboBox.setBounds(260, 118, 191, 22);
	        add(accesoComboBox);
	        
	        textIDUsuario = new JTextField();
	        textIDUsuario.setColumns(10);
	        textIDUsuario.setBounds(728, 68, 191, 22);
	        add(textIDUsuario);
	        
	        
	        nombreUsuarioTF = new JTextField();
	        nombreUsuarioTF.setColumns(10);
	        nombreUsuarioTF.setBounds(260, 68, 191, 22);
	        add(nombreUsuarioTF);
	        
	        JLabel lblNombre = new JLabel("ID del Usuario");
	        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblNombre.setBounds(627, 70, 152, 13);
	        add(lblNombre);
	        
	        JLabel lblTitulo = new JLabel("AGREGAR USUARIO");
	        lblTitulo.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 18));
	        lblTitulo.setBounds(426, 22, 261, 22);
	        add(lblTitulo);
	        
	        JLabel lblContrasena = new JLabel("Contraseña");
	        lblContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblContrasena.setBounds(627, 122, 152, 13);
	        add(lblContrasena);
	        
	        contrasenaTF = new JTextField();
	        contrasenaTF.setColumns(10);
	        contrasenaTF.setBounds(728, 119, 191, 22);
	        add(contrasenaTF);
	        
	        agregarButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		agregarUsuario();
	        	}
	        });

	}
	
	 private void agregarUsuario() {
	        try {
	            // Obtener los datos de los campos de texto
	            String nombre = nombreUsuarioTF.getText();
	            int idUsuario = Integer.parseInt(textIDUsuario.getText());
	            String nivelAcceso = (String) accesoComboBox.getSelectedItem();
	            String contrasena = contrasenaTF.getText();
	            int nivelAccesoInt;
	            Usuario usuario = null;
	            
	            // Crear un nuevo Usuario
	            switch(nivelAcceso) {
	            
	            case "Administrador":
	            	nivelAccesoInt = 3;
	            	usuario = new Admin(idUsuario, nombre, contrasena, nivelAccesoInt);
	            	break;
	            	
	            case "Gestor Inventario":
	            	nivelAccesoInt = 2;
	            	usuario = new GestorInventario(idUsuario, nombre, contrasena, nivelAccesoInt);
	            	break;
	            	
	            case "Cajero":
	            	nivelAccesoInt = 1;
	            	usuario = new Cajero(idUsuario, nombre, contrasena, nivelAccesoInt);
	            	break;
	            }
	            
	            //"Administrador", "Gestor Inventario", "Cajero"

	            
	            // Llamar al controlador para agregar el producto
	            ControladorUsuarios controlador = new ControladorUsuarios();
	            controlador.agregar(usuario);
	            

	            // Mostrar mensaje de éxito
	            JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente!");

	            // Limpiar los campos
	            textIDUsuario.setText("");
	            nombreUsuarioTF.setText("");
	            contrasenaTF.setText("");

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Por favor, verifique los campos.");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error al agregar el producto: " + ex.getMessage());
	        }
	    }
}


