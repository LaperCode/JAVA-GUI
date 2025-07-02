package TITV.MenuExample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import TITV.MenuExample.view.MenuExampleView;

public class MenuExampleController implements ActionListener, MenuListener {
    private MenuExampleView menuExampleView;

    public MenuExampleController(MenuExampleView menuExampleView) {
        this.menuExampleView = menuExampleView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand(); // lấy cái text

        if(btn.equals("Open")) {
            this.menuExampleView.setTextJLabel("Bạn đã click JMenuItem Open");
        } else if(btn.equals("New")) {
            this.menuExampleView.setTextJLabel("Bạn đã click JMenuItem New");
        } else if (btn.equals("Welcome")) {
            this.menuExampleView.setTextJLabel("bạn đã click JMenuItem Welcome");
        } else if(btn.equals("Help")) {
            this.menuExampleView.setTextJLabel("Bạn đã click JMenuItem Help");
        } else if(btn.equals("Exit")) {
            System.exit(0);
        } if(btn.equals("Toolbar")) {
            // Ép kiểu sự kiện thành nút
            AbstractButton checkBox = (AbstractButton) e.getSource(); // Lấy đối tượng
            boolean check = checkBox.getModel().isSelected(); // getModel là nơi lưu trữ thông tin
            if(check) {
                this.menuExampleView.enableToolbar();
            } else {
                this.menuExampleView.disableToolbar();
            }
        } else {
            this.menuExampleView.setTextJLabel("Bạn đã click: " + btn);
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        this.menuExampleView.setTextJLabel("Bạn đã click JMenu Help");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        // Không cần xử lý khi menu bị bỏ chọn
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        // Không cần xử lý khi menu bị hủy
    }
    
}
