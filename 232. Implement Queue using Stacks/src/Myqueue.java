class MyQueue {
    Stack<Integer> one;
    Stack<Integer> two;

    public MyQueue() {
        one = new Stack<>();
        two = new Stack<>();

    }

    public void push(int x) {
        while (!two.isEmpty()) {
            one.add(two.pop());
        }
        one.add(x);
    }

    public int pop() {
        while (!one.isEmpty()) {
            two.add(one.pop());
        }
        return two.pop();
    }

    public int peek() {
        while(!one.isEmpty()) {
            two.add(one.pop());
        }
        return two.peek();
    }

    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */