package Nemo;

public class CommandRelease extends Command{

    {this.key = 'm';}

    @Override
    public void commandAction(Sub submarine) {
        submarine
                .getDepthManager()
                .releaseCapsule();
    }
}
