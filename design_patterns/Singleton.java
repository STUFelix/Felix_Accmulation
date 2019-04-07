/*
  双检锁/双重校验锁（DCL，即 double-checked locking）
*/
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/*----------------------------------------------------*/


/*
这种方式能达到双检锁方式一样的功效，但实现更简单。
对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
*/
public class Singleton(){
    private Singleton();
    
    private static class SingletonInstance(){
        private static Singleton INSTANCE = new Singleton();
    }
    
    private static Singleton getInstance()[
        return Singleton.INSTANCE;
    }
}

/*----------------------------------------------------*/

/*
描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。
不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
不能通过 reflection attack 来调用私有构造方法。
*/

public enum Singleton {  
    INSTANCE;  
    public void whateverMethod() {  
    }  
}

