package br.fepi.si.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.fepi.si.model.Jogador;
import br.fepi.si.repository.Jogadores;
import br.fepi.si.util.JpaUtil;

@FacesConverter(forClass = Jogador.class)
public class JogadorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Jogador retorno = null;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				Jogadores jogadores = new Jogadores(em);
				retorno = jogadores.porRegistro(new Long(value));
			}
			return retorno;
		} finally {
			em.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Jogador jogador = (Jogador) value;
			
			return jogador.getIdJogador() == null ? null : jogador.getIdJogador().toString();
		}
		return null;
	}

}