
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.CursoService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class CursoServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/CursoServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.CursoService";

    @Dependent
    @Produces
    @Default
    private CursoService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, CursoService.class);
    }
}
