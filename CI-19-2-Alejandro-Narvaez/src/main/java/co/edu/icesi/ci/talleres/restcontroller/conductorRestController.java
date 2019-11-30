package co.edu.icesi.ci.talleres.restcontroller;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

public interface conductorRestController {
	
	public Iterable<Tmio1Conductore> getConductores();
	
	public Tmio1Conductore addConductor(Tmio1Conductore conductor);
	
	public Tmio1Conductore delConductor(String cedula);

}
