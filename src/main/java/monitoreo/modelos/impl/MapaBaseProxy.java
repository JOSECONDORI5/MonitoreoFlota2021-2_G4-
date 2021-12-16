package monitoreo.modelos.impl;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;

import monitoreo.modelos.interfaces.IMapaBase;

public class MapaBaseProxy implements IMapaBase {

    private int tipoMapa = 0;
    private MapaBase mapaBase;

    public void setTipoMapa(int tipo)  {

        this.tipoMapa = tipo;
    }

    @Override
    public ArcGISMap getMapaBase() {
        
        ArcGISMap map = null;

        if (tipoMapa != 0  )   {

            mapaBase = new MapaBase(this.tipoMapa);
            map = mapaBase.getMapaBase();
        }
        else    {
            System.out.println("Creando el mapabase por defecto del Proxy...");
            map = new ArcGISMap(Basemap.createImagery());
        }

        return map;
    }
    
    public Viewpoint setViewPoint() {
        double coordenadaXInicial = -12.05847;
        double coordenadaYInicial = -77.08654;
        
        Viewpoint viewpoint = new Viewpoint(coordenadaXInicial, coordenadaYInicial, 12000);   // UNMSM-2
        
        return viewpoint;
    }
    
}
