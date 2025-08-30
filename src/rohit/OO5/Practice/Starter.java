package rohit.OO5.Practice;

import java.util.ArrayList;
import java.util.List;

// Basic Ones //
class Car{
    private final int MakeCost;
    private final String Model;
    private final String Date;

    Car(int cost , String model, String year){
        this.MakeCost=cost;
        this.Model=model;
        this.Date=year;
    }

    void DetailShow(){
        System.out.println("\nModel name: "+Model);
        System.out.printf("%s Cost: %d\n",Model,MakeCost);
        System.out.printf("%s Year: %s\n",Model,Date);
    }
}


class Animal{
    void MakeSound(){
        System.out.println("Animals Sound");
    }
}
class Dog extends Animal{
    @Override
    void MakeSound(){
        System.out.println("This is Dog Sound");
    }
}
class Cat extends Animal{
    @Override
    void MakeSound(){
        System.out.println("This is Cat sound");
    }
}


class Bank{
    private int AccNumber;
    private int Balance;

    Bank(int AccNum, int Amount){
        this.AccNumber=AccNum;
        this.Balance=Amount;
    }

    void getAC(){
        System.out.println("Account Number: "+AccNumber);
    }

    void getBAL(){
        System.out.println("Balance of "+AccNumber+" is: "+Balance);
    }

    void setAC(int newAC){
        AccNumber=newAC;
        System.out.println("Success");
    }

    void Deposit(int amount){
        Balance+=amount;
    }

    void Withdraw(int amount){
        if (Balance>amount) System.out.println("Insfficient Amount");
        else {
            Balance-=amount;
            System.out.println("Success");
        }
    }
}


abstract class Shapes{
    abstract void area();
}
class Circle extends Shapes{

    @Override
    void area() {
        int radius = 23;
        System.out.println("Circle Area: "+CircleArea(radius));
    }

    private int CircleArea(int radius) {
        return (int) (Math.PI*(radius*radius));
    }
}
class Rectangle extends Shapes{

    @Override
    void area() {
        int x = 5;
        int y = 10;
        System.out.println("Rectangle Area: "+RectangleArea(x,y));
    }

    private int RectangleArea(int x, int y) {
        return x*y;
    }
}

// Intermediate Ones //
class Person{
    private final String NameData;
    private final int AgeData;

    Person(String namae , int NenSai){
        this.NameData=namae;
        this.AgeData=NenSai;
    }
    void DataShow(Address address){
        System.out.println("Name: "+NameData);
        System.out.println("AgeData: "+AgeData);
        System.out.println("Address{city}: "+address.getCity());
        System.out.println("Address{zipcode}: "+address.getZipCode());
        System.out.println("Address{Street}: "+address.getStreet());
    }
}
class Address{
    private final String Street;
    private final int ZipCode;
    private final String City;

    Address(String street,int code , String city){
        this.Street=street;
        this.ZipCode=code;
        this.City=city;
    }
    String getStreet(){
        return Street;
    }
    int getZipCode(){
        return ZipCode;
    }
    String getCity(){
        return City;
    }
}


class Library{
    private final List<Book> Books;
    Library(){
        this.Books=new ArrayList<>();
    }
    void AddBook(Book book){
        Books.add(book);
    }
    void ShowBooks(){
        for(Book start: Books){
            System.out.println(start);
        }
    }
    void SearchBook(String title){
        Book foundBook = null;
        for(Book eachBook : Books){
            if (eachBook.getTitle().equals(title)){
                foundBook=eachBook;
                break;
            }
        }
        if (foundBook==null) System.out.println("Book not Found");
        else BookDetail(foundBook);

    }
    void BookDetail(Book book){
        System.out.println("Title: "+book.getTitle());
        System.out.println("Author: "+book.getAuthor());
        System.out.println("ISBN: "+book.getISBN());
    }
}
class Book{
    private final String TitleData;
    private final String BookAuthor;
    private final int ISBN;
    Book(String title , String owner , int id){
        this.TitleData=title;
        this.BookAuthor=owner;
        this.ISBN=id;
    }
    String getTitle(){
        return TitleData;
    }
    String getAuthor(){
        return BookAuthor;
    }
    int getISBN(){
        return ISBN;
    }
}


