//Phonebook App
/*

A phone book app that presents a list of options for a user to use the app

 */
import javax.sound.midi.Soundbank;
import java.util.*;

public class PhoneBook
{
    private ArrayList<String[]> contactDetails;
    private String contactFirstName;
    private String contactLastName;
    private String phoneNumber;


   public PhoneBook(String firstName, String lastName, String phoneNumber)
   {
      this.contactFirstName = firstName;
      this.contactLastName = lastName;
      this.phoneNumber = phoneNumber;

   }
   public String goToMainMenu()
   {
      String prompt = """
              \nYour phoneBook
              1 -> Register new contact
              2 -> Search contacts by first name
              3 -> Search contact by phone number
              4 -> View all contacts
              5 -> Edit contact
              6 -> Exit
              """;
      return prompt;

   }
   public void controls()
   {
      String choice = input("Enter an option: ");
      char x = choice.charAt(0);
      switch(x)
      {
         case '1' -> registerNewContact();
         case '2' -> searchContactsByFirstName();
         case '3' -> searchContactByPhoneNumber();
         case '4' -> viewContacts();
         case '5' -> editContact();
         case '6' -> endProgram();
         default -> goToMainMenu();
      }
   }
   public void registerNewContact()
   {
      String firstName = input("Enter contact first name: ");
      String lastName = input("Enter contact last name: ");
      String phoneNumber = input("Enter phone number: ");
      String[] contacts = {this.contactFirstName, this.contactLastName, this.phoneNumber};
      contactDetails.add(contacts);
      goToMainMenu();
   }
   public ArrayList<String[]> searchContactsByFirstName()
   {
      String contactFirstName = input("Enter first name: ");
      ArrayList<String[]> result = new ArrayList<>();
      for (String[] contact : contactDetails)
      {
         if (contact[0].equalsIgnoreCase(contactFirstName)) result.add(contact);
      }
      return result;
   }
   public ArrayList<String[]> searchContactByPhoneNumber()
   {
      String contactPhoneNumber = input("Enter phone number: ");
      ArrayList<String[]> result = new ArrayList<>();
      for (String[] contact : contactDetails)
      {
         if (contact[0].equalsIgnoreCase(contactPhoneNumber)) result.add(contact);
      }
      return result;
   }
   public ArrayList<String[]> editContact()
   {
      display("""
                 How will you like to update contact details?
                 1 -> By first name
                 1 -> By last name
                 1 -> By phone number
                 """);
      String contactInfo = input("Enter phone number: ");
      ArrayList<String[]> result = new ArrayList<>();
      for (String[] contact : contactDetails)
      {
         if (contact[0].equalsIgnoreCase(contactInfo)) result.add(contact);

      }
      return result;
   }
   public ArrayList<String[]> viewContacts()
   {
      return contactDetails;
   }
   public void endProgram()
   {
      System.exit(0);
   }
   public static String input(String textPrompt)
   {
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();
      return userInput;
   }
   public static void display(String message)
   {
      System.out.print(message);
   }

   public static void main(String[] args)
   {
      PhoneBook newContact = new PhoneBook("Jane","Foster", "01-567-3456");
      display(newContact.goToMainMenu());
   }
}
