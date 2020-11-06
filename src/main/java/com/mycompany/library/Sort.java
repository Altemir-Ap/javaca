/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import java.util.ArrayList;

/**
 *
 * @author altemir
 */
public class Sort {
    
    public ArrayList<Books> sortBooksByTitle(ArrayList<Books> books) {

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j + 1).getTitle()) > 0) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    }

    public ArrayList<Books> sortBooksByAuthor(ArrayList<Books> books) {

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                if (books.get(j).getAuthor().compareTo(books.get(j + 1).getAuthor()) > 0) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    }

    public ArrayList<Readers> sortReadersById(ArrayList<Readers> readers) {
        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() - 1; j++) {
                if (readers.get(j).getId() > readers.get(j + 1).getId()) {
                    Readers temp = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, temp);
                }
            }
        }
        return readers;
    }

    public ArrayList<Readers> sortReadersByName(ArrayList<Readers> readers) {
        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() - 1; j++) {
                if (readers.get(j).getName().compareTo(readers.get(j + 1).getName()) > 0) {
                    Readers temp = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, temp);
                }
            }
        }
        return readers;
    }
}
