package com.test.qlph.dto;

import java.util.Objects;
import java.util.UUID;

public class EmployeeDTO {
    private UUID employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeePhone;
    private String employeeAddress;
    private String employeeEmail;
    private Long employeeSalary;

    public EmployeeDTO(){

    }

    public EmployeeDTO (UUID employeeId, String employeeCode, String employeeName, String employeePhone, String employeeAddress, String employeeEmail, Long employeeSalary) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeEmail = employeeEmail;
        this.employeeSalary = employeeSalary;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "UUID: " + employeeId +
                " | Code: " + employeeCode +
                " | Ten: " + employeeName +
                " | SDT: " + employeePhone +
                " | Dia chi: " + employeeAddress +
                " | Email: " + employeeEmail +
                " | Luong: " + employeeSalary;
    }
}
