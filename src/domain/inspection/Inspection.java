package domain.inspection;

import domain.facility.*;
import java.util.List;
import java.util.ArrayList;

public class Inspection{

    private String typeOfInspection;
    private String inspectionDetail;
    private String inspectionDate;

    public Inspection(){}

    public Inspection(String typeOfInspection, String inspectionDetail, String inspectionDate,Apartment apartmentId ){
        this.typeOfInspection = typeOfInspection;
        this.inspectionDetail = inspectionDetail;
        this.inspectionDate = inspectionDate;
    }
    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getTypeOfInspection(){
        return typeOfInspection;
    }

    public void setTypeOfInspection(String typeOfInspection){
        this.typeOfInspection = typeOfInspection;
    }

    public String getInspectionDetail(){
        return inspectionDetail;
    }

    public void setInspectionDetail(String inspectionDetail){
        this.inspectionDetail = inspectionDetail;
    }

}