package com.objectiva.stream;

import java.util.ArrayList;
import java.util.List;

public class ExampleObj {
    private int Id;
    private String name;

    private List<Long> ids = new ArrayList<>();

    public ExampleObj() {
    }

    public ExampleObj(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
