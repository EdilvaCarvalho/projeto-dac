
package br.edu.ifpb.dac.projeto.shared.domain.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface UsuarioService {
    
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void remover(int id);
    Usuario getUsuario(int id);
    Usuario autenticar(String email, String senha);
    List<Usuario> listarTodos();
    List<Usuario> listarAcessoLiberado();
    List<Usuario> listarAcessoPendente();
}
