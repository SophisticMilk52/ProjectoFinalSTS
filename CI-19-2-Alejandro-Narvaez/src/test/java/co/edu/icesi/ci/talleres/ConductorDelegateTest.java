package co.edu.icesi.ci.talleres;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;

import co.edu.icesi.ci.talleres.delegate.BusDelegateImp;
import co.edu.icesi.ci.talleres.delegate.ConductorDelegateImp;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ConductorDelegateTest {

	@Mock
	private RestTemplate restTemplate;
	

	@InjectMocks
	@Autowired
	private ConductorDelegateImp busDelegate;
	
	final String URI_SERVER = "http://localhost:8080/api/";
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void MostrarBusTest() {
		Tmio1Conductore bus1 = new Tmio1Conductore();
		Tmio1Conductore bus2 = new Tmio1Conductore();
		
		bus1.setCedula("12223");
		bus1.setNombre("Beycker");
		bus1.setApellidos("Agredo");
		bus1.setFechaNacimiento(new Date(20));
		bus1.setFechaContratacion(new Date(30));

		bus1.setCedula("22233");
		bus1.setNombre("Narvaez");
		bus1.setApellidos("Alejandro");
		bus1.setFechaNacimiento(new Date(40));
		bus1.setFechaContratacion(new Date(50));
		//Yo le doy comportamiento a los metodos del RestTemplate
		Tmio1Conductore[] buses = {bus1, bus2};
		
	Mockito
    .when(restTemplate.getForObject(
    		URI_SERVER + "conductores",Tmio1Conductore[].class))
    .thenReturn(buses);

	Iterable<Tmio1Conductore> employee = busDelegate.getConductores();
    
	assertEquals(bus1.getCedula(), employee.iterator().next().getCedula());

	}
	
	@Test
	public void AgregarBusTest() {
		
		Tmio1Conductore bus1 = new Tmio1Conductore();
	
		
		bus1.setCedula("21221");
		bus1.setNombre("Beycker");
		bus1.setApellidos("Agredo");
		bus1.setFechaNacimiento(new Date(20));
		bus1.setFechaContratacion(new Date(30));

		Mockito.when(restTemplate.postForEntity(URI_SERVER + "conductores", bus1, Tmio1Conductore.class)).thenReturn(new ResponseEntity<Tmio1Conductore>(bus1, HttpStatus.OK));
	Mockito.when( restTemplate.getForObject(URI_SERVER + "conductores/" + bus1.getCedula(), Tmio1Conductore.class)).thenReturn(bus1);

	Tmio1Conductore employee = busDelegate.getConductor(bus1.getCedula());
    
	assertEquals(bus1.getCedula(), employee.getCedula());

	}
	
}
