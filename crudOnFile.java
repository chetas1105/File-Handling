package Assignment7_FILE_IO;


import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
class student implements Serializable{
    int sRollNumber;
    String sName;
    long sPhoneNumber;
    student(int sRollNumber,String sName ,long sPhoneNumber){
        this.sRollNumber = sRollNumber;
        this.sName = sName;
        this.sPhoneNumber = sPhoneNumber;
    }

    @Override
    public String toString() {
        return  sRollNumber +" "+  sName  +" "+  sPhoneNumber ;
    }
}
public class que4_CRUD_menu {
    public static void main(String[] args) throws Exception{
        System.out.println("\t\t----STUDENT MANAGEMENT SYSTEM----");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("\tEnter the File Name : ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        ArrayList<Assignment7_FILE_IO.student> al = new ArrayList<Assignment7_FILE_IO.student>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        ListIterator<Assignment7_FILE_IO.student> li = null;




        int choice =0;
        do{
            System.out.println("    Menu");
            System.out.println("1.Create / Insert");
            System.out.println("2.Read / Display");
            System.out.println("3.Search");
            System.out.println("4.Update");
            System.out.println("5.Delete");
            System.out.println("6.Exit");
            System.out.print("Enter the choice : ");
            choice = sc.nextInt();
            System.out.println();
            switch (choice){
                case 1:
                    System.out.print("Enter the number of student :");
                    int n = sc.nextInt();
                    System.out.println();
                    for(int i =0;i<n;i++){
                        System.out.print("Enter student's Roll Number : ");
                        int rollNumber = sc.nextInt();
                        System.out.println();

                        System.out.print("Enter the student's Name : ");
                        String Name = sc1.nextLine();
                        System.out.println();


                        System.out.print("Enter student's Contact Number :");
                        long phoneNumber = sc.nextLong();
                        System.out.println();

                        al.add(new Assignment7_FILE_IO.student(rollNumber,Name,phoneNumber));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;

                case 2:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Assignment7_FILE_IO.student>) ois.readObject();
                        ois.close();

                        System.out.println("================================================");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            System.out.println(li.next());
                        }
                        System.out.println("================================================");
                    }else{
                        System.out.println("File Not Found.....!");
                    }
                    break;

                case 3:
                    if(file.isFile()) {
                        boolean found = false;
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Assignment7_FILE_IO.student>) ois.readObject();
                        ois.close();
                        System.out.print("Enter the roll of student whose date you want to search : ");
                        int roll = sc.nextInt();
                        System.out.println("================================================");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Assignment7_FILE_IO.student s = (Assignment7_FILE_IO.student) li.next();
                            if(s.sRollNumber==roll) {
                                System.out.println(s);
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("Student Data not exist.....!");
                        }
                        System.out.println("================================================");
                    }else{
                        System.out.println("File Not Found.....!");
                    }
                    break;
                case 4:
                    if(file.isFile()) {
                        boolean found = false;
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Assignment7_FILE_IO.student>) ois.readObject();
                        ois.close();
                        System.out.print("Enter the roll of student whose date you want to search : ");
                        int roll = sc.nextInt();
                        System.out.println("================================================");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Assignment7_FILE_IO.student s = (Assignment7_FILE_IO.student) li.next();
                            if(s.sRollNumber==roll) {
                                System.out.println(s);
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("Student Data not exist.....!");
                        }
                        System.out.println("================================================");
                    }else{
                        System.out.println("File Not Found.....!");
                    }


                case 5:
                    if(file.isFile()) {
                        boolean found = false;
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Assignment7_FILE_IO.student>) ois.readObject();
                        ois.close();
                        System.out.print("Enter the roll of student whose date you want to update : ");
                        int roll = sc.nextInt();
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Assignment7_FILE_IO.student s = (Assignment7_FILE_IO.student) li.next();
                            if(s.sRollNumber==roll) {
                                System.out.println("Enter the updated details");
                                System.out.print("Enter the new roll number : ");
                                int rollN = sc.nextInt();
                                s.sRollNumber = rollN;
                                System.out.print("Enter the new name : ");
                                String name = sc1.nextLine();
                                s.sName = name;
                                System.out.print("Enter the new phone number : ");
                                long contact = sc.nextLong();
                                s.sPhoneNumber =contact;
                                found = true;
                            }
                        }
                        if(found){
                            System.out.println("Student data successfully updated.....!");
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                        }
                        else{
                            System.out.println("Student Data not exist.....!");
                        }

                    }else{
                        System.out.println("File Not Found.....!");
                    }
                    break;

            }

        }while (choice !=6);

    }
}
