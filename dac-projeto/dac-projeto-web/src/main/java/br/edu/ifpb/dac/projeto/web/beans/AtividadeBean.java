/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Atividade;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AtividadeService;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.TurmaService;
import br.edu.ifpb.dac.projeto.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joseph
 */
@Named
@SessionScoped
public class AtividadeBean implements Serializable {

    @Inject
    private AtividadeService atividadeService;
    @Inject
    private TurmaService turmaService;
    private Atividade atividade = new Atividade();

    public AtividadeBean() {
        
    }
    
    public String cadastrar() {
        this.atividadeService.salvar(atividade);
        this.atividade= new Atividade();
        FacesUtil.addMsgInfo("atividade cadastrada com sucesso!");
        return null;
    }
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public AtividadeService getAtividadeService() {
        return atividadeService;
    }

    public void setAtividadeService(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }
    
    public List<Turma> getTurma(){
        return turmaService.listar();
    }
}
