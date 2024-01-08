import java.util.*;
public class AlfursanTest{

static Scanner input = new Scanner(System.in);

public static void main(String[] args){

System.out.println("enter first customer name");
String name = input.nextLine();

AlfursanAcc obj1 = new AlfursanAcc(name);
AlfursanAcc obj2 = new AlfursanAcc("Ahmed Fahad");
AlfursanAcc obj3 = new AlfursanAcc("Manal omar");
obj1.addMiles(55000);
obj2.addMiles(1000);
obj3.addMiles(6000);

System.out.println("the number of accounts created: " + AlfursanAcc.numOfAccounts);
obj1.printInfo();
obj2.printInfo();
obj3.printInfo();

if(transferPoints(obj2, obj3, 50)){
System.out.println("## tranfere Done ##");
obj2.printInfo();
obj3.printInfo();
}
else{
System.out.println("## transfere failed ##");
System.out.println("*********************************");
}

if(transferPoints(obj1, obj2 , 2000)){
System.out.println("## tranfere Done ##");
obj1.printInfo();
obj2.printInfo();
}
else{
System.out.println("## transfere failed ##");
System.out.println("*********************************");
}

String tireBefore = obj3.getTire();

obj3.addMiles(50000);
if(tireIncreased(tireBefore.charAt(0) , obj3.getTire().charAt(0))){
System.out.println("the tire of customer #"+obj3.getID()+ " has increased");
obj3.printInfo();
}
else
System.out.println("the tire of customer #" + obj3.getID() +"didn't increase");


System.out.println("enter number of trips");
int tripNo = input.nextInt();
for(int i = 1; i<=tripNo;i++){
System.out.println("enter miles for trip number" + i);
double miles = input.nextDouble();
obj2.addMiles(miles);
}
obj2.printInfo();
}

public static boolean transferPoints( AlfursanAcc giver, AlfursanAcc receiver, double points){

boolean canTransefer = false;

if (giver.getPoints()>=points && points>0 && (giver.getTire().equals("Gold") || giver.getTire().equals("Platinum"))){
canTransefer = true;
giver.setPoints(giver.getPoints() - (int)points);
receiver.setPoints(receiver.getPoints() + (int)points);
giver.updateTire();
receiver.updateTire();
}
return canTransefer;
}

public static boolean tireIncreased(char before , char after){
boolean afterHigher = false;

if(after == 'P' && before != 'P')
afterHigher = true;
else if(before == 'S' && after == 'G')
afterHigher = true;

return afterHigher;

}



}