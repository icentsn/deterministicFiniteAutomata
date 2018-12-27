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
public class InputView {
    //Asking the user for the input

    public String openUserPrompt() {
        JFrame frame = new JFrame();
        String input = JOptionPane.showInputDialog(frame, "Enter String:");
        return input;
    }
}
