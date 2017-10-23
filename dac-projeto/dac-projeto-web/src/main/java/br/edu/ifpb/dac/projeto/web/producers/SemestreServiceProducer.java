
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.SemestreService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class SemestreServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/SemestreServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.SemestreService";

    @Dependent
    @Produces
    @Default
    private SemestreService getSemestreService() {
        return new ServiceLocator().lookup(RESOURCE, SemestreService.class);
    }
}
