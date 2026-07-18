class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack = new Stack<>();
        Stack<StringBuilder>stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                number=number*10+(c-'0');
            }
            else if(c=='['){
                countstack.push(number);
                stringStack.push(current);

                current = new StringBuilder();
                number = 0;
            }
            else if(c==']'){
                int repeat=countstack.pop();
                StringBuilder previous = stringStack.pop();

                for(int i=0;i<repeat;i++){
                    previous.append(current);
                }
                current=previous;
            }
            else{
                current.append(c);
            }
        }
        return current.toString();
    }
}