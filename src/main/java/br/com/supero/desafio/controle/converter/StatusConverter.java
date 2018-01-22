package br.com.supero.desafio.controle.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.supero.desafio.modelo.dao.entidades.Status;

@FacesConverter(value = "statusConverter")
public class StatusConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty() && !value.equals("Selecione")) {
			return Status.valueOf(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Status) {
			return ((Status) value).name();
		}
		return null;
	}
}