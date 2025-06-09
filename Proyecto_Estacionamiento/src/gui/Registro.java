package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import Arreglos.ClienteArray;
import Arreglos.vehicleArray;
import clases.Factura;
import clases.cliente;
import clases.vehiculo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblRegistrarNuevoVehculo_1;
	private JLabel lblNewLabel_1;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JLabel lblMarca;
	private JLabel lblVehculo;
	private JComboBox cmbTipo;
	private JLabel lblRegistrarChofer;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JTextField txtTelf;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	
	vehicleArray listaVehiculo = vehicleArray.getInstancia();
	
	/**
	 * Create the panel.
	 */
	public Registro() {
		
		setLayout(null);
		
		{
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(96, 204, 146, 20);
			add(txtApellido);
		}
		{
			lblRegistrarChofer = new JLabel("Registrar Chofer");
			lblRegistrarChofer.setBounds(27, 155, 146, 14);
			add(lblRegistrarChofer);
		}
		{
			cmbTipo = new JComboBox();
			cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Ligero", "Pesado"}));
			cmbTipo.setBounds(95, 100, 147, 22);
			add(cmbTipo);
		}
		{
			lblNewLabel_2 = new JLabel("Imagen");
			lblNewLabel_2.setBounds(287, 48, 139, 96);
			add(lblNewLabel_2);
		}
		{
			txtTelf = new JTextField();
			txtTelf.setColumns(10);
			txtTelf.setBounds(96, 229, 146, 20);
			add(txtTelf);
		}
		{
			txtPlaca = new JTextField();
			txtPlaca.setColumns(10);
			txtPlaca.setBounds(95, 44, 147, 20);
			add(txtPlaca);
		}
		{
			lblNewLabel_1 = new JLabel("Placa:");
			lblNewLabel_1.setBounds(30, 47, 46, 14);
			add(lblNewLabel_1);
		}
		{
			lblVehculo = new JLabel("Vehículo: ");
			lblVehculo.setBounds(27, 104, 65, 14);
			add(lblVehculo);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(95, 72, 147, 20);
			add(txtMarca);
		}
		{
			lblTelefono = new JLabel("Telefono :");
			lblTelefono.setBounds(29, 232, 82, 14);
			add(lblTelefono);
		}
		{
			btnNewButton = new JButton("Ingresar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(337, 262, 89, 23);
			add(btnNewButton);
		}
		{
			lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(27, 75, 49, 14);
			add(lblMarca);
		}
		{
			lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(28, 182, 83, 14);
			add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(28, 207, 83, 14);
			add(lblApellido);
		}
		{
			lblRegistrarNuevoVehculo_1 = new JLabel("Registrar nuevo vehículo");
			lblRegistrarNuevoVehculo_1.setBounds(27, 22, 146, 14);
			add(lblRegistrarNuevoVehculo_1);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(96, 179, 146, 20);
			add(txtNombre);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	
	
	String Placa() {
		return txtPlaca.getText();
	}
	String Marca() {
		return txtMarca.getText();
	}
	String tipoVehiculo() {
		return  cmbTipo.getSelectedItem().toString();
	}
	String NomCliente() {
		return txtNombre.getText();
	}
	String ApleCliente() {
		return txtApellido.getText();
	}
	String Telf() {
		return txtTelf.getText();	
	}
	int Contador() {
		if(listaVehiculo.Size()==0)return 0;
		return listaVehiculo.Size()+1;
	}
	
	
	private void limpiarCampos() {
	    txtPlaca.setText("");
	    txtMarca.setText("");
	    txtNombre.setText("");
	    txtApellido.setText("");
	    txtTelf.setText("");
	    cmbTipo.setSelectedIndex(0);
	    txtPlaca.requestFocus(); // Pone el foco en el campo de placa
	}
	
	
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	try {
	        // Validar campos obligatorios
	        if(Placa().isEmpty() || Marca().isEmpty() || NomCliente().isEmpty() || 
	           ApleCliente().isEmpty() || Telf().isEmpty()) {
	            JOptionPane.showMessageDialog(this, 
	                "Todos los campos son obligatorios", 
	                "Error", 
	                JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        vehiculo v = listaVehiculo.Search(Placa());
	        
	        if(v != null) {
	            JOptionPane.showMessageDialog(
	                this,
	                "La placa " + Placa() + " ya está registrada",
	                "Placa duplicada",
	                JOptionPane.WARNING_MESSAGE
	            );
	        }
	        else {
	            int k = Contador(); //ayuda estabilizar el mismo a vehiculo y chofer
	            cliente a = new cliente(NomCliente(), ApleCliente(), Telf(), k);
	            Factura b = new Factura(k);
	            v = new vehiculo(Placa(), Marca(), tipoVehiculo(), a, k,b);
	            
	            listaVehiculo.Add(v);
	           // vehicleArray.getInstancia().Add(v); ///
	           
	                
	                // Mensaje de confirmación
	                JOptionPane.showMessageDialog(
	                    this,
	                    "Vehículo registrado:\n" +
	                    "Placa: " + v.getPlacVehiculo() + "\n" +
	                    "Marca: " + v.getMarVehiculo() + "\n" +
	                    "Dueño: " + a.getNomCliente() + " " + a.getApeCliente(),
	                    "Registro exitoso",
	                    JOptionPane.INFORMATION_MESSAGE
	                );
	                
	                // Limpiar campos después del registro
	                
	                limpiarCampos();
	            }
	        
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this,"Error al registrar");
	    }
		
	}
}
