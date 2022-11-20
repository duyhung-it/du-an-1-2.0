package com.raven.swing.table;

import com.nhomsau.viewmodel.SinhVienView;
import com.raven.model.ModelStudent;

public interface EventAction<T> {

    public void delete(T model);

    public void update(T model);
}
