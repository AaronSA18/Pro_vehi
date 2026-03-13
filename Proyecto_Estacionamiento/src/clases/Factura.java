package clases;

public class Factura {
	private int idFactura;
	
	
	public Factura(int idFactura) {
		
		this.idFactura = idFactura;
	}
// getter and setter
	
	
	
	
	
	//
	public int getTarifaTipoVehiculo(String tipoVehiculo) {
		if(tipoVehiculo=="Pesado")return 8;
		return 4;
		
	}
}
