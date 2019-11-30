package co.edu.icesi.ci.talleres.delegate;

import co.edu.icesi.ci.talleres.model.Tmio1Ruta;

public interface RutaDelegate {

	public Iterable<Tmio1Ruta> getRutas();
	
	public Tmio1Ruta getRuta(Integer id);
	
	public Tmio1Ruta addRuta(Tmio1Ruta ruta);
	
	public void delRuta(Tmio1Ruta ruta);
	
}
