package co.com.poli.appcreditos.business;

import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface ICreditoBusiness {

    List<Credito> obtenerListaCreditos();

    String crearCredito(Credito credito);

    Credito obtenerCredito(String numero);
    
    String creditoMasUsado();
    String acumuladoCreditos();
    String mayorPrestamista();

}
