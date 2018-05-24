package co.com.poli.appcreditos.dao;

import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface ICreditoDao {
    
    List<Credito> obtenerListaCreditos();
    String crearCredito(Credito credito);
    Credito obtenerCredito(String numero);   
}
