package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Gastronomia;
import modelo.Hospedaje;
import modelo.Servicio;
import modelo.Sistema;

public class Test {
	
	public static void main(String[] args) {
		
		Servicio g1 = null;
		
		Servicio h1 = null;
		
		
		try {
			g1 = new Gastronomia("4892", 15.0f, true, "Hamburguesa Criolla", 180.0f, 3);
		} catch (Exception e) {
			System.out.println(e);	
		}
		
		try {
			g1 = new Gastronomia("489235", 15.0f, true, "Hamburguesa Criolla", 180.0f, 3);
		} catch (Exception e) {
			System.out.println(e);	
		}
		
		try {
			h1 = new Hospedaje("2872", 10.0f, true,"Caba�a 3 personas", 1500.0f);
		} catch (Exception e) {
			System.out.println(e);	
		}
		try {
			h1 = new Hospedaje("287282", 10.0f, true,"Caba�a 3 personas", 1500.0f);
		} catch (Exception e) {
			System.out.println(e);	
		}
		
		
		
		List <Servicio> sistemaServicio  = new ArrayList<Servicio>();

		sistemaServicio.add(g1);
		sistemaServicio.add(h1);
		Sistema sistema1 = new Sistema(sistemaServicio);
		

		
		try {
			sistema1.agregarGastronomia("858927", 15.0f, true, "Milanesa con pure",350.f, 3);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

		try {
			sistema1.agregarGastronomia("182835", 20.0f,false, "Gaseosa",120.0,3);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			sistema1.agregarHospedaje("489259",15.0f,true,"=Habitaci�n triple", 2200.0f);
		} catch (Exception e) {
			System.out.println(e);	
		}
		try {
			sistema1.agregarHospedaje("758972", 15.0f,false,"Habitaci�n simple",1000.0f);
		} catch (Exception e) {
			System.out.println(e);	
		}

		
		System.out.println("El precio final para g1 es: "+((Gastronomia)g1).calcularPrecioFinal(LocalDate.of(2020,10,28)));
		System.out.println("El precio final para h1 es: "+((Hospedaje)h1).calcularPrecioFinal(LocalDate.of(2020,10,27)));
		
		List<Servicio> serviciosEnPromocion = sistema1.traerServicio(true);
		List<Servicio> serviciosdeldia = sistema1.traerServicio(true, LocalDate.of(2020,10,28));
		

		System.out.println("\n*los servicios en promocion son los siguientes \n"+serviciosEnPromocion);
		System.out.println("\n*los servicios del dia promocion son los siguientes \n"+ serviciosdeldia);
		
		// Traer Servicio por codigo
		System.out.println("\n*Traer por codigo: "+sistema1.traerServicio("489235"));
		
		
		
		
		
		
	}//Main

}//Test
