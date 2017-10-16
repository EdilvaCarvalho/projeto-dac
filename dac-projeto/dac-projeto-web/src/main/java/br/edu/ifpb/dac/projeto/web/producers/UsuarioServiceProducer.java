
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.UsuarioService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class UsuarioServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/UsuarioServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.UsuarioService";

    @Dependent
    @Produces
    @Default
    private UsuarioService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, UsuarioService.class);
    }
}
