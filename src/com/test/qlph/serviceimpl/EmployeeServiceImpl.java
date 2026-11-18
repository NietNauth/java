package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.EmployeeDTO;
import com.test.qlph.service.EmployeeService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String CODE_REGEX = "^NV\\d{3}$";

    @Override
    public Optional<EmployeeDTO> getByCode(String employeeCode) {
        for (EmployeeDTO dto : KaraokeConstant.listEmployee) {
            if (dto.getEmployeeCode().equalsIgnoreCase(employeeCode)) {
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    private String inputEmployeeCode() {
        while (true) {
            System.out.print("Nhap ma nhan vien (VD: NV001): ");
            String code = KaraokeConstant.sc.nextLine().trim().toUpperCase();
            if (code.isEmpty()) {
                System.out.println("Ma khong duoc de trong");
            } else if (!code.matches(CODE_REGEX)) {
                System.out.println("Sai dinh dang, phai la NV + 3 chu so");
            } else if (getByCode(code).isPresent()) {
                System.out.println("Ma da ton tai, nhap ma khac");
            } else {
                return code;
            }
        }
    }

    @Override
    public ArrayList<EmployeeDTO> getAll() {
        return KaraokeConstant.listEmployee;
    }

    @Override
    public Optional<EmployeeDTO> getById(String employeeId) {
        for (EmployeeDTO employeeDTO : KaraokeConstant.listEmployee) {
            if (employeeDTO.getEmployeeId().toString().equalsIgnoreCase(employeeId)) {
                return Optional.of(employeeDTO);
            }
        }
        return Optional.empty();
    }

    @Override
    public void showAll() {
        int stt = 1;
        System.out.println("\n---Danh sach nhan vien---");
        if (KaraokeConstant.listEmployee.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }
        for (EmployeeDTO employeeDTO : KaraokeConstant.listEmployee) {
            System.out.println("STT: " + (stt++) + " | " + employeeDTO.toString());
        }
    }

    @Override
    public void addEmployee() {
        System.out.println("\n---Them nhan vien ---");
        UUID employeeId = UUID.randomUUID();
        String employeeCode = inputEmployeeCode();

        System.out.print("Nhap ten: ");
        String employeeName = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap SDT: ");
        String employeePhone = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String employeeAddress = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap email: ");
        String employeeEmail = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap luong: ");
        Long employeeSalary = Long.parseLong(KaraokeConstant.sc.nextLine());

        EmployeeDTO employeeDTO = new EmployeeDTO(employeeId, employeeCode, employeeName, employeePhone, employeeAddress, employeeEmail, employeeSalary);
        KaraokeConstant.listEmployee.add(employeeDTO);
        System.out.println("Them nhan vien thanh cong");
    }

    @Override
    public void updateEmployee() {
        System.out.println("\n---Sua nhan vien ---");
        System.out.print("Nhap ma nhan vien can sua: ");
        String employeeCode = KaraokeConstant.sc.nextLine().trim();

        Optional<EmployeeDTO> employeeDTOOptional = getByCode(employeeCode);
        if (employeeDTOOptional.isEmpty()) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }

        EmployeeDTO employeeDTO = employeeDTOOptional.get();
        System.out.print("Nhap ten moi: ");
        employeeDTO.setEmployeeName(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap dia chi moi: ");
        employeeDTO.setEmployeeAddress(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap SDT moi: ");
        employeeDTO.setEmployeePhone(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap email moi: ");
        employeeDTO.setEmployeeEmail(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap luong moi: ");
        employeeDTO.setEmployeeSalary(Long.parseLong(KaraokeConstant.sc.nextLine()));

        System.out.println("Cap nhat nhan vien thanh cong");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("\n---Xoa nhan vien ---");
        System.out.print("Nhap ma nhan vien can xoa: ");
        String employeeCode = KaraokeConstant.sc.nextLine().trim();

        Optional<EmployeeDTO> employeeDTOOptional = getByCode(employeeCode);
        if (employeeDTOOptional.isEmpty()) {
            System.out.println("Khong tim thay nhan vien");
            return;
        }

        KaraokeConstant.listEmployee.remove(employeeDTOOptional.get());
        System.out.println("Xoa nhan vien thanh cong");
    }
}
