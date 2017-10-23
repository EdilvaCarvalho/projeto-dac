
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.TurmaService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class TurmaServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/TurmaServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.TurmaService";

    @Dependent
    @Produces
    @Default
    private TurmaService getTurmaService() {
        return new ServiceLocator().lookup(RESOURCE, TurmaService.class);
    }
}