interface FLyabke {
    void Fly();
}
class Bird implements FLyabke{

    @Override
    public void Fly() {
        System.out.println("I am A Bird , I can fly");
    }
}
class Airplane implements FLyabke{

    @Override
    public void Fly() {
        System.out.println("I am a Airplane , I can fly too");
    }
}


class InvalidAgeException extends Exception{
    void CusExcep(){
        System.out.println("Exception Chan came , o namaye wa InvalidAgeException desu");
    }
}
class newPerson extends InvalidAgeException{
    private int Age;

    void setAge(int age ) throws InvalidAgeException{
        this.Age=age;
    }
}

// Advanced //
class SingleDataBaseConnection{
    private  static SingleDataBaseConnection connection = null;
    private SingleDataBaseConnection(){}

    static SingleDataBaseConnection getInstance(){
        if (connection==null)connection=new SingleDataBaseConnection();
        return connection;
    }
}


//Implement an Abstract Factory pattern
// with an interface GUIFactory and
// concrete factories WindowsFactory and MacFactory.
// Define product interfaces, Button and TextField, and
// concrete products for each platform.
// Demonstrate creating GUI components using the abstract factory.
interface Button{
    void render();
    void AdvanceRender();
}
interface TextField{
    void render();
}
class WindowsB implements Button{
    @Override
    public void render() {

    }
    @Override
    public void AdvanceRender() {

    }
}
class WindowsT implements TextField{
    @Override
    public void render() {

    }
}
class MacB implements Button{
    @Override
    public void render() {

    }
    @Override
    public void AdvanceRender() {

    }
}
class MacT implements TextField{
    @Override
    public void render() {

    }
}
interface GUIFactory{
    Button Button();
    TextField TextField();
}
class WindowsFactory implements GUIFactory{
    @Override
    public Button Button() {
        return null;
    }

    @Override
    public TextField TextField() {
        return null;
    }
}
class LinuxFactory implements GUIFactory{
    @Override
    public Button Button() {
        return null;
    }

    @Override
    public TextField TextField() {
        return null;
    }
}
class MacFactory implements GUIFactory{
    @Override
    public Button Button() {
        return null;
    }

    @Override
    public TextField TextField() {
        return null;
    }
}


interface MilkDecorator{
    void DecorUP();
    void DecorDOWN();
}
interface SugarDecorator{
    void SugarHigh();
    void SugarLow();
}
class MilkD implements MilkDecorator{
    @Override
    public void DecorUP() {
        System.out.println("Decor Up of Milk");
    }

    @Override
    public void DecorDOWN() {
        System.out.println("Deccor Down of Milk");
    }
}
class SugarD implements SugarDecorator{

    @Override
    public void SugarHigh() {
        System.out.println("Sugar is High ");
    }

    @Override
    public void SugarLow() {
        System.out.println("Sugar is Low");
    }
}
interface Decorater{
    MilkDecorator FancyMilk();
    SugarDecorator SugarControl();
}
class Coffe implements Decorater{
    @Override
    public MilkDecorator FancyMilk() {
        System.out.println("Normal Coffie Milk amount is ok");
        return new MilkD();
    }

    @Override
    public SugarDecorator SugarControl() {
        System.out.println("Normal COffie sugar is ok");
        return new SugarD();
    }
}
class MarshMelloCOffie implements Decorater{
    @Override
    public MilkDecorator FancyMilk() {
        System.out.println("MarshMellow Coffie Milk amount is ok");
        return new MilkD();
    }

    @Override
    public SugarDecorator SugarControl() {
        System.out.println("MarshMellow COffie sugar is ok");
        return new SugarD();
    }
}
class DarzillingCoffie implements Decorater{
    @Override
    public MilkDecorator FancyMilk() {
        System.out.println("Darzilling Coffie Milk amount is ok");
        return new MilkD();
    }

