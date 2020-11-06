/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

/**
 *
 * @author altemir
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author altemir
 */
public class Data {

    public ArrayList<Books> loadBooks() throws FileNotFoundException {

        FileInputStream file = new FileInputStream("books.txt");
        String strline = "";
        ArrayList<Books> books = new ArrayList<Books>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");
                books.add(new Books(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3])));
                strline = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Readers> loadReaders() throws FileNotFoundException {

        FileInputStream file = new FileInputStream("readers.txt");
        String strline = "";
        ArrayList<Readers> readers = new ArrayList<Readers>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");
                readers.add(new Readers(Integer.parseInt(parts[0]), parts[1], parts[2]));
                strline = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readers;

    }

    public ArrayList<Borrows> listBorrows(int id) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("borrows.txt");
        String strline = "";
        ArrayList<Borrows> borrows = new ArrayList<Borrows>();
        ArrayList<Borrows> newList = new ArrayList<Borrows>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");

                borrows.add(new Borrows(Integer.parseInt(parts[0]), parts[1], parts[2]));
                strline = br.readLine();
            }
            for (int i = 0; i < borrows.size(); i++) {
                if (id == borrows.get(i).readerId) {
                    newList.add(borrows.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    public String registerBorrow(String[] borrows) throws IOException {

        try {
            BufferedWriter writeBorrow = new BufferedWriter(new FileWriter("borrows.txt", true));
            writeBorrow.write(borrows[0] + "," + borrows[1] + "," + borrows[2] + "\n");
            writeBorrow.close();
        } catch (IOException e) {
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }

        return "Borrow Registered sucessfully";
    }

    public String registerReturn(String[] rArray) throws IOException {

        try {
            BufferedWriter writeReturn = new BufferedWriter(new FileWriter("returns.txt", true));
            writeReturn.close();
        } catch (IOException e) {
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }

        return "Book returned sucessfully";
    }

    public boolean searchBookByTitle(ArrayList<Books> book, String title) {
        boolean found = false;
        for (Books b : book) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Book not found");
        }
        return found;
    }

    public boolean searchBookByAuthor(ArrayList<Books> book, String author) {
        boolean found = false;
        for (Books b : book) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Author not found");
        }

        return found;

    }

    public boolean searchReaderByName(ArrayList<Readers> reader, String name) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getName().equalsIgnoreCase(name)) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }

    public boolean searchReaderById(ArrayList<Readers> reader, int id) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getId() == id) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }


}
