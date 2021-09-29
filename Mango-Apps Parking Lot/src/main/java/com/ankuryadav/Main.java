package com.ankuryadav;

import com.ankuryadav.commands.CommandExecutorFactory;
import com.ankuryadav.mode.InteractiveMode;
import com.ankuryadav.service.ParkingLotService;
import java.io.IOException;

public class Main {
  public static void main(final String[] args) throws IOException {
    final OutputPrinter outputPrinter = new OutputPrinter();
    final ParkingLotService parkingLotService = new ParkingLotService();
    final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

    new InteractiveMode(commandExecutorFactory, outputPrinter).process();
  }
}
