package GUIJPanelGui;

import javax.swing.JButton;
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

public class Agregar extends JPanel {

	private static final long serialVersionUID = 1L;
    private JButton agregarButton;
    private JTextField textPrecioProducto;
    private JTextField textIDProducto;
    private JTextField textStockProducto;
    private JTextField textNombreProducto;

       
  
	public Agregar() {
	        agregarButton = new JButton("Añadir Producto");
	        agregarButton.setForeground(new Color(255, 255, 255));
	        agregarButton.setBackground(new Color(18, 128, 129));
	        agregarButton.setBounds(399, 173, 351, 45);
	        setLayout(null);
	        setPreferredSize(new Dimension(1104, 241)); 
	        JLabel label_4 = new JLabel("");
	        label_4.setBounds(0, 244, 516, 61);
	        add(label_4);
	        add(agregarButton);
	        
	        JLabel lblID = new JLabel("ID del Producto");
	        lblID.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblID.setBounds(98, 70, 152, 13);
	        add(lblID);
	        
	        JLabel lblPrecioProducto = new JLabel("Precio del Producto");
	        lblPrecioProducto.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblPrecioProducto.setBounds(98, 120, 152, 13);
	        add(lblPrecioProducto);
	        
	        textPrecioProducto = new JTextField();
	        textPrecioProducto.setColumns(10);
	        textPrecioProducto.setBounds(260, 118, 191, 22);
	        add(textPrecioProducto);
	        
	        textIDProducto = new JTextField();
	        textIDProducto.setColumns(10);
	        textIDProducto.setBounds(260, 68, 191, 22);
	        add(textIDProducto);
	        
	        JLabel lblStock = new JLabel("Stock del Producto");
	        lblStock.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblStock.setBounds(678, 120, 152, 13);
	        add(lblStock);
	        
	        textStockProducto = new JTextField();
	        textStockProducto.setColumns(10);
	        textStockProducto.setBounds(840, 118, 191, 22);
	        add(textStockProducto);
	        
	        textNombreProducto = new JTextField();
	        textNombreProducto.setColumns(10);
	        textNombreProducto.setBounds(840, 70, 191, 22);
	        add(textNombreProducto);
	        
	        JLabel lblNombre = new JLabel("Nombre del Producto");
	        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        lblNombre.setBounds(678, 72, 152, 13);
	        add(lblNombre);
	        
	        JLabel lblTitulo = new JLabel("Agregar Producto");
	        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
	        lblTitulo.setBounds(498, 26, 162, 22);
	        add(lblTitulo);
	        
	        agregarButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		agregarProducto();
	        	}
	        });

	}
	 private void agregarProducto() {
	        try {
	            // Obtener los datos de los campos de texto
	            String nombre = textNombreProducto.getText();
	            int idProducto = Integer.parseInt(textIDProducto.getText());
	            int stock = Integer.parseInt(textStockProducto.getText());
	            float precio = Float.parseFloat(textPrecioProducto.getText());

	            // Crear un nuevo producto
	            Producto nuevoProducto = new Producto(idProducto, stock, precio, nombre);

	            // Llamar al controlador para agregar el producto
	            ControladorInventario controlador = new ControladorInventario();
	            controlador.agregar(nuevoProducto);

	            // Mostrar mensaje de éxito
	            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente!");

	            // Limpiar los campos
	            textIDProducto.setText("");
	            textNombreProducto.setText("");
	            textPrecioProducto.setText("");
	            textStockProducto.setText("");

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Por favor, verifique los campos.");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error al agregar el producto: " + ex.getMessage());
	        }
	    }
}


