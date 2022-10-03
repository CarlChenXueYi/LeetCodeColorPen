package Threadthread;

public class daemon {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(t1.isDaemon());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());
        t1.start();
        t1.setDaemon(false);

    }
}
