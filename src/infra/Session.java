package infra;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private Map<String, Object> store = new HashMap<>();

    public Session(){
        this.store = new HashMap<>();
    }
    public void setAttribute(String key, Object value){
        store.put(key, value);
    }

    public Object getAttribute(String key){
        return store.get(key);
    }

    public void removeAttribute(String key){
        store.remove(key);
    }

    public boolean hasAttribute(String key){
        return store.containsKey(key);
    }
}
