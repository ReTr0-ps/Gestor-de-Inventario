package GUIJPanelGui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Inicio() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(20, 70, 117));
		setPreferredSize(new Dimension(1104, 241));
		panel.setBounds(0, 0, 1104, 241);
		add(panel);
		
		JLabel lblTitulo = new JLabel("¡Bienvenido Coordinador de Productos!");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitulo.setBounds(389, 10, 317, 41);
		panel.add(lblTitulo);
		
		JLabel lblText = new JLabel("Esta aplicación te permite gestionar usuarios con facilidad y eficiencia.");
		lblText.setForeground(new Color(255, 255, 255));
		lblText.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblText.setBounds(240, 54, 503, 32);
		panel.add(lblText);
		
		JLabel lblTextAdd = new JLabel("▶ Agregar Productos: \r\nIntroduce nuevos productos en tu inventario rápidamente, proporcionando detalles esenciales como nombre, precio y stock.");
		lblTextAdd.setForeground(new Color(255, 255, 255));
		lblTextAdd.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTextAdd.setBounds(72, 82, 948, 32);
		panel.add(lblTextAdd);
		
		JLabel lblTextDelete = new JLabel("▶ Editar Productos: Realiza ajustes y actualiza la información de los productos existentes según sea necesario para mantener tus datos siempre al día.");
		lblTextDelete.setForeground(new Color(255, 255, 255));
		lblTextDelete.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTextDelete.setBounds(72, 116, 981, 32);
		panel.add(lblTextDelete);
		
		JLabel lblTextEdit = new JLabel("▶ Eliminar Productos: Borra productos del inventario de manera sencilla cuando ya no sean necesarios o cuando desees limpiar tu base de datos.");
		lblTextEdit.setForeground(new Color(255, 255, 255));
		lblTextEdit.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTextEdit.setBounds(72, 145, 948, 42);
		panel.add(lblTextEdit);
		
		JLabel lblTextShow = new JLabel("▶ Realiza actualizaciones en tiempo real para reflejar los cambios en tu inventario. Asegúrate de que todos los datos estén siempre actualizados y correctos.");
		lblTextShow.setForeground(new Color(255, 255, 255));
		lblTextShow.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTextShow.setBounds(72, 184, 1014, 26);
		panel.add(lblTextShow);
		
		JSeparator separatorInferior = new JSeparator();
		separatorInferior.setBounds(55, 218, 1007, 11);
		panel.add(separatorInferior);
		
		JSeparator separatorSuperior = new JSeparator();
		separatorSuperior.setBounds(55, 54, 1007, 11);
		panel.add(separatorSuperior);
		
		JSeparator separatorVerticalDerecho = new JSeparator();
		separatorVerticalDerecho.setOrientation(SwingConstants.VERTICAL);
		separatorVerticalDerecho.setBounds(1062, 54, 9, 164);
		panel.add(separatorVerticalDerecho);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(55, 54, 9, 164);
		panel.add(separator);

	}

}
