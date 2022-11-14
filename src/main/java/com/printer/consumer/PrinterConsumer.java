package com.printer.consumer;

import java.util.List;

public class PrinterConsumer extends Consumer{
    public PrinterConsumer(List<Integer> s) {
        super(s);
    }

    @Override
    public void consume(int num) {
        System.out.println("Printer consumes: " + num);
    }

    @Override
    public int getInternal() {
        return 500;
    }
}
