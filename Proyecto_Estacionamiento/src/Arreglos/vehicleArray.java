package Arreglos;

import java.util.ArrayList;

import clases.Factura;
import clases.cliente;
import clases.vehiculo;
import gui.Estacionamiento;
import gui.lista;


public class vehicleArray {
	private static final vehicleArray instancia = new vehicleArray();

    private ArrayList<vehiculo> vehicle;
    
    // 3. Constructor privado para evitar instanciación externa
    private vehicleArray() {
    	notificarActualizacion();
    	
        vehicle = new ArrayList<vehiculo>();
    }
    
    // 4. Método estático para obtener la instancia única
    
    public static  vehicleArray getInstancia() {     
        return instancia;
    }
	
	public void Add(vehiculo v) {
		vehicle.add(v);
		notificarActualizacion();
		Actualizacion_1();
	}
	
	public vehiculo Get(int v) {
		return vehicle.get(v);
	}
	
	public int Size() {
		return vehicle.size();
	}
	public void Notificar() {
		notificarActualizacion();
		Actualizacion_1();
		
	}
	
	public vehiculo Search(String plate) {
		for (int i = 0; i < Size(); i++) {
			if (Get(i).getPlacVehiculo().equals(plate)) {
				return Get(i);
			}
		}
		return null;
	}
	public void Delete(vehiculo x) {
		vehicle.remove(x);
		notificarActualizacion();
		Actualizacion_1();
	}
	public static void initializeSampleData() {
		vehicleArray lista = vehicleArray.getInstancia();// datos predeterminados
		// Clientes originales (2)
	    cliente cliente1 = new cliente("Juan", "Perez", "12345678", 001);
	    cliente cliente2 = new cliente("Maria", "Gomez", "87654321", 002);
	    
	    // 8 nuevos clientes
	    cliente cliente3 = new cliente("Carlos", "Rodriguez", "5551234", 003);
	    cliente cliente4 = new cliente("Ana", "Lopez", "5555678", 004);
	    cliente cliente5 = new cliente("Luis", "Martinez", "5559012", 005);
	    cliente cliente6 = new cliente("Sofia", "Garcia", "5553456", 006);
	    cliente cliente7 = new cliente("Pedro", "Sanchez", "5557890", 007);
	    
	    
	    // Facturas para cada cliente
	    Factura factura1 = new Factura(001);
	    Factura factura2 = new Factura(002);
	    Factura factura3 = new Factura(003);
	    Factura factura4 = new Factura(004);
	    Factura factura5 = new Factura(005);
	    Factura factura6 = new Factura(006);
	    Factura factura7 = new Factura(007);
	    
	    
	    // Vehículos originales (2)
	    lista.Add(new vehiculo("ABC123", "Toyota", "Ligero", cliente1, 1, factura1));
	    lista.Add(new vehiculo("XYZ789", "Nissan", "Ligero", cliente2, 2, factura2));
	    
	    // 8 nuevos vehículos con diferentes características
	    lista.Add(new vehiculo("DEF456", "Honda",  "Ligero", cliente3, 3, factura3));
	    lista.Add(new vehiculo("GHI789", "Ford", "Pesado", cliente4, 4, factura4));
	    lista.Add(new vehiculo("JKL012", "Chevrolet", "Ligero", cliente5, 5, factura5));
	    lista.Add(new vehiculo("MNO345", "Volkswagen",  "Pesado", cliente6, 6, factura6));
	    lista.Add(new vehiculo("PQR678", "Hyundai","Ligero", cliente7, 7, factura7));
	    
    }
	
	//Actualizacion Panel Lista
	private lista panelLista;
	private Estacionamiento panelEsta;
	
	public void registrarPanelLista(lista panel) {
        this.panelLista = panel;
    }

    private void notificarActualizacion() {
        if (panelLista != null) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                panelLista.actualizarTablaCompleta();
            });
           
        }
    }
    
    //Actualizacion Panel Estacionamiento
    public void registrarPanel(Estacionamiento panel) {
        this.panelEsta = panel;
    }

    private void Actualizacion_1() {
        if (panelEsta != null) {
            javax.swing.SwingUtilities.invokeLater(() -> {
            	panelEsta.actualizarTablaCompleta();
            });
           
        }
    }
    
 
    
}
