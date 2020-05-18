package repository.impl;

import model.Contact;
import model.concrete.NumberPhoneContact;
import repository.IGeneralRepository;

import java.io.*;
import java.util.List;

public class ContactRepository implements IGeneralRepository {
    public static String filePath = "D:\\Code Gym\\Git\\Module 2\\Java\\FinalExamModule2\\data\\contacts.csv";
    @Override
    public void save(List<Contact> list) {
        try {
            PrintStream ps = new PrintStream(filePath);
            for (Contact contact: list){
                ps.println(contact.toString());
            }
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(List<Contact> list) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                String numberPhone = attributes[0];
                String group = attributes[1];
                String fullName = attributes[2];
                String gender = attributes[3];
                String address = attributes[4];
                String mail = attributes[5];
                list.add(new NumberPhoneContact(numberPhone,fullName,group,gender,address,mail));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
