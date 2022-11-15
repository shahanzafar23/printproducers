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
                num = produceNum(num);
                stack.add(num);
            }
            try {
                sleep(getInternal());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract int produceNum(int num);

    public abstract int getInternal();
}
