import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("---Phong hat Karaoke----");
            System.out.println("1. Quan ly phong hat");
            System.out.println("2. Quan ly khach hang"); // TODO không cần
            System.out.println("3. Quan ly dat phong"); // TODO
            System.out.println("4. Quan ly menu");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    roomMenu();
                    break;

                case 2:
                    customerMenu();
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
        }while (choice != 0);

        sc.close();
    }

    private static void roomMenu() {
        int choice;
        do {
            System.out.println("----Quan ly phong hat----");
            System.out.println("1. Them phong hat");
            System.out.println("2. Sua phong hat");
            System.out.println("3. Xoa phong hat");
            System.out.println("4. Tim kiem phong hat"); //TODO khong can lam. thieu dat phong
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chuc nang them");
                    break;
                case 2:
                    System.out.println("Chuc nang sua");
                    break;
                case 3:
                    System.out.println("Chuc nang xoa");
                    break;
                case 4:
                    System.out.println("Chuc tim kiem");
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        }while (choice != 0);

    }

    //TODO bo
    private static void customerMenu() {
        int choice;
        do {
            System.out.println("----Quan ly khach hang----");
            System.out.println("1. Them khach hang");
            System.out.println("2. Sua khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chuc nang them");
                    break;
                case 2:
                    System.out.println("Chuc nang sua");
                    break;
                case 3:
                    System.out.println("Chuc nang xoa");
                    break;
                case 4:
                    System.out.println("Chuc tim kiem");
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        }while (choice != 0);

    }

    private static void bookingMenu() {
        int choice;
        do {
            System.out.println("----Quan ly dat phong----");
            System.out.println("1. Them dat phong");
            System.out.println("2. Sua dat phong");
            System.out.println("3. Xoa dat phong");
            System.out.println("4. Tim kiem dat phong");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chuc nang them");
                    break;
                case 2:
                    System.out.println("Chuc nang sua");
                    break;
                case 3:
                    System.out.println("Chuc nang xoa");
                    break;
                case 4:
                    System.out.println("Chuc tim kiem");
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        }while (choice != 0);

    }

    private static void menuMenu() {
        int choice;
        do {
            System.out.println("----Quan ly menu----");
            System.out.println("1. Them menu");
            System.out.println("2. Sua menu");
            System.out.println("3. Xoa menu");
            System.out.println("4. Tim kiem menu");
            System.out.println("0. Thoat");
            System.out.print("Nhap: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chuc nang them");
                    break;
                case 2:
                    System.out.println("Chuc nang sua");
                    break;
                case 3:
                    System.out.println("Chuc nang xoa");
                    break;
                case 4:
                    System.out.println("Chuc tim kiem");
                    break;
                case 0:
                    System.out.println("Quay lai");
                    break;
                default:
                    System.out.println("Lua chon sai");
            }
        }while (choice != 0);

    }
}