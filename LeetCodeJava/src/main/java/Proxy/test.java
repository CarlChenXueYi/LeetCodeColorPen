package Proxy;

public class test {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
        proxy.eat();
    }
}
