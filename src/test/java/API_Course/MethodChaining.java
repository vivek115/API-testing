package API_Course;

public class MethodChaining {
    public static MethodChaining a1(){
        System.out.println("this is a1 method");
        return new MethodChaining();
    }
    public  MethodChaining a2(){
        System.out.println("this is a2 method");
        return new MethodChaining();
    }
    public  MethodChaining a3(){
        System.out.println("this is a3 method");
        return new MethodChaining();
    }
    public static void main(String[] args){
       // MethodChaining methodchaining = new MethodChaining();
        //methodchaining.a1().a2().a3();
        a1().a2().a3();
    }
}
