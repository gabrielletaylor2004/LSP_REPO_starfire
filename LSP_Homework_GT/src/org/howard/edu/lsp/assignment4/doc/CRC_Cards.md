CRC Card
Class: AirTransponder

Responsibilities:
- Broadcasts the aircraft type and flight data
- Encodes data into high-density packet format

Collaborators (if any):
- N/A

Assumptions (if any):
- The information broadcasted is always accurate.



CRC Card
Class: ATCReceiver

Responsibilities:

- Accepts incoming transponder data packets
- Forwards packets for unpacking

Collaborators (if any):

- AirTransponder
- ATCUnpacker

Assumptions (if any):

- N/A



CRC Card
Class: ATCUnpacker

Responsibilities:

- Decodes and validates the high-density packet format of data broadcasted by the transponder
- Extracts the aircraft type and flight details
- Forwards unpacked data to be stored

Collaborators (if any):

-ATCReceiver
-ATCStore

Assumptions (if any):
- Package format specification is known.
- Validation rules for assessing packet format are predefined.



CRC Card
Class: ATCStore

Responsibilities:

- Receives decoded package data
- Stores aircraft type to a database
- Stores flight data, such as flight number, altitude, speed, and location to a database

Collaborators (if any):

- ATCUnpacker
- GraphicsDisplay
- DangerAnalysis
- ATController

Assumptions (if any):

- Each aircraft has a unique flight number or identification.



CRC Card
Class: GraphicsDisplay

Responsibilities:

- Retrieves aircraft data from database
- Creates a graphical display of aircraft data for controller
- Updates visual display when new data is provided
- Refreshes display data every 10 seconds
- Displays danger alerts on screen

Collaborators (if any):

- ATCStore
- ATCAlert

Assumptions (if any):

- The display system supports frequent refreshing.
- The display refresh interval remains fixed at 10 seconds.



CRC Card
Class: DangerAnalysis

Responsibilities:

- Analyzes flight data such as locations and altitudes
- Detects potential collisions and/or unsafe altitudes
- Creates and forwards danger notifications for controller

Collaborators (if any):

- ATCStore
- ATCAlert

Assumptions (if any):

- Safe distance thresholds between aircrafts are predefined.



CRC Card
Class: ATCAlert

Responsibilities:

- Receives danger alert notifications
- Notifies the controller of the alerts

Collaborators (if any):

-DangerAnalysis
-ATController
-GraphicsDisplay

Assumptions (if any):
- N/A



CRC Card
Class: ATController

Responsibilities:

- Requests aircraft details from the database
- Displays aircraft details received from database
- Displays danger alerts

Collaborators (if any):

- ATCStore
- ATCAlert
- GraphicsDisplay

Assumptions (if any):

- All data in the database is valid and updated.





Note of AI/Internet usage: I used online sources to help to write assumptions for some classes.




