package ir.cactus.utils;

import java.util.Date;

public class JsonFileModel {
    private String FileName;
    private int Record_number;

    public JsonFileModel(String fileName, int record_number, int error_Code, String ERROR_CLASSIFICATION_Name, String ERROR_DESCRIPTION, Date ERROR_DATE) {
        FileName = fileName;
        Record_number = record_number;
        Error_Code = error_Code;
        this.ERROR_CLASSIFICATION_Name = ERROR_CLASSIFICATION_Name;
        this.ERROR_DESCRIPTION = ERROR_DESCRIPTION;
        this.ERROR_DATE = ERROR_DATE;
    }

    private int Error_Code;
    private String ERROR_CLASSIFICATION_Name;
    private String ERROR_DESCRIPTION;
    private Date ERROR_DATE;

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public void setRecord_number(int record_number) {
        Record_number = record_number;
    }

    public void setError_Code(int error_Code) {
        Error_Code = error_Code;
    }

    public void setERROR_CLASSIFICATION_Name(String ERROR_CLASSIFICATION_Name) {
        this.ERROR_CLASSIFICATION_Name = ERROR_CLASSIFICATION_Name;
    }

    public void setERROR_DESCRIPTION(String ERROR_DESCRIPTION) {
        this.ERROR_DESCRIPTION = ERROR_DESCRIPTION;
    }

    public void setERROR_DATE(Date ERROR_DATE) {
        this.ERROR_DATE = ERROR_DATE;
    }

    public String getFileName() {
        return FileName;
    }

    public int getRecord_number() {
        return Record_number;
    }

    public int getError_Code() {
        return Error_Code;
    }

    public String getERROR_CLASSIFICATION_Name() {
        return ERROR_CLASSIFICATION_Name;
    }

    public String getERROR_DESCRIPTION() {
        return ERROR_DESCRIPTION;
    }

    public Date getERROR_DATE() {
        return ERROR_DATE;
    }
}
