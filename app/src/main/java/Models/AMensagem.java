package Models;

import android.annotation.TargetApi;
import android.os.Build;

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

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public boolean isValid(){
        return (conexao.isConectado() && !tokenConversa.isEmpty());
    }


    //public int getListUsuarios() {
      //  return listUsuarios;  //eu quero a lista de usuarios pra setar no adpter
    //}
}
