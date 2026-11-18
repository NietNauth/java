package com.test.qlph.service;

import com.test.qlph.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeService {
    ArrayList<EmployeeDTO> getAll();
    Optional<EmployeeDTO> getById(String employeeId);
    Optional<EmployeeDTO> getByCode(String employeeCode);
    void showAll();
    void addEmployee();
    void updateEmployee();
    void deleteEmployee();
}
