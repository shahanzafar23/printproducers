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
            synchronized (stack) {
                while(stack.isEmpty())
                {
                    try{
                        stack.wait();
                    } catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                try {
                    sleep(getInternal());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int number = ((LinkedList<Integer>) stack).removeLast();
                consume(number);
                stack.notifyAll();
            }
        }
    }

    public abstract void consume(int num);

    public abstract int getInternal();
}
