
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AulaService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class AulaServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/AulaServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.AulaService";

    @Dependent
    @Produces
    @Default
    private AulaService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, AulaService.class);
    }
}
