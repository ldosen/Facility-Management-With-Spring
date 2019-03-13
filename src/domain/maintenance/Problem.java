package domain.maintenance;

public class Problem {

    private int problemId;
    private String problemDescription;
    private float costToFix;
    private float hoursToFix;

    public Problem() {}

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public float getCostToFix() {
        return costToFix;
    }

    public void setCostToFix(float costToFix) {
        this.costToFix = costToFix;
    }

    public float getHoursToFix() {
        return hoursToFix;
    }

    public void setHoursToFix(float hoursToFix) {
        this.hoursToFix = hoursToFix;
    }
}
