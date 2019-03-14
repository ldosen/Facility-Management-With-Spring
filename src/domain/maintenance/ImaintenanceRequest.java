package domain.maintenance;

public interface ImaintenanceRequest {

    public int getRequestId();
    public void setRequestId(int requestId);
    public String getMaintenanceDescription();
    public void setMaintenanceDescription(String maintenanceDescription);
}
