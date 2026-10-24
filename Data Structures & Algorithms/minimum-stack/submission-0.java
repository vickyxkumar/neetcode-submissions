class MinStack {

    Stack<Integer> st;
    PriorityQueue<Integer> pq;
    public MinStack() {
        st = new Stack<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        st.push(val);
        pq.add(val);
    }
    
    public void pop() {
        int val  = st.pop();
        pq.remove(val);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}
