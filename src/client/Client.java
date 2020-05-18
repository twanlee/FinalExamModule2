package client;

import controller.ContactController;
import model.Contact;
import model.concrete.NumberPhoneContact;
import repository.impl.ContactRepository;
import service.impl.SortNameContact;
import service.impl.SortNumberPhoneContact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    List<Contact> myList = new ArrayList<>();
    ContactController contactController = new ContactController();
    SortNameContact sortNameContact = new SortNameContact();
    SortNumberPhoneContact sortNumberPhoneContact = new SortNumberPhoneContact();
    ContactRepository contactRepository = new ContactRepository();
    File file = new File(ContactRepository.filePath);
    Scanner scanner = new Scanner(System.in);

    public boolean checkFirstTime(){
        if(file.length()==0){
            return true;
        }else
            return false;
    }
    public void menu(){
        contactRepository.load(myList);
        while (true){
        System.out.println("-------Quản lí danh bạ-------");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Sắp xếp số điện thoại");
        System.out.println("9. Sắp xếp tên");
        System.out.println("0. Thoát");
        System.out.println("Chọn chức năng: ");


            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    contactController.displayAll(myList);
                    break;
                case 2:
                    myList.add(addNewContact());
                    System.out.println("Done");
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại cần sửa");
                    scanner.nextLine();
                    String numberPhone = scanner.nextLine();
                    Contact myContacts = addNewContact();
                    contactController.update(myList,myContacts,numberPhone);
                    break;
                case 4:
                    System.out.println("Nhập số điện thoại bạn muốn xóa");
                    scanner.nextLine();
                    String yourPhone = scanner.nextLine();
                    contactController.remove(myList,yourPhone);
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại hoặc tên");
                    scanner.nextLine();
                    String numberOrName = scanner.nextLine();
                    contactController.disPlaySingleContact(myList,numberOrName);
                    break;
                case 6:
                    contactRepository.load(myList);
                    break;
                case 7:
                    contactRepository.save(myList);
                    break;
                case 8:
                    contactController.sort(myList,sortNameContact);
                    contactController.displayAll(myList);
                    break;
                case 9:
                    contactController.sort(myList,sortNumberPhoneContact);
                    contactController.displayAll(myList);
                    break;
                case 0:
                    contactRepository.save(myList);
                    System.exit(0);
            }
        }
    }

    private Contact addNewContact() {
        System.out.println("Nhập số điện thoại");
        scanner.nextLine();
        String number = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        return new NumberPhoneContact(number,name,group,gender,address,email);
    }
}
