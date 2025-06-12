package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Arreglos.vehicleArray;

public class vehiculo {
	private String placVehiculo;
    private String marVehiculo;
    private String tipVehiculo;
    private Factura fac;
    private cliente cli;
    private int codVehiculo;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    
    private static final DateTimeFormatter FORMATO_FECHA_HORA = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public vehiculo(String placVehiculo, String marVehiculo, String tipVehiculo, 
                   cliente cli, int codVehiculo,Factura fac) {
        this.placVehiculo = placVehiculo;
        this.marVehiculo = marVehiculo;
        this.tipVehiculo = tipVehiculo;
        this.cli = cli;
        this.fac = fac;
        this.codVehiculo = codVehiculo;
        this.fechaHoraEntrada = LocalDateTime.now(); // Registra automáticamente la entrada
    }
    
    //FormatoFH
    private String formatearFecha(LocalDateTime fecha) {
        if (fecha == null) return "No registrada";
        return fecha.format(FORMATO_FECHA_HORA);
    }
    
    // Getters y Setters
    public String getPlacVehiculo() {
        return placVehiculo;
    }

    public void registrarSalida() {
        this.fechaHoraSalida = LocalDateTime.now();
    }
    
    public Factura getFac() {
		return fac;
	}

	public void setFac(Factura fac) {
		this.fac = fac;
	}

	public String getMarVehiculo() {
		return marVehiculo;
	}

	public String getTipVehiculo() {
		return tipVehiculo;
	}

	public void setPlacVehiculo(String placVehiculo) {
		this.placVehiculo = placVehiculo;
	}

	public void setMarVehiculo(String marVehiculo) {
		this.marVehiculo = marVehiculo;
	}

	public void setTipVehiculo(String tipVehiculo) {
		this.tipVehiculo = tipVehiculo;
	}

	public int getCodVehiculo() {
		return codVehiculo;
	}

	public void setCodVehiculo(int codVehiculo) {
		this.codVehiculo = codVehiculo;
	}

	public cliente getCli() {
		return cli;
	}

	public void setCli(cliente cli) {
		this.cli = cli;
	}
	
	//
	public LocalDateTime getFechaHoraEntrada() {
		return fechaHoraEntrada;
	}

	
	//
	public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
		this.fechaHoraEntrada = fechaHoraEntrada;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	//method
	public long calcularTiempoEstacionamiento() {
        if (fechaHoraEntrada == null) return 0;
        LocalDateTime hasta = fechaHoraSalida != null ? fechaHoraSalida : LocalDateTime.now();
        return Duration.between(fechaHoraEntrada, hasta).toMinutes();
    }
    
	public String DatoVehiculo() {
		 return "Placa: " + placVehiculo + "\n"+
	               "Marca: " + marVehiculo + "\n"+
	               "Tipo: " + tipVehiculo +"\n"+
	               "Cliente: " + cli.getNomCliente() +"\n"+
	               "Telefono: " + cli.getTelfCliente() +"\n";
	}
    public String Entrada() {
        return DatoCompletoVehi() +
               "Entrada: " + formatearFecha(fechaHoraEntrada )+"\n"+
               "Salida: Sigue en estacionamiento\n\n";
    }
    public String Salida() {
        long minutos = calcularTiempoEstacionamiento();
        long horas = minutos / 60;
        long minutosRestantes = minutos % 60;
        
        return DatoCompletoVehi() +
               "Entrada: " + formatearFecha(fechaHoraEntrada) + "\n" +
               "Salida: " + formatearFecha(fechaHoraSalida) + "\n" +
               "Tiempo estacionado: " + horas + "h " + minutosRestantes + "m\n" +
               "Tipo: " + tipVehiculo + "\n" +
               "Horas cobradas: " + getHorasCobradas() + "\n" +
               "Costo total: S/" + String.format("%.2f", calcularCostoEstacionamiento()) + "\n\n";
    }
    public String DatoCompletoVehi() {
    	return "Codigo: " + codVehiculo + "\n"+
    			"Placa: " + placVehiculo + "\n"+
	            "Marca: " + marVehiculo + "\n"+
	            "Tipo: " + tipVehiculo +"\n"+
	            "Cliente: " + cli.getNomCliente() +"\n"+
	            "Apellido : " + cli.getApeCliente() + "\n"+
	            "Telefono : " + cli.getTelfCliente() + "\n";
    }
    
    //
    //
    public double calcularCostoEstacionamiento() {
        long minutosTotales = calcularTiempoEstacionamiento();
        
        // Siempre se cobra mínimo 1 hora
        if (minutosTotales <= 60) {
            return getTarifaPorTipo();
        }
        
        // Calcular horas redondeando hacia arriba
        long horasRedondeadas = minutosTotales / 60;
        if (minutosTotales % 60 > 0) {
            horasRedondeadas++;
        }
        
        return horasRedondeadas * getTarifaPorTipo();
    }
    //metodo
     public int getTarifaPorTipo() {
    	return  fac.getTarifaTipoVehiculo(getTipVehiculo());
     }
    //metodo 
     private long getHorasCobradas() {

         long minutos = calcularTiempoEstacionamiento();
         if (minutos <= 60) return 1;
         
         long horas = minutos / 60;
         if (minutos % 60 > 0) {
             return horas + 1;
         }
         return horas;
     }
}

    
    

