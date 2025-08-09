package GUIJPanelGui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;

import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Editar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textPrecioOriginal;
	private JTextField textIDOriginal;
	private JTextField textStockOriginal;
	private JTextField textNombreOriginal;
	private JTextField textNombreNuevo;
	private JTextField textPrecioNuevo;
	private JSpinner SpinnerStockNuevo;
	private JCheckBox chckbxActualizarStock;

	/**
	 * Create the panel.
	 */
	public Editar() {
		setPreferredSize(new Dimension(1104, 241));
		setLayout(null);
		
		JButton EditarCambios = new JButton("Añadir nuevos cambios");
		EditarCambios.setForeground(Color.WHITE);
		EditarCambios.setBackground(new Color(18, 128, 129));
		EditarCambios.setBounds(685, 170, 226, 44);
		add(EditarCambios);
		
		JLabel lblIDOriginal = new JLabel("ID del Producto");
		lblIDOriginal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblIDOriginal.setBounds(10, 47, 152, 13);
		add(lblIDOriginal);
		
		JLabel lblPrecioOriginal = new JLabel("Precio del Producto");
		lblPrecioOriginal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrecioOriginal.setBounds(18, 194, 152, 13);
		add(lblPrecioOriginal);
		
		textPrecioOriginal = new JTextField();
		textPrecioOriginal.setEnabled(false);
		textPrecioOriginal.setColumns(10);
		textPrecioOriginal.setBounds(156, 192, 191, 24);
		add(textPrecioOriginal);
		
		textIDOriginal = new JTextField();
		textIDOriginal.setColumns(10);
		textIDOriginal.setBounds(132, 45, 191, 22);
		add(textIDOriginal);
		
		JLabel lblStockOriginal = new JLabel("Stock del Producto");
		lblStockOriginal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblStockOriginal.setBounds(10, 145, 152, 13);
		add(lblStockOriginal);
		
		textStockOriginal = new JTextField();
		textStockOriginal.setEnabled(false);
		textStockOriginal.setColumns(10);
		textStockOriginal.setBounds(156, 143, 191, 24);
		add(textStockOriginal);
		
		textNombreOriginal = new JTextField();
		textNombreOriginal.setEnabled(false);
		textNombreOriginal.setColumns(10);
		textNombreOriginal.setBounds(172, 98, 191, 24);
		add(textNombreOriginal);
		
		JLabel lblNombreOriginal = new JLabel("Nombre del Producto");
		lblNombreOriginal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNombreOriginal.setBounds(10, 100, 152, 13);
		add(lblNombreOriginal);
		
		JLabel lblTitulo = new JLabel("Editar Producto");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitulo.setBounds(410, 10, 140, 22);
		add(lblTitulo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(469, 48, 10, 183);
		add(separator);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(18, 128, 129));
		btnBuscar.setBounds(364, 45, 80, 22);
		add(btnBuscar);
		
		JLabel lblNombreNuevo = new JLabel("Nombre del Nuevo Producto");
		lblNombreNuevo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNombreNuevo.setBounds(477, 80, 186, 13);
		add(lblNombreNuevo);
		
		textNombreNuevo = new JTextField();
		textNombreNuevo.setColumns(10);
		textNombreNuevo.setBounds(663, 77, 191, 24);
		add(textNombreNuevo);
		
		JLabel lblStockNuevo = new JLabel("Stock del Nuevo Producto");
		lblStockNuevo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblStockNuevo.setBounds(861, 86, 178, 13);
		add(lblStockNuevo);
		
		textPrecioNuevo = new JTextField();
		textPrecioNuevo.setColumns(10);
		textPrecioNuevo.setBounds(650, 122, 191, 24);
		add(textPrecioNuevo);
		
		JLabel lblPrecioProductoNuevo = new JLabel("Precio del Nuevo Producto");
		lblPrecioProductoNuevo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrecioProductoNuevo.setBounds(477, 125, 210, 13);
		add(lblPrecioProductoNuevo);
		
		SpinnerStockNuevo = new JSpinner();
		SpinnerStockNuevo.setBounds(1024, 77, 70, 28);
		add(SpinnerStockNuevo);
		
		chckbxActualizarStock = new JCheckBox("Solo actualizar Stock");
		chckbxActualizarStock.setFont(new Font("Segoe UI", Font.BOLD, 14));
		chckbxActualizarStock.setBounds(485, 45, 178, 21);
		add(chckbxActualizarStock);
		
		//Funcionamientos de los botones
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		
		EditarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditarProducto();
				
			}
		});
		
		//Si fue clickeado se activará esté evento solo para stock
		chckbxActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxActualizarStock.isSelected()) {
					textNombreNuevo.setEnabled(false);
					textPrecioNuevo.setEnabled(false);
				}else {
					textNombreNuevo.setEnabled(true);
					textPrecioNuevo.setEnabled(true);
				}
			}
		});

	}
	
	private void buscarProducto() {
	    try {
	    	ControladorInventario controlador = new ControladorInventario();
	        int idOriginal = Integer.parseInt(textIDOriginal.getText());
	        Producto producto = controlador.buscarProductoPorID(idOriginal);
	        
	        if (producto != null) {
	        	//llenar el campo del viejo producto
	            textNombreOriginal.setText(producto.getNombre());
	            textPrecioOriginal.setText(String.valueOf(producto.getPrecio()));
	            textStockOriginal.setText(String.valueOf(producto.getStock()));

	            // Llenar el campo del nuevo producto
	            textNombreNuevo.setText(producto.getNombre());
	            textPrecioNuevo.setText(String.valueOf(producto.getPrecio()));
	            SpinnerStockNuevo.setValue(producto.getStock());
	            
	        } else {
	            JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Error en el ID del producto. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al buscar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void EditarProducto() {
		try {
			ControladorInventario controlador = new ControladorInventario();
			int idOriginal = Integer.parseInt(String.valueOf(textIDOriginal.getText()));
			Producto productoViejo = controlador.buscarProductoPorID(idOriginal);
			
			if (productoViejo == null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			
			// Obtener el nuevo stock del JSpinner
	        int NuevoStock = (Integer) SpinnerStockNuevo.getValue();
	        
	        
			//Ver que el usuario quiere actualizar
			if(chckbxActualizarStock.isSelected()) {
				
				//Solo actualizar Stock
				Producto productoActualizado = new Producto(productoViejo.getIdProducto(), NuevoStock, productoViejo.getPrecio(), productoViejo.getNombre());
				controlador.actualizar(productoViejo, productoActualizado);
			}else {
				
				//Actualizar todos los campos
				String nombreNuevoProducto = textNombreNuevo.getText();
				float nuevoPrecio = Float.parseFloat(textPrecioNuevo.getText());
				Producto productoActualizado = new Producto(idOriginal, NuevoStock, nuevoPrecio, nombreNuevoProducto);
				controlador.actualizar(productoViejo, productoActualizado);
				
			}
			
			JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
			
		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Por favor ingresa valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
