package org.texastorque.texastorque20155.subsystem;

import edu.wpi.first.wpilibj.DriverStation;
import org.texastorque.texastorque20155.feedback.Feedback;
import org.texastorque.texastorque20155.input.Input;
import org.texastorque.texastorque20155.output.Output;

public abstract class Subsystem {

    protected Input input;
    protected final Feedback feedback;
    protected final Output output;
    protected final DriverStation ds;

    public Subsystem() {
        feedback = Feedback.getInstance();
        output = Output.getInstance();
        ds = DriverStation.getInstance();
    }

    public final void setInput(Input input_) {
        input = input_;
    }

    //put values to dashboard
    public abstract void pushToDashboard();

    //initialize control loops/misc to 0
    public abstract void init();

    //run the subsystem (every 1/100 of a second)
    public abstract void run();

    //send values to robotoutput
    protected abstract void output();
}
