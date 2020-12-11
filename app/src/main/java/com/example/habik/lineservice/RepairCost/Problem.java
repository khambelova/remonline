package com.example.habik.lineservice.RepairCost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Problem {

    @SerializedName("title")
    @Expose
    private String problemName;

    @SerializedName("price")
    @Expose
    private String problemCost;

    public Problem(String problemName, String problemCost) {
        this.problemName = problemName;
        this.problemCost = problemCost;
    }

    public String getProblemName() {
        return problemName;
    }

    public String getProblemCost() {
        return problemCost;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public void setProblemCost(String problemCost) {
        this.problemCost = problemCost;
    }
}
