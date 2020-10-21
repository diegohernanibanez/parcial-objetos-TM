package modelo;

import java.time.LocalDate;

public class Gastronomia extends Servicio  {
	
	private String gastronomia;
	private double precio;
	private int diaSemDesc;
	public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia,
			double precio, int diaSemDesc) throws Exception{
		super(codServicio, porcentajeDescuento, enPromocion);
		this.gastronomia = gastronomia;
		this.precio = precio;
		this.diaSemDesc = diaSemDesc;
	}
	public String getGastronomia() {
		return gastronomia;
	}
	public void setGastronomia(String gastronomia) {
		this.gastronomia = gastronomia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getDiaSemDesc() {
		return diaSemDesc;
	}
	public void setDiaSemDesc(int diaSemDesc) {
		this.diaSemDesc = diaSemDesc;
	}
	
	@Override
	public String toString() {
		return "Gastronomia [gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + "]\n";
	}
	
	@Override
	public double calcularPrecioFinal(LocalDate dia) {
	double precioFinal=0;
	
		//Aplica promocion en caso de que exista promocion, y el dia de la semana coincida con el dia de promocion
		if (enPromocion && (dia.getDayOfWeek().getValue()==this.getDiaSemDesc()))
		{
			precioFinal= this.precio * (this.porcentajeDescuento/100);
		}
		
		else {
			 precioFinal= this.precio;
		}
		return precioFinal;
	}


}
