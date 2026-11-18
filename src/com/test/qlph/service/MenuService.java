package com.test.qlph.service;

import com.test.qlph.dto.MenuDTO;

import java.util.ArrayList;
import java.util.Optional;

public interface MenuService {
    ArrayList<MenuDTO> getAll();
    Optional<MenuDTO> getById(String itemId);
    Optional<MenuDTO> getByCode(String itemCode);
    void showAll();
    void addMenu();
    void updateMenu();
    void deleteMenu();
}
