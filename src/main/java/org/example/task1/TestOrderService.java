package org.example.task1;

public class TestOrderService {
    public static void main(String[] args) throws InterruptedException {
        OrderSevice orderSevice = new OrderSevice();

        Runnable task = ()->{
            Object obj="";
            synchronized (obj){
                orderSevice.increaseOrderCount();
            }
        };

        for (int i = 0; i < 90000; i++) {
            new Thread(task).start();
        }
        Thread.sleep(1000);

        System.out.println("Counted: "+orderSevice.orderCount);


    }
}
