package TITV.MenuExample.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import TITV.MenuExample.view.MenuExampleView;

public class MenuExampleMouseListener implements MouseListener {
    private MenuExampleView menuExampleView;

    public MenuExampleMouseListener(MenuExampleView menuExampleView) {
        this.menuExampleView =  menuExampleView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // mousePressed đi chung với mouseReleased
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.isPopupTrigger()) { // Nhấn chuột phải
            this.menuExampleView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
        // checkPopupTrigger(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // checkPopupTrigger(e);
        if (e.isPopupTrigger()) { // Nhấn chuột phải
            this.menuExampleView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    // private void checkPopupTrigger(MouseEvent e) {
    //     if (e.isPopupTrigger()) { // Kiểm tra nếu đúng là nhấp chuột phải
    //         this.menuExampleView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
    //     }
    // }
    
}
