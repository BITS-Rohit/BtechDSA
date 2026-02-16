import java.util.Stack;

class Exam {

    static class linkedlist{
        int data;
        linkedlist next;

        linkedlist(int data){
            this.data=data;
            this.next = null;
        }
    }

    //Implementation of Stack using a linked list
    static class StacksLL{
        linkedlist top = null;

        void push(int data){
            if (top==null)top = new linkedlist(data);
            else {
                linkedlist t = new linkedlist(data);
                t.next=top;
                top=t;
            }
        }

        int peek(){
            if ( top==null) return -1; // for this we are printing -1
            else return top.data;
        }

        int pop(){
            if(top==null)return -1;
            int data = top.data;
            top=top.next;
            return data;
        }

        //Application of stack: infix, Prefix and Postfix
        //infix to prefix
        String in_to_postfix(String s){
            Stack<Character> stacks = new Stack<>();
            String str = new StringBuilder(s).reverse().toString();
            StringBuilder out = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(Character.isLetterOrDigit(ch))out.append(ch);
                else if (ch==')')stacks.push(ch);
                else if (ch=='('){
                    while(!stacks.isEmpty() && stacks.peek()!=')')out.append(stacks.pop());
                    stacks.pop(); // Removing ')'
                }
                else {
                    while(!stacks.isEmpty() && pre(stacks.peek())>=pre(ch))out.append(stacks.pop());
                    stacks.push(ch);
                }
            }
            return out.toString();
        }

        String in_to_pre(String s){
            return new StringBuilder(in_to_postfix(s)).reverse().toString();
        }

        String pre_to_post(String  s){ // means given String is already a prefix, so we just need to reverse it
            return new StringBuilder(s).reverse().toString();
        }

        String post_to_pre(String  s){ // means given String is already a postfix, so we just need to reverse it
            return new StringBuilder(s).reverse().toString();
        }

        private int pre(char ch) {
            if ( ch=='+' || ch=='-' )return 1;
            return 2;
        }
    }
}
