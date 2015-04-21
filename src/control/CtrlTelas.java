/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maurilio
 */
public class CtrlTelas {

    /**
     * Adiciona um JInternalFrame à um desktop pane.
     *
     * @param desktop
     * @param frame
     */
    public static void chamaTelas(JDesktopPane desktop, JInternalFrame frame) {
        desktop.add(frame);
        frame.setVisible(true);
        frame.setEnabled(true);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CtrlTelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        CtrlTelas.centralizaForm(desktop, frame);
    }

    private static void centralizaForm(JDesktopPane desktop, JInternalFrame frame) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    public static void adicionaLinha(JTable table, ArrayList<String> linhas) {
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        for(String txt:linhas){
            df.addRow(new Object[]{txt});
        }
        table.setModel(df);
    }
}
