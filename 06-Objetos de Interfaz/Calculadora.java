 /**
  * Calculadora
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 public class Calculadora extends JFrame {
    // Variables de clase de Interfaz
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JButton btnMas, btnMenos, btnMult, btnDiv, btnIgual, btnPunto, btnC;
    private JTextField txtDisplay;
    private JPanel pnlTeclado, pnlDisplay;

    // Variables de clase de Funcionalidad
    private double numero1, numero2, resultado;
    private char operación;
    private boolean operando, punto;        //  banderas
    private String displaynum, sign;

    public Calculadora() {
        super("Calculadora");

        //  Creación de los componentes
        btn0 = new JButton("0");         btn1 = new JButton("1");
        btn2 = new JButton("2");         btn3 = new JButton("3");
        btn4 = new JButton("4");         btn5 = new JButton("5");
        btn6 = new JButton("6");         btn7 = new JButton("7");
        btn8 = new JButton("8");         btn9 = new JButton("9");
        btnMas = new JButton("+");       btnMenos = new JButton("-");
        btnMult = new JButton("*");      btnDiv = new JButton("/");
        btnIgual = new JButton("=");     btnPunto = new JButton(".");
        btnC = new JButton("C");     
        
        txtDisplay = new JTextField("0");

        pnlDisplay = new JPanel();
        pnlTeclado = new JPanel();

        //  Organizar los JPaneles
        pnlTeclado.setLayout( new GridLayout(4, 4, 2, 2) );
        pnlTeclado.add(btn7);
        pnlTeclado.add(btn8);
        pnlTeclado.add(btn9);
        pnlTeclado.add(btnDiv);
        pnlTeclado.add(btn4);
        pnlTeclado.add(btn5);
        pnlTeclado.add(btn6);
        pnlTeclado.add(btnMult);
        pnlTeclado.add(btn1);
        pnlTeclado.add(btn2);
        pnlTeclado.add(btn3);
        pnlTeclado.add(btnMenos);
        pnlTeclado.add(btnIgual);
        pnlTeclado.add(btn0);
        pnlTeclado.add(btnPunto);
        pnlTeclado.add(btnMas);

        pnlDisplay.setLayout( new BorderLayout() );
        pnlDisplay.add(btnC, "East");
        pnlDisplay.add(txtDisplay, "Center");

        add(pnlDisplay, "North");
        add(pnlTeclado, "Center");

        //  Funcionalidad
        operando = punto = true;

        // Gestion de Eventos 
        addWindowListener( new CloseWindow() );

        btn0.addActionListener(new BotonNumerico());
        btn1.addActionListener(new BotonNumerico());
        btn2.addActionListener(new BotonNumerico());
        btn3.addActionListener(new BotonNumerico());
        btn4.addActionListener(new BotonNumerico());
        btn5.addActionListener(new BotonNumerico());
        btn6.addActionListener(new BotonNumerico());
        btn7.addActionListener(new BotonNumerico());
        btn8.addActionListener(new BotonNumerico());
        btn9.addActionListener(new BotonNumerico());
        btnMas.addActionListener(new BotonOpera());
        btnMenos.addActionListener(new BotonOpera());
        btnMult.addActionListener(new BotonOpera());
        btnDiv.addActionListener(new BotonOpera());
        btnPunto.addActionListener(new BotonPunto());
        btnIgual.addActionListener(new BotonIgual());
        btnC.addActionListener(new BotonC());

        //  Configuración de la interfaz
        setSize(400, 400);
        setVisible(true);
        txtDisplay.setEditable(false);
        setResizable(false);
    }

    private class CloseWindow extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }

    }

    public class BotonC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtDisplay.setText("0");
            operando = punto = true;
            numero1 = numero2 = resultado = 0.0;          
        }
        
    }

    public class BotonOpera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (operando) {
                sign = new String(e.getActionCommand());
                operación = sign.charAt(0);
                numero1 = Double.parseDouble( txtDisplay.getText() );
                txtDisplay.setText("0");
                operando = false;
            } //  de operando           
        }
        
    }

    public class BotonPunto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (punto) {
                displaynum = new String( txtDisplay.getText() );
                displaynum += ".";
                txtDisplay.setText(displaynum);
                punto = false; 
            }          
        }
        
    }

    public class BotonIgual implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numero2 = Double.parseDouble(txtDisplay.getText());
            switch (operación) {
                case '+': resultado = numero1 + numero2; break;
                case '-': resultado = numero1 - numero2; break;
                case '*': resultado = numero1 * numero2; break;
                case '/': resultado = numero1 / numero2; break;
            }
            txtDisplay.setText(String.valueOf(resultado));
            operando = punto = true;        
        }
        
    }

    public class BotonNumerico implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displaynum = new String( txtDisplay.getText());
            if ( displaynum.equals("0") ) {
                displaynum = "";
            }    
            displaynum += e.getActionCommand();
            txtDisplay.setText(displaynum);          
        }
        
    }


    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

    }
    
 }

