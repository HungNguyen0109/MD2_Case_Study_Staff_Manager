package com.company.view;

import java.util.Scanner;

public class MenuStaff {
    MenuStaff() {
        Scanner scanner = new Scanner(System.in);
        StaffView staffView = new StaffView();
        System.out.println("======> STAFF MANAGE <======");
        System.out.println("1.Hiển thị danh sách nhân viên");
        System.out.println("2.Trạng thái làm việc");
        System.out.println("3.Tìm kiếm nhân viên");
        System.out.println("4.Hiển thị bảng lương");
        System.out.println("5.Hiện thị tài khoản đăng nhập");
        System.out.println("6.Đăng xuất");
        System.out.println("Chọn thao tác:");

        int chooseMenu = Integer.parseInt(scanner.nextLine());
        switch (chooseMenu) {
            case 1:
                staffView.showListStaff();
                break;
            case 2:
                System.out.println("1.Kiểm tra" + "\n" +
                        "2.Thay đổi");
                String choose = scanner.next();
                switch (choose) {
                    case "1":
                        staffView.checkStatusByName();
                        break;
                    case "2":
                        staffView.editStatus();
                        break;
                    default:
                        System.err.println("Vui lòng nhập lại !!");
                        new MenuStaff();
                }
                break;
            case 3:
                System.out.println("1.Tìm kiếm theo Id" + "\n" +
                        "2.Tìm kiếm theo tên");
                String choose1 = scanner.nextLine();
                switch (choose1) {
                    case "1":
                        staffView.findById();
                        break;
                    case "2":
                        staffView.findByName();
                        break;
                    default:
                        System.err.println("Vui lòng nhập lại !!");
                        new MenuStaff();
                }
                break;
            case 4:
                System.out.println("1.FullTime" + "\n" + "" +
                        "2.PartTime");
                String choose5 = scanner.nextLine();
                switch (choose5) {
                    case "1":
                        System.out.println("=====> FullTime <=====");
                        staffView.showListSalaryFull();
                        break;
                    case "2":
                        System.out.println("=====> PartTime <=====");
                        staffView.showListSalaryPart();
                        break;
                    default:
                        System.err.println("Vui lòng nhập lại !!");
                        new MenuStaff();
                        break;
                }
            case 5:
                new UserView().showListUserLogin();
                break;

            case 6:
                new Main();
                break;
            default:
                System.err.println("Vui lòng nhập lại !!");
                new MenuStaff();
        }
    }
}

