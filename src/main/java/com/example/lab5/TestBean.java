package com.example.lab5;

public class TestBean {
    @Pattern(regex="correct",message="incorrect")
    public String Validation;

    public TestBean() {
    }

    public TestBean(String g) {
        this.Validation =g;
    }

    public void setName(String Validation)
    {
        this.Validation = Validation;
    }
    public String getName()
    {
        return Validation;
    }
}