public class StaticEx {
    static int x = 10;
    static final int NUMBER_OF_STUDENTS = 12;//constant
    
    public static void main(String[] args) {
        x = 15;
        
        display();
        
        StaticEx.display();
        
        StaticEx s = new StaticEx();
        s.display2();
}
    
    public static int display(){
    return 10;
    }
    
     public void display2(){
         System.out.println("Hi");
    }
}
