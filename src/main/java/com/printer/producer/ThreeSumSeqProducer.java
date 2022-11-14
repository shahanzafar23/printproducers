package com.printer.producer;

import com.printer.producer.Producer;

import java.util.List;

public class ThreeSumSeqProducer extends Producer {
    public ThreeSumSeqProducer(List<Integer> s) {
        super(s);
    }

    @Override
    public int produceNum(int num) {
        System.out.println("Produced number: " + (num + 3));
        return num + 3;
    }

    @Override
    public int getInternal() {
        return 100;
    }
}
