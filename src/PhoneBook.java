import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phonebook = new HashMap<>();
    public Set<String> keys = phonebook.keySet();

    private void checkNumber(String number) {
        if (number == null || number.isEmpty())
            throw new IllegalArgumentException("Телефон отсутствует");

        for (char c : number.toCharArray()) {
            if (!(Character.isDigit(c) || c == '*' || c == '#' || c == '+' || c == '-')) {
                throw new IllegalArgumentException("Некорректный ввод");
            }
        }
    }

    public boolean addContact(String contact) {
        if (phonebook.containsKey(contact)) {
            return false;
        }
        phonebook.put(contact, new HashSet<>());
        return true;
    }

    public boolean deleteContact(String contact) {
        return phonebook.remove(contact) != null;
    }

    public void addPhone(String contact, String number) {
        checkNumber(number);
        Set<String> numberSet = phonebook.get(contact);
        if (numberSet != null) {
            numberSet.add(number);
        } else {
            numberSet = new HashSet<>();
            numberSet.add(number);
            phonebook.put(contact, numberSet);
        }
    }

    public void deletePhone(String contact, String number) {
        checkNumber(number);
        Set<String> numberSet = phonebook.get(contact);
        numberSet.remove(number);
    }

    public Set<String> FindNumbers(String contact) {
        if (!phonebook.get(contact).isEmpty()) {
            return phonebook.get(contact);
        } else {
            return null;
        }
    }

    public String FindContact(String number) {
        checkNumber(number);
        String resault = "";
        System.out.println(phonebook.entrySet());
        Set<HashMap.Entry<String, Set<String>>> entrySet = phonebook.entrySet();
        if (entrySet.contains(number)) {

        }
        return "";
    }
}

