package com.test.qlph.service;

import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.dto.MenuDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class MenuService {
    private Scanner sc = KaraokeConstant.sc;
    private int menuCounter = 0;

    private String generateItemCode() {
        menuCounter++;
        return String.format("MN%03d", menuCounter);
    }

    public ArrayList<MenuDTO> getAll() {
        return KaraokeConstant.listMenu;
    }

    public Optional<MenuDTO> getById(String itemId) {
        for (MenuDTO menuDTO : KaraokeConstant.listMenu) {
            if (menuDTO.getItemId().toString().equalsIgnoreCase(itemId)) {
                return Optional.of(menuDTO);
            }
        }
        return Optional.empty();
    }

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

    public void addMenu() {
        System.out.println("\n---Them mon vao menu---");
        UUID itemId;
        MenuDTO temp = new MenuDTO();
        do {
            itemId = UUID.randomUUID();
            temp.setItemId(itemId);
        } while (KaraokeConstant.listMenu.contains(temp));

        String itemCode = generateItemCode();

        System.out.print("Nhap ten mon: ");
        String itemName = sc.nextLine();
        System.out.print("Nhap loai mon (Do an / Do uong / Khac): ");
        String itemCategory = sc.nextLine();
        System.out.print("Nhap gia tien: ");
        Long itemPrice = Long.parseLong(sc.nextLine());

        MenuDTO menuDTO = new MenuDTO(itemId, itemCode, itemName, itemCategory, itemPrice);
        KaraokeConstant.listMenu.add(menuDTO);
        System.out.println("Them mon thanh cong! (Ma: " + itemCode + " | UUID: " + itemId + ")");
    }

    public void updateMenu() {
        System.out.println("\n---Sua mon trong menu---");
        System.out.print("Nhap UUID mon can sua: ");
        String itemId = sc.nextLine().trim();

        Optional<MenuDTO> menuOpt = getById(itemId);
        if (menuOpt.isEmpty()) {
            System.out.println("Khong tim thay mon");
            return;
        }

        MenuDTO menuDTO = menuOpt.get();
        System.out.print("Nhap ten mon moi: ");
        menuDTO.setItemName(sc.nextLine());
        System.out.print("Nhap loai mon moi: ");
        menuDTO.setItemCategory(sc.nextLine());
        System.out.print("Nhap gia moi: ");
        menuDTO.setItemPrice(Long.parseLong(sc.nextLine()));

        System.out.println("Cap nhat mon thanh cong");
    }

    public void deleteMenu() {
        System.out.println("\n---Xoa mon trong menu---");
        System.out.print("Nhap UUID mon can xoa: ");
        String itemId = sc.nextLine().trim();

        Optional<MenuDTO> menuOpt = getById(itemId);
        if (menuOpt.isEmpty()) {
            System.out.println("Khong tim thay mon");
            return;
        }

        KaraokeConstant.listMenu.remove(menuOpt.get());
        System.out.println("Xoa mon thanh cong");
    }
}
