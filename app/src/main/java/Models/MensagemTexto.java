package Models;

import java.security.Timestamp;

/**
 * Created by ice on 22/11/17.
 */

public class MensagemTexto extends AMensagem {
    private String mensagem;

    public MensagemTexto(ConexaoParams conn, String tokenConversa, String mensagem){
        super(conn, tokenConversa);
        this.mensagem = mensagem;
    }

    @Override
    public String getTipoMensagem() {
        return "Texto";
    }

    public boolean isValid(){
        return (conexao.isConectado() && !tokenConversa.isEmpty() && !mensagem.isEmpty());
    }
}
