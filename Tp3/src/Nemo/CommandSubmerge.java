package Nemo;

public class CommandSubmerge extends Command{

    {this.key = 'd';}

    @Override
    public void move(Sub submarino) {
        submarino.getCoordenadas().descend();
    }
}
