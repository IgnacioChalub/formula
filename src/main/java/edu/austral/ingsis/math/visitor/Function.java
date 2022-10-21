package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitors.Visitor;

public interface Function {
    void accept(Visitor visitor);
}
