package FuncoesSerializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.stream.Stream;

import Models.StreamMessage;

/**
 * Created by ice on 29/11/17.
 */

public class SerializeStream {
    public static FileOutputStream serializeMessageObject(Serializable obj) throws IOException {
        StreamMessage _streamMessage = new StreamMessage();
        FileOutputStream fOut = null;
        //Gson jsonSeriaizer = new Gson();

        _streamMessage.setClassName(obj.getClass().getName());
        _streamMessage.setSerializedObject(obj.toString());

        try {
            fOut = new FileOutputStream("stream_"+obj.hashCode());
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeUnshared(_streamMessage);
            oOut.close();
            fOut.close();
        } catch (IOException e){
            throw e;
        }
        return fOut;
    }

    public StreamMessage deserializeMessageObject(FileInputStream fIn) throws IOException, ClassNotFoundException {
        StreamMessage _streamMessage = null;
        try {
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            _streamMessage = (StreamMessage) oIn.readObject();
            oIn.close();
            fIn.close();
        } catch (IOException e) {
            throw e;
        }
        return _streamMessage;
    }

    public Serializable objectMaterializator(StreamMessage msg)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classe = Class.forName(msg.getClassName());
        Object obj = classe.newInstance();
        return (Serializable) obj;
    }
}
