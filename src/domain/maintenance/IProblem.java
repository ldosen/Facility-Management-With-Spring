package domain.maintenance;

public interface IProblem {
    public int getProblemId();
    public void setProblemId(int problemId);
    public String getProblemDescription();
    public void setProblemDescription(String problemDescription);
    public float getCostToFix();
    public void setCostToFix(float costToFix);
    public float getHoursToFix();
    public void setHoursToFix(float hoursToFix);
}
