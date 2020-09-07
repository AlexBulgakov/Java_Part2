package ru.geekbrains.alexbulgakov.java_part2.lection3.homework;

import java.util.*;

public class PhoneBook{
    HashMap<String, ArrayList<Contacts>> contactList = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (contactList.containsKey(surname)) {
            ArrayList<Contacts> contacts = contactList.get(surname);
            contacts.add(new Contacts(surname, phoneNumber));
        } else {
            ArrayList<Contacts> contacts = new ArrayList<>();
            contacts.add(new Contacts(surname, phoneNumber));
            contactList.put(surname, contacts);
        }
    }

    public ArrayList<String> get(String surname) {
        if (!contactList.containsKey(surname)) return null;
        ArrayList<Contacts> contacts = contactList.get(surname);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            result.add(contacts.get(i).numberPhone);
        }
        return result;
    }


}
