
import java.util.*;

public class Task_01 {
    public static void main(String[] args) {
        HashMap<String, List<String>> contacts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1) Добавить контакт");
            System.out.println("2) Вывести всех");
            System.out.println("3) Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после считывания числа

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите телефон: ");
                    String phoneNumber = scanner.nextLine();
                    addContact(contacts, name, phoneNumber);
                    System.out.println("Контакт успешно добавлен.\n");
                    break;
                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("Телефонная книга пуста.\n");
                    } else {
                        System.out.println("Список контактов:");
                        printContactsSortedByPhoneCount(contacts);
                    }
                    break;
                case 3:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.\n");
                    break;
            }
        }
    }

    private static void addContact(HashMap<String, List<String>> contacts, String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            List<String> phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    private static void printContactsSortedByPhoneCount(HashMap<String, List<String>> contacts) {
        List<String> allPhoneNumbers = new ArrayList<>();

        for (List<String> phoneNumbers : contacts.values()) {
            allPhoneNumbers.addAll(phoneNumbers);
        }

        Collections.sort(allPhoneNumbers, Collections.reverseOrder());
        List<String> keys = new ArrayList<>(contacts.keySet());

        System.out.println("Список контактов (отсортирован по убыванию числа телефонов):");
        for (String phoneNumber : allPhoneNumbers) {
            for (String key : keys) {
                List<String> phoneNumbers = contacts.get(key);
                String value = String.join(", ", phoneNumbers);
                if (value.equals(phoneNumber)) {
                    System.out.println(key + ":" +  phoneNumber);
                    break;
                }
            }
        }
        System.out.println();
    }
}