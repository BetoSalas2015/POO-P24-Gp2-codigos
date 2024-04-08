 /**
  * Calculadora
  */
  import java.awt.*;
  import java.awt.event.*;
  
   public class Calculadora1 extends Frame {
      // Variables de clase de Interfaz
      private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
      private Button btnMas, btnMenos, btnMult, btnDiv, btnIgual, btnPunto, btnC;
      private TextField txtDisplay;
      private Panel pnlTeclado, pnlDisplay;
  
      // Variables de clase de Funcionalidad
      private double numero1, numero2, resultado;
      private char operación;
      private boolean operando, punto;        //  banderas
      private String displaynum, sign;
  
      public Calculadora1() {
          super("Calculadora");
  
          //  Creación de los componentes
          btn0 = new Button("0");         btn1 = new Button("1");
          btn2 = new Button("2");         btn3 = new Button("3");
          btn4 = new Button("4");         btn5 = new Button("5");
          btn6 = new Button("6");         btn7 = new Button("7");
          btn8 = new Button("8");         btn9 = new Button("9");
          btnMas = new Button("+");       btnMenos = new Button("-");
          btnMult = new Button("*");      btnDiv = new Button("/");
          btnIgual = new Button("=");     btnPunto = new Button(".");
          btnC = new Button("C");     
          
          txtDisplay = new TextField("0");
  
          pnlDisplay = new Panel();
          pnlTeclado = new Panel();
  
          //  Organizar los paneles
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
          Calculadora1 calculadora = new Calculadora1();
  
      }
      
   }
  
  