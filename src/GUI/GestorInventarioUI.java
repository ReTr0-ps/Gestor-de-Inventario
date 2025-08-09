package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PriorityQueue;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BasesDatos.BD;
import GUIJPanelGui.Agregar;
import GUIJPanelGui.Editar;
import GUIJPanelGui.Inicio;

import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestorInventarioUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBusqueda;
	private JTable table;
	TableRowSorter<TableModel> ordenadorTabla;
	private JPanel ContentJpanel;
	private DefaultTableModel modelo;
	
	/**
	 * Create the frame.
	 */
	public GestorInventarioUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Gestionamiento de Inventario");
		lblTitulo.setBounds(653, 7, 308, 25);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblTitulo);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(255, 255, 255));
		panelTabla.setBounds(253, 132, 1104, 315);
		contentPane.add(panelTabla);
		panelTabla.setLayout(null);
		// Crear el modelo de la tabla
        modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Título", "Descripción", "Fecha"}
        );

        // Crear la tabla con el modelo
        table = new JTable(modelo);
        
        // Crear el TableRowSorter y asociarlo con el modelo
        ordenadorTabla = new TableRowSorter<>(modelo);
        table.setRowSorter(ordenadorTabla);

        // Crear el JScrollPane y agregar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1104, 313);
        panelTabla.add(scrollPane);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(287, 717, 207, 41);
		btnAgregarProducto.setForeground(new Color(255, 255, 255));
		btnAgregarProducto.setBackground(new Color(18, 128, 129));
		contentPane.add(btnAgregarProducto);
		
		JButton btnEditarProducto = new JButton("Editar Producto");
		btnEditarProducto.setForeground(new Color(255, 255, 255));
		btnEditarProducto.setBackground(new Color(18, 128, 129));
		btnEditarProducto.setBounds(566, 717, 207, 41);
		contentPane.add(btnEditarProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRegistroSeleccionado();
			}
		});
		btnEliminarProducto.setForeground(new Color(255, 255, 255));
		btnEliminarProducto.setBackground(new Color(18, 128, 129));
		btnEliminarProducto.setBounds(842, 717, 207, 41);
		contentPane.add(btnEliminarProducto);
		
		textBusqueda = new JTextField();
		textBusqueda.setBounds(386, 104, 327, 23);
		contentPane.add(textBusqueda);
		textBusqueda.setColumns(10);
		
		JButton btnActualizarProducto = new JButton("Actualizar");
		btnActualizarProducto.setForeground(new Color(255, 255, 255));
		btnActualizarProducto.setBackground(new Color(18, 128, 129));
		btnActualizarProducto.setBounds(1111, 717, 207, 41);
		contentPane.add(btnActualizarProducto);
		
		ContentJpanel = new JPanel();
		ContentJpanel.setBounds(253, 445, 1104, 241);
		contentPane.add(ContentJpanel);
		
		JPanel Linea = new JPanel();
		Linea.setBackground(new Color(20, 70, 117));
		Linea.setBounds(326, 45, 972, 23);
		contentPane.add(Linea);
		
		JLabel lblbuscarProducto = new JLabel("Buscar por nombre:");
		lblbuscarProducto.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblbuscarProducto.setBounds(262, 111, 133, 13);
		contentPane.add(lblbuscarProducto);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBounds(10, 8, 171, 27);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(18, 128, 129));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		//Funcionalidad de salir hacía el login
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cierra la ventana actual
				dispose();
				// Muestra la ventana de inicio de sesión
                LoginUI loginUI = new LoginUI(); // Crear instancia
                loginUI.frame.setVisible(true);
			}
		});
		
		//mostrar productos
		mostrarProductos();
		
		//funcionalidad de botones
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar Jagregar = new Agregar();
				MostrarPanelAgregar(Jagregar);
				
			}
		});
		
		btnEditarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar Jeditar = new Editar();
				MostrarPanelEditar(Jeditar);
			}
		});
		
		btnActualizarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorInventario.CargarProductosBD();
				mostrarProductos();
			}
		});
		
		
		textBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				FiltrarPorText();
			}
		});
		
		///Cambio de colores
		btnEliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminarProducto.setBackground(new Color(214, 38, 31));
				
			}
			
			@Override
            public void mouseExited(MouseEvent e) {
                btnEliminarProducto.setBackground(new Color(18, 128, 129));
            }
		});
		
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(214,38,31));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(18,128,129));
			}
		});
		
		MostrarPanelInicio();
	}
	
	public void MostrarPanelInicio() {
		Inicio inicioP = new Inicio();
		inicioP.setBounds(0, 0, 551, 284);
		
		ContentJpanel.removeAll();
		ContentJpanel.add(inicioP);
		ContentJpanel.revalidate();
		ContentJpanel.repaint();
	}
	
	private void MostrarPanelAgregar(JPanel p) {
		p.setBounds(0, 0, 1104, 241);
		
		ContentJpanel.removeAll();
		ContentJpanel.add(p);
		ContentJpanel.revalidate();
		ContentJpanel.repaint();
		
	}
	
	private void MostrarPanelEditar(JPanel p) {
		p.setBounds(0, 0, 1104, 241);
		
		ContentJpanel.removeAll();
		ContentJpanel.add(p);
		ContentJpanel.revalidate();
		ContentJpanel.repaint();
		
	}
	
	public void FiltrarPorText() {
		   
		
	    String textoBusqueda = textBusqueda.getText();
	    
	    /* Usa la expresión regular para hacer la búsqueda insensible a mayúsculas y minúsculas>
	     * La sintaxis "? super TableModel" indica que el filtro puede aceptar cualquier tipo que sea TableModel o sus superclases. 
	     * Lo mismo aplica para "? super Integer".*/
	    RowFilter<? super TableModel, ? super Integer> filtro = RowFilter.regexFilter("(?i)" + textoBusqueda, 1);
	    
	    // Aplica el filtro al TableRowSorter
	    ordenadorTabla.setRowFilter(filtro);
	}
	
	public void mostrarProductos() {

	    //Obtén el modelo existente de la tabla y luego Limpiar las filas
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
	
	    //Obtener la lista de productos desde la prioridad
	    PriorityQueue<Producto> listaProductos = ControladorInventario.getLista();
	    try {
	        for (Producto producto : listaProductos) {
	        	// Rellenar el arreglo 'columnas' con los datos del ResultSet
	            String[] columnas = new String[4];
	            columnas[0] = String.valueOf(producto.getIdProducto());
	            columnas[1] = producto.getNombre();
	            columnas[2] = String.valueOf(producto.getPrecio());
	            columnas[3] = String.valueOf(producto.getStock());
	            
	            // Añadir la fila al modelo de la tabla
	            modelo.addRow(columnas);
			
	        }   

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error");
	    }
	}
	
	void eliminarRegistroSeleccionado() {
	    int selectedRow = table.getSelectedRow(); // 'table' es tu JTable

	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Seleccione un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Obtener el ID como String y convertirlo a Integer
	    String idString = (String) table.getValueAt(selectedRow, 0);
	    int idProducto = Integer.parseInt(idString);

	    String nombreProducto = (String) table.getValueAt(selectedRow, 1); // Otra columna, si la hay

	    Producto prod = new Producto(idProducto, nombreProducto); // Crear el objeto Producto

	    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

	    if (confirm == JOptionPane.YES_OPTION) {
	    	ControladorInventario objetoControlador = new ControladorInventario();
		       objetoControlador.eliminar(prod);
	        
	        ((DefaultTableModel) table.getModel()).removeRow(selectedRow); // Elimina la fila de la tabla
	        JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	

}
