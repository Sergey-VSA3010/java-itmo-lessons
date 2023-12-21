package game.commands;

public class Load implements Command {
    private ReceiverCommand command;

    public Load(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.loadGame();
    }

    @Override
    public String toString() {
        return "ЗАГРУЗИТЬ ИГРУ!";
    }
}

