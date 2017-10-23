
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.SalaService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class SalaServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/SalaServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.SalaService";

    @Dependent
    @Produces
    @Default
    private SalaService getSalaService() {
        return new ServiceLocator().lookup(RESOURCE, SalaService.class);
    }
}
