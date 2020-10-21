package modelo;

import java.time.LocalDate;

public abstract class Servicio {
protected String codServicio;
protected double porcentajeDescuento;
protected boolean enPromocion;
public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
	super();
	this.porcentajeDescuento = porcentajeDescuento;
	this.enPromocion = enPromocion;
	setCodServicio(codServicio);
}
public String getCodServicio() {
	return codServicio;
}
public void setCodServicio(String codServicio) throws Exception {
	if (codServicio.length()==6){
		this.codServicio = codServicio;
	}
	else {
		throw new Exception("Largo Incorrecto");
	}
	
	
}
public double getPorcentajeDescuento() {
	return porcentajeDescuento;
}
public void setPorcentajeDescuento(double porcentajeDescuento) {
	this.porcentajeDescuento = porcentajeDescuento;
}
public boolean isEnPromocion() {
	return enPromocion;
}
public void setEnPromocion(boolean enPromocion) {
	this.enPromocion = enPromocion;
}
@Override
public String toString() {
	return "Servicio [codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion="
			+ enPromocion + "]";
}

protected abstract double calcularPrecioFinal (LocalDate dia);


}
