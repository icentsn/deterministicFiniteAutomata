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
public class Transition {

    private final String fromState;
    private final Character label;
    private final String toState;

    public Transition(String fromState, Character label, String toState) {
        this.fromState = fromState;
        this.label = label;
        this.toState = toState;
    }

    public Character getLabel() {
        return label;
    }

    public String getFromState() {
        return fromState;
    }

    public String getToState() {
        return toState;
    }
}
