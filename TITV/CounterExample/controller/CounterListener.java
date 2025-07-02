package TITV.CounterExample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TITV.CounterExample.view.CounterView;

public class CounterListener implements ActionListener {
    private CounterView ctv;
    
    public CounterListener(CounterView ctv) {
        this.ctv = ctv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Đã nhấn nút gì đó?");
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

        String src = e.getActionCommand();
        System.out.println("Bạn đã nhấn nút "+src);

        if(src.equals("UP")) {
            this.ctv.increment(); // từ đây -> CounterView có thuộc tính counterModel -> CounterModel có void increment
        } else if(src.equals("DOWN")) {
            this.ctv.decrement();
        }
    }
}
