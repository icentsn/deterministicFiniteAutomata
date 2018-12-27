/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author icentsn
 */
import javax.swing.*;

public class OutputView {

    public void showResult(boolean accept) {
        JFrame frame = new JFrame();
        String result;
        if (accept) {
            result = "<html><font color=#00FF00>Accept!!</font>";
        }
        else {
            result = "<html><font color=#FF0000>Reject!!</font>";
        }
        JOptionPane.showMessageDialog(frame, result);
        System.exit(0);
    }
}