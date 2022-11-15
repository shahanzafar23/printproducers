package com.printer.consumer;

import java.util.List;
import java.util.Random;

public class PrinterConsumer extends Consumer{
    public PrinterConsumer(List<Integer> s) {
        super(s);
    }

    @Override
    public void consume(int num) {
        System.out.println("Printer consumes: " + num);
    }

    @Override
    public long getPrintWindow() {
        return new Random().nextInt(3000);
    }

    @Override
    public int getInternal() {
        return new Random().nextInt(5000);
    }
}
