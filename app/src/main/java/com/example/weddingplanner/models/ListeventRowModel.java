package com.example.weddingplanner.models;

public class ListeventRowModel {
    private long id;
    private String txtFittingWedding;
    private String txtEvent;
    private String txtOne;

    public ListeventRowModel(String txtFittingWedding, String txtEvent, String txtOne) {
        this.txtFittingWedding = txtFittingWedding;
        this.txtEvent = txtEvent;
        this.txtOne = txtOne;
    }

    public String getTxtFittingWedding() {
        return txtFittingWedding;
    }

    public void setTxtFittingWedding(String txtFittingWedding) {
        this.txtFittingWedding = txtFittingWedding;
    }

    public String getTxtEvent() {
        return txtEvent;
    }

    public void setTxtEvent(String txtEvent) {
        this.txtEvent = txtEvent;
    }

    public String getTxtOne() {
        return txtOne;
    }

    public void setTxtOne(String txtOne) {
        this.txtOne = txtOne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
