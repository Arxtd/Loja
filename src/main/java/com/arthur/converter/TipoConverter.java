
package com.arthur.converter;

import com.arthur.modelo.Tipo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 *
 * @author Arthur
 */
@FacesConverter(value = "tipoconverter", forClass = Tipo.class)
public class TipoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Tipo) uiComponent.getAttributes().get(value);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value instanceof Tipo) {

            Tipo entity = (Tipo) value;

            if (entity != null && entity instanceof Tipo && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
