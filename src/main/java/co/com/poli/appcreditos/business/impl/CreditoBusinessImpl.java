package co.com.poli.appcreditos.business.impl;

import co.com.poli.appcreditos.business.ICreditoBusiness;
import co.com.poli.appcreditos.dao.impl.CreditoDaoImpl;
import co.com.poli.appcreditos.model.Credito;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class CreditoBusinessImpl implements ICreditoBusiness{

    private CreditoDaoImpl creditoDaoImpl = new CreditoDaoImpl();
    
    @Override
    public List<Credito> obtenerListaCreditos() {
        return creditoDaoImpl.obtenerListaCreditos();
    }

    @Override
    public String crearCredito(Credito credito) {
        boolean bandera = true;
        String respuesta = "Credito ya existe";
        Credito credit = obtenerCredito(credito.getCredito());
        
        List<Credito> listaCreditos = creditoDaoImpl.obtenerListaCreditos();
        
        for (Credito cred : listaCreditos) {
            if (cred.getDocumento().equalsIgnoreCase(credit.getDocumento())) {//si el documento ya tiene 1 credito
                
                if (cred.getTipoCredito().equalsIgnoreCase(credito.getTipoCredito())) {
                    respuesta = "Ya tiene un credito de este tipo";
                    bandera = false;
                }
                
            }
        }
        if (bandera) {
            respuesta = creditoDaoImpl.crearCredito(credito);
        }
        
        if (credit==null) {
            respuesta = creditoDaoImpl.crearCredito(credito);
        }
        return respuesta;
    }

    @Override
    public Credito obtenerCredito(String numero) {
        return creditoDaoImpl.obtenerCredito(numero);
    }

    @Override
    public String creditoMasUsado() {
        int acumVivienda=0, acumEstudio=0, acumInversion=0;
        String mensaje="";
        
        List<Credito> listaCreditos = creditoDaoImpl.obtenerListaCreditos();
        
        for (Credito credit : listaCreditos) {
            if (credit.getTipoCredito().equalsIgnoreCase("vivienda")) {
                acumVivienda++;
            }else if (credit.getTipoCredito().equalsIgnoreCase("estudio")) {
                acumEstudio++;
            }else{
                acumInversion++;
            }
        }//finFor
        
        if (acumEstudio>acumInversion && acumEstudio > acumVivienda) {
            mensaje = "El tipo de credito mas usado es para Estudio";
        }else if(acumInversion > acumEstudio && acumInversion > acumVivienda){
            mensaje = "El tipo de credito mas usado es para Inversion";
        }else{
            mensaje = "El tipo de crito mas usado es para Vivienda";
        }
        
        return mensaje;
    }

    @Override
    public String acumuladoCreditos() {
        
        return "";
    }

    @Override
    public String mayorPrestamista() {
        
        return "";
    }
    
}
