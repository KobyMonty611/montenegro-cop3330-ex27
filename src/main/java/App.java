/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Koby Montenegro
 */


import java.util.Scanner;

class Main
{
    public static int firstValidate(String firstNameInput)
    {
        int count = 0;
        if(firstNameInput.length() < 2)
        {
            //response1 = The first name must be at least 2 characters long.
            count++;

            if(firstNameInput.equals(""))
            {
                //response2 = The first name must be filled in.
                count++;
            }

            return count;
        }

        else
        {
            count = 0;
        }
        return count;
    }

    public static int lastValidate(String lastNameInput)
    {
        int count = 0;
        if(lastNameInput.length() < 2)
        {
            //response1 = The last name must be at least 2 characters long.
            count++;

            if(lastNameInput.equals(""))
            {
                //response2 = The last name must be filled in.
                count++;
            }
        }

        else
        {
            count = 0;
        }

        return count;
    }

    public static int zipValidate(String zipCodeInput)
    {
        int count = 0;

        try
        {
            int Num = Integer.parseInt(zipCodeInput);
        }
        catch(NumberFormatException e)
        {
            count++;
        }

        if(!(zipCodeInput.length() == 5))
        {
            count++;
        }

        return count;
        //The zipcode must be a 5 digit number.
    }

    public static int idValidate(String employeeIDInput)
    {
        int count = 0;

        if((Character.isDigit(employeeIDInput.charAt(0)) || Character.isDigit(employeeIDInput.charAt(1))))
        {
            count++;
            //System.out.println("AA no good");
        }

        if((employeeIDInput.substring(1,2).equals('-')))
        {
           count++;
           //System.out.println("Hyphen no good");
        }

        try
        {
            int Num = Integer.parseInt(employeeIDInput.substring(2));
        }
        catch(NumberFormatException e)
        {
            count++;
            //System.out.println("Number no good");
        }

        return count;
        //The employee ID must be in the format of AA-1234.

    }

    public static void validateInput(String firstName, String lastName, String zipCode, String employeeID)
    {
        String response = "";
        int count = 0;

        if(firstValidate(firstName) == 1)
        {
            response += "The first name must be at least 2 characters long.\n";
            count++;
        }
            else if(firstValidate(firstName) == 2)
            {
            response += "The first name must be filled in.\nThe last name must be at least 2 characters long.\n";
            count++;
            }

        if(lastValidate(lastName) == 1)
        {
            response += "The last name must be at least 2 characters long.\n";
            count++;
        }
            else if(lastValidate(lastName) == 2)
            {
            response += "The last name must be filled in.\nThe last name must be at least 2 characters long.\n";
            count++;
            }

        if(idValidate(employeeID) >0)
        {
            response += "The employee ID must be in the format of AA-1234.\n";
            count++;
        }

        if(zipValidate(zipCode) > 0)
        {
            response += "The zipcode must be a 5 digit number.\n";
            count++;
        }

        if(count==0)
        {
            response += "There were no errors found.";
        }

        System.out.print(response);
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String first, last, zip, id;

        System.out.print("Enter the first name: ");
        first = scan.nextLine();
        System.out.print("Enter the last name: ");
        last = scan.nextLine();
        System.out.print("Enter the ZIP code: ");
        zip = scan.nextLine();
        System.out.print("Enter the employee ID: ");
        id = scan.nextLine();

        validateInput(first, last, zip, id);

        scan.close();

    }
}