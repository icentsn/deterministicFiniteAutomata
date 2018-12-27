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
import java.io.*;
import java.util.ArrayList;

public class Controller {

    public void startApplication() {
        FileChooserView fileChooserView = new FileChooserView();
        String filePath = fileChooserView.openFileChooser();
        FiniteAutomata machine = createMachine(filePath);

        InputView inputView = new InputView();
        String input = inputView.openUserPrompt();
        if (input == null) {
            System.exit(0);
        }
        boolean isAccept = machine.run(input);
        OutputView outputView = new OutputView();
        outputView.showResult(isAccept);
    }
    
    // Big-O = O(n)
    protected FiniteAutomata createMachine(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String startState = null;
            ArrayList<String> acceptStates = new ArrayList<>();
            ArrayList<Transition> transitions = new ArrayList<>();
            int loopCount = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (loopCount == 1) {
                    startState = line;
                }
                else if (loopCount == 2) {
                    String[] states = line.split("\\s+");
                    for (int i = 0; i < states.length; i++) {
                        acceptStates.add(states[i]);
                    }
                }
                else {
                    String[] t = line.split("\\s+");
                    Transition transition = new Transition(t[0], t[1].charAt(0), t[2]);
                    transitions.add(transition);
                }
                loopCount++;
            }
            return new FiniteAutomata(startState, acceptStates, transitions);
        } catch (IOException | NullPointerException e) {
            System.exit(0);
        }
        return null;
    }
}

