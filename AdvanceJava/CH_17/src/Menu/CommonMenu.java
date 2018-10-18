package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class CommonMenu {
    
    public static void getCommonMenu(JFrame f) {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        jMenuBar.add(file);
        
        jMenuBar.add(new JMenu("About"));
        
        JMenu help = new JMenu("Help");
        jMenuBar.add(help);
        
        JMenuItem item1 = new JMenuItem("New");
        item1.setMnemonic('N');
        item1.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new New().setVisible(true);
            }
        });
        
        JMenuItem item2 = new JMenuItem("Open");
        Object obj = new Object();
        item2.setIcon(new javax.swing.ImageIcon(obj.getClass().getResource("/Menu/logo.PNG")));
        
        item2.setMnemonic('O');
        item2.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        file.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Open().setVisible(true);
            }
        });
        
        file.add(item1);
        //file.add(new JMenuItem("New"));
        file.add(new JMenuItem("No Open"));
        JMenuItem item4 = new JMenuItem("Exit");
        file.add(item4);
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f.setJMenuBar(jMenuBar);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
