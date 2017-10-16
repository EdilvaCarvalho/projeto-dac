
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.LaboratorioService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class LaboratorioServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/LaboratorioServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.LaboratorioService";

    @Dependent
    @Produces
    @Default
    private LaboratorioService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, LaboratorioService.class);
    }
}
