public class Stack {
    private int maxSize;      
    private int top;          
    private int[] data;        

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.top = -1;         
        this.data = new int[maxSize]; 
    }

    // Push operation: Add an element to the top of the stack
    public void push(int element) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            data[++top] = element;  
        }
    }

    // Pop operation: Remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;             
        } else {
            return data[top--];    
        }
    }

    // Peek operation: View the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;         
        } else {
            return data[top];     
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);       
    }

    // Main method for testing the stack
    public static void main(String[] args) {
        Stack stack = new Stack(5); 

        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element is: " + stack.peek()); 
        System.out.println("Removed element: " + stack.pop()); 
        System.out.println("Top element is: " + stack.peek()); 
        System.out.println("Is stack empty? " + stack.isEmpty()); 
    }
}
