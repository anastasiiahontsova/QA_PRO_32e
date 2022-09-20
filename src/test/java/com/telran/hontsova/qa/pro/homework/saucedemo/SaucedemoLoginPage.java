package com.telran.hontsova.qa.pro.homework.saucedemo;

     import org.testng.annotations.Test;

public class SaucedemoLoginPage extends SaucedemoTestBase{


         @Test
         public void testLoginForm()

         {
             loginForm(EMAIL_FOR_LOGIN, PSW_FOR_LOGIN);
         }

}



