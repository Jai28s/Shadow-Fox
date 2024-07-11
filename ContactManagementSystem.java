import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private final String name;
    private final String phoneNumber;
    private final String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmail() {
        return email;  
    }

    void setPhoneNumber(String newPhoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void setEmail(String newEmail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

public class ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    contacts.add(new Contact(name, phoneNumber, email));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.println("\nContacts:");
                    for (Contact contact : contacts) {
                        System.out.println("Name: " + contact.getName());
                        System.out.println("Phone: " + contact.getPhoneNumber());
                        System.out.println("Email: " + contact.getEmail());
                        System.out.println();
                    }
                    break;
               
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String contactNameToUpdate = scanner.next();
                    boolean found = false;

                    for (Contact contact : contacts) {
                        if (contact.getName().equalsIgnoreCase(contactNameToUpdate)) 
                {
                            
                            System.out.print("Enter new phone number: ");
                            String newPhoneNumber = scanner.next();
                            System.out.print("Enter new email: ");
                            String newEmail = scanner.next();

                            contact.setPhoneNumber(newPhoneNumber);
                            contact.setEmail(newEmail);
                            System.out.println("Contact updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                    System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    String contactNameToDelete = scanner.next();
                    boolean removed = contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(contactNameToDelete));

                    if (removed) {
                    System.out.println("Contact deleted successfully!");
                    } else {
                    System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Contact Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
