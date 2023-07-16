package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question implements Comparable<Question> {
    public String url;
    @JsonProperty("importance_level")
    public int importanceLevel;

    public Question() {
    }

    public Question(String url, int importanceLevel) {
        this.url = url;
        this.importanceLevel = importanceLevel;
    }

    @Override
    public int compareTo(Question o) {
        return o.importanceLevel - this.importanceLevel;
    }
}
