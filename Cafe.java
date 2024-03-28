import java.util.Scanner;

public class Cafe {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // This is the header and the menu of the cafe.
        System.out.println("\t\t\tCafe\n\t\t\t====\n");
        System.out.println("\tMENU\n");
        System.out.println("1. Cappuccino\t$4.99\n2. Espresso\t\t$2.99\n3. Latte\t\t\t$6.99\n");
        System.out.println("Hello there! Welcome to the Cafe!!");

        // This asks the customer if they want to check the price of the coffee and decide whether they want to buy or not.
        System.out.print("\nWant to check your total price first? Type yes or no. -> ");
        String checkChoice = userInput.nextLine();
        while (!(checkChoice.toLowerCase().equals("yes") || checkChoice.toLowerCase().equals("no"))){
            System.out.print("\nWrong! Just type Yes or No. ->");
            checkChoice = userInput.nextLine();
        }
        // This runs if the customer want the price check and asks the coffee they want and the number, and then shows their would be cost.
        if (checkChoice.toLowerCase().equals("yes")){
            System.out.print("\nSo, which coffee you want to check the total price of? ->");
            String coffeeCheck = userInput.nextLine();
            while (!(coffeeCheck.equals("1") || coffeeCheck.equals("2") || coffeeCheck.equals("3") || coffeeCheck.toLowerCase().equals("cappuccino") || coffeeCheck.toLowerCase().equals("espresso") || coffeeCheck.toLowerCase().equals("latte"))){
                System.out.print("Please choose coffee from the menu. -> ");
                coffeeCheck = userInput.nextLine();
            }
            if (coffeeCheck.equals("1")){
                coffeeCheck = "cappuccino";
            }else if(coffeeCheck.equals("2")){
                coffeeCheck = "espresso";
            }else if(coffeeCheck.equals("3")){
                coffeeCheck = "latte";
            }
            System.out.print("\nAnd, how many " + coffeeCheck + " do you want?->");
            int numCheck = userInput.nextInt();
            while (numCheck <= 0){
                System.out.print("\nYou have to order one or more! So, how many?-> ");
                numCheck = userInput.nextInt();
            }
            userInput.nextLine();
            CafeCustomer checkInfo = new CafeCustomer("Customer", numCheck, false, coffeeCheck);
            System.out.printf("\nYour total would be $%.2f.\n",checkInfo.calcTotal());

        } 
        // After checking, this will ask if the customer would like to order or not.
        System.out.print("\nSo, would you like to order?-> ");
        String orderCheck = userInput.nextLine();
        while (!(orderCheck.toLowerCase().equals("yes") || orderCheck.toLowerCase().equals("no"))){
            System.out.print("\nWrong! Just type Yes or No ->");
            orderCheck = userInput.nextLine();
        }
        // If the customer don't want to order, this will terminate the program.
        if (orderCheck.toLowerCase().equals("no")){
            System.exit(0);    
        }        

        // This will ask the customer what they would like to order from the menu.
        System.out.print("\nWhat would you like to order, then? -> ");

        String coffeeChoice = userInput.nextLine();
        while (!(coffeeChoice.equals("1") || coffeeChoice.equals("2") || coffeeChoice.equals("3") || coffeeChoice.toLowerCase().equals("cappuccino") || coffeeChoice.toLowerCase().equals("espresso") || coffeeChoice.toLowerCase().equals("latte"))){
            System.out.print("We only serve coffee on the menu. Choose from the menu. -> ");
            coffeeChoice = userInput.nextLine();
        }

        if (coffeeChoice.equals("1")){
            coffeeChoice = "cappuccino";
        }else if(coffeeChoice.equals("2")){
            coffeeChoice = "espresso";
        }else if(coffeeChoice.equals("3")){
            coffeeChoice = "latte";
        }
        // It asks for the number of coffee they want.
        System.out.print("\nHow many " + coffeeChoice + " do you need? -> ");
        int numOfCoffee = userInput.nextInt();
        while (numOfCoffee <= 0){
            System.out.print("\nYou have to order one or more! So, how many?-> ");
            numOfCoffee = userInput.nextInt();
        }
        userInput.nextLine();

        // This asks for the name of the customer.
        System.out.print("\nWhat is your name? -> ");
        String customerName = userInput.nextLine();

        // This part checks whether customer have membership of the cafe and gives discount if they have it.
        System.out.print("\nDo you have membership of this cafe? Type Yes or No-> ");
        String memberCheck = userInput.nextLine();

        while (!(memberCheck.toLowerCase().equals("yes") || memberCheck.toLowerCase().equals("no"))){
            System.out.print("\nWrong! Just type Yes or No ->");
            memberCheck = userInput.nextLine();
        }
        boolean isMember = false;
        if (memberCheck.toLowerCase().equals("yes")){
            isMember = true;
            System.out.println("You'll get 20% discount for your order!!");
        } 
        // Creating the customer1 object with the given parameters.
        CafeCustomer customer1 = new CafeCustomer(customerName, numOfCoffee, isMember, coffeeChoice);
        
        // Shows the total price of the coffee with the discount(if any).
        System.out.printf("\nYour total for %d %s is $%.2f.", numOfCoffee, coffeeChoice, customer1.calcTotal());

        // Asks for a tip to the customer.
        System.out.print("\n\nDo you want to give us a tip? If yes, type the amount, else put 0.-> ");
        double tip = userInput.nextDouble();
        while (tip < 0){
            System.out.print("\nYou can't give negative tip. So, try again.-> ");
            tip = userInput.nextDouble();
        }
        customer1.setTip(tip);

        // Calculates the final total cost of the coffees.
        double finalTotal = customer1.calcTotal() + tip;
        System.out.printf("\n\nSo, your final total is $%.2f.", finalTotal);      

        // Provides the bill to the customer.
        System.out.println("\n\n   Here's your bill!");
        System.out.println("   =================\n");
        System.out.println(customer1);

    }
}
