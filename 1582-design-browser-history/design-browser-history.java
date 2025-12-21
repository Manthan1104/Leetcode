

 public class Node {
    String data;
    Node next;
    Node back;

    // Default constructor
    Node() {
        this.data = "";
        this.next = null;
        this.back = null;
    }

    // Constructor with data
    Node(String data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    // Constructor with data, next, and back
    Node(String data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}



class BrowserHistory {
    Node curr=null;

    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode=new Node(url);
        newNode.back = curr;

    // clear forward history
    curr.next = null;
        curr.next=newNode;
        curr=newNode;

    }
    
    public String back(int steps) {
        while(steps>0){
            if(curr.back!=null){
                curr=curr.back;
            }else break;
            steps--;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while(steps>0){
            if(curr.next!=null){
                curr=curr.next;
            }else break;
            steps--;
        }
        return curr.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */