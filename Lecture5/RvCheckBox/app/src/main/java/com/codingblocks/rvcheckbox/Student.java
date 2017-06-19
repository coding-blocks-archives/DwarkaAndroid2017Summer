package com.codingblocks.rvcheckbox;

/**
 * Created by the-dagger on 19/06/17.
 */

public class Student {

    String name;
    Boolean checked;

    public Student(String name, Boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
