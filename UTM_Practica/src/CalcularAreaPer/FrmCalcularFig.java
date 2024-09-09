package CalcularAreaPer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCalcularFig extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JComboBox<String> cmbFiguras;
    private JTextField txtDato1, txtDato2, txtDato3;
    private JLabel lblDato1, lblDato2, lblDato3, lblResultado;
    private JButton btnCalcular;

    public FrmCalcularFig() {
        setTitle("Cálculo de Figuras Geométricas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ComboBox para seleccionar la figura
        JLabel lblSeleccion = new JLabel("Selecciona la figura:");
        lblSeleccion.setBounds(10, 10, 150, 30);
        add(lblSeleccion);

        cmbFiguras = new JComboBox<>(new String[] {"Rectángulo","Cuadrado", "Círculo", "Triángulo"});
        cmbFiguras.setBounds(170, 10, 150, 30);
        add(cmbFiguras);

        // Campos de datos
        lblDato1 = new JLabel("Dato 1:");
        lblDato1.setBounds(10, 50, 100, 30);
        add(lblDato1);
 
        txtDato1 = new JTextField();
        txtDato1.setBounds(120, 50, 100, 30);
        add(txtDato1);

        lblDato2 = new JLabel("Dato 2:");
        lblDato2.setBounds(10, 90, 100, 30);
        add(lblDato2);

        txtDato2 = new JTextField();
        txtDato2.setBounds(120, 90, 100, 30);
        add(txtDato2);

        lblDato3 = new JLabel("Dato 3:");
        lblDato3.setBounds(10, 130, 100, 30);
        add(lblDato3);

        txtDato3 = new JTextField();
        txtDato3.setBounds(120, 130, 100, 30);
        add(txtDato3);

        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 170, 100, 30);
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(10, 210, 600, 80);
        add(lblResultado);

        // Acción cuando cambia la selección en el ComboBox
        cmbFiguras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampos();
            }
        });

        // Acción cuando se presiona el botón "Calcular"
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        actualizarCampos(); // Inicializar los campos según la selección actual
    }

    // Método para actualizar los campos de entrada según la figura seleccionada
    private void actualizarCampos() {
        String figuraSeleccionada = (String) cmbFiguras.getSelectedItem();
        
        if (figuraSeleccionada.equals("Rectángulo")) {
            lblDato1.setText("Largo:");
            lblDato2.setText("Ancho:");
            lblDato3.setVisible(false);
            txtDato3.setVisible(false);
        }else if (figuraSeleccionada.equals("Cuadrado")){
            lblDato1.setText("Lado:");
            lblDato2.setVisible(false);
            txtDato2.setVisible(false);
            lblDato3.setVisible(false);
            txtDato3.setVisible(false);
        }
        else if (figuraSeleccionada.equals("Círculo")) {
            lblDato1.setText("Radio:");
            lblDato2.setVisible(false);
            txtDato2.setVisible(false);
            lblDato3.setVisible(false);
            txtDato3.setVisible(false);
        } else if (figuraSeleccionada.equals("Triángulo")) {
            lblDato1.setText("Lado A:");
            lblDato2.setText("Lado B:");
            lblDato3.setText("Lado C:");
            lblDato2.setVisible(true);
            txtDato2.setVisible(true);
            lblDato3.setVisible(true);
            txtDato3.setVisible(true);
        }
    }

    // Método para realizar los cálculos
    private void calcular() {
        String figuraSeleccionada = (String) cmbFiguras.getSelectedItem();
        try {
            if (figuraSeleccionada.equals("Rectángulo")) {
                double largo = Double.parseDouble(txtDato1.getText());
                double ancho = Double.parseDouble(txtDato2.getText());
                Rectangulo rectangulo = new Rectangulo(largo, ancho);
                lblResultado.setText("<html>Área: " + rectangulo.calcularArea() + "<br>Perímetro: " + rectangulo.calcularPerimetro());
            } else if (figuraSeleccionada.equals("Cuadrado")) {
                double lado = Double.parseDouble(txtDato1.getText());
                Cuadrado Cuadrado = new Cuadrado(lado);
                lblResultado.setText("<html>Área: " + Cuadrado.calcularArea() + "<br>Perímetro: " + Cuadrado.calcularPerimetro());
            } else if (figuraSeleccionada.equals("Círculo")) {
                double radio = Double.parseDouble(txtDato1.getText());
                Circulo circulo = new Circulo(radio);
                lblResultado.setText("<html>Área: " + circulo.calcularArea() + "<br>Perímetro: " + circulo.calcularPerimetro());
            } else if (figuraSeleccionada.equals("Triángulo")) {
                double ladoA = Double.parseDouble(txtDato1.getText());
                double ladoB = Double.parseDouble(txtDato2.getText());
                double ladoC = Double.parseDouble(txtDato3.getText());
                Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
                lblResultado.setText("<html>Área: " + triangulo.calcularArea() + "<br>Perímetro: " + triangulo.calcularPerimetro() + "<br>Tipo: " + triangulo.tipoTriangulo() + "</html>");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Introducir solo valores numéricos");
        }
    }
}
