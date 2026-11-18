package com.test.qlph.serviceimpl;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.MenuDTO;
import com.test.qlph.service.MenuService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class MenuServiceImpl implements MenuService {
    private static final String CODE_REGEX = "^MN\\d{3}$";

    @Override
    public Optional<MenuDTO> getByCode(String itemCode) {
        for (MenuDTO dto : KaraokeConstant.listMenu) {
            if (dto.getItemCode().equalsIgnoreCase(itemCode)) {
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    private String inputMenuCode() {
        while (true) {
            System.out.print("Nhap ma mon (VD: MN001): ");
            String code = KaraokeConstant.sc.nextLine().trim().toUpperCase();
            if (code.isEmpty()) {
                System.out.println("Ma khong duoc de trong");
            } else if (!code.matches(CODE_REGEX)) {
                System.out.println("Sai dinh dang, phai la MN + 3 chu so");
            } else if (getByCode(code).isPresent()) {
                System.out.println("Ma da ton tai, nhap ma khac");
            } else {
                return code;
            }
        }
    }

    @Override
    public ArrayList<MenuDTO> getAll() {
        return KaraokeConstant.listMenu;
    }

    @Override
    public Optional<MenuDTO> getById(String itemId) {
        for (MenuDTO menuDTO : KaraokeConstant.listMenu) {
            if (menuDTO.getItemId().toString().equalsIgnoreCase(itemId)) {
                return Optional.of(menuDTO);
            }
        }
        return Optional.empty();
    }

    @Override
    public void showAll() {
        int stt = 1;
        System.out.println("\n---Danh sach menu---");
        if (KaraokeConstant.listMenu.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }
        for (MenuDTO menuDTO : KaraokeConstant.listMenu) {
            System.out.println("STT: " + (stt++) + " | " + menuDTO);
        }
    }

    @Override
    public void addMenu() {
        System.out.println("\n---Them mon vao menu---");
        UUID itemId = UUID.randomUUID();
        String itemCode = inputMenuCode();

        System.out.print("Nhap ten mon: ");
        String itemName = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap loai mon (Do an / Do uong / Khac): ");
        String itemCategory = KaraokeConstant.sc.nextLine();
        System.out.print("Nhap gia tien: ");
        Long itemPrice = Long.parseLong(KaraokeConstant.sc.nextLine());

        MenuDTO menuDTO = new MenuDTO(itemId, itemCode, itemName, itemCategory, itemPrice);
        KaraokeConstant.listMenu.add(menuDTO);
        System.out.println("Them mon thanh cong! (Ma: " + itemCode + " | UUID: " + itemId + ")");
    }

    @Override
    public void updateMenu() {
        System.out.println("\n---Sua mon trong menu---");
        System.out.print("Nhap ma mon can sua: ");
        String itemCode = KaraokeConstant.sc.nextLine().trim();

        Optional<MenuDTO> menuOpt = getByCode(itemCode);
        if (menuOpt.isEmpty()) {
            System.out.println("Khong tim thay mon");
            return;
        }

        MenuDTO menuDTO = menuOpt.get();
        System.out.print("Nhap ten mon moi: ");
        menuDTO.setItemName(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap loai mon moi: ");
        menuDTO.setItemCategory(KaraokeConstant.sc.nextLine());
        System.out.print("Nhap gia moi: ");
        menuDTO.setItemPrice(Long.parseLong(KaraokeConstant.sc.nextLine()));

        System.out.println("Cap nhat mon thanh cong");
    }

    @Override
    public void deleteMenu() {
        System.out.println("\n---Xoa mon trong menu---");
        System.out.print("Nhap ma mon can xoa: ");
        String itemCode = KaraokeConstant.sc.nextLine().trim();

        Optional<MenuDTO> menuOpt = getByCode(itemCode);
        if (menuOpt.isEmpty()) {
            System.out.println("Khong tim thay mon");
            return;
        }

        KaraokeConstant.listMenu.remove(menuOpt.get());
        System.out.println("Xoa mon thanh cong");
    }
}
