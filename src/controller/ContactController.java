package controller;

import model.Contact;
import service.IComparator;
import service.impl.ContactServiceImpl;

import java.util.List;

public class ContactController {
        ContactServiceImpl contactService = new ContactServiceImpl();
        public void displayAll(List<Contact> list){
            contactService.displayAll(list);
        }
        public void disPlaySingleContact(List<Contact> list, String numberPhoneOrName){
            System.out.println(contactService.disPlaySingleContact(list,numberPhoneOrName));
        }
        public void sort(List<Contact> list, IComparator iComparator){
            contactService.sort(list,iComparator);
        }
        public Contact findCorrectly(List<Contact> lists, String numberPhoneOrName){
            return contactService.findCorrectly(lists,numberPhoneOrName);
        }
        public List<Contact> find(List<Contact> list, String numberPhoneOrName){
           return contactService.find(list,numberPhoneOrName);
        }
        public boolean remove(List<Contact> list, String numberPhoneOrName){
            return contactService.remove(list,numberPhoneOrName);
        }
        public void add(List<Contact> list, Contact contact){
            contactService.add(list,contact);
        }
        public void update(List<Contact> list, Contact contact, String numberPhone){
            contactService.update(list,contact,numberPhone);
        }
}
