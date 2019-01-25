import BeaStackQueue.Stack;

/*
method to parse math expressions
the shunting yard algo is stack based (one stack for numbs one for the operators
operator-precedence parsing
intuition->can read source code line by line and process it accordingly
 */
public class DijkstraInterpreter {
    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public DijkstraInterpreter() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpreterExpression(String expression) {
        String[] expressionArr = expression.split(" ");
        for (String s : expressionArr) {
            if (s.equals("(")) {
                //do nothing
            } else if (s.equals("+")) {
                this.operationStack.push(s);
            } else if (s.equals("*")) {
                this.operationStack.push(s);
            } else if (s.equals(")")) {
                String operation = this.operationStack.pop();

                if (operation.equals("+")) {
                    this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
                } else if (operation.equals("*")) {
                    this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
                }
            } else {
                this.valueStack.push(Double.parseDouble(s));
            }
        }
    }

    public void result() {
        System.out.println(this.valueStack.pop());
    }

}
