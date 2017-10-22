/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.projeto.web.producers;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AtividadeService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author joseph
 */
@ApplicationScoped
public class AtividadeServiceProducer {
    
        
    private static final String RESOURCE = "java:global/dac-projeto-core/AtividadeServiceImpl!br.edu.ifpb.dac.projeto.shared.domain.interfaces.AtividadeService";

    @Dependent
    @Produces
    @Default
    private AtividadeService getAtividadeService() {
        return new ServiceLocator().lookup(RESOURCE, AtividadeService.class);
    }
    
}
