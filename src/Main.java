public class Main {
    public void fun(Object o){
        System.out.println("char fun");
    }

    public void fun(CharSequence ch){
        System.out.println("CharSequence fun");
    }

    public static void main(String[] args) {

        Main m = new Main();
        m.fun("H");
    }
}