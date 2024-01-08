public class AlfursanAcc{

public static int numOfAccounts;
private int ID;
private String name;
private double miles;
private int points;
private char tire;

public AlfursanAcc(String name){
this.name = name;
miles = 0;
points = 0;
tire = 'S';
numOfAccounts++;
ID = numOfAccounts;
}

public void addMiles(double m){

if(m<0)
System.out.println("can't use negative miles");
else{
miles+=m;
points = points + (int)Math.ceil(miles/5);
updateTire();
}

}

public void updateTire(){
if(points<=1000)
tire = 'S';
else if(points<=5000)
tire = 'G';
else if (points>5000)
tire = 'P';

}

public void printInfo(){

System.out.printf("ID: %d - %s%n", ID, name.toUpperCase());
System.out.printf("M/P: %.2f / %d%n", miles, points);
System.out.println("Tire: " + (tire == 'S'? "Silver" : tire == 'G'? "Gold":"Platinum"));
if(tire == 'G' || tire == 'P')
System.out.println("priority boarding");
System.out.println("------------------");
}

public void setMiles( int m){
miles = m;
}
public void setTire(char ch){
tire = ch;
}
public void setPoints(int p){
points = p;
}

public int getPoints(){
return points;
}
public int getID(){
return ID;
}
public double getMiles(){
return miles;
}
public String getName(){
return name;
}
public String getTire(){
if (tire == 'S')
return "Silver";
else if (tire == 'G')
return "Gold";
else if (tire == 'P')
return "Platinum";
return "";
}

}