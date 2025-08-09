package GUI;
import GUIJPanelGui.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BasesDatos.BD;
import GUIJPanelGui.panelGestorInventario;
import LogicaNegocio.ControladorInventario;
import LogicaNegocio.Producto;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class AdminitradorUI extends JFrame {
    
 
	JPanel contenedor;
    private static final long serialVersionUID = 1L;

    public AdminitradorUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(100, 100, 1920, 1080);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1540, 48);
        menuBar.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.gray);
		menuBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		setBackground(Color.gray);
        getContentPane().setLayout(null);
        getContentPane().add(menuBar);
        
        
        
        JMenuItem itemInventario = new JMenuItem("Gestionar Inventario");
        itemInventario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelInventario();
        		System.out.println("Inventario");
        	}
        	
        });
        menuBar.add(itemInventario);
        
        JMenuItem itemFacturar = new JMenuItem("Facturar Venta");
        itemFacturar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelVenta();
        	}
        });
        
        JMenuItem GestionUsuarios = new JMenuItem("Gestion De Usuarios");
        GestionUsuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//gestion usuario
        		panelGestionUsuarios();
        	}
        });
        menuBar.add(GestionUsuarios);
        menuBar.add(itemFacturar);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar Sesión");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  dispose();
                  LoginUI loginUI = new LoginUI(); // Crear instancia
                  loginUI.frame.setVisible(true);

        	}
        });
        
        
        menuBar.add(mntmNewMenuItem);
        
        contenedor = new JPanel();
        contenedor.setBounds(0, 45, 1920, 1035);
        getContentPane().add(contenedor);
        
       
        
        contenedor.setLayout(null);
        
        
    }
    
    public void panelInventario() {
    	
    	panelGestorInventario panelGestor = new panelGestorInventario();
    	panelGestor.setBounds(0, 0, 1920, 1080);
		
		contenedor.removeAll();
		contenedor.add(panelGestor);
		contenedor.revalidate();
		contenedor.repaint();
    }
    
    public void panelVenta() {
    	
    	panelVenta panelVenta = new panelVenta();
    	panelVenta.setBounds(0, 0, 1920, 1080);
		
		contenedor.removeAll();
		contenedor.add(panelVenta);
		contenedor.revalidate();
		contenedor.repaint();
   }
    
    public void panelGestionUsuarios() {
    	panelGestorUsuario panelUsuario = new panelGestorUsuario();
    	panelUsuario.setBounds(0, 0, 1920, 1080);
		
		contenedor.removeAll();
		contenedor.add(panelUsuario);
		contenedor.revalidate();
		contenedor.repaint();
    }
}
