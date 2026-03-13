package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Arreglos.vehicleArray;
import clases.vehiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class lista extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JScrollPane scrollPane = new JScrollPane();
	
	private final JTextArea txtS = new JTextArea();
	
	private final JButton btnBuscar = new JButton("Buscar");
	private final JButton btnNewButton = new JButton("Listar");
	
	private final JLabel lblNewLabel = new JLabel("Ingresar Placa : ");
	
	private final JTextField txtPlaca = new JTextField();
	private vehicleArray tablaVehi = vehicleArray.getInstancia();
	
	private String[] columnas = { "Placa", "Marca", "Tipo", "Cliente", "Apellido","Telefono","Entrada","Salida"};
	private final JTable table;
	private DefaultTableModel tableModel;
	

	/**
	 * Create the panel.
	 */
	public lista() {
		setLayout(null);
		tablaVehi.registrarPanelLista(this);
		actualizarTablaCompleta();
		
		{
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(568, 448, 131, 23);
			add(btnBuscar);
		}
		{
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(439, 448, 119, 23);
			add(btnNewButton);
		}
		{
			
			scrollPane.setBounds(44, 103, 655, 318);
			add(scrollPane);
			tableModel = new DefaultTableModel(columnas, 0);
		    table = new JTable(tableModel);			
			scrollPane.setViewportView(table);
									
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			txtPlaca.setBounds(181, 52, 220, 20);
			add(txtPlaca);
			txtPlaca.setColumns(10);
		}
		{
			
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(46, 50, 151, 23);
			add(lblNewLabel);
		}
		 vehicleArray.initializeSampleData();
		 //mostrarDatos();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	
	String Placa() {
		if(txtPlaca.getText().isEmpty())
			return null;
		return txtPlaca.getText();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) { //Listar todo
		actualizarTablaCompleta();
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
	
	
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) { //Buscar
		try {
			if(Placa().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			vehiculo p=tablaVehi.Search(Placa());
			if (p != null) {
	            JOptionPane.showMessageDialog(this, "Vehículo encontrado");
	            tableModel.setRowCount(0); // Limpiar la tabla
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
	        else {
	        	JOptionPane.showMessageDialog(this, "La placa no existe");
			}
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Error al buscar");
		}
	}
}
