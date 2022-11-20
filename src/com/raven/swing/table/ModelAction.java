package com.raven.swing.table;

import com.nhomsau.viewmodel.SinhVienView;
import com.raven.model.ModelStudent;

public class ModelAction {

    public SinhVienView getStudent() {
        return student;
    }

    public void setStudent(SinhVienView student) {
        this.student = student;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(SinhVienView student, EventAction event) {
        this.student = student;
        this.event = event;
    }

    public ModelAction() {
    }

    private SinhVienView student;
    private EventAction event;
}
