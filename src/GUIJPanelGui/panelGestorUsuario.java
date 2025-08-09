package GUIJPanelGui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;

import GUIJPanelGui.Agregar;
import GUIJPanelGui.Editar;
import GUIJPanelGui.Inicio;
import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;
import LogicaNegocio.*;

public class panelGestorUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textBusqueda;
	private JTable table;
	private TableRowSorter<TableModel> ordenadorTabla;
	private DefaultTableModel modelo;
	
	/**
	 * Create the panel.
	 */
	public panelGestorUsuario() {
		
		setVisible(true);
		setPreferredSize(new Dimension(1920,1080));
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		
		JLabel lblTitulo = new JLabel("GESTION DE USUARIOS");
		lblTitulo.setForeground(new Color(51, 51, 51));
		lblTitulo.setBounds(640, 10, 461, 25);
		lblTitulo.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 20));
		add(lblTitulo);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(new Color(255, 255, 255));
		panelTabla.setBounds(253, 132, 1104, 315);
		add(panelTabla);
		panelTabla.setLayout(null);
		
		// Crear el modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"ID", "Nombre", "NivelDeAcceso"});

        // Crear la tabla con el modelo
        table = new JTable(modelo);
        
        // Crear el TableRowSorter y asociarlo con el modelo
        ordenadorTabla = new TableRowSorter<>(modelo);
        table.setRowSorter(ordenadorTabla);

        // Crear el JScrollPane y agregar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1104, 313);
        panelTabla.add(scrollPane);
		
		JButton btnAgregarProducto = new JButton("Agregar Usuario");
		btnAgregarProducto.setBounds(253, 522, 207, 41);
		btnAgregarProducto.setForeground(new Color(255, 255, 255));
		btnAgregarProducto.setBackground(new Color(18, 128, 129));
		add(btnAgregarProducto);
		
		JButton btnEditarProducto = new JButton("Editar Usuario");
		btnEditarProducto.setForeground(new Color(255, 255, 255));
		btnEditarProducto.setBackground(new Color(18, 128, 129));
		btnEditarProducto.setBounds(544, 522, 207, 41);
		add(btnEditarProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar Usuario");
		btnEliminarProducto.setForeground(new Color(255, 255, 255));
		btnEliminarProducto.setBackground(new Color(18, 128, 129));
		btnEliminarProducto.setBounds(808, 522, 207, 41);
		add(btnEliminarProducto);
		
		textBusqueda = new JTextField();
		textBusqueda.setBounds(386, 104, 327, 23);
		add(textBusqueda);
		textBusqueda.setColumns(10);
		
		JButton btnActualizarProducto = new JButton("Actualizar");
		btnActualizarProducto.setForeground(new Color(255, 255, 255));
		btnActualizarProducto.setBackground(new Color(18, 128, 129));
		btnActualizarProducto.setBounds(1126, 522, 207, 41);
		add(btnActualizarProducto);
		
		JPanel Linea = new JPanel();
		Linea.setBackground(new Color(18, 128, 129));
		Linea.setBounds(518, 45, 525, 23);
		add(Linea);
		
		JLabel lblbuscarProducto = new JLabel("Buscar por nombre:");
		lblbuscarProducto.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblbuscarProducto.setBounds(262, 111, 133, 13);
		add(lblbuscarProducto);
		
		//mostrar productos
		mostrarProductos();
		
		//funcionalidad de botones
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarUsuario Jagregar = new AgregarUsuario();
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
		
		MostrarPanelInicio();
	}
	
	public void MostrarPanelInicio() {
	}
	
	private void MostrarPanelAgregar(JPanel p) {
		p.setBounds(0, 0, 1104, 241);
		
		removeAll();
		add(p);
		revalidate();
		repaint();

	}
	
	private void MostrarPanelEditar(JPanel p) {
		p.setBounds(0, 0, 1104, 241);
		
		removeAll();
		add(p);
		revalidate();
		repaint();
		
	}
	
	public void FiltrarPorText() {
		String textoBusqueda = textBusqueda.getText();
	    RowFilter<? super TableModel, ? super Integer> filtro = RowFilter.regexFilter("(?i)" + textoBusqueda, 1);
	    ordenadorTabla.setRowFilter(filtro);
	}
	
	public void mostrarProductos() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
	
	    PriorityQueue<Usuario> listaUsuarios = ControladorUsuarios.getLista();
	    
	    try {
	        for (Usuario usuario : listaUsuarios) {
	            
	        	String nombreUsuario = usuario.getNombre();
	        	String contrasena = usuario.getContrasena();
	        	int id = usuario.getId();
	        	int acceso = usuario.getNivelDeAcceso();
	        	
	            modelo.addRow(new String[] {String.valueOf(id), nombreUsuario, String.valueOf(acceso)});
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, Error");
	    }
	}
}
