package eight;
import java.util.ArrayList;
import java.util.List;
public class ListAdd2 {



    /**
     * 重点说明：
     * 1.实例化一个lock,使用wait和notify的时候一定要配合synchronized关键字去使用
     * 2.lock.wait(); 等待，并且释放锁
     * 3.lock.notify(); 唤醒，不释放锁
     */

        private volatile static List list = new ArrayList();

        public void add() {
            list.add("bjsxt");
        }

        public int size() {
            return list.size();
        }

        public static void main(String[] args) {
            final ListAdd2 list2 = new ListAdd2();
//实例化一个lock,使用wait和notify的时候一定要配合synchronized关键字去使用
            final Object lock = new Object();

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        synchronized (lock) {
                            for (int i = 0; i < 10; i++) {
                                list2.add();
                                System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素");
                                Thread.sleep(500);
                                if (list2.size() == 5) {
                                    System.out.println("size==5，已发出通知");
//线程唤醒，但是并不释放锁， 所以，等t1线程执行完毕， t2线程才能得到锁，继续执行
                                    lock.notify();
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "t1");
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    synchronized (lock) {
                        if (list2.size() != 5) {
                            try {
//线程等待，并且释放锁
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + "list.size==5线程停止");
                        throw new RuntimeException();//抛出运行时异常
                    }
                }
            }, "t2");
//t2先执行，等待，释放锁
            t2.start();
//t1在t2释放锁后执行，当list.size==5时唤醒t2线程，但是这个时候并没有释放锁，
//所以t2必须等t1执行完毕后才能得到锁，继续执行
            t1.start();
        }
}
