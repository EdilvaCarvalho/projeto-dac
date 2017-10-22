/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.AtividadeDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Atividade;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.AtividadeService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author joseph
 */
@Stateless
@Remote(AtividadeService.class)
public class AtividadeServiceImpl implements AtividadeService{
 
    @EJB
    private AtividadeDAO atividadeDAO;

    @Override
    public void salvar(Atividade atividade) {
        atividadeDAO.salvar(atividade);
    }

    @Override
    public void atualizar(Atividade atividade) {
        atividadeDAO.atualizar(atividade);
    }

    @Override
    public void remover(int codigo) {
        Atividade atividade = atividadeDAO.getAtividade(codigo);
        atividadeDAO.remover(atividade);
    }

    @Override
    public Atividade getAtividade(int codigo) {
        return atividadeDAO.getAtividade(codigo);
    }

    @Override
    public List<Atividade> listar() {
        return atividadeDAO.listar();
    }

   
}