    @Override
    public SugarDecorator SugarControl() {
        System.out.println("Darzilling COffie sugar is ok");
        return new SugarD();
    }
}


class LegacySystem{
    void proccessData(){
        System.out.println("Data in process Data in LegacySystem");
    }
}
interface DataProcessor{
    void process();
}
class Adapter implements DataProcessor {
    private LegacySystem LS;
    Adapter(LegacySystem ls){
        this.LS=ls;
    }
    @Override
    public void process() {
        LS.proccessData();
    }
}


interface Observer{
    void Checker();
}
class ReactSub1 implements Observer{
    private Subject sub;
    ReactSub1(Subject s){
        sub=s;
    }
    @Override
    public void Checker() {
        while(sub.getChange()) {
            System.out.println("Change detected");
        }
    }
}
class Subject{
    private boolean Change;
    Subject(boolean bool){
        this.Change=bool;
    }
    void setChange(boolean bool){
        this.Change=bool;
    }
    boolean getChange() {
        return Change;
    }
}


class ShowOutPut{
    public static void main(String[] args) {

        Car mycar = new Car(2100000,"Thar","2017");
        mycar.DetailShow();

        // if this printing shows polymorphism,
        // then I have demonstreated here if this is
        //not polynmorphism than correct me, please
        System.out.println();
        Dog d = new Dog();
        Cat c = new Cat();
        d.MakeSound();
        c.MakeSound();

        //Abstraction Implementation
        System.out.println();
        Circle C= new Circle();
        Rectangle R = new Rectangle();
        C.area();
        R.area();

        //Composition Implementation
        System.out.println();
        Person p = new Person("Rohit",20);
        Address a = new Address("15A",110032,"Delhi");
        p.DataShow(a);

        //Aggreagtion Implementation
        System.out.println();
        Library lib = new Library();
        Book Maths  = new Book("Mathmatics","RD Sharma",3422);
        Book Physics = new Book("Physics", "HC Verma", 1234);
        Book Chemistry = new Book("Chemistry", "OP Tandon", 5678);
        Book Biology = new Book("Biology", "Pradeep", 9101);
        Book English = new Book("English", "Wren & Martin", 1121);

        lib.AddBook(Maths);
        lib.AddBook(Physics);
        lib.AddBook(Chemistry);
        lib.AddBook(Biology);
        lib.AddBook(English);
        lib.SearchBook(Maths.getTitle());

        //Interfaces Implementation
        System.out.println();
        Bird b = new Bird();
        Airplane A = new Airplane();
        b.Fly();
        A.Fly();

        //Exception Handling with Oops Implementation
        //Although I am a bit doubted about this implementation, so correct me if I am wrong
        System.out.println();
        newPerson ps = new newPerson();
        try{
            ps.setAge(34);
        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }
        finally {
            ps.CusExcep();
        }

        //Design Pattern
        System.out.println();
        SingleDataBaseConnection SingleConnection = SingleDataBaseConnection.getInstance();

        //Here on if u find any error, ya do tell me and correct me

        //Abstract Factory Pattern
        System.out.println();
        GUIFactory wini = new WindowsFactory();
        GUIFactory lini = new LinuxFactory();
        GUIFactory maci = new MacFactory();

        //Decorator Factpry Implementation
        System.out.println();
        Coffe coffe= new Coffe();
        MilkDecorator md = coffe.FancyMilk();
        SugarDecorator sd = coffe.SugarControl();

        MarshMelloCOffie mc  = new MarshMelloCOffie();
        MilkDecorator Mmilk = mc.FancyMilk();
        SugarDecorator Msugar = mc.SugarControl();

        System.out.println(coffe.FancyMilk());
        System.out.println(coffe.SugarControl());
        System.out.println(mc.FancyMilk());
        System.out.println(mc.SugarControl());

        //Observer Pattern
        Subject sub = new Subject(false);
        ReactSub1 rs = new ReactSub1(sub);
        rs.Checker();
        System.out.println("nothing is done");
        sub.setChange(true);
        rs.Checker();
    }
}

