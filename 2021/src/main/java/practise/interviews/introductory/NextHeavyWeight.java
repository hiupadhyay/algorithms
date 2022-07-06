package practise.interviews.introductory;

import java.util.*;

public class NextHeavyWeight {

    private Test t;

    public NextHeavyWeight(Test t) {
        this.t = t;
    }


    void display() {
        t.test = new HashMap<>();
        print();
    }

    void print() {
        System.out.println(t.test);
    }

    public static void main(String[] args) {
        NextHeavyWeight nextHeavyWeight = new NextHeavyWeight(new Test());
        nextHeavyWeight.display();
    }
}

class Test {

    public Map<String, String> test;

}



