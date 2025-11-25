import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * CSE 205 - Proyecto de Programación 3
 * Clase View: Interfaz gráfica del evaluador de expresiones
 * 
 * Proporciona una ventana con:
 * - Campo de texto para ingresar expresiones
 * - Botón Clear para limpiar
 * - Botón Evaluate para evaluar la expresión
 * - Botón Exit para salir
 */
public class View extends JFrame {
    
    // Componentes de la interfaz
    private JTextField mInputField;
    private JButton mClearButton;
    private JButton mEvaluateButton;
    private JButton mExitButton;
    
    // Objeto Expression para evaluar expresiones
    private Expression mExpression;
    
    /**
     * Constructor que inicializa la interfaz gráfica
     */
    public View() {
        // Inicializa el objeto Expression
        mExpression = new Expression();
        
        // Configura la ventana principal
        setTitle("Evaluador de Expresiones");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        
        // Crea el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel superior: Campo de entrada
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        JLabel inputLabel = new JLabel("Expresión:");
        mInputField = new JTextField(20);
        mInputField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(mInputField, BorderLayout.CENTER);
        
        // Panel inferior: Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        mClearButton = new JButton("Clear");
        mEvaluateButton = new JButton("Evaluate");
        mExitButton = new JButton("Exit");
        
        buttonPanel.add(mClearButton);
        buttonPanel.add(mEvaluateButton);
        buttonPanel.add(mExitButton);
        
        // Agrega los paneles al panel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        // Agrega el panel principal a la ventana
        add(mainPanel);
        
        // Configura los listeners (manejadores de eventos)
        setupListeners();
        
        // Permite evaluar con Enter
        mInputField.addActionListener(e -> evaluateExpression());
    }
    
    /**
     * Configura los manejadores de eventos para los botones
     */
    private void setupListeners() {
        // Botón Clear: Limpia el campo de entrada
        mClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mInputField.setText("");
                mInputField.requestFocus();
            }
        });
        
        // Botón Evaluate: Evalúa la expresión ingresada
        mEvaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateExpression();
            }
        });
        
        // Botón Exit: Cierra la aplicación
        mExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    /**
     * Evalúa la expresión ingresada por el usuario
     * Muestra el resultado en un diálogo o un mensaje de error si falla
     */
    private void evaluateExpression() {
        try {
            // Obtiene el texto del campo de entrada
            String input = mInputField.getText().trim();
            
            // Verifica que no esté vacío
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Por favor ingrese una expresión",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            // Evalúa la expresión
            Double result = mExpression.evaluate(input);
            
            // Muestra el resultado
            JOptionPane.showMessageDialog(
                this,
                "Resultado: " + result,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
            );
            
        } catch (Exception ex) {
            // Muestra mensaje de error si la evaluación falla
            JOptionPane.showMessageDialog(
                this,
                "Error al evaluar la expresión:\n" + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        // Usa el Look and Feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, usa el Look and Feel por defecto
        }
        
        // Crea y muestra la ventana en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.setVisible(true);
            }
        });
    }
}
