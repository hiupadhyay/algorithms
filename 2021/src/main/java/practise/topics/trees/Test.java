package practise.topics.trees;

public class Test {

    public static  String getKey(String viewId) {
        // Strip off the "/" and the ".jsp" from the viewId.
        StringBuffer key = new StringBuffer();
        key.append(viewId.substring(1, 2).toLowerCase());
        key.append(viewId, 2, viewId.indexOf("."));
        return key.toString();
    }

    public static void main(String[] args) {
        System.out.println(Test.getKey("/test.xhtml"));

    }
}
