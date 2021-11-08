package bsu.rfe.group7.java.Chikilev.varB10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Function extends JFrame {
    private static final int Widht = 400;
    private static final int Height = 320;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private double mem1,mem2,mem3;
    Double result;
    private JTextField textFieldZ;
    private JTextField textFieldResult;
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons2 = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;

    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y,Double z) {
        return (Math.sin(3.14*y*y)+Math.log(y*y))/(Math.sin(3.14*z*z)+Math.sin(x)+Math.log(z*z)+x*x+Math.pow(2.78,Math.cos(z*x)));
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y,Double z) {
        return (Math.sin(Math.pow(z,y))*Math.sin(Math.pow(z,y)))/(Math.sqrt(1+x*x*x));
    }

    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Function.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    public Function() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(
                BorderFactory.createLineBorder(Color.YELLOW));
// Создать область с полями ввода для X и Y
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        ButtonGroup radioButtons2 = new ButtonGroup();
        JRadioButton first = new JRadioButton("Переменная 1:");
        JRadioButton second = new JRadioButton("Переменная 2:");
        JRadioButton third = new JRadioButton("Переменная 3:");
       radioButtons2.add(first);
        first.setSelected(true);
       radioButtons2.add(second);
       radioButtons2.add(third);

        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
// Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
//labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
// Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());

                    if (formulaId==1)
                        result = calculate1(x,y,z);
                    else
                        result = calculate2(x,y,z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Function.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton MSum = new JButton("M+");
        MSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    if(mem1 != x)
                    if(mem1 == 0 ){
                        mem1 = Double.parseDouble(textFieldX.getText());

                    }
                    if(mem2 != y)
                    if( mem2 == 0){
                        mem2 = Double.parseDouble(textFieldY.getText());
                    }
                    if(mem3 != z)
                    if(mem3 == 0){
                        mem3 = Double.parseDouble(textFieldZ.getText());
                    }
                    if(first.isSelected()){
                        result = mem1+ result;
                    }else if(second.isSelected()){
                        result += mem2;
                    }else if(third.isSelected()){
                        result += mem3;
                    }
                    textFieldResult.setText(result.toString());
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Function.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton MReset = new JButton("MC");
        MReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if(first.isSelected()){
                    mem1 =  0;
                }else if(second.isSelected()){
                    mem2 = 0;
                }else if(third.isSelected()){
                    mem3 = 0;
                    textFieldZ.setText("0");
                }
                result = 0.0;
                textFieldResult.setText("0");

            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
                result = 0.0;
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(MSum);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(MReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));
        // mem
        Box Mem = Box.createHorizontalBox();
        Mem.add(Box.createHorizontalGlue());
        Mem.add(first);
        Mem.add(Box.createHorizontalStrut(30));
        Mem.add(second);
        Mem.add(Box.createHorizontalStrut(30));
        Mem.add(third);
        Mem.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.RED));
// Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(Mem);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

}

