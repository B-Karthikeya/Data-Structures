public class InfixToPostfix {
    public class Stack{
        int top;
        char[] arr;
        int size;

        Stack(int n){
            this.top = -1;
            this.arr = new char[n];
            this.size = n;
        }
        public boolean isFull(){
            return top == size-1;
        }
        public boolean isEmpty(){
            return top == -1;
        }

        public void push(char ch){
            if(isFull()) System.out.println("Stack overflow");

            else {
                top++;
                arr[top] = ch;
            }

        }

        public char pop(){
            
                char k = arr[top];
                top--;
                return k;
            

        }
        public char peek(){
            
                
                return arr[top];
    
        }
    }

    public int prec(char ch){
        if(ch == '+' || ch == '-') return 1;
        else if ( ch == '*' || ch == '/') return 2;
        else return 0;
    }
    public boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/') return true;
        else return false;
    }

    public String InfToPost(String str){
        char[] exp = str.toCharArray();
        Stack st = new Stack(exp.length);
        String res = "";
        for(int i =0;i<exp.length;i++)
        {
            if(!isOperator(exp[i])) res+=exp[i];
            else{
                if(st.isEmpty()) st.push(exp[i]);
                else if(prec(exp[i])>prec(st.peek())) st.push(exp[i]);
                else {
                    while(!st.isEmpty()   ) {
                        if(prec(exp[i])<=prec(st.peek())) res += st.pop();
                        else break;
                    }
                    st.push(exp[i]);
                    
                    
                }
            }
        }
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }

    public static void main(String[] args){
        InfixToPostfix obj = new InfixToPostfix();
        String exp = "a/b/c+d*e/f+g-h";
        System.out.println("postfix expression :" + obj.InfToPost(exp));
    }

}
