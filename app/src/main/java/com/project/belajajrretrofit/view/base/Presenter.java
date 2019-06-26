package com.project.belajajrretrofit.view.base;

public interface Presenter<T extends View> {
    void onAttach(T view);
    void onDetach();
}
