package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;

import LogicaNegocio.ControladorUsuarios;
import LogicaNegocio.Login;
import LogicaNegocio.Usuario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI {

	public JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordUsuario;
	private boolean isPasswordVisible = false;

	
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 797, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(20, 70, 117));
		panelLogin.setBounds(399, 0, 384, 502);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel TituloLogin = new JLabel("-- Acceso a FactX --");
		TituloLogin.setForeground(new Color(255, 255, 255));
		TituloLogin.setBounds(129, 112, 139, 41);
		TituloLogin.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		panelLogin.add(TituloLogin);
		
		textUsuario = new JTextField("Ingrese su nombre de usuario");
		textUsuario.setBounds(104, 255, 194, 24);
		panelLogin.add(textUsuario);
		textUsuario.setColumns(10);	
		JLabel lblOjoPassword = new JLabel(""); 
		lblOjoPassword.setBounds(266, 333, 29, 19);
		lblOjoPassword.setIcon(new ImageIcon(GUI.LoginUI.class.getResource("/gui/imagenes/Ojo.png")));
		panelLogin.add(lblOjoPassword);
		
		passwordUsuario = new JPasswordField("");
		passwordUsuario.setBounds(104, 330, 194, 25);
		panelLogin.add(passwordUsuario);
		
		JLabel lblBienvenidos = new JLabel("Bienvenidos");
		lblBienvenidos.setForeground(new Color(255, 255, 255));
		lblBienvenidos.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 35));
		lblBienvenidos.setBounds(104, 74, 185, 41);
		panelLogin.add(lblBienvenidos);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblUsuario.setBounds(24, 247, 78, 41);
		panelLogin.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setForeground(new Color(255, 255, 255));
		lblContrasena.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblContrasena.setBounds(24, 322, 78, 41);
		panelLogin.add(lblContrasena);
		
		JButton btnLongIn = new JButton("Iniciar Sesión");
		
		//Acción al Iniciar Sesion
		btnLongIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String usuario = textUsuario.getText();
				
				//Se convierte de Char[] a string
				String password = new String(passwordUsuario.getPassword());
				
				//Método guard clauses o return early: niega la condición, si se cumple se ejecuta lo que hay dentro de ese bloque retunando en él.
				if(!Login.validarSesion(usuario, password)) {
					JOptionPane.showMessageDialog(null, "Credenciales Inválidas", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				System.out.println("Validado Correctamente");
				frame.dispose();
				
				Optional<Usuario> usuarioValidado = Login.ObtenerInfoUsuario(usuario);  
				//Después dentro 
				if(usuarioValidado.isEmpty()) {
					System.out.println("El usuario no existe");
					return;
				}
				
				Login.VentanaCorrespondiente(usuarioValidado.get());
				
			}
		});
		btnLongIn.setForeground(new Color(255, 255, 255));
		btnLongIn.setBackground(new Color(18, 128, 129));
		btnLongIn.setBounds(132, 396, 129, 34);
		btnLongIn.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		panelLogin.add(btnLongIn);
	
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 403, 502);
		frame.getContentPane().add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(GUI.LoginUI.class.getResource("/gui/imagenes/Logonuevo.png")));
		logo.setBounds(0, 0, 403, 502);
		panelLogo.add(logo);
		
		// Solicitar el foco al panelLogin y no en el textfield, a la hora de iniciar el programa y que funcione la parte el texto en el textfiel.
        SwingUtilities.invokeLater(() -> panelLogin.requestFocusInWindow());
		
		//Funcionamientos parte interfaz
		 textUsuario.addFocusListener((FocusListener) new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (textUsuario.getText().equals("Ingrese su nombre de usuario")) {
	                    textUsuario.setText("");
	                    textUsuario.setForeground(Color.BLACK);
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (textUsuario.getText().isEmpty()) {
	                    textUsuario.setText("Ingrese su nombre de usuario");
	                    textUsuario.setForeground(Color.GRAY);
	                }
	            }
	        });
		 
		 lblOjoPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (isPasswordVisible) {
						
						// Ocultar la contraseña
	                    passwordUsuario.setEchoChar('•');
	                    lblOjoPassword.setBackground(null);
	                    lblOjoPassword.setOpaque(false);
	                } else {
	                	
	                	// Mostrar password
						passwordUsuario.setEchoChar((char) 0); 
						lblOjoPassword.setBackground(Color.LIGHT_GRAY);
						lblOjoPassword.setOpaque(true); 
	                }
					
					//*Alternar el estado 
					isPasswordVisible = !isPasswordVisible; 
				}
			});
	}
}