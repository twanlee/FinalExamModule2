package repository;

import model.Contact;

import java.util.List;

public interface IGeneralRepository {
    void save(List<Contact> list);
    void load(List<Contact> list);

}
