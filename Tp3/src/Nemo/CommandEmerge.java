package Nemo;

public class CommandEmerge extends Command {

    {this.key = 'u';}

    @Override
    public void move(Sub submarino) {
        submarino.getCoordenadas().ascend();

    }
}
