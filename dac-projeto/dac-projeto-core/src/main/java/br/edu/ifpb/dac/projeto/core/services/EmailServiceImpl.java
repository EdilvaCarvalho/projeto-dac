package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.shared.domain.interfaces.EmailService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.EmailException;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author joseph
 */
@Stateless
@Remote(EmailService.class)
public class EmailServiceImpl implements EmailService{
    
    /**
     *
     * @param destinatario
     */
    @Override
    public void enviaEmailSimples(String destinatario){
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            email.addTo(destinatario); //destinatário
            email.setFrom(""); // remetente
            email.setSubject("teste"); // assunto do e-mail
            email.setMsg("testando email"); //conteudo do e-mail
            email.setAuthentication("remetente ","senha");
            email.setSmtpPort(465);
            email.setSSL(true);
            email.setTLS(true);	
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
