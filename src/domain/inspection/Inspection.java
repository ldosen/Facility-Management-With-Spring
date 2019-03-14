package domain.inspection;

import domain.facility.*;
import java.util.List;
import java.util.ArrayList;

public class Inspection implements Iinspection{

    private String typeOfInspection;
    private String inspectionDetail;
    private String inspectionDate;

    public Inspection(){}

    public Inspection(String typeOfInspection, String inspectionDetail, String inspectionDate,Apartment apartmentId ){
        this.typeOfInspection = typeOfInspection;
        this.inspectionDetail = inspectionDetail;
        this.inspectionDate = inspectionDate;
    }

    @Override
    public String getTypeOfInspection() {
        return typeOfInspection;
    }

    @Override
    public void setTypeOfInspection(String typeOfInspection) {
        this.typeOfInspection = typeOfInspection;
    }

    @Override
    public String getInspectionDetail() {
        return inspectionDetail;
    }

    @Override
    public void setInspectionDetail(String inspectionDetail) {
        this.inspectionDetail = inspectionDetail;
    }

    @Override
    public String getInspectionDate() {
        return inspectionDate;
    }

    @Override
    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }
}