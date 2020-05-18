package service;

import model.Contact;

import java.util.ArrayList;
import java.util.List;

public interface IContactService {
     void displayAll(List<Contact> list);
     void disPlaySingleContact(List<Contact> list, String numberPhoneOrName);
     void sort(List<Contact> list, IComparator iComparator);
     Contact findCorrectly(List<Contact> lists, String numberPhoneOrName);
     ArrayList<Contact> find(List<Contact> list, String numberPhoneOrName);
     boolean remove(List<Contact> list, String numberPhoneOrName);
     void add(List<Contact> list, Contact contact);
     void update(List<Contact> list, Contact contact, String numberPhone);
}
