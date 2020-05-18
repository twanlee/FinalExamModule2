package model;

public abstract class Contact {
    private String numberPhone;
    private String fullName;
    private String group;
    private String  gender;
    private String address;
    private String mail;

    public Contact(String numberPhone, String fullName, String group, String gender, String address, String mail) {
        this.numberPhone = numberPhone;
        this.fullName = fullName;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String toString() {
        return numberPhone+"," + group+","+fullName+","+gender+","+address+","+mail;
    }
    public String displayInfo(){
        return "Number Phone: "+numberPhone+" | Group: "+group+" | Name: "+
                fullName+" | Gender: "+gender+" | Address: "+ address + " | Email: " + mail;
    }
}
