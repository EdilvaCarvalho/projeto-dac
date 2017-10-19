
package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService;
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
public class HorarioBeans implements Serializable {
    
    @Inject
    private HorarioService horarioService;

    public HorarioBeans() {
    }
    
    public List<Horario> getTodosOsHorarios() {
        return this.horarioService.listar();
    }
}
