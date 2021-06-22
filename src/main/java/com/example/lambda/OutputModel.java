package com.example.lambda;

public class OutputModel {
    private String id;
    private String recordId;
    private String itemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OutputModel{" +
                "id='" + id + '\'' +
                ", recordId='" + recordId + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
