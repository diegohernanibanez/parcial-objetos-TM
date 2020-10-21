package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import modelo.Servicio;
import funciones.Funciones;

public class Sistema {
	
	private List<Servicio> lstServicio = new ArrayList<>();

	public Sistema(List<Servicio> lstServicio) {
		super();
		this.lstServicio = lstServicio;
	}

	public List<Servicio> getLstServicio() {
		return lstServicio;
	}

	public void setLstServicio(List<Servicio> lstServicio) {
		this.lstServicio = lstServicio;
	}

	@Override
	public String toString() {
		return "Sistema [lstServicio=\n" + lstServicio + "]";
	} 
	
	public List<Servicio> traerServicio (boolean enPromocion, LocalDate dia)
	{	
	
		List<Servicio> servicioList = new ArrayList<Servicio>();
		for (Servicio servicio : this.lstServicio) {
			if (servicio instanceof Gastronomia ) {
				if (Funciones.traerDiaDeLaSemana(dia)==((Gastronomia)servicio).getDiaSemDesc()) {
					servicioList.add(servicio);
				}
			}
		}
		return servicioList;
	}
	
	
	public Servicio traerServicio (String codServicio)
	{
		Servicio s1=null;
		
		for (Servicio servicio : this.lstServicio) {
			if(servicio.getCodServicio()==codServicio)
			{
				s1 = servicio;
			}
			
		}
		return s1;
	}
	
	public List<Servicio> traerServicio (boolean enPromocion)
	{
		List<Servicio> servicioList = new ArrayList<Servicio>();
		for (Servicio servicio : this.lstServicio) {

			if(enPromocion==servicio.isEnPromocion())
			{	
				servicioList.add(servicio);
			}

		}

		return servicioList;
	}
	
	public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String
			gastronomia, double precio, int diaSemDesc) throws Exception{
		
		boolean existeGastronomia=false;
		Gastronomia gastronomiaAux = null;
		// List <Servicio> listAux = new ArrayList<Servicio>();
		
		for (Servicio servicio : this.lstServicio) {
			if(servicio.getCodServicio()==codServicio){
				existeGastronomia = true;
				throw new Exception("Ya existe esa gastronomia");
			}//If
		}//For
			if (!existeGastronomia){
				gastronomiaAux= new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
				this.lstServicio.add(gastronomiaAux);
			}//Else
			
		
	

		return existeGastronomia;
	}//agregarGastronomia
	 
	public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String
			hospedaje,double precioPorNoche)throws Exception{
		
		boolean existeHospedaje=false;
		Hospedaje hospedajeAux = null;
		
		for (Servicio servicio : lstServicio) {
			
			if (servicio.getCodServicio()==codServicio) {
				existeHospedaje = true;
				throw new Exception("Ya existe ese Hospedaje");
			}//if
		}//for
			if (!existeHospedaje) {				
				hospedajeAux = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
				this.lstServicio.add(hospedajeAux);
				}
			
			
				
			
		

		return existeHospedaje;
		
	}//agregarHospedaje
	

}
