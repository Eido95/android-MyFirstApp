package com.example.mydatabindingapp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

/**
 * Created by Eido on 22/10/2016.
 */

public class User extends BaseObservable {
    private final String firstName;
    private final String lastName;
    private boolean administrator;
    private boolean cool;

    /**
     * Called when an administrator changed.
     * @param view The view
     */
    public void changeAdministrator(View view)
    {
        this.setAdministrator(!this.isAdministrator());
    }

    @Bindable
    public boolean isCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
        this.notifyPropertyChanged(BR.cool);

    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
        this.notifyPropertyChanged(BR.administrator);
    }
    @Bindable
    public boolean isAdministrator() {
        return administrator;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }
}
