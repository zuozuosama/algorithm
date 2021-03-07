package leetcode;


import java.util.Stack;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
public class BrowserHistory {

    private Stack<String> backAndCur;
    private Stack<String> forward;

    public BrowserHistory(String homepage) {
        backAndCur = new Stack<>();
        forward = new Stack<>();
        backAndCur.push(homepage);
    }

    public void visit(String url) {
        backAndCur.push(url);
        forward.clear();
    }

    public String back(int steps) {
        for (; steps > 0 && backAndCur.size() > 1; steps--) {
            String cur = backAndCur.pop();
            forward.push(cur);
        }
        System.out.println(backAndCur.peek());
        return backAndCur.peek();
    }

    public String forward(int steps) {
        for (; steps > 0 && !forward.isEmpty(); steps--) {
            String fw = forward.pop();
            backAndCur.push(fw);
        }
        System.out.println(backAndCur.peek());
        return backAndCur.peek();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}

