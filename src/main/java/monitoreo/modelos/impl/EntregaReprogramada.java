
package monitoreo.modelos.impl;

import monitoreo.modelos.interfaces.IEntrega;

public class EntregaReprogramada implements IEntrega {

    private IEntrega entrega;
    private String rangoHora;
    private String fecha;
    private Double costoAdicional = 10.00;

    public EntregaReprogramada(IEntrega entrega, String rangoHora, String fecha) {
        this.entrega = entrega;
        this.rangoHora = rangoHora;
        this.fecha = fecha;
    }
    
    @Override
    public void listarEntrega() {
        System.out.println("[Entrega Reprogramada] Entrega re-planificada: " + this.fecha + " - " + this.rangoHora );
    }

    @Override
    public Double calcularCosto() {
        return this.entrega.calcularCosto() + this.costoAdicional;
    }

}
