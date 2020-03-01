package ua.serheiev.oleksii.task1.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanContext {

    private static final Map<String, Object> instances = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getBean(String className) {
        return (T) instances.get(className);
    }

    public void putBean(String className, Object instance) {
        instances.put(className, instance);
    }
}
