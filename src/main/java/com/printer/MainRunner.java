package com.printer;

import com.printer.consumer.Consumer;
import com.printer.consumer.PrinterConsumer;
import com.printer.producer.FiveSumSeqProducer;
import com.printer.producer.Producer;
import com.printer.producer.ThreeSumSeqProducer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainRunner {
    public static void main(String []args)
    {
        List<Integer> stack = new LinkedList<Integer>();
        List<Producer> producers = new ArrayList<>();

        producers.add(new ThreeSumSeqProducer(stack));
        producers.add(new FiveSumSeqProducer(stack));

        List<Consumer> consumers = new ArrayList<>();
        consumers.add(new PrinterConsumer(stack));

        producers.stream().forEach(producer -> producer.start());
        consumers.stream().forEach(consumer -> consumer.start());
    }
}
