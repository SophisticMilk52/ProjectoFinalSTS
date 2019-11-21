package co.edu.icesi.ci.talleres;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.ci.talleres.dao.DAOBus;
import co.edu.icesi.ci.talleres.dao.DAOConductor;
import co.edu.icesi.ci.talleres.dao.DAORuta;
import co.edu.icesi.ci.talleres.dao.DAOServicio;
import co.edu.icesi.ci.talleres.model.Tmio1Bus;
import co.edu.icesi.ci.talleres.model.Tmio1Conductore;
import co.edu.icesi.ci.talleres.model.Tmio1Ruta;
import co.edu.icesi.ci.talleres.model.Tmio1Servicio;
import co.edu.icesi.ci.talleres.model.Tmio1ServicioPK;

@SpringBootTest(classes = Ci192TalleresApplication.class)
@RunWith(SpringRunner.class)
@Rollback
public class TestTmio1Bus {

	@Autowired
	private DAOBus bus;
	@Autowired
	private DAORuta rutad;
	@Autowired
	private DAOConductor conductord;
	@Autowired
	private DAOServicio serviciod;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public void escenario() {
		assertNotNull(bus);
		Tmio1Bus talumno = new Tmio1Bus();
		talumno.setMarca("Mazda");
		talumno.setModelo(6969);
		talumno.setPlaca("ABC123");
		bus.save(talumno);
	}

	// --------------------------------------------------------------------
	// PRUEBA
	// --------------------------------------------------------------------
	public void escenario2() throws ParseException {
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setActiva("si");
		ruta.setDiaInicio(new BigDecimal(20));
		ruta.setDiaFin(new BigDecimal(26));
		ruta.setNumero("123");
		ruta.setDescripcion("descrpcion");
		ruta.setHoraInicio(new BigDecimal(180));
		ruta.setHoraFin(new BigDecimal(200));
		
		rutad.save(ruta);
		
		Tmio1Bus bu = new Tmio1Bus();
		bu.setMarca("Mazda");
		bu.setModelo(123);
		bu.setPlaca("IPA666");
		bu.setCapacidad(20.0);

		
		bus.save(bu);
		
		Tmio1Conductore condu = new Tmio1Conductore();
		condu.setCedula("123456");
		condu.setApellidos("Morales");
		condu.setNombre("Larvo");
		condu.setFechaNacimiento(format.parse("1998-12-01"));
		condu.setFechaContratacion(format.parse("1999-12-01"));

		
		conductord.save(condu);
		
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		pk.setCedulaConductor("123456");
		pk.setIdBus(bu.getId());
		pk.setIdRuta(ruta.getId());
		pk.setFechaInicio(format.parse("2003-12-10"));
		pk.setFechaFin(format.parse("2003-12-20"));

		Tmio1Servicio serv = new Tmio1Servicio();
		serv.setTmio1Bus(bu);
		serv.setTmio1Conductore(condu);
		serv.setId(pk);
		serv.setTmio1Ruta(ruta);
		
		serviciod.save(serv);
		
		pk = new Tmio1ServicioPK();
		pk.setCedulaConductor("123456");
		pk.setIdBus(bu.getId());
		pk.setIdRuta(ruta.getId());
		pk.setFechaInicio(format.parse("2003-12-05"));
		pk.setFechaFin(format.parse("2003-12-25"));
		
		serv = new Tmio1Servicio();
		serv.setTmio1Bus(bu);
		serv.setTmio1Conductore(condu);
		serv.setId(pk);
		serv.setTmio1Ruta(ruta);
		
		serviciod.save(serv);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void VigenciaTest() throws ParseException {
		escenario2();
		Date fecha;
		try {
			fecha = format.parse("2003-12-15");
			assertEquals(1, bus.buscarDatosServicioVigencia(fecha).size());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------
	// FINAL DE LA PRUEBA
	// ------------------------------------------------------------------------
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void agregarTest() {
		assertNotNull(bus);
		Tmio1Bus talumno = new Tmio1Bus();
		talumno.setMarca("Mazada");
		talumno.setModelo(6969);
		talumno.setPlaca("ABC123");
		bus.save(talumno);
		assertNotNull(bus.findAll().get(0));

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {
		assertNotNull(bus);
		Tmio1Bus talumno = new Tmio1Bus();
		talumno.setMarca("Mazada");
		talumno.setModelo(6969);
		talumno.setPlaca("ABC123");
		bus.save(talumno);

		bus.delete(bus.findAll().get(0));
		assertEquals(0, bus.findAll().size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void buscarPlacaTest() {
		this.escenario();
		assertNotNull(bus.buscarPorPlaca("ABC123").get(0));

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {
		assertNotNull(bus);
		Tmio1Bus talumno = new Tmio1Bus();
		talumno.setMarca("Mazda");
		talumno.setModelo(6969);
		talumno.setPlaca("ABC123");
		bus.save(talumno);
		talumno.setPlaca("EFD123");
		talumno.setMarca("IPA");
		talumno.setModelo(2222);
		bus.update(talumno);
		assertNotNull(bus.findAll());
		assertEquals(1, bus.buscarPorMarca("IPA").size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void buscarMarcaTest() {
		this.escenario();
		assertNotNull(bus.buscarPorMarca("Mazda").get(0));

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void buscarModeloTest() {
		this.escenario();
		assertNotNull(bus.buscarPorModelo(6969).get(0));

	}

}
