package Arreglos;

import java.util.ArrayList;

import clases.Factura;
import clases.cliente;
import clases.vehiculo;
import gui.lista;


public class vehicleArray {
	private static final vehicleArray instancia = new vehicleArray();

    private ArrayList<vehiculo> vehicle;
    
    // 3. Constructor privado para evitar instanciación externa
    private vehicleArray() {
        vehicle = new ArrayList<vehiculo>();
    }
    
    // 4. Método estático para obtener la instancia única
    
    public static  vehicleArray getInstancia() {     
        return instancia;
    }
	
	public void Add(vehiculo v) {
		vehicle.add(v);
		notificarActualizacion();
	}
	
	public vehiculo Get(int v) {
		return vehicle.get(v);
	}
	
	public int Size() {
		return vehicle.size();
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
	}
	public static void initializeSampleData() {
		vehicleArray lista = vehicleArray.getInstancia();// datos predeterminados
        cliente cliente1 = new cliente("Juan", "Perez", "12345678",001);
        cliente cliente2 = new cliente("Maria", "Gomez", "87654321",002);
        
        Factura clienteA = new Factura(001);
        Factura clienteB = new Factura(002);
        
        lista.Add(new vehiculo("ABC123", "Toyota", "Ligero", cliente1, 1,clienteA));
        lista.Add(new vehiculo("XYZ789", "Nissan", "Ligero", cliente2, 2,clienteB));
    }
	
	//Actualizacion Panel Lista
	private lista panelLista;
	
	public void registrarPanelLista(lista panel) {
        this.panelLista = panel;
    }

    private void notificarActualizacion() {
        if (panelLista != null) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                panelLista.mostrarDatos();
            });
           
        }
    }
    
 
    
}
