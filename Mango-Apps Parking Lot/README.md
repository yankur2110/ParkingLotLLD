1. Problem Statement:
    1. Design a parking lot which can hold ‘n’ cars of different colour and different registration numbers.
        1. every car is issued a ticket for a spot (spot has been assigned based on the nearest entry point).
    2. Your application should be able to support following queries:
        1. i/p: colour
            1. o/p: registration numbers of all cars with that colour.
        2. i/p: registration number
            1. o/p: slot number for that car
        3. all slot numbers where a car is placed.
2. Note: we are going to use this functionality using command line i.e.,
3. $ create_parking_lot 6  --> this will create a parking lot of size 6.
   $ park KA-01-HH-1234 White --> park the car, slot 1 would be allocated.
   $ park KA-01-BB-0001 Black --> park the car, slot 2 would be allocated.
   $ leave 2 --> slot 1 would be free now.
   $ status --> will show all the slots where a car is placed i.e., 1.
   $ registration_numbers_for_cars_with_colour White --> KA-01-HH-1234
   $ slot_numbers_for_cars_with_colour White --> 1.
   $ exit

Solution explained:

1. we are creating different packages:
    1. *command*: idea is to create each command as a different class.
    2. *exception:* we can have different type of exceptions like ParkingFull, SlotNotFound etc. We are creating a separate exception class for each of them.
    3. *mode:* we can have different mode for reading the input for e.g., file, command line. Core logic remains the same.
    4. *model:* we will create model classes in this package.
    5. *service:* we are creating a *ParkingLotService* which will be the main service and handle the parking .
2. we have created a class *OutputPrinter*.
    1. this class is used to print the output. For now we are printing the output in the console only we are using systout whereas in future, we might need to print somewhere else. In that case, we don’t need to change in actual methods.. we just need to update this class.
3. core functionality of the system lies in ParkingLotService class.
