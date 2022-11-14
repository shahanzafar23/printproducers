package com.printer.producer;

import java.util.List;

public abstract class Producer extends Thread{
    public Producer(List<Integer> s) {
        stack = s;
    }

    private List<Integer> stack = null;
    private int num = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (stack) {
                try {
                    sleep(getInternal());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num = produceNum(num);
                stack.add(num);
                stack.notifyAll();
            }
        }
    }

    public abstract int produceNum(int num);

    public abstract int getInternal();
}
