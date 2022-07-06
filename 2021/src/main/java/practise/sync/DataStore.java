package practise.sync;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private final Sync sync = new Sync();

    private Map<String, User> map = new HashMap<>();

    User save(User u) {
        return sync.write(() -> {
            return map.put(u.getUid(), u);
        });

    }
}

class User {
    String uid;

    public String getUid() {
        return uid;
    }
}
