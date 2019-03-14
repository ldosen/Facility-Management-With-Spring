package domain.maintenance;

import java.util.List;
import domain.maintenance.Problem;

public interface ImaintenanceVisit {

    public int getVisitId();
    public void setVisitId(int visitId);
    public List<Problem> getProblemsList();
    public void setProblemsList(List<Problem> problemsList);
    public void addProblemToFix(Problem problem);

}
