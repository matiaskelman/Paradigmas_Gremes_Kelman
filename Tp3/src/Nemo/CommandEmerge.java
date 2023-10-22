package Nemo;

public class CommandEmerge extends Command {

    {this.key = 'u';}

    @Override
    public void commandAction(Sub submarine) {
        submarine
                .getDepthManager()
                .ascend();
    }
}
