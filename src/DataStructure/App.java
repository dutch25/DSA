package DataStructure;
import Algorithm.*;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("gt:" + Calculate.gt(10));
        // System.out.println("sum:" + Calculate.sum(10));
        // System.out.println("fibo:" + Calculate.fibo(10));
        MyTree myTree = new MyTree();
        myTree.print(myTree.root);
    }
}
