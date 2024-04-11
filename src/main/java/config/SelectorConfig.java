package config;

import java.util.Map;

public class SelectorConfig {
    private int minHeight;
    private int maxHeight;
    private Map<String, Boolean> allowedTypes;

    // Getters and Setters

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Map<String, Boolean> getAllowedTypes() {
        return allowedTypes;
    }

    public void setAllowedTypes(Map<String, Boolean> allowedTypes) {
        this.allowedTypes = allowedTypes;
    }
}
