package Models;

/**
 * Created by ice on 22/11/17.
 */

public class MensagemAudio extends AMensagem {

    public MensagemAudio(ConexaoParams conn, String tokenConversa) {
        super(conn, tokenConversa);
    }

    @Override
    public String getTipoMensagem() {
        return "Áudio";
    }
}
