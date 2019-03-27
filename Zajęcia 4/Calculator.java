import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    static JTextArea output;
    JScrollPane scrollPane;
    static JTextField textField;



    static public Container addList() throws InvalidInputException
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(50, 260);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("sinus(x)");
        listModel.addElement("cosinus(x)");
        listModel.addElement("tangens(x)");
        listModel.addElement("arccosinus(x)");
        listModel.addElement("arcsinus(x)");
        listModel.addElement("e^(x)");
        listModel.addElement("x*pi");
        listModel.addElement("Levy's constant");
        listModel.addElement("Modulo");
        listModel.addElement("Factorial");
        listModel.addElement("Exponentiation");
        JList<String> list = new JList<>(listModel);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                double num = 0;
                try {
                    num = Double.parseDouble(textField.getText());
                }
                catch(NumberFormatException exc)
                {
                    output.setText(output.getText() + "\n" + "NaN input" + "\n");
                    return;
                }

                int switcher = list.getSelectedIndex();
                switch(switcher)
                {
                    case 1:
                        //sinsus
                        output.setText( output.getText() + "\n" +
                                        "sin(" + num + ")" + " =\n" +
                                        Math.sin(num) + "\n");
                        break;
                    case 2:
                        //cosinus
                        output.setText( output.getText() + "\n" +
                                "cos(" + num + ")" + " =\n" +
                                Math.cos(num) + "\n");
                        break;
                    case 3:
                        //tangens
                        output.setText( output.getText() + "\n" +
                                "tan(" + num + ")" + " =\n" +
                                Math.tan(num) + "\n");
                        break;
                    case 4:
                        //acos
                        output.setText( output.getText() + "\n" +
                                "acos(" + num + ")" + " =\n" +
                                Math.acos(num) + "\n");
                        break;
                    case 5:
                        //asin
                        output.setText( output.getText() + "\n" +
                                "asin(" + num + ")" + " =\n" +
                                Math.asin(num) + "\n");
                        break;
                    case 6:
                        //e^x
                        output.setText( output.getText() + "\n" +
                                "e^(" + num + ")" + " =\n" +
                                Math.exp(num) + "\n");
                        break;
                    case 7:
                        //e^x
                        output.setText( output.getText() + "\n" +
                                "pi*" + num + "" + " =\n" +
                                Math.PI*(num) + "\n");
                        break;
                    case 8:
                        //e^x
                        textField.setText( textField.getText() + "[L.]");
                        break;
                    case 9:
                        //e^x
                        textField.setText( textField.getText() + "#");
                        break;
                    case 10:
                        //e^x
                        textField.setText( textField.getText() + "!");
                        break;
                    case 11:
                        //e^x
                        textField.setText( textField.getText() + "^");
                        break;
                    default:
                        break;
                }
            }
        });

        panel.add(list, BorderLayout.CENTER);

        JButton button = new JButton("EVALUATEEEEEEEEEEEE!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Expression expression = new Expression(textField.getText());
                textField.setText("");
                Double result = 0.0;
                boolean result_ok = false;
                if (expression.checkSyntax()) {
                    result = expression.calculate();
                    result_ok = true;
                }
                else {
                    String errorMessage = expression.getErrorMessage();
                    try {
                        throw new InvalidInputException(errorMessage);
                    } catch (InvalidInputException e1) {
                        e1.printStackTrace();
                    }
                }
                if(result_ok)
                    output.setText(output.getText() + "\n" + expression.getExpressionString() + " = \n" + result + "\n");
            }
        });
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    static public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("settings");
        menuBar.add(menu);
        menuItem = new JMenuItem("reset");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("exit");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);

        return menuBar;
    }
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);


        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        JPanel panel_ = new JPanel(new BorderLayout());
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        //contentPane.add(scrollPane, BorderLayout.CENTER);

        textField = new JTextField("",10);
        panel_.add(scrollPane, BorderLayout.WEST);
        panel_.add(textField, BorderLayout.SOUTH);

        return panel_;
    }

    private JMenuBar createMenu()
    {
        JMenuBar bar = new JMenuBar();

        JMenu options = new JMenu("options");
        JMenuItem reset = new JMenuItem();
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JMenuItem exit = new JMenuItem();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        options.add(reset);
        options.add(exit);

        bar.add(options);

        return bar;
    }

    private static void createAndShowGUI() throws InvalidInputException {
        //Create and set up the window.
        JFrame frame = new JFrame("MenuDemo");
        //JPanel frame_right = new JPanel();
        //frame_right.setVisible(true);
        frame.setSize(70, 260);
        //frame.add(frame_right, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Calculator demo = new Calculator();
        frame.setJMenuBar(Calculator.createMenuBar());
        frame.add(demo.createContentPane(), BorderLayout.WEST);
        //frame_right.add(addList(), BorderLayout.NORTH);
        frame.add(addList(), BorderLayout.EAST);

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (InvalidInputException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
