package Models;

import java.io.Serializable;

/**
 * Created by ice on 29/11/17.
 */

public class StreamMessage implements Serializable{
    private String className;
    private String serializedObject;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSerializedObject() {
        return serializedObject;
    }

    public void setSerializedObject(String serializedObject) {
        this.serializedObject = serializedObject;
    }
}
