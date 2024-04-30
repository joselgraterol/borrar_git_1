import java.awt.event.*;
import javax.swing.*;

public class Xampp extends JFrame implements ActionListener {

  private JButton startButton;
  private JButton stopButton;

  public Xampp() {
    super("XAMPP Controller");

    // Create buttons
    startButton = new JButton("Start XAMPP");
    stopButton = new JButton("Stop XAMPP");

    // Add buttons to panel
    JPanel panel = new JPanel();
    panel.add(startButton);
    panel.add(stopButton);

    // Add action listener
    startButton.addActionListener(this);
    stopButton.addActionListener(this);

    // Set content pane and display window
    getContentPane().add(panel);
    pack();
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command;
    try {
      if (e.getSource() == startButton) {
        command = "sudo /opt/lampp/xampp start";
      } else if (e.getSource() == stopButton) {
        command = "sudo /opt/lampp/xampp stop";
      } else {
        return;
      }

      // Execute command using Runtime
      Runtime.getRuntime().exec(command);
      JOptionPane.showMessageDialog(this, "Command executed successfully!");
    } catch (Exception ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(this, "Error executing command: " + ex.getMessage());
    }
  }

  public static void main(String[] args) {
    new Xampp();
  }
}
