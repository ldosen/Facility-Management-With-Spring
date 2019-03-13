package domain.maintenance;

import java.*;
import domain.facility.Apartment;

public class MaintenanceRequest {

    private int requestId;
    private String maintenanceDescription;

    public MaintenanceRequest(){}

    public MaintenanceRequest(int id, String maintenanceDescription, Apartment apartment){
        this.requestId = id;
        this.maintenanceDescription = maintenanceDescription;
    }

    public int getRequestd(){
        return requestId;
    }

    public void setRequestId(int id){
        this.requestId = id;
    }

    public String getMaintenanceDescription(){
        return maintenanceDescription;
    }

    public void setDescription(String maintenanceDescription){
        this.maintenanceDescription = maintenanceDescription;
    }
}