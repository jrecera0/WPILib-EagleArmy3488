package edu.wpi.first.ds;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class MainFrame extends JFrame implements KeyListener {
  JTextPane j;
  public static double joystickValue;
  public static boolean noInput = false;
  private static double offset = 0.09;
  
  public MainFrame()    
  {
    super ("title");        
    setBounds (0, 0, 640, 480);        
    setDefaultCloseOperation (EXIT_ON_CLOSE);        
    j = new JTextPane ();        
    j.setBackground(Color.BLACK);        
    j.setForeground(Color.LIGHT_GRAY);        
    j.setFont(new Font("courier", Font.BOLD, 15));        
    j.addKeyListener (this);        
    getContentPane().add(j);        
    setVisible(true);    
  }

  public static double getMe() {
    return joystickValue;
  }
  
  public void keyPressed (KeyEvent arg0)    
  {
    int code = arg0.getKeyCode();
    switch(code) {
      case KeyEvent.VK_LEFT:
        joystickValue = joystickValue - offset;
        break;
      case KeyEvent.VK_RIGHT:
        joystickValue = joystickValue + offset;
        break;
      case KeyEvent.VK_DOWN:
        joystickValue = joystickValue + offset;
        break;
      case KeyEvent.VK_UP:
        joystickValue = joystickValue - offset;
        break;
    }
  }
  
  public void keyReleased (KeyEvent arg0) {
    noInput = true;
    decrement();
  }
  
  public void keyTyped (KeyEvent arg0) {
    noInput = false;
  }

  public static void decrement() {
    if(noInput) {
      if(Math.abs(joystickValue) < 0.09) {
        joystickValue = 0;
      } else {
        joystickValue = joystickValue >= 0 ? joystickValue - offset / 2: joystickValue + offset / 2;
      }
    }
  }
}