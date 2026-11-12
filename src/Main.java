import com.test.qlph.constant.KaraokeConstant;
import com.test.qlph.service.BookingService;
import com.test.qlph.service.EmployeeService;
import com.test.qlph.service.MenuService;
import com.test.qlph.service.RoomService;

import java.util.Scanner;

public class Main {

    static Scanner sc = KaraokeConstant.sc;
    static EmployeeService employeeService = new EmployeeService();
    static RoomService roomService = new RoomService();
    static MenuService menuService = new MenuService();
    static BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("---Phong hat Karaoke----");
            System.out.println("1. Quan ly phong hat");
            System.out.println("2. Quan ly nhan vien");
            System.out.println("3. Quan ly dat phong");
            System.out.println("4. Quan ly menu");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    roomMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    bookingMenu();
                    break;
                case 4:
                    menuMenu();
                    break;
                case 0:
                    System.out.println("BYE!");
                    break;
                default:
                    System.out.println("Chon sai!");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void roomMenu() {
        int choice;
        do {
            System.out.println("----Quan ly phong hat----");
            System.out.println("1. Them phong hat");
            System.out.println("2. Sua phong hat");
            System.out.println("3. Xoa phong hat");
            System.out.println("4. Danh sach phong hat");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    roomService.addRoom();
                    break;
                case 2:
                    roomService.updateRoom();
                    break;
                case 3:
                    roomService.deleteRoom();
                    break;
                case 4:
                    roomService.showAll();
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        } while (choice != 0);
    }

    private static void employeeMenu() {
        int choice;
        do {
            System.out.println("----Quan ly nhan vien----");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Sua nhan vien");
            System.out.println("3. Xoa nhan vien");
            System.out.println("4. Danh sach nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    employeeService.addEmployee();
                    break;
                case 2:
                    employeeService.updateEmployee();
                    break;
                case 3:
                    employeeService.deleteEmployee();
                    break;
                case 4:
                    employeeService.showAll();
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        } while (choice != 0);
    }

    private static void bookingMenu() {
        int choice;
        do {
            System.out.println("----Quan ly dat phong----");
            System.out.println("1. Them dat phong");
            System.out.println("2. Sua dat phong");
            System.out.println("3. Xoa dat phong");
            System.out.println("4. Danh sach dat phong");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.updateBooking();
                    break;
                case 3:
                    bookingService.deleteBooking();
                    break;
                case 4:
                    bookingService.showAll();
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        } while (choice != 0);
    }

    private static void menuMenu() {
        int choice;
        do {
            System.out.println("----Quan ly menu----");
            System.out.println("1. Them menu");
            System.out.println("2. Sua menu");
            System.out.println("3. Xoa menu");
            System.out.println("4. Danh sach menu");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    menuService.addMenu();
                    break;
                case 2:
                    menuService.updateMenu();
                    break;
                case 3:
                    menuService.deleteMenu();
                    break;
                case 4:
                    menuService.showAll();
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        } while (choice != 0);
    }
}
