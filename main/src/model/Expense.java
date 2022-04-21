package model;

import java.util.Map;

public class Expense {
    private Map<String,String> metaData;
    private Split split;
    private User user;

    public Expense(Map<String, String> metaData, Split split, User user) {
        this.metaData = metaData;
        this.split = split;
        this.user = user;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, String> metaData) {
        this.metaData = metaData;
    }

    public Split getSplit() {
        return split;
    }

    public void setSplit(Split split) {
        this.split = split;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addMetaData(String key,String value) {
        this.metaData.put(key,value);
    }

    public String getMetaData(String key) {
        return this.metaData.getOrDefault(key,"MetaDataNotFound");
    }

    public void updateMetaData(String key,String value) {
        this.metaData.replace(key,value);
    }
}
