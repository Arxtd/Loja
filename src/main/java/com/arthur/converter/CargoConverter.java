
package com.arthur.converter;

import com.arthur.modelo.Cargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 *
 * @author Arthur
 */
@FacesConverter(value = "cargoconverter", forClass = Cargo.class)
public class CargoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Cargo) uiComponent.getAttributes().get(value);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value instanceof Cargo) {

            Cargo entity = (Cargo) value;

            if (entity != null && entity instanceof Cargo && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
