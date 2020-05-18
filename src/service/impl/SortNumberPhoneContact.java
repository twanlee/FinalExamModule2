package service.impl;

import model.Contact;
import service.IComparator;

public class SortNumberPhoneContact implements IComparator {
    @Override
    public int compare(Contact contact1, Contact contact2) {
        return contact1.getNumberPhone().compareTo(contact2.getNumberPhone());
    }
}
