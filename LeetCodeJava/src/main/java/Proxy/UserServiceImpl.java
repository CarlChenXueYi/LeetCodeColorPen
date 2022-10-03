package Proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("------add------------");
    }

    @Override
    public void eat() {
        System.out.println("--------eat----------");
    }
}
