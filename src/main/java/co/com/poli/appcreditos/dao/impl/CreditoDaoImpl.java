package co.com.poli.appcreditos.dao.impl;

import co.com.poli.appcreditos.dao.ICreditoDao;
import co.com.poli.appcreditos.data.CreditoData;
import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class CreditoDaoImpl implements ICreditoDao{

    @Override
    public List<Credito> obtenerListaCreditos() {
        return CreditoData.getListaCreditos();
    }

    @Override
    public String crearCredito(Credito credito) {
        List<Credito> listaCreditos = CreditoData.getListaCreditos();
        listaCreditos.add(credito);
        CreditoData.setListaCreditos(listaCreditos);        
        return "Credito creado";
    }

    @Override
    public Credito obtenerCredito(String numero) {
        Credito credito = null;
        List<Credito> listaCreditos = CreditoData.getListaCreditos();
        for (Credito credit : listaCreditos) {
            if (credit.getCredito().equals(numero)) {
                credito = credit;
            }
        }
        return credito;
    }
}
