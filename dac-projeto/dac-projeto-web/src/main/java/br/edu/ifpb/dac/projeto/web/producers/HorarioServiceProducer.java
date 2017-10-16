
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class HorarioServiceProducer {
    
    private static final String RESOURCE = "java:global/dac-projeto-core/HorarioServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.HorarioService";

    @Dependent
    @Produces
    @Default
    private HorarioService getAulaService() {
        return new ServiceLocator().lookup(RESOURCE, HorarioService.class);
    }
}
