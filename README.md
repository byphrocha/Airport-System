# Airport-System
This project serves as a simple foundation for flight management, allowing basic operations such as registration, reservation, and information retrieval. It's an example of applying object-oriented concepts and interacting with users through Java's standard input and output.

Main Functionalities: 

Flight Registration: Requests information from the user about a new flight.
Creates a Flight object with the provided data and adds it to a list of flights.

Seat Reservation: Enables the reservation of seats on a specific flight.
Checks the availability of the desired seat.
Associates a passenger with the reserved seat, maintaining a record of reserved seats for each flight.

Flight Information Inquiry: Allows detailed information inquiry about a specific flight.
Presents details such as origin, destination, departure date and time, total number of seats, and reserved seats.

Interactive Menu: Provides an interactive menu for users to choose from the available functionalities.
Allows users to navigate through the system's options.

Key Components:

Classes Flight and Passenger:
Flight: Represents a flight with its attributes (number, origin, destination, etc.) and methods to manipulate seat reservations.

Passenger: Represents a passenger with basic information.

Main Class (AtvIntegradoraCo): Contains the main method that starts the program.
Offers an interactive menu for system operations.
Implements methods for each menu option, such as flight registration, seat reservation, and flight information inquiry.

General Functioning:
Flight Registration: The user provides information about the new flight, which is used to create a Flight object and add it to the list of flights.

Seat Reservation: The user provides the desired flight number and passenger details.
The system checks seat availability and associates the passenger with the reserved seat.

Information Inquiry: The user provides the flight number to check specific flight details, including reserved seats and passengers associated with each seat.

