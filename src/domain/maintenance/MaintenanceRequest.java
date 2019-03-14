package domain.maintenance;

import java.*;
import domain.facility.Apartment;

public class MaintenanceRequest implements ImaintenanceRequest {

    private int requestId;
    private String maintenanceDescription;

    public MaintenanceRequest(){}

    public MaintenanceRequest(int id, String maintenanceDescription, Apartment apartment){
        this.requestId = id;
        this.maintenanceDescription = maintenanceDescription;
    }

    @Override
    public int getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    @Override
    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

}