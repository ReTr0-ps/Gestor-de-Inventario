package LogicaNegocio;

public class Cajero extends Usuario{



	private int numeroCaja;
	private int turno;
	private double totalDeVentas;
	private double efectivoDisponible;
	
	
	//Constructor
	
	public Cajero(int id, String nombreUsuario, String contrasena, int nivelDeAcceso) {
		
		super(id, nombreUsuario, contrasena, nivelDeAcceso);
		
	}
	
	
	//Getters y Setters
	
	public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    // Getter y Setter para turno
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    // Getter y Setter para totalDeVentas
    public double getTotalDeVentas() {
        return totalDeVentas;
    }

    public void setTotalDeVentas(double totalDeVentas) {
        this.totalDeVentas = totalDeVentas;
    }

    // Getter y Setter para efectivoDisponible
    public double getEfectivoDisponible() {
        return efectivoDisponible;
    }

    public void setEfectivoDisponible(double efectivoDisponible) {
        this.efectivoDisponible = efectivoDisponible;
    }
	
}
