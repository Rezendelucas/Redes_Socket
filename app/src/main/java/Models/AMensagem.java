package Models;

import java.io.Serializable;
import java.security.Timestamp;

/**
 * Created by ice on 22/11/17.
 */

public abstract class AMensagem implements Serializable {
    protected ConexaoParams conexao;
    protected String tokenConversa;
    protected Timestamp horaMensagem;

    public AMensagem(ConexaoParams conn, String tokenConversa){
        this.conexao = conn;
        this.tokenConversa = tokenConversa;
    }

    public abstract String getTipoMensagem();

    public boolean isValid(){
        return (conexao.isConectado() && !tokenConversa.isEmpty());
    }

}
