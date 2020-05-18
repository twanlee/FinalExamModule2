package service.impl;

import model.Contact;
import service.IComparator;

public class SortNameContact implements IComparator {

    @Override
    public int compare(Contact contact1, Contact contact2) {
        return contact1.getFullName().compareTo(contact2.getFullName());
    }
}
