package br.com.supero.desafio.controle.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class MensagemUtils {
	
	public static void mostraMensagemErro(String msg) {
		mostraMensagem(msg, true);
	}
	
	public static void mostraMensagemInfo(String msg) {
		mostraMensagem(msg, false);
	}

	public static void mostraMensagem(String msg, boolean erro) {
		if (erro) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
		}
	}

	public static void mensagemValidator(String msg) {
		FacesMessage fmsg = new FacesMessage(msg);
		throw new ValidatorException(fmsg);
	}
}
