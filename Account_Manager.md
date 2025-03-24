# Account Manager Project

## Overview
The **Account Manager** project is a simple Java-based application for managing bank accounts. It allows users to create, view, delete, and save account details using serialization for data persistence.

## Features

### 1. **Create Account**
- Users can create a new account by entering the account number, name, and initial balance.
- The created account is stored in a **HashMap** for easy retrieval and management.
- The system confirms the successful creation of the account.

### 2. **Delete Account**
- Users can delete an account by providing the account number.
- If the account exists, it is removed from the HashMap.
- This action is irreversible.

### 3. **View Account**
- Users can check details of a specific account by entering the account number.
- The system retrieves and displays the account details (Account No, Name, Balance).
- If the account does not exist, no output is shown.

### 4. **View All Accounts**
- Users can view details of all existing accounts.
- The system iterates through the HashMap and prints each account's details.

### 5. **Save Accounts**
- The system saves all account details to a file (`Accounts.txt`) using Java **Object Serialization**.
- All stored accounts persist even after the program exits.

### 6. **Exit**
- The user can exit the program.
- Before exiting, all accounts are automatically saved to `Accounts.txt`.

## Data Persistence
- The program uses **serialization** to save and load account data.
- When the program starts, it attempts to read the stored accounts from `Accounts.txt`.
- When the user chooses to save or exit, all accounts are written to the file.

## How It Works
1. The program loads saved account details (if available) from `Accounts.txt`.
2. The user is presented with a **menu** to perform different operations.
3. Based on the user's choice, the corresponding action is performed.
4. The program runs in a loop until the user chooses to exit.
5. On exit, all account details are saved to `Accounts.txt`.

## Technologies Used
- **Java** for logic and functionality.
- **File Handling & Serialization** for data persistence.
- **HashMap** for efficient account storage and retrieval.

## Future Enhancements
- Add authentication for better security.
- Implement interest calculation for savings accounts.
- Support for transaction history tracking.
- Improve user input validation to handle edge cases.

## Code Implementation
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

class Account implements Serializable {
    String accno;
    String name;
    Double balance;

    Account() {
    }

    Account(String a, String b, Double c) {
        accno = a;
        name = b;
        balance = c;
    }

    public String toString() {
        return "Account No: " + accno + " Name: " + name + " Balance: " + balance;
    }
}

public class Account_Manager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = null;
        HashMap<String, Account> a = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream("Accounts.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                acc = (Account) ois.readObject();
                System.out.println(acc);
                a.put(acc.accno, acc);
            }
            fis.close();
            ois.close();
        } catch (Exception e) {
        }

        try {
            FileOutputStream fos = new FileOutputStream("Accounts.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            System.out.println("Menu");
            int choice;
            String accno, name;
            double balance;

            do {
                System.out.println("1. Create Account");
                System.out.println("2. Delete Account");
                System.out.println("3. View Account");
                System.out.println("4. View All Accounts");
                System.out.println("5. Save Accounts");
                System.out.println("6. Exit");

                System.out.println("Enter your choice here: ");
                choice = sc.nextInt();
                sc.skip("(\r\n|[\r\n\u2028\u2029\u0085])?");

                switch (choice) {
                    case 1:
                        System.out.println("Enter Details: Account No, Name, Balance");
                        accno = sc.nextLine();
                        name = sc.nextLine();
                        balance = sc.nextDouble();
                        acc = new Account(accno, name, balance);
                        a.put(accno, acc);
                        System.out.println("Account Created For: " + name);
                        break;

                    case 2:
                        System.out.print("Enter Account No: ");
                        sc.nextLine();
                        accno = sc.nextLine();
                        a.remove(accno);
                        break;

                    case 3:
                        System.out.print("Enter Account No: ");
                        accno = sc.nextLine();
                        acc = a.get(accno);
                        System.out.println(acc);
                        break;

                    case 4:
                        for (Account x : a.values())
                            System.out.println(x);
                        break;

                    case 5:
                    case 6:
                        oos.writeInt(a.size());
                        for (Account x : a.values()) {
                            oos.writeObject(x);
                        }
                }
            } while (choice != 5);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }
}
```

## How to Run
1. Compile the Java file: `javac Account_Manager.java`
2. Run the program: `java Account_Manager`
3. Follow the on-screen menu to create, view, delete, and save accounts.

