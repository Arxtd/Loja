package com.arthur.converter;
import com.arthur.modelo.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 *
 * @author arthur
 */
@FacesConverter(value = "fornecedorconverter", forClass = Fornecedor.class)
public class FornecedorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Fornecedor) uiComponent.getAttributes().get(value);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value instanceof Fornecedor) {

            Fornecedor entity = (Fornecedor) value;

            if (entity != null && entity instanceof Fornecedor && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}
