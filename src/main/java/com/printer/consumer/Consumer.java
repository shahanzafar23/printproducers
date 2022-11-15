package com.printer.consumer;

import java.util.LinkedList;
import java.util.List;

public abstract class Consumer extends Thread{
    public Consumer(List<Integer> s) {
        stack = s;
    }

    private List<Integer> stack = null;

    @Override
    public void run() {
        while(true){
            long endWindow = System.currentTimeMillis() + getPrintWindow();
            System.out.println("Consumer Working.....");
            while(System.currentTimeMillis() < endWindow){
                synchronized (stack) {
                    if(!stack.isEmpty())
                    {
                        int number = ((LinkedList<Integer>) stack).removeLast();
                        consume(number);
                    }
                }
            }
            System.out.println("Consumer ended going to sleep.....");
            try {
                sleep(getInternal());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void consume(int num);

    public abstract long getPrintWindow();

    public abstract int getInternal();
}
