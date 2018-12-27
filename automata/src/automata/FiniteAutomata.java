package automata;

/**
 *
 * @author icentsn
 */
import java.util.ArrayList;

public class FiniteAutomata {

    private final String startState;
    private final ArrayList<String> acceptStates;
    private final ArrayList<String> states;
    private final ArrayList<Transition> transitions;

    public FiniteAutomata(String startState, ArrayList<String> acceptStates, ArrayList<Transition> transitions) {
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.transitions = transitions;
        states = new ArrayList<>();
        for (int i = 0; i < transitions.size(); i++) {
            String fromState = transitions.get(i).getFromState();
            String toState = transitions.get(i).getToState();
            if (!states.contains(fromState)) {
                states.add(fromState);
            }
            if (!states.contains(toState)) {
                states.add(toState);
            }
        }
        System.out.println("States: " + states);
    }

    public ArrayList<Character> alphabet() {
        ArrayList<Character> alphabets = new ArrayList<>();
        for (int i = 0; i < transitions.size(); i++) {
            char label = transitions.get(i).getLabel();
            if (!alphabets.contains(label)) {
                alphabets.add(label);
            }
        }
        System.out.println("Alphabets: " + alphabets);
        return alphabets;
    }

    //Big-O = O(n^2)
    public boolean run(String input) {
        boolean accept = true;
        ArrayList<Character> alphabets = alphabet();
        System.out.println("Input String: " + input);
        ArrayList<String> test = new ArrayList<>();
        test.add(startState);

        for (int i = 0; i < input.length(); i++) {
            if (alphabets.contains(input.charAt(i))) {
                for (int j = 0; j < transitions.size(); j++) {
                    char label = transitions.get(j).getLabel();
                    String fromState = transitions.get(j).getFromState();
                    String toState = transitions.get(j).getToState();

                    // start state
                    if (i == 0) {
                        if (fromState.equals(startState) && label == input.charAt(i)) {
                            test.add(toState);
                            break;
                        }
                    }
                    else {
                        //compare the transition (label) to the fromState to the toState
                        if (fromState.equals(test.get(test.size() - 1)) && label == input.charAt(i)) {
                            test.add(toState);
                            break;
                        }
                    }
                }
            }
            else {
                accept = false;
                break;
            }
        }
        
        //print out the stage step
        for (int i = 0; i < test.size(); i++) {
            if (i == 0) {
                System.out.print(">> ");
            }
            System.out.print(test.get(i));
            if (i != test.size() - 1) {
                System.out.print(" -> ");
            }
            else {
                System.out.print("\n");
            }
        }
        accept = acceptStates.contains(test.get(test.size() - 1)) && accept;
        System.out.println("Output: " + accept);
        return accept;
    }

    public ArrayList<String> states() {
        return states;
    }
}
