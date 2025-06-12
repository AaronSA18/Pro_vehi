package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Arreglos.vehicleArray;

import clases.vehiculo;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estacionamiento extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtPlaca;
	private JButton btnNewButton;
	private JButton btnBuscar;
	
	private vehicleArray tablaVehi = vehicleArray.getInstancia();
	private String[] columnas = { "Placa", "Marca", "Tipo", "Cliente", "Apellido","Telefono","Entrada","Salida"};
	private JScrollPane scrollPane;
	private JTable table;
	 private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public Estacionamiento() {
		setLayout(null);
		tablaVehi.registrarPanel(this);
		{
			lblNewLabel = new JLabel("Ingresar Placa : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(42, 52, 151, 23);
			add(lblNewLabel);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(177, 54, 220, 20);
			add(txtPlaca);
		}
		{
			btnNewButton = new JButton("Listar");
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(435, 450, 119, 23);
			add(btnNewButton);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnBuscar.setBounds(456, 53, 131, 23);
			add(btnBuscar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(42, 106, 653, 318);
			add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				Object[][] datos = new Object[tablaVehi.Size()][8];

				for (int i = 0; i < tablaVehi.Size(); i++) {
					vehiculo p = tablaVehi.Get(i);
					datos[i][0] = p.getPlacVehiculo();
					datos[i][1] = p.getMarVehiculo();
					datos[i][2] = p.getTipVehiculo();
					datos[i][3] = p.getCli().getNomCliente();
					datos[i][4] = p.getCli().getApeCliente();
					datos[i][5] = p.getCli().getTelfCliente();
					datos[i][6] = p.getFechaHoraEntrada();
					datos[i][7] = p.VerificarSalida();
				}
				table.setModel(new DefaultTableModel(datos, columnas));
			}
			
		}
		
	}
	//
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	String Placa() {
		return txtPlaca.getText();
	}
	
	
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		try {
			if(Placa().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			vehiculo p=tablaVehi.Search(Placa());
	        if (p!=null) {
	        	JOptionPane.showMessageDialog(this, "Producto encontrado");
	        	table.setModel(new DefaultTableModel());
	        	Object[][] datos = new Object[tablaVehi.Size()][8];

				for (int i = 0; i < tablaVehi.Size(); i++) {
					
					datos[0][0] = p.getPlacVehiculo();
					datos[0][1] = p.getMarVehiculo();
					datos[0][2] = p.getTipVehiculo();
					datos[0][3] = p.getCli().getNomCliente();
					datos[0][4] = p.getCli().getApeCliente();
					datos[0][5] = p.getCli().getTelfCliente();
					datos[0][6] = p.getFechaHoraEntrada();
					datos[0][7] = p.VerificarSalida();
	        	table.setModel(new DefaultTableModel(datos, columnas));
				}
			}
	        else {
	        	JOptionPane.showMessageDialog(this, "La placa no existe");
			}
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Error al buscar");
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[][] datos = new Object[tablaVehi.Size()][8];

		for (int i = 0; i < tablaVehi.Size(); i++) {
			vehiculo p = tablaVehi.Get(i);
			datos[i][0] = p.getPlacVehiculo();
			datos[i][1] = p.getMarVehiculo();
			datos[i][2] = p.getTipVehiculo();
			datos[i][3] = p.getCli().getNomCliente();
			datos[i][4] = p.getCli().getApeCliente();
			datos[i][5] = p.getCli().getTelfCliente();
			datos[i][6] = p.getFechaHoraEntrada();
			datos[i][7] = p.VerificarSalida();
		}
		table.setModel(new DefaultTableModel(datos, columnas));
	}
	
	public void actualizarTablaCompleta() {
		
	        SwingUtilities.invokeLater(() -> {
	            tableModel.setRowCount(0);
	            for (int i = 0; i < tablaVehi.Size(); i++) {
	                vehiculo p = tablaVehi.Get(i);
	                tableModel.addRow(new Object[]{
	                    p.getPlacVehiculo(),
	                    p.getMarVehiculo(),
	                    p.getTipVehiculo(),
	                    p.getCli().getNomCliente(),
	                    p.getCli().getApeCliente(),
	                    p.getCli().getTelfCliente(),
	                    p.getFechaHoraEntrada(),
	                    p.VerificarSalida()
	                });
	            }
	        });
	    }
	
}
