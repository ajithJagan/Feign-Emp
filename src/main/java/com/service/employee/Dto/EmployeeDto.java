package com.service.employee.Dto;


public class EmployeeDto {

    private String employeeName;
    private int mark1;
    private int mark2;
    private int mark3;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public EmployeeDto(String employeeName, int mark1, int mark2, int mark3) {
        this.employeeName = employeeName;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }
}
