
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class ProfessorServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/ProfessorServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService";

    @Dependent
    @Produces
    @Default
    private ProfessorService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, ProfessorService.class);
    }
}
