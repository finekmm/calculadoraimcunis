import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {

    private JFrame frame;
    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JLabel resultadoLabel;
    private JLabel classificacaoLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraIMC().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Calculadora IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JLabel lblPeso = new JLabel("Peso (Kg):");
        pesoTextField = new JTextField();
        JLabel lblAltura = new JLabel("Altura (Cm):");
        alturaTextField = new JTextField();
        JButton btnCalcular = new JButton("Calcular");
        resultadoLabel = new JLabel();
        classificacaoLabel = new JLabel();

        btnCalcular.addActionListener(e -> calcularIMC());

        contentPane.add(lblPeso);
        contentPane.add(pesoTextField);
        contentPane.add(lblAltura);
        contentPane.add(alturaTextField);
        contentPane.add(btnCalcular);
        contentPane.add(resultadoLabel);
        contentPane.add(classificacaoLabel);

        frame.getContentPane().add(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText()) / 100; // Converter altura para metros

            double imc = peso / (altura * altura);

            String resultado = String.format("Seu IMC é: %.2f", imc);
            resultadoLabel.setText(resultado);

            String classificacao;

            if (imc < 18.5) {
                classificacao = "Classificação: Abaixo do peso";
            } else if (imc < 25) {
                classificacao = "Classificação: Peso normal";
            } else if (imc < 30) {
                classificacao = "Classificação: Sobrepeso";
            } else if (imc < 35) {
                classificacao = "Classificação: Obesidade Grau I";
            } else if (imc < 40) {
                classificacao = "Classificação: Obesidade Grau II";
            } else {
                classificacao = "Classificação: Obesidade Grau III";
            }

            classificacaoLabel.setText(classificacao);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
