/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.converter;

import capsoftaccounting.model.Movcon;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author praveen
 */
@FacesConverter(value = "movConConverter")
public class MovConConverter implements Converter {
    
    
    
     private static Map<String, Movcon> mapa = new HashMap<String, Movcon>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        System.out.println("getASObject >>>>>>>>>>>>>>>>>>>>>>>>"+mapa.get(value));
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Movcon) {
            Movcon f = (Movcon) value;
            mapa.put(String.valueOf(f.getIddoc()), f);
            System.out.println("getAsString >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+mapa.put(String.valueOf(f.getIddoc()), f));
            return String.valueOf(f.getIddoc());
        } else {
            return "";
        }
    }
/*
   FrateFacade frateFacade = lookupFrateFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Frate frate;
        if (value != null) {
            frate = (Frate)frateFacade.find(Integer.parseInt(value));
            return frate;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Frate) value).getIdFrate().toString();
        }
        return null;
    }

    private FrateFacade lookupFrateFacade() {
        Context context;
        try {
            context = new InitialContext();
            return (FrateFacade) context.lookup("java:global/sig_ofmcap/FrateFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }

    }*/
    
    
    
    
}
