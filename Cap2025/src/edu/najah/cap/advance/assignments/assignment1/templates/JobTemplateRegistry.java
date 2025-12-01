package edu.najah.cap.advance.assignments.assignment1.templates;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry {

    private final Map<String, HeavyTemplate> registry = new HashMap<>();

    public void register(String key, HeavyTemplate template) {
        registry.put(key, template);
    }

    public HeavyTemplate get(String key) {
        HeavyTemplate t = registry.get(key);
        if (t == null) {
            throw new IllegalArgumentException("No template for key: " + key);
        }
        return t.clone(); // Prototype هنا
    }
}
