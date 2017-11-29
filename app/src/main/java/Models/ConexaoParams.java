package Models;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.Serializable;

/**
 * Created by ice on 22/11/17.
 */

public class ConexaoParams implements Serializable {
    private String ip;
    private String token;
    //Lista de usuários conectados

    public ConexaoParams(String ip){
        this.ip = ip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp(){
        return this.ip;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public boolean isConectado(){
        return (!this.ip.isEmpty() && !this.token.isEmpty());
    }
}
