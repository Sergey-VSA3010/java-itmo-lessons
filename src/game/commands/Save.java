package game.commands;

public class Save implements Command {
    private final ReceiverCommand command;

    public Save(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.saveGame();
    }

    @Override
    public String toString() {
        return "CОХРАНИТЬ ИГРУ!";
    }
}
