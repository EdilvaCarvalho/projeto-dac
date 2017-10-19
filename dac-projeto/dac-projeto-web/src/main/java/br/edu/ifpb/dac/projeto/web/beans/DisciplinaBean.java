
package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DisciplinaService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class DisciplinaBean implements Serializable{
    
    @Inject
    private DisciplinaService disciplinaService;

    public DisciplinaBean() {
    }
    
}
