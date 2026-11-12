package com.test.qlph.service;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeService {
    private Scanner sc = KaraokeConstant.sc;

    private int employeeCounter = 0;

    private String generateEmployeeCode() {
        employeeCounter++;
        return String.format("NV%03d", employeeCounter);
    }

    public ArrayList<EmployeeDTO> getAll(){
        return KaraokeConstant.listEmployee;
    }

    public Optional<EmployeeDTO> getById(String employeeId){
        for(EmployeeDTO employeeDTO : KaraokeConstant.listEmployee){
            if(employeeDTO.getEmployeeId().toString().equalsIgnoreCase(employeeId)){
                return Optional.of(employeeDTO);
            }
        }
        return Optional.empty();
    }

    public void showAll(){
        int stt = 1;
        System.out.println("\n---Danh sach nhan vien---");
        if(KaraokeConstant.listEmployee.isEmpty()){
            System.out.println("Danh sach trong");
            return;
        }
        for(EmployeeDTO employeeDTO : KaraokeConstant.listEmployee){
            System.out.println("STT: " + (stt++) +  " | " + employeeDTO.toString() );
        }
    }

    public void addEmployee(){
        System.out.println("\n---Them nhan vien ---");
        UUID employeeId;
        EmployeeDTO emp = new EmployeeDTO();

        do {
            employeeId = UUID.randomUUID();
            emp.setEmployeeId(employeeId);
        }while (KaraokeConstant.listEmployee.contains(emp));

        String employeeCode = generateEmployeeCode();

        System.out.print("Nhap ten: ");
        String employeeName = sc.nextLine();
        System.out.print("Nhap SDT: ");
        String employeePhone = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String employeeAddress = sc.nextLine();
        System.out.print("Nhap email: ");
        String employeeEmail = sc.nextLine();
        System.out.print("Nhap luong: ");
        Long employeeSalary = Long.parseLong(sc.nextLine());

        EmployeeDTO employeeDTO = new EmployeeDTO(employeeId, employeeCode, employeeName, employeePhone, employeeAddress, employeeEmail, employeeSalary);

        KaraokeConstant.listEmployee.add(employeeDTO);
        System.out.println("Them nhan vien thanh cong");
    }

    public void updateEmployee(){
        System.out.println("\n---Sua nhan vien ---");
        System.out.print("Nhap ma nhan vien can sua: ");
        String employeeId = sc.nextLine();

        Optional<EmployeeDTO> employeeDTOOptional = getById(employeeId);
        if(employeeDTOOptional.isEmpty()){
            System.out.println("Khong tim thay nhan vien");
            return;
        }

        EmployeeDTO employeeDTO = employeeDTOOptional.get();
        System.out.print("Nhap ten moi: ");
        employeeDTO.setEmployeeName(sc.nextLine());
        System.out.print("Nhap dia chi moi: ");
        employeeDTO.setEmployeeAddress(sc.nextLine());
        System.out.print("Nhap SDT moi: ");
        employeeDTO.setEmployeePhone(sc.nextLine());
        System.out.print("Nhap email moi: ");
        employeeDTO.setEmployeeEmail(sc.nextLine());
        System.out.print("Nhap luong moi: ");
        employeeDTO.setEmployeeSalary(Long.parseLong(sc.nextLine()));

        System.out.println("Cap nhat nhan vien thanh cong");

    }

    public void deleteEmployee(){
        System.out.println("\n---Xoa nhan vien ---");
        System.out.print("Nhap ma nhan vien can xoa: ");
        String employeeId = sc.nextLine();

        Optional<EmployeeDTO> employeeDTOOptional = getById(employeeId);
        if(employeeDTOOptional.isEmpty()){
            System.out.println("Khong tim thay nhan vien");
            return;
        }

        KaraokeConstant.listEmployee.remove(employeeDTOOptional.get());
        System.out.println("Xoa nhan vien thanh cong");
    }
}

