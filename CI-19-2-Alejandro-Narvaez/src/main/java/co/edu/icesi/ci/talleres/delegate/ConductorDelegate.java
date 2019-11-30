package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1Conductore;

public interface ConductorDelegate {

	public Iterable<Tmio1Conductore> getConductores();
	
	public Tmio1Conductore getConductor(String cedula);
	
	public Tmio1Conductore addConductor(Tmio1Conductore conductor);
	
	public void delConductor(Tmio1Conductore conductor);
}
