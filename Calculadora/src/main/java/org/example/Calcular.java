package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcular extends JFrame {
    private JButton Number8;
    private JButton Number7;
    private JButton Number9;
    private JButton Number5;
    private JButton Number6;
    private JButton Number4;
    private JButton Number2;
    private JButton Number3;
    private JButton Number1;
    private JButton Number0;
    private JButton SumaNum;
    private JButton RestaNum;
    private JButton MultNum;
    private JButton DivNum;
    private JButton EqualNum;
    private JPanel MainPanel;
    private JLabel ScreenLbl;
    private JButton DelBtn;
    private String text;
    private int mode;
    private double num1;
    private boolean nuevo = true;
    private boolean history = false;

    public Calcular(){
        setVisible(true);
        setContentPane(MainPanel);
        setTitle("Calculadora");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        EqualNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        SumaNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator(text, 0);
            }
        });

        RestaNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator(text, 1);
            }
        });

        MultNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator(text, 2);
            }
        });

        DivNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator(text, 3);
            }
        });

        DelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAll();
            }
        });

        Number0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("0");
            }
        });

        Number1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("1");
            }
        });

        Number2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("2");
            }
        });

        Number3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("3");
            }
        });

        Number4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("4");
            }
        });

        Number5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("5");
            }
        });

        Number6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("6");
            }
        });

        Number7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("7");
            }
        });

        Number8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("8");
            }
        });

        Number9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("9");
            }
        });
    }

    private void addNumber(String number){
        if (nuevo) {
            text = number;
            nuevo = false;
        } else {
            text += number;
        }
        ScreenLbl.setText(text);
    }

    private void operator(String text, int newMode){
        if (!history){
            num1 = Double.parseDouble(text);
        }

        mode = newMode;
        nuevo = true;
        history = true;
    }

    private void calculate() {
        double num2 =Double.parseDouble(text);
        double num3 = 0;

        switch (mode) {
            case 0:
                num3 = num1 + num2;
                break;

            case 1:
                num3 = num1 - num2;
                break;

            case 2:
                num3 = num1 * num2;
                break;

            case 3:
                if (num2 != 0) {
                    num3 = num1 / num2;
                } else {
                    deleteAll();
                    ScreenLbl.setText("Math Error");
                    return;
                }
                break;
        }
        ScreenLbl.setText(Double.toString(num3));
        num1 = num3;
        nuevo = true;
    }

    private void deleteAll(){
        text = "";
        num1 = 0;
        mode = 0;
        nuevo = true;
        history = false;
        ScreenLbl.setText("");
    }
}
