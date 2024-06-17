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
                System.out.println("4. View All Account");
                System.out.println("5. Save Account");
                System.out.println("6. Exit");

                System.out.println("Enter your choice here: ");
                choice = sc.nextInt();

                sc.skip("(\r\n|[\r\n\u2028\u2029\u0085])?");

                switch (choice) {
                    case 1:
                        System.out.println("Enter Detaile: Account No , Name , Balance");
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
