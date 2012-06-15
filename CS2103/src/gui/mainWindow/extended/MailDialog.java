/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mainWindow.extended;

import gui.Resource;
import gui.UIController;

import java.awt.Component;
import java.awt.Color;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import logic.JIDLogic;

/**
 * Google Calendar log in frame
 * @author Ramon
 */
public class MailDialog extends javax.swing.JDialog {
	private static Logger	 logger=Logger.getLogger(MailDialog.class);
    /**
     * Creates new form LogInDialog
     */
    public MailDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    	UIController.setLoginOn(true);
        this.initComponents();
        this.addEvent();
        this.setTabSequence();
        this.setMovable();
        this.setBackground(new Color(0,0,0,0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * constructure
     * @param parent JFrame on which this dialog is based
     * @param x x-coordinate that this dialog will be displayed
     * @param y y-coordinate that this dialog will be displayed
     */
    public MailDialog(java.awt.Frame parent, int x, int y) {
    	super(parent, true);
    	UIController.setLoginOn(true);
        this.initComponents();
        this.addEvent();
        this.setTabSequence();
        this.setBackground(new Color(0,0,0,0));
        this.setLocation(x, y);
        this.setMovable();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        userTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setIconImages(null);

        mailLabel.setText("<html><b>e-mail:</html>");
        mailLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        mailLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        mailLabel.setBounds(10, 55, 85, 25);
        jLayeredPane2.add(mailLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        userTextField.setText("");
        userTextField.setBounds(60, 55, 125, 25);
        jLayeredPane2.add(userTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        submitButton.setText("<html>submit</html>");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        submitButton.setBounds(202, 55, 74, 26);
        jLayeredPane2.add(submitButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        
        background.setIcon(Resource.mailBG);
        background.setBounds(0, 0, 290, 120);
        jLayeredPane2.add(background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        this.setUndecorated(true);
        this.pack();
        
    }// </editor-fold>

    /**
     * modify log in button action
     * @param evt
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.dispose();
    	JIDLogic.setCommand("agendaEmail");
    	JIDLogic.executeCommand("agendaEmail " + userTextField.getText());
    }
    
    
    
	/**
	 * set look and feel of this dialog box
	 */
    private static void setLook() {
    	

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			logger.error("set look", e);
		} catch (InstantiationException e) {
			logger.error("set look", e);
		} catch (IllegalAccessException e) {
			logger.error("set look", e);
		} catch (UnsupportedLookAndFeelException e) {
			logger.error("set look", e);
		}
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        setLook();
        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                MailDialog dialog = new MailDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
    }
    
    
    // Variables declaration - do not modify
    private javax.swing.JLabel background;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField userTextField;
    private javax.swing.JLabel mailLabel;
    private static boolean shown = true;
    // End of variables declaration
    
    /**
     * highlight text in the text field when selected
     */
    private void addEvent() {
    	userTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				userTextField.selectAll();
			}    		
    	});
    }
    
    /**
     * modify tab sequence of diagram
     */
    private void setTabSequence() {
        setFocusTraversalPolicy(new MyFocusTraversalPolicy());
    }
    
    /**
     * Modified FocusTraversalPolicy for indicating tab sequence
     * @author Ramon
     *
     */
    class MyFocusTraversalPolicy extends FocusTraversalPolicy {

		@Override
		public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
			if(aComponent.equals(userTextField))
				return submitButton;
			if(aComponent.equals(submitButton))
				return userTextField;
			return null;
		}

		@Override
		public Component getComponentBefore(Container arg0, Component aComponent) {
			if(aComponent.equals(userTextField))
				return submitButton;
			if(aComponent.equals(submitButton))
				return userTextField;
			return null;
		}

		@Override
		public Component getDefaultComponent(Container arg0) {
			return userTextField;
		}

		@Override
		public Component getFirstComponent(Container arg0) {
			return userTextField;
		}

		@Override
		public Component getLastComponent(Container arg0) {
			return submitButton;
		}	
    }
    
    
    Point point = new Point();
    
    /**
     * make login dialog movable
     */
    private void setMovable() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();

			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = MailDialog.this.getLocation();
				MailDialog.this.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);				
			}
		});
    }
    
}
