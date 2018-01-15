/**
 * @author liming
 * @date 2018-01-12 11:46
 */
public class Client {

    public static void main(String[] args) {
        SuperClass sc = new SubClass();
//        Object obj = sc.get("obj");
//        Object o = sc.get(new Object());
//        String s = (String) new Object();
        SuperClass<String> s = new SubClass();
    }
}
