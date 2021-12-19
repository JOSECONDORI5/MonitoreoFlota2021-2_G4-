package monitoreo.modelos;

import javafx.stage.Stage;
import monitoreo.modelos.impl.EntregaProgramada;
import monitoreo.modelos.impl.EntregaTipoServicio;
import monitoreo.modelos.impl.GuiaEntrega;
import monitoreo.modelos.impl.PoliLinea;
import monitoreo.modelos.impl.Punto;
import monitoreo.modelos.impl.PuntoMonitoreoBuilder;
import monitoreo.modelos.impl.RecojoTipoServicio;
import monitoreo.modelos.interfaces.IEntrega;
import monitoreo.modelos.interfaces.ITipoServicio;

import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;

public class FachadaPregunta2 {
    
    private PoliLinea polilinea;
    private Punto puntoInicial;
    private GuiaEntrega guia;
    private Mapa mapa;
    private Punto puntoRecojo;
    private Punto puntoEntrega;
    private ITipoServicio recojo ;
    private ITipoServicio entrega ;

    public FachadaPregunta2(Stage stage) {
        
        this.puntoInicial = new Punto() ;
        this.mapa=new Mapa();
        this.guia= new GuiaEntrega();
        this.recojo = new RecojoTipoServicio();
        this.entrega = new EntregaTipoServicio();
    
        
    }
    public Punto getPuntoRecojo() {
        return puntoRecojo;
    }
    public Punto getpuntoEntrega() {
        return puntoEntrega;
    }
    
    public void CrearPuntoInicial(PuntoMonitoreoBuilder puntoBuilder){
        this.puntoInicial=puntoBuilder.build();
    }
    public void CrearPuntoRecojo(double p1,double p2){
        this.puntoRecojo=new Punto(this.recojo,p1,p2);
    }
    public void CrearPuntoEntrega(double p1,double p2){
        this.puntoEntrega=new Punto(this.entrega,p1,p2);
    }
    public void agregarPolilinea(Double[][] puntosEntrega ) {
       this.polilinea=new PoliLinea(this.entrega, puntosEntrega);
    }
    public void agregarEntregas(String hora,String fecha){
        EntregaProgramada entrega=new EntregaProgramada(hora,fecha);
        this.guia.agregarEntrega(entrega);
    }

    public GuiaEntrega getGuia() {
        return guia;
    }


    public Punto getPuntoInicial() {
        return puntoInicial;
    }


    public PoliLinea getPolilinea() {
        return polilinea;
    }

    


}
