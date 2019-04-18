package domain.maintenance;

import java.util.List;
import java.util.ArrayList;

public class MaintenanceVisit implements ImaintenanceVisit {

    private int visitId;
    private List<Problem> problemsToFix;

    public MaintenanceVisit(){}

    @Override
    public int getVisitId() {
        return visitId;
    }

    @Override
    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    @Override
    public List<Problem> getProblemsList() {
        return problemsToFix;
    }

    @Override
    public void setProblemsList(List<Problem> problemsList) {
        this.problemsToFix = problemsList;
    }

    @Override
    public void addProblemToFix(Problem problem) {
        problemsToFix.add(problem);
    }
}
