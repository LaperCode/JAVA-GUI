package TITV.MenuExample.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
// import java.awt.Font;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import TITV.MenuExample.controller.MenuExampleController;
import TITV.MenuExample.controller.MenuExampleMouseListener;

public class MenuExampleView extends JFrame {
    private JLabel jLabel;
    private JToolBar jToolBar;
    public JPopupMenu jPopupMenu;

    public MenuExampleView() {
        this.setTitle("Draw Example");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        // Set Icon => JFrame
        URL urlIconExample = MenuExampleView.class.getResource("icon_menuExample.png");
        Image image = Toolkit.getDefaultToolkit().createImage(urlIconExample);
        this.setIconImage(image);

        //Tạo controller
        MenuExampleController menuExampleController = new MenuExampleController(this);

        //Tạo thanh menu
        JMenuBar jMenuBar = new JMenuBar();

        //Tạo các Menu và các menu con
        JMenu jMenu_file = new JMenu("File");
        JMenuItem jMenuItem_new = new JMenuItem("New", KeyEvent.VK_N);
        jMenuItem_new.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuExampleView.class.getResource("icon_menuExample.png")).getScaledInstance(10, 10, Image.SCALE_SMOOTH)));
        jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        jMenuItem_new.addActionListener(menuExampleController);

        JMenuItem jMenuItem_open = new JMenuItem("Open", KeyEvent.VK_O);
        jMenuItem_open.addActionListener(menuExampleController);
        jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        
        JMenuItem jMenuItem_exit = new JMenuItem("Exit", KeyEvent.VK_X);
        jMenuItem_exit.addActionListener(menuExampleController);
        jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));

        jMenu_file.add(jMenuItem_new);
        jMenu_file.add(jMenuItem_open);
        jMenu_file.addSeparator(); // đường gạch ngang
        jMenu_file.add(jMenuItem_exit);

        
        // Menu View
        JMenu jMenu_view = new JMenu("View");
        JCheckBoxMenuItem jCheckBoxMenuItem_toolbar = new JCheckBoxMenuItem("Toolbar");
        jCheckBoxMenuItem_toolbar.addActionListener(menuExampleController);
        //Thêm Ctrl+T của ô Toolbar trong tab View
        jCheckBoxMenuItem_toolbar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        jMenu_view.add(jCheckBoxMenuItem_toolbar);

        // Menu Help
        JMenu jMenu_help = new JMenu("Help");
        jMenu_help.addMenuListener(menuExampleController);
        jMenu_help.setMnemonic(KeyEvent.VK_L);
        jMenu_help.setDisplayedMnemonicIndex(0);
        JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
        jMenuItem_welcome.addActionListener(menuExampleController);
        jMenu_help.add(jMenuItem_welcome);
        
        // Add các menu vào thanh Menu
        jMenuBar.add(jMenu_file);
        jMenuBar.add(jMenu_view);
        jMenuBar.add(jMenu_help);

        // Thêm thanh menu vào chương trình
        this.setJMenuBar(jMenuBar);

        // ------------- Tạo toolBar -------------
        jToolBar = new JToolBar();

        JButton jButton_undo = new JButton("Undo");
        jButton_undo.setToolTipText("Nhấn vào đây để quay lại thao tác vừa rồi");
        jButton_undo.addActionListener(menuExampleController);

        JButton jButton_redo = new JButton("Redo");
        jButton_redo.addActionListener(menuExampleController);
        jButton_redo.setToolTipText("Nhấn vào đây để quay lại thao tác mới trước thao tác cũ");
        
        JButton jButton_copy = new JButton("Copy");
        jButton_copy.addActionListener(menuExampleController);
        jButton_copy.setToolTipText("Nhấn vào đây để sao chép dữ liệu");
        
        JButton jButton_paste = new JButton("Paste");
        jButton_paste.addActionListener(menuExampleController);
        jButton_paste.setToolTipText("Nhấn vào đây để dán dữ liệu vừa mới sao chép");
        
        JButton jButton_cut = new JButton("Cut");
        jButton_cut.addActionListener(menuExampleController);
        jButton_cut.setToolTipText("Nhấn vào đây để di chuyển dữ liệu");
        
        jToolBar.add(jButton_undo);
        jToolBar.add(jButton_redo);
        jToolBar.add(jButton_copy);
        jToolBar.add(jButton_cut);
        jToolBar.add(jButton_paste);
        
        // this.add(jToolBar, BorderLayout.NORTH); // Ẩn để làm tính năng cho view toolbar
        
        // --------- Menu chuột phải JPopupMenu ---------
        jPopupMenu = new JPopupMenu();
        JMenu jMenuPopupFont = new JMenu("Font");
        JMenuItem jMenuItemType = new JMenuItem("Type");
        jMenuItemType.addActionListener(menuExampleController);
        JMenuItem jMenuItemSize = new JMenuItem("Size");
        jMenuItemSize.addActionListener(menuExampleController);
        jMenuPopupFont.add(jMenuItemType);
        jMenuPopupFont.add(jMenuItemSize);
        
        JMenuItem jMenuItemCut = new JMenuItem("Cut");
        jMenuItemCut.addActionListener(menuExampleController);
        JMenuItem jMenuItemCopy = new JMenuItem("Copy");
        jMenuItemCopy.addActionListener(menuExampleController);
        JMenuItem jMenuItemPaste = new JMenuItem("Paste");
        jMenuItemPaste.addActionListener(menuExampleController);

        jPopupMenu.add(jMenuPopupFont);
        jPopupMenu.addSeparator();
        jPopupMenu.add(jMenuItemCut);
        jPopupMenu.add(jMenuItemCopy);
        jPopupMenu.add(jMenuItemPaste);
        
        this.add(jPopupMenu);
        
        // Thêm sự kiện phải chuột vào JLabel
        MenuExampleMouseListener menuExampleMouseListener = new MenuExampleMouseListener(this);
        this.addMouseListener(menuExampleMouseListener);
        
        // 
        
        //Tạo lable hiển thị
        // Font f = new Font("Arial", Font.BOLD, 50);
        jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuExampleView.class.getResource("test.png"))));
        
        this.add(jLabel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setTextJLabel(String s) {
        this.jLabel.setText(s);
    }

    public void enableToolbar() {
        this.add(jToolBar, BorderLayout.NORTH);
        this.refresh();
    }

    public void disableToolbar() {
        this.remove(jToolBar);
        this.refresh();
    }

    public void refresh() {
        // this.pack();
        // this.setSize(500,500);
        // this.getSize(getPreferredSize());
        this.revalidate(); // Cập nhật bố cục giao diện
        this.repaint(); // Vẽ lại giao diện (Không cần thiết. Chỉ dùng khi vẽ lại nội dung đồ họa, 
                        // khi có thành phần giao diện yêu cầu làm mới trực tiếp mà ko liên quan đến layout)
    }

    public static void main(String[] args) {
        new MenuExampleView();
    }
}
