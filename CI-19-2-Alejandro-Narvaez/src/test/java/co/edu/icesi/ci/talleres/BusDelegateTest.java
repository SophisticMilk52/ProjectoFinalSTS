package co.edu.icesi.ci.talleres;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
//import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import co.edu.icesi.ci.talleres.delegate.BusDelegate;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BusDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Autowired
	@InjectMocks
	private BusDelegate busDelegate;
	
	final String URI_SERVER = "http://localhost:8080/";
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void crearBusTest() {
		Tmio1Bus bus1 = new Tmio1Bus();
		Tmio1Bus bus2 = new Tmio1Bus();
		
		bus1.setCapacidad(10.0);
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(2019);
		
		bus2.setCapacidad(20.0);
		bus2.setMarca("chevrolet");
		bus2.setPlaca("ADX413");
		bus2.setModelo(2019);
		//Yo le doy comportamiento a los metodos del RestTemplate
		Tmio1Bus[] buses = {bus1, bus2};
		
		//Mockito.when(restTemplate.getForObject(URI_SERVER + "buses", Tmio1Bus[].class)).then(buses);
		assertEquals(true, true);
	}
	
}
