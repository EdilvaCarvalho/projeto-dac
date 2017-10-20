package br.edu.ifpb.dac.projeto.web.filtro;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.enuns.TipoUsuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
@WebFilter(filterName = "AltorizarAcesso", urlPatterns = {
    "/faces/admin/*", "/faces/professor/*", "/faces/publico/*"
})
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("user");

        if (usuario == null) {
            httpResponse.sendRedirect("/dac-projeto-web/faces/index.xhtml");
        } else {

            String path = httpRequest.getRequestURI();
            path = path.substring(httpRequest.getContextPath().length());
            TipoUsuario tipoUsuario = usuario.getTipoUsuario();
            if (naoAltorizado(tipoUsuario, path)) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean naoAltorizado(TipoUsuario tipoUsuario, String path) {
        switch (tipoUsuario) {
            case ADMINISTRADOR:
                if (!path.startsWith("/faces/admin") && !path.startsWith("/faces/publico")) {
                    return true;
                }
                break;
            case PROFESSOR:
                if (!path.startsWith("/faces/professor") && !path.startsWith("/faces/publico")) {
                    return true;
                }
                break;
            case PUBLICO:
                if (!path.startsWith("/faces/publico")) {
                    return true;
                }
                break;
        }
        return false;
    }

}
