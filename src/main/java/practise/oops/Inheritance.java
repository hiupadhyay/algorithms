package practise.oops;

import java.util.Map;

public class Inheritance {

    public static void main(String[] args) {
    }
}

class Model {

    public void prize() {
        System.out.println("Prize of old Model");
    }
}

class GenerationOne extends Model {

    public void prize() {
        System.out.println("Prize of new Model");

    }

}