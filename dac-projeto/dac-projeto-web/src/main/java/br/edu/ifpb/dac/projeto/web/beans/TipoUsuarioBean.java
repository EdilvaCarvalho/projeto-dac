
package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.enuns.TipoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@ApplicationScoped
public class TipoUsuarioBean implements Serializable{
    
    public TipoUsuario[] getTipoUsuarios(){
        return new TipoUsuario[] {TipoUsuario.ADMINISTRADOR, TipoUsuario.PROFESSOR, TipoUsuario.PUBLICO};
    }
    
}
