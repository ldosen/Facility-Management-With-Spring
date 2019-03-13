package domain.maintenance;

import java.util.List;
import java.util.ArrayList;

public class MaintenanceVisit {

    private int visitId;
    private List<Problem> problemsToFix = new ArrayList<>();

    public MaintenanceVisit(){}

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public void setProblemsToFix(List<Problem> problemsToFix) {
        this.problemsToFix = problemsToFix;
    }

    public void addProblemToFix(Problem problem){
        problemsToFix.add(problem);
    }
}
