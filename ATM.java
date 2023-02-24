import java.util.*;
class AtmInterface{
    int userPin,userId;
    ArrayList<String> data=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    int amount,money=0;
    AtmInterface(int id,int pin){
        userId=id;
        userPin=pin;
        amount=10000;
    }
    public void TransactionHistory(){
        if(data.size()==0){
            System.out.println("Sorry,,,,No Transactions are done yet");
        }
        else{
            System.out.println("Here are your transactions......");
            for(int i=0;i<data.size();i++){
                System.out.println(data.get(i));
            }
        }
        System.out.println();
    }
    public void Withdraw(){
        System.out.println("Enter amount:");
        money=sc.nextInt();
        if(money<=amount){
            amount-=money;
           data.add(money*(1.0)+" is withdrawn from your account "+userId);
            System.out.println("amount Withdrawn successfully!!!");
            System.out.println("Your Current Balance in your account is "+amount*(1.0));
        }
        else{
            System.out.println("Sorry,,,,you didn't have enough money in your account..");
        }
        System.out.println();
    }
    public void Deposit(){
        System.out.println("Enter amount");
        money=sc.nextInt();
        amount+=money;
       data.add(money+" is deposited to your account "+userId);
        System.out.println("Your Current Balance is "+amount*(1.0));
        System.out.println();
    }
    public void Transfer(){
        System.out.println("Enter account id  to transfer");
        int account_id=sc.nextInt();
        System.out.println("Enter cash you want to transfer");
        money=sc.nextInt();
        if(money<=amount){
        amount-=money;
       data.add(money+" is transfered to the account "+account_id);
        System.out.println( +money*(1.0)+" is successfully transfered to the account "+account_id);
        System.out.println("Your Current Balance is "+amount);}
        else{
             System.out.println("Sorry,,,,you didn't have enough money in your account..");
        }
        System.out.println();
    }
    public void Quit(){
        System.out.println("You can remove your card");
        System.out.println();
    }
}
class ATM{
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         System.out.println("Welcome to Automatic Teller Machine service");
         System.out.println("Please enter your user id");
         int id=sc.nextInt();
         System.out.println("Please don't remove your card while processing!!!!");
         System.out.println("Please enter your pin");
         int pin=sc.nextInt();
         AtmInterface atm=new AtmInterface(id,pin);
         int ch=0;
         do{
         System.out.println("Please kindly select your option:");
         System.out.println("1.Transaction History");
         System.out.println("2.Withdraw");
         System.out.println("3.Deposit");
         System.out.println("4.Transfer");
         System.out.println("5.Quit");
         System.out.println();
         System.out.println("Please enter your choice:");
         ch=sc.nextInt();
         switch(ch){
            case 1: atm.TransactionHistory();
                    break;
            case 2: atm.Withdraw();
                    break;
            case 3: atm.Deposit();
                    break;
            case 4: atm.Transfer();
                    break;
            case 5: atm.Quit();
                    break;
            default:System.out.println("Select valid option");
                    break;
         }
         }while(ch!=5);
         System.out.println("Thank You....Come again next time!!!!");
    }
}