public class Hello {
    public static void main(String[] args){
        System.out.println("Hello");

        new Thread(()->hey()).start();
    }



    public static void hey(){
        System.out.println("hey");
    }
}
