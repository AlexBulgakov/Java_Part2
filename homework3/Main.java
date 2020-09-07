package ru.geekbrains.alexbulgakov.java_part2.lection3.homework;

public class Main {
    public static void main(String[] args) {
        FindUniques find = new FindUniques();
        String[] arr = {
                "индивидyyм",
                "критический",
                "мотивирyющий",
                "абстракция",
                "игнорировать",
                "yтопический",
                "сyбьективизм",
                "концептyальный",
                "критический",
                "поляризатор",
                "консенсyс",
                "диалект",
                "материальный",
                "мотивация",
                "парадогма"
        };

        find.findUniques(arr);
        find.countWordInArray(arr);

        PhoneBook myPhones = new PhoneBook();

        myPhones.add("Lit", "10038088");
        myPhones.add("Specter", "1040712");
        myPhones.add("Specter", "1111111");
        myPhones.add("Ross", "12539165");

        System.out.println(myPhones.get("Specter"));
    }
}
