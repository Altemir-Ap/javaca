/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author altemir
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Data data = new Data();
        Sort sort = new Sort();
        

        ArrayList<Books> myBooks = data.loadBooks();
        ArrayList<Readers> myReaders = data.loadReaders();

        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        do {

            System.out.println("----- Library System ------");
            System.out.println("---------------------------");
            System.out.println("1- Search Book By Author ");
            System.out.println("2- Search Book By Title");
            System.out.println("3- List Book By Author");
            System.out.println("4- List Book By Title");
            System.out.println("5- Search Reader by Name");
            System.out.println("6- Search Reader by Id");
            System.out.println("7- List Reader By Id");
            System.out.println("8- List Reader By Name");
            System.out.println("9- Register a borrow");
            System.out.println("10- Register a return");
            System.out.println("11- List borrow by Reader Id");
            System.out.println("0- Press 0 to exit");
            System.out.println("------- -------");
            System.out.println("Select an menu option");
            try {
                int input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 1:
                        System.out.println("Type an author name");
                        String author = sc.nextLine();
                        System.out.println(data.searchBookByAuthor(myBooks, author));
                        break;
                    case 2:
                        System.out.println("Type a book title");
                        String title = sc.nextLine();
                        System.out.println(data.searchBookByTitle(myBooks, title));
                        break;
                    case 3:
                        System.out.println("All books sorted by Author");
                        System.out.println(sort.sortBooksByAuthor(myBooks));
                        break;
                    case 4:
                        System.out.println("Books sorted by Title");
                        System.out.println(sort.sortBooksByTitle(myBooks));
                        break;
                    case 5:
                        System.out.println("Type a reader name");
                        String readerName = sc.nextLine();
                        System.out.println(data.searchReaderByName(myReaders, readerName));
                        break;
                    case 6:
                        System.out.println("Type a Reader Id");
                        String readerId = sc.nextLine();
                        System.out.println(data.searchReaderById(myReaders, Integer.parseInt(readerId)));
                        break;
                    case 7:
                        System.out.println("Readers sorted By Id");
                        System.out.println(sort.sortReadersById(myReaders));
                        break;
                    case 8:
                        System.out.println("Readers sorted by Name");
                        System.out.println(sort.sortReadersByName(myReaders));
                        break;
                    case 9:
                        System.out.println("Type an Id Reader");
                        String id = sc.nextLine();

                        System.out.println("Type an Book Name");
                        String book = sc.nextLine();

                        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String strDate = dt.format(now);

                        String[] array = {id, book, strDate};

                        System.out.println(data.registerBorrow(array));
                        break;
                    case 10:
                        System.out.println("Type an Id Reader");
                        String idReader = sc.nextLine();

                        System.out.println("Type an Book Name");
                        String bookName = sc.nextLine();

                        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime dateNow = LocalDateTime.now();
                        String dateF = date.format(dateNow);

                        String[] returnArray = {idReader, bookName, dateF};

                        System.out.println(data.registerReturn(returnArray));
                        break;
                    case 11:
                        System.out.println("Type an Reader ID");
                        String readIdBorrow = sc.nextLine();
                        System.out.println(data.listBorrows(Integer.parseInt(readIdBorrow)));
                        break;
                    case 0:
                        loop = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } while (loop);

    }

}
