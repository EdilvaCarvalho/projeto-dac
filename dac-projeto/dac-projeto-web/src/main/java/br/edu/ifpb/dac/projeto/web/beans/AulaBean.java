package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AulaService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class AulaBean implements Serializable {

    @Inject
    private AulaService aulaService;

    public AulaBean() {
    }

    public List<Aula> getTodasAsAulas() {
        return this.aulaService.listar();
    }
}
