package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question implements Comparable<Question> {
    public String url;
    @JsonProperty("importance_level")
    public int importanceLevel;

    private Boolean solved;

    @JsonProperty("solved")
    public Boolean getSolved() {
        return solved;
    }

    @JsonProperty("solved")
    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    public Question() {
        this.importanceLevel = 3;
        this.solved = false;
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
