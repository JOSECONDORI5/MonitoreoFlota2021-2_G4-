package monitoreo.modelos.impl;

import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;

import monitoreo.modelos.interfaces.IPuntoMonitoreo;

public class PuntoMonitoreoBuilder implements IPuntoMonitoreo {
    
    private String descripcionPunto;
    private Double latitud;
    private Double longitud;
    private SimpleMarkerSymbol.Style estilo;
    private int color;
    private int tamano;

    public PuntoMonitoreoBuilder(String descripcionPunto)  {
        this.descripcionPunto = descripcionPunto;
    }

    public PuntoMonitoreoBuilder withSimbolo(SimpleMarkerSymbol.Style estilo, int color, int tamano)  {
        this.estilo = estilo;
        this.color = color;
        this.tamano = tamano;
        return this;
    }

    public PuntoMonitoreoBuilder withUbicacion(Double latitud, Double longitud)  {
        this.latitud = latitud;
        this.longitud = longitud;
        return this;
    }

    @Override
    public Punto build() {

        Punto punto = new Punto();
        punto.setDescripcionPunto(this.descripcionPunto);
        punto.setColor(this.color);
        punto.setEstilo(this.estilo);
        punto.setLatitud(this.latitud);
        punto.setLongitud(this.longitud);
        punto.setTamano(this.tamano);
        punto.generaPunto();
        return punto;
    }

}
