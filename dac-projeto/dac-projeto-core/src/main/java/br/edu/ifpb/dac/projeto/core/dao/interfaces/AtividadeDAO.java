/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Atividade;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface AtividadeDAO {
 
    void salvar(Atividade atividade);
    void atualizar(Atividade atividade);
    void remover(Atividade atividade);
    Atividade getAtividade(int codigo);
    List<Atividade> listar();
}
