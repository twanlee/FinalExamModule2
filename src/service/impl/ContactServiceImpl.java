package service.impl;

import model.Contact;
import service.IComparator;
import service.IContactService;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements IContactService {
    @Override
    public void displayAll(List<Contact> list) {
        for (Contact contact : list) System.out.println(contact.displayInfo());;
    }

    @Override
    public void disPlaySingleContact(List<Contact> list, String numberPhoneOrName) {
        System.out.println(findCorrectly(list,numberPhoneOrName).displayInfo());

    }

    @Override
    public void sort(List<Contact> list, IComparator iComparator) {
        for (int i=0; i<list.size(); i++){
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (iComparator.compare(list.get(j), list.get(j + 1)) < 0) {
                    Contact temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public Contact findCorrectly(List<Contact> lists, String numberPhoneOrName) {
            for (Contact contact: lists){
                if(contact.getFullName().equalsIgnoreCase(numberPhoneOrName) || contact.getNumberPhone().equalsIgnoreCase(numberPhoneOrName)){
                    return contact;
                }
            }
            return null;
    }

    @Override
    public ArrayList<Contact> find(List<Contact> list, String numberPhoneOrName) {
        ArrayList<Contact> newList = new ArrayList<>();
        for (Contact contact : list){
            if(contact.getNumberPhone().contains(numberPhoneOrName) || contact.getFullName().contains(numberPhoneOrName)){
                newList.add(contact);
            }
        }return newList;
    }

    @Override
    public boolean remove(List<Contact> list, String numberPhoneOrName) {
            Contact contact = findCorrectly(list,numberPhoneOrName);
            if(contact!=null){
                list.remove(contact);
                return true;
            }return false;
    }

    @Override
    public void add(List<Contact> list, Contact contact) {
        Contact contactCheck1 = findCorrectly(list,contact.getFullName());
        Contact contactCheck2 = findCorrectly(list,contact.getNumberPhone());
        if(contactCheck1 == null && contactCheck2 ==null){
            list.add(contact);
            System.out.println("Done");
        }else System.out.println("Duplicate contact! Check Again!");
    }

    @Override
    public void update(List<Contact> list, Contact contact, String numberPhone) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone().equalsIgnoreCase(numberPhone)) {
                index = i;
            }
        }
        if(index!=-1){

                list.get(index).setFullName(contact.getAddress());
                list.get(index).setGender(contact.getGender());
                list.get(index).setGroup(contact.getGroup());;
                list.get(index).setMail(contact.getMail());
                list.get(index).setAddress(contact.getAddress());

        }
    }
}
