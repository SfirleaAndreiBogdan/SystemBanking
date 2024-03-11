import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bk = new BankingSystem("John Steph",1);
        bk.showMenu();
    }
}

class BankingSystem{

    private boolean activate=false;
    private int pin=0;
     double balance=0.0;
    private String customerName;
    private int customerId;

     int lastTransaction;

    public BankingSystem(String customerName,int customerId) {
        this.customerId=customerId;
        this.customerName = customerName;
    }
    public void showMenu() throws InterruptedException {

        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Bank " + customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println("======================");
        System.out.println("1:Check Balance");
        System.out.println("2:Deposit");
        System.out.println("3:Withdraw");
        System.out.println("4:Last Transaction");
        System.out.println("5:Change PIN");
        System.out.println("6:Activate your Card");
        System.out.println("7:Exit");
        System.out.println("======================");

        System.out.print("Choose the operation you want to make: ");
        option = scanner.nextInt();
        System.out.println();
        do{
        switch (option) {
            case 1:
                System.out.println("======================");
                showBalance();
                System.out.println("======================");
                System.out.println();
                break;
            case 2:
                System.out.print("How much do you want to deposit?:");
                int money = scanner.nextInt();
                System.out.println();
                System.out.println("======================");
                calculateBalance(money);
                System.out.println("======================");
                System.out.println();
                break;
            case 3:
                System.out.print("enter the amount you want to withdraw: ");
                int amount = scanner.nextInt();
                System.out.println();
                System.out.println("======================");
                withdraw(amount);
                System.out.println("======================");
                System.out.println();
                break;
            case 4:
                System.out.println("======================");
                getPrevTransaction();
                System.out.println("======================");
                System.out.println();
                break;
            case 5:
                System.out.println("======================");
                changePin();
                System.out.println("======================");
                System.out.println();
                break;
            case 6:
                if (activate){
                    System.out.println("Your card is already activated.");
                    break;}
                activateCard();
                System.out.println();
                break;
            case 7:
                System.out.println("======================");
                exit();
                System.out.println("======================");
                break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
            System.out.print("Choose the next operation you want to make: ");
            option = scanner.nextInt();
        }while (option>=1 && option<=8);
    }

    public void showBalance(){
        System.out.println("Balance:" + balance);
    }
    public void calculateBalance(int amount){
        if (amount!=0){
            balance=balance+amount;
            lastTransaction=amount;
        }
        System.out.println("Your balance is:"+ balance);
    }
    public void withdraw(int amount){
        if (amount!=0 && balance>=amount){
            balance=balance-amount;
            lastTransaction=-amount;
        }else if(amount>balance){
            System.out.println("Insufficient founds.");
        }
        System.out.println("Balance:"+ balance);
    }
    public void getPrevTransaction(){
        if (lastTransaction>0){
            System.out.println("Balance:"+ lastTransaction);
        }else if (lastTransaction<0){
            System.out.println("Withdrawn:"+ Math.abs(lastTransaction));
        }else {
            System.out.println("No transaction is ocurred.");
        }
    }
    public void activateCard() throws InterruptedException {
        System.out.println("======================");
        System.out.println("Activating..");
        System.out.println("======================");
        Thread.sleep(1000);
        System.out.println("=============================");
        System.out.println("Your card has been activated.");
        System.out.println("=============================");
        activate=true;
    }
    public void changePin(){
        Scanner scanner = new Scanner(System.in);

        if(pin==0){System.out.println("Current PIN: 0000");
        }else {
            System.out.println("Current PIN:"+ pin);
        }
        System.out.println("======================");

        System.out.print("Enter your new PIN:");

        pin =scanner.nextInt();
        System.out.println("======================");
        System.out.println("Your new pin is:" + pin);
    }
    public void exit(){
        System.out.println("Exit..");
        System.out.println("======================");
        System.exit(0);
    }
}


