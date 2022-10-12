package com.telran.hontsova.homework.phonebook.fw;

import com.telran.hontsova.homework.phonebook.model.Contact;
import com.telran.hontsova.homework.phonebook.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


        @DataProvider
    public Iterator<Object[]> newUsersFromFilePositive() {
            List<Object[]> list = new ArrayList<>();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/newUsersPositive.csv"));
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] lineValues = line.split(",");
                    list.add(new Object[]{new User(lineValues[0], lineValues[1])});
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.iterator();
        }


     @DataProvider
    public Iterator<Object[]> newUsersFromFileNegative() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/newUsersNegative.csv"));
            String line = bufferedReader.readLine();
            while(line!=null){
                String[] lineValues =  line.split(",");
                list.add(new Object[]{ new User(lineValues[0],lineValues[1])});
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDataToAddNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Contact("testName", "testLastName", "123456789", "testEmail@gmail.com", "testAddress", "testDescription")});
        list.add(new Object[]{new Contact("1testName", "1testLastName", "1123456789", "1testEmail@gmail.com", "1testAddress", "1testDescription")});
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> UserDataFromFileToAddNewContact() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/userData.csv"));
            String line = bufferedReader.readLine();
            while(line!=null){
                String[] lineValues =  line.split(",");
                list.add(new Object[]{ new Contact(lineValues[0], lineValues[1], lineValues[2], lineValues[3], lineValues[4], lineValues[5])});
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list.iterator();
    }

//    @DataProvider
//    public Iterator<Object[]> newUsersPositive() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{new User("testlogin@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testlogin1@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testlogin2@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testlogin3@gmail.com", "Test123456789!_")});
//        return list.iterator();
//    }

//    @DataProvider
//    public Iterator<Object[]> newUsersNegative() {
//        List<Object[]> list = new ArrayList<>();
//        //test with invalid email
//        list.add(new Object[]{new User("Testlogin@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testlogin111@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testtestlogin2@gmail.com", "Test123456789!_")});
//        list.add(new Object[]{new User("testlogin@mail.com", "Test123456789!_")});
//        //tests with invalid password
//        list.add(new Object[]{new User("testlogin@gmail.com", "Test123456789")});
//        list.add(new Object[]{new User("testlogin1@gmail.com", "test123456789!_")});
//        list.add(new Object[]{new User("testlogin2@gmail.com", "TEST123456789!_")});
//        list.add(new Object[]{new User("testlogin3@gmail.com", "Test111111111!_")});
//        return list.iterator();
//    }



}
