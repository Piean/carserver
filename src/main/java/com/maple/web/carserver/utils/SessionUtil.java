package com.maple.web.carserver.utils;

import java.util.HashMap;
import java.util.Map;

public class SessionUtil {

    private static SessionUtil instance;
    private Map<String, Integer> map;

    private SessionUtil() {
        map = new HashMap<>();
    }

    public static SessionUtil getInstance() {
        if (instance == null) {
            synchronized (SessionUtil.class) {
                if (instance == null) {
                    instance = new SessionUtil();
                }
            }
        }
        return instance;
    }

    public void addSessionId(String sessionId, Integer userId) {
        instance.map.put(sessionId, userId);
    }

    public boolean findSessionId(String sessionId) {
        return instance.map.containsKey(sessionId);
    }

    public Integer getUserId(String sessionId) {
        return instance.map.get(sessionId);
    }

}
