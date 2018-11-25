package com.fh.shop.api.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTableResult<T> implements Serializable {


    private static final long serialVersionUID = 2081057316711381604L;

    private  Long recordsTotal;

    private  Long recordsFiltered;

    private List<T> data =new ArrayList<>();

    private  Integer draw;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

