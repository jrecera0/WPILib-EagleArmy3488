// Thank you Mr. Brew for sending me the code base for me to work with

package edu.wpi.first.ds;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class MainFrame extends JFrame implements KeyListener {
  // JFrame creation
  JTextPane j;

  // Accesible data
  public double xAxis;
  public double yAxis;
  public boolean aPressed;
  public boolean bPressed;
  public boolean xPressed;
  public boolean yPressed;

  // These things?
  boolean noXInput = false;
  boolean noYInput = false;
  int zeroDivisor = 2;
  double offset = 0.09;
  
  public MainFrame()    
  {
    super("Xbox Controller");        
    setBounds(0, 0, 640, 480);        
    setDefaultCloseOperation(EXIT_ON_CLOSE);        
    j = new JTextPane();        
    j.setBackground(Color.BLACK);        
    j.setForeground(Color.LIGHT_GRAY);        
    j.setFont(new Font("courier", Font.BOLD, 15));        
    j.addKeyListener(this);        
    getContentPane().add(j);        
    setVisible(true);    
  }
  
  public void keyPressed (KeyEvent arg0)    
  {
    int code = arg0.getKeyCode();
    switch(code) {
      case KeyEvent.VK_LEFT:
        xAxis = xAxis - offset * 2;
        break;
      case KeyEvent.VK_RIGHT:
        xAxis = xAxis + offset * 2;
        break;
      case KeyEvent.VK_DOWN:
        yAxis = yAxis + offset * 2;
        break;
      case KeyEvent.VK_UP:
        yAxis = yAxis - offset * 2;
        break;
      case KeyEvent.VK_A:
        aPressed = true;
        break;
      case KeyEvent.VK_B:
        bPressed = true;
        break;
      case KeyEvent.VK_X:
        xPressed = true;
        break;
      case KeyEvent.VK_Y:
        yPressed = true;
        break;
    }
  }
  
  public void keyReleased (KeyEvent arg0) {
    int code = arg0.getKeyCode();
    if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
      noXInput = true;
    }
    if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
      noYInput = true;
    }
    switch(code) {
      case KeyEvent.VK_A:
        aPressed = false;
        break;
      case KeyEvent.VK_B:
        bPressed = false;
        break;
      case KeyEvent.VK_X:
        xPressed = false;
        break;
      case KeyEvent.VK_Y:
        yPressed = false;
        break;
    }
  }
  
  public void keyTyped (KeyEvent arg0) {
    int code = arg0.getKeyCode();
    if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
      noXInput = false;
    }
    if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
      noYInput = false;
    }
    switch(code) {
      case KeyEvent.VK_LEFT:
        xAxis = xAxis - offset;
        break;
      case KeyEvent.VK_RIGHT:
        xAxis = xAxis + offset;
        break;
      case KeyEvent.VK_DOWN:
        yAxis = yAxis + offset;
        break;
      case KeyEvent.VK_UP:
        yAxis = yAxis - offset;
        break;
    }
  }

  public void zeroYAxis() {
    if(noYInput) {
      if(Math.abs(yAxis) < 0.04) {
        yAxis = 0;
      }
      else {
        yAxis = yAxis >= 0 ? yAxis - offset / zeroDivisor : yAxis + offset / zeroDivisor;
      }
    }
  }

  public void zeroXAxis() {
    if(noXInput) {
      if(Math.abs(xAxis) < 0.04) {
        xAxis = 0;
      }
      else {
        xAxis = xAxis >= 0 ? xAxis - offset / zeroDivisor : xAxis + offset / zeroDivisor;
      }
    }
  }
}