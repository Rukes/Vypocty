package parser.functionality;

import parser.functionality.type.*;

public enum Functionality {

    PI(),
    EULER_NUMBER();

    private FunctionalityEvaluation evaluation;

    static {
        PI.setEvaluation(new FunctionalityPI());
        EULER_NUMBER.setEvaluation(new FunctionalityEulerNumber());
    }

    Functionality(){ }

    public void setEvaluation(FunctionalityEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public FunctionalityEvaluation getEvaluation() {
        return evaluation;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
