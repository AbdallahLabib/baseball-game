import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (String s : ops) {
            if (s == "C") {
                total -= stack.pop();
            } else if (s == "D") {
                stack.push(2 * stack.peek());
                total += stack.peek();
            } else if (s == "+") {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
                total += newScore;
            } else {
                int val = Integer.valueOf(s);
                stack.push(val);
                total += val;
            }
        }

        return total;

    }
}
