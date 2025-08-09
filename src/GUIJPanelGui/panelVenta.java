package GUIJPanelGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;
import LogicaNegocio.Usuario;
import LogicaNegocio.Venta.ControladorVentas;
import LogicaNegocio.Venta.ProductoVenta;
import LogicaNegocio.Venta.Venta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class panelVenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField codigoTF;
	private JTable table;
	JSpinner cantidadSpinner;
	JComboBox<Producto> productosComboBox = new JComboBox<Producto>();
	private JTextField subtotalTF;
	private JTextField descuentoTF;
	private JTextField totalTF;
	private JTextField efectivoTF;
	private JTextField cambioTF;
	JButton btnConfirmar, btnAñadir;
	Producto productoSelect;
	ArrayList<ProductoVenta> productosVenta = new ArrayList<>();
	DefaultTableModel mt;
	float total;
	float subtotal;
	float descuento = 0;
	float efectivo = 0;
	float cambio = 0;

	public panelVenta() {

		setBackground(new Color(240, 240, 240));
		setBounds(0, 0, 1920, 1080);
		setVisible(true);
		setLayout(null);

		JLabel facturarLabel = new JLabel("FACTURAR VENTA");
		facturarLabel.setForeground(new Color(45, 45, 45));
		facturarLabel.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 39));
		facturarLabel.setBounds(589, 47, 623, 38);
		add(facturarLabel);

		JPanel barrita = new JPanel();
		barrita.setBackground(new Color(24, 124, 129));
		barrita.setBounds(589, 96, 393, 10);
		add(barrita);

		JPanel panel = new JPanel();
		panel.setBounds(228, 121, 1153, 621);
		add(panel);
		panel.setLayout(null);
		productosComboBox.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		productosComboBox.setBounds(216, 40, 197, 28);
		productosComboBox.setEditable(true);
		productosComboBox.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		panel.add(productosComboBox);

		codigoTF = new JTextField();
		codigoTF.setBounds(423, 41, 225, 27);
		panel.add(codigoTF);
		codigoTF.setColumns(10);

		cantidadSpinner = new JSpinner();
		cantidadSpinner.setBounds(658, 40, 61, 28);
		cantidadSpinner.setValue(1);
		panel.add(cantidadSpinner);

		JLabel labelProducto = new JLabel("Producto");
		labelProducto.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		labelProducto.setBounds(216, 26, 102, 13);
		panel.add(labelProducto);

		JLabel codigoLabel = new JLabel("Codigo De Barras");
		codigoLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		codigoLabel.setBounds(423, 27, 135, 13);
		panel.add(codigoLabel);

		JLabel lblCant = new JLabel("Cant.");
		lblCant.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		lblCant.setBounds(658, 27, 102, 13);
		panel.add(lblCant);

		// Tabla y ScrollPane

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 98, 901, 292);
		panel.add(scrollPane);

		mt = new DefaultTableModel();
		mt.setColumnIdentifiers(
				new Object[] { "Código", "Nombre de producto", "Cantidad", "Precio Unitario", "Precio Total" });

		table = new JTable(mt);

		scrollPane.setViewportView(table);

		// Texfiled y Labels bajo la tabal
		subtotalTF = new JTextField();
		subtotalTF.setEditable(false);
		subtotalTF.setForeground(new Color(61, 61, 61));
		subtotalTF.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		subtotalTF.setBounds(106, 435, 256, 36);
		panel.add(subtotalTF);
		subtotalTF.setColumns(10);

		descuentoTF = new JTextField();
		descuentoTF.setForeground(new Color(61, 61, 61));
		descuentoTF.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		descuentoTF.setColumns(10);
		descuentoTF.setBounds(106, 511, 66, 36);
		panel.add(descuentoTF);

		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalTF.setForeground(new Color(61, 61, 61));
		totalTF.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		totalTF.setColumns(10);
		totalTF.setBounds(106, 570, 256, 36);
		panel.add(totalTF);

		JLabel subtotalLabel = new JLabel("SUBTOTAL");
		subtotalLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		subtotalLabel.setBounds(106, 418, 102, 13);
		panel.add(subtotalLabel);

		JLabel lblDescuentoporciento = new JLabel("DESCUENTO (PORCIENTO)");
		lblDescuentoporciento.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblDescuentoporciento.setBounds(106, 492, 226, 13);
		panel.add(lblDescuentoporciento);

		JLabel totalLabel = new JLabel("TOTAL");
		totalLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		totalLabel.setBounds(106, 557, 183, 13);
		panel.add(totalLabel);

		JLabel lblEfectivo = new JLabel("EFECTIVO");
		lblEfectivo.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblEfectivo.setBounds(497, 418, 102, 13);
		panel.add(lblEfectivo);

		efectivoTF = new JTextField();
		efectivoTF.setForeground(new Color(61, 61, 61));
		efectivoTF.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		efectivoTF.setColumns(10);
		efectivoTF.setBounds(497, 435, 256, 36);
		panel.add(efectivoTF);

		cambioTF = new JTextField();
		cambioTF.setEditable(false);
		cambioTF.setForeground(new Color(61, 61, 61));
		cambioTF.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		cambioTF.setColumns(10);
		cambioTF.setBounds(497, 509, 256, 36);
		panel.add(cambioTF);

		JLabel lblCambio = new JLabel("CAMBIO");
		lblCambio.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblCambio.setBounds(497, 492, 102, 13);
		panel.add(lblCambio);

		// Calculo del cambio
		JButton btnNewButton = new JButton("CALCULAR CAMBIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarValores();

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(61, 61, 61));
		btnNewButton.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 14));
		btnNewButton.setBounds(497, 570, 264, 36);
		panel.add(btnNewButton);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 12));
		btnAñadir.setBackground(new Color(24, 124, 129));
		btnAñadir.setBounds(747, 40, 153, 31);
		panel.add(btnAñadir);

		// Funcionalidad boton
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Obtener la cantidad y el código
				int codigo = Integer.parseInt(codigoTF.getText());
				agregarProducto(codigo);

			}
		});

		btnConfirmar = new JButton("CONFIRMAR VENTA");
		btnConfirmar.setBackground(new Color(24, 124, 129));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 14));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarVenta();
			}
		});
		btnConfirmar.setBounds(790, 435, 225, 176);
		panel.add(btnConfirmar);

		// Llenar el comboBox
		for (Producto ProductoAUX : ControladorInventario.getLista()) {

			productosComboBox.addItem(ProductoAUX);

		}

		productosComboBox.setSelectedIndex(-1);

		JButton btnAplicarDescuento = new JButton("APLICAR DESCUENTO");
		btnAplicarDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarValores();
			}
		});
		btnAplicarDescuento.setForeground(Color.WHITE);
		btnAplicarDescuento.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 14));
		btnAplicarDescuento.setBackground(new Color(61, 61, 61));
		btnAplicarDescuento.setBounds(179, 511, 183, 36);
		panel.add(btnAplicarDescuento);

		// Elimnar Producto
		JButton btnEliminarProducto = new JButton("ELIMINAR PRODUCTO");

		btnEliminarProducto.setForeground(Color.WHITE);
		btnEliminarProducto.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 12));
		btnEliminarProducto.setBackground(new Color(200, 0, 0));
		btnEliminarProducto.setBounds(790, 394, 218, 28);

		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				int idProducto = (int) table.getValueAt(index, 0);

				productosVenta.removeIf(pro -> pro.getIdProducto() == idProducto);
				actualizarValores();
			}
		});

		panel.add(btnEliminarProducto);

		// FUNCIONALIDAD COMOBO BOX

		// TextField Auxiliar que se optiene del EditorCOmponent del Combo Box
		JTextField textFieldAUX = (JTextField) productosComboBox.getEditor().getEditorComponent();

		textFieldAUX.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				// Se obtiene lo que el usuario está ingresando en el combo BOX. El
				// EditorComponent se tiene que convertir a un TF, y de Tf a String
				String entrada = textFieldAUX.getText();

				// Limpiar el combo box
				productosComboBox.removeAllItems();
				productosComboBox.hidePopup();

				// Por cada elemento que coincida se va a llenar el ComboBox
				for (Producto productoAUX : ControladorInventario.getLista()) {

					// Signifcado If: Si el nombre del producto coincide con
					if (productoAUX.getNombre().toLowerCase().contains(entrada.toLowerCase())) {
						productosComboBox.addItem(productoAUX);
					}
				}

				textFieldAUX.setText(entrada);
				productosComboBox.showPopup();

			}
		});

		// Funcionalidad si se ha insertado algo en el combo box
		productosComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Busca si lo insertado en el combo box realmente está en la lista de productos
				Optional<Producto> productoDelTextField = ControladorInventario.getLista().stream()
						.filter(us -> us.getNombre().equalsIgnoreCase(textFieldAUX.getText())).findFirst();

				if (!productoDelTextField.isEmpty()) {

					productoSelect = (Producto) productosComboBox.getSelectedItem();
					codigoTF.setText("" + productoSelect.getIdProducto());
				}

			}
		});

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(-1, -35, 0, 0);
		add(btnNewButton_1);
		

		/* Funcionalidad de salir al login
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cierra la ventana actual
				dispose();
				// Muestra la ventana de inicio de sesión
				LoginUI loginUI = new LoginUI();
				loginUI.frame.setVisible(true);
			}
		});*/
	}

	public void agregarProducto(int codigo) {

		// Lambda para buscar el producto del código
		Optional<Producto> producto = ControladorInventario.getLista().stream()
				.filter(pr -> pr.getIdProducto() == codigo).findFirst();

		// Si el producto existe
		if (!producto.isEmpty()) {

			int id = producto.get().getIdProducto();
			float precio = producto.get().getPrecio();
			String nombre = producto.get().getNombre();
			int cantidad = (int) cantidadSpinner.getValue();

			// Booleano para determinar si el producto ya está agregado en la compra
			boolean productoAgregado = productosVenta.stream().filter(pr -> pr.getIdProducto() == codigo).findFirst()
					.isPresent();

			if (productoAgregado) {

				productosVenta.stream().filter(produ -> produ.getIdProducto() == id)
						.forEach(produ -> produ.setCantidad(produ.getCantidad() + cantidad));

			} else {
				ProductoVenta productoVenta = new ProductoVenta(id, precio, nombre, cantidad);
				productosVenta.add(productoVenta);
			}

			actualizarValores();
		}

	}
	
	//Crear Venta
	public void confirmarVenta() {
		
		ControladorVentas controlVentas = new ControladorVentas();
		//Si la lista no está vacia 
		if(!productosVenta.isEmpty()) {
			
			
			Venta nuevaVenta = new Venta(LocalDateTime.now(), productosVenta, subtotal, total, descuento, efectivo, cambio);
			controlVentas.agregar(nuevaVenta);
			JOptionPane.showMessageDialog(null, "Venta Realizada Correctamente", "Sucessfully", JOptionPane.INFORMATION_MESSAGE);
			reiniciarValores();
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Inserte los productos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void actualizarValores() {

		// Actualizar tabla

		mt.setRowCount(0);

		int codigo;
		String nombre;
		int cant;
		float precioUnitario;
		float precioTotal;
		subtotal = 0;
		total = 0;
		

		for (ProductoVenta producto : productosVenta) {

			codigo = producto.getIdProducto();
			nombre = producto.getNombre();
			cant = producto.getCantidad();
			precioUnitario = producto.getPrecio();
			precioTotal = producto.getPrecioTotal();

			mt.addRow(new Object[] { codigo, nombre, cant, precioUnitario, precioTotal });

			subtotal += producto.getPrecioTotal();
		}

		// Renderizado a la tabla
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Total, subtotal, etc.
		subtotalTF.setText("RD$ " + subtotal);

		descuento = 0;

		if (!descuentoTF.getText().equals("")) {
			descuento = Float.parseFloat(descuentoTF.getText());
			descuento = descuento / 100;

		}

		if (descuento != 0)
			total = subtotal - subtotal * descuento;
		else
			total = subtotal;

		// Cambio
		efectivo = 0;
		cambio = 0;

		// Si el text field no está vacio
		if (!efectivoTF.getText().equals("")) {

			cambio = Float.parseFloat(efectivoTF.getText()) - total;

			cambioTF.setText("RD$ " + cambio);

		}

		totalTF.setText("RD$ " + total);

	}
	
	void reiniciarValores() {
		
		efectivoTF.setText("");
		descuentoTF.setText("");;
		cambioTF.setText("");
		efectivo = 0;
		cambio = 0;
		cantidadSpinner.setValue(1);
		
		
		
		productosVenta.clear();
		actualizarValores();
		
	}
}
