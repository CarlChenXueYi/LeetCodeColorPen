package IO;

import java.io.ObjectOutputStream;

public class IOModel {
    public static void main(String[] args) {
//        BIO （Blocking I/O）：同步阻塞I/O模式，数据的读取写入必须阻塞在一个线程内等待其完成。这里假设一个烧开水的场景，
//        有一排水壶在烧开水，BIO的工作模式就是， 叫一个线程停留在一个水壶那，直到这个水壶烧开，才去处理下一个水壶。但是实际上
//    线程在等待水壶烧开的时间段什么都没有做。
//
//        NIO （New I/O）：同时支持阻塞与非阻塞模式，但这里我们以其同步非阻塞I/O模式来说明，那么什么叫做同步非阻塞？如
//    果还拿烧开水来说，NIO的做法是叫一个线程不断地轮询每个水壶的状态，看看是否有水壶的状态发生了改变，从而进行下一步的操作。
//
//        AIO （ Asynchronous I/O）：异步非阻塞I/O模型。异步非阻塞与同步非阻塞的区别在哪里？异步非阻塞无需一个线程
//    去轮询所有IO操作的状态改变，在相应的状态改变后，系统会通知对应的线程来处理。对应到烧开水中就是，为每个水壶上面装了一
//    个开关，水烧开之后，水壶会自动通知我水烧开了。

    }

    public static void BIO() {
        User user = new User();
        user.age = 23;
        user.name = "cxy";
        System.out.println(user);

//        Write to file
        ObjectOutputStream objectOutputStream = null;
    }
}

class User {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }
}
