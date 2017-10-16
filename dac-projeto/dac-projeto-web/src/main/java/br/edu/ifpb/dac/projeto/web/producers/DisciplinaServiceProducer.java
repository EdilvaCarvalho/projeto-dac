
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DisciplinaService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class DisciplinaServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/DisciplinaServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.DisciplinaService";

    @Dependent
    @Produces
    @Default
    private DisciplinaService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, DisciplinaService.class);
    }
}
