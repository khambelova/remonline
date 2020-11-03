package com.example.habik.lineservice;

public class Problem {

    private String problemName;
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
