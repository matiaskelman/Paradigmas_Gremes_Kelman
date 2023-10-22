package Nemo;

public class CommandSubmerge extends Command{

    {this.key = 'd';}

    @Override
    public void commandAction(Sub submarine) {
        submarine
                .getDepthManager()
                .descend();
    }
}
