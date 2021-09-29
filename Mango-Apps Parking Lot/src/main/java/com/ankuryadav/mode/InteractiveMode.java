package com.ankuryadav.mode;

import com.ankuryadav.OutputPrinter;
import com.ankuryadav.commands.CommandExecutor;
import com.ankuryadav.commands.CommandExecutorFactory;
import com.ankuryadav.commands.ExitCommandExecutor;
import com.ankuryadav.exception.InvalidCommandException;
import com.ankuryadav.model.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode {

  private CommandExecutorFactory commandExecutorFactory;
  private OutputPrinter outputPrinter;

  public InteractiveMode(
      final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    this.commandExecutorFactory = commandExecutorFactory;
    this.outputPrinter = outputPrinter;
  }

  public void process() throws IOException {
    outputPrinter.welcome();
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final String input = reader.readLine();
      final Command command = new Command(input);
      processCommand(command);
      if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
        break;
      }
    }
  }

  protected void processCommand(final Command command) {
    final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
    if (commandExecutor.validate(command)) {
      commandExecutor.execute(command);
    } else {
      throw new InvalidCommandException();
    }
  }
}
