
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DuvidaService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class DuvidaServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/DuvidaServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.DuvidaService";

    @Dependent
    @Produces
    @Default
    private DuvidaService getDuvidaService() {
        return new ServiceLocator().lookup(RESOURCE, DuvidaService.class);
    }
}
