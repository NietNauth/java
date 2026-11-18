package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.EmployeeDTO;
import com.test.qlph.service.EmployeeService;
import com.test.qlph.util.InputUtil;

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
        String employeeName = InputUtil.inputString("Nhap ten");
        String employeePhone = InputUtil.inputPhone("Nhap SDT");
        String employeeAddress = InputUtil.inputString("Nhap dia chi");
        String employeeEmail = InputUtil.inputEmail("Nhap email");
        Long employeeSalary = InputUtil.inputPositiveLong("Nhap luong");

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
        employeeDTO.setEmployeeName(InputUtil.inputString("Nhap ten moi", employeeDTO.getEmployeeName()));
        employeeDTO.setEmployeeAddress(InputUtil.inputString("Nhap dia chi moi", employeeDTO.getEmployeeAddress()));
        employeeDTO.setEmployeePhone(InputUtil.inputPhone("Nhap SDT moi", employeeDTO.getEmployeePhone()));
        employeeDTO.setEmployeeEmail(InputUtil.inputEmail("Nhap email moi", employeeDTO.getEmployeeEmail()));
        employeeDTO.setEmployeeSalary(InputUtil.inputPositiveLong("Nhap luong moi", employeeDTO.getEmployeeSalary()));

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

        EmployeeDTO employeeDTO = employeeDTOOptional.get();
        if (!InputUtil.confirm("Ban chac chan muon xoa nhan vien " + employeeDTO.getEmployeeCode() + "?")) {
            System.out.println("Da huy xoa");
            return;
        }

        KaraokeConstant.listEmployee.remove(employeeDTO);
        System.out.println("Xoa nhan vien thanh cong");
    }
}
