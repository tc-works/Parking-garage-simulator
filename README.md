# Parking-garage-simulator

CODING TASK

Simulation of a parking garage in Java

Given requirements:

- The amount of the parking decks and parking places is not given and has to be changeable
- The parking garage has to support the vehicle types car and motorcycle
- The vehicles must also exist outside of the parking garage
- Every vehicle has a unique ID (license plate number)
- It must be possible to park and unpark the vehicles in the parking garage
- It has to be possible to show the free parking places and to search for a car and its place

How to start and what is needed:

- Use Eclipse for programing the simulation 
- Use the WindowsBuilder extension to create the GUI with buttons, input text fields and a text field for output
- Create the vehicles as her own class
- Create a abstract class to define the types of vehicles
- Use a two dimensional array with the parking decks and the parking places for storing the vehicle id numbers in it
- Create the parking garage as her own class with the two dimensional array in it
- Use an arraylist for saving the already created vehicle ids
- Create a class for action tasks like showing the free parking places, creating and parking a vehicle, unparking a vehicle and more

Which classes are needed ?

- „Parkhaus“ to create the object parking garage
- „Fahrzeug“ to create the objects of the vehicles
- „FahrzeugTyp“ to give predefined attributes for the type of a vehicle (this is a abstract class where no object can be created
- „Simulation “ in which action tasks are programed (like for getting the parking status of a vehicle or checking if the ID already exists when it will be created)
- „Window “ for the visualization in a GUI (Graphic User Interface)
- „ButtonListener “ in which is programmed what happens by clicking the buttons

How does my result it look like ?

![image](https://user-images.githubusercontent.com/109070237/178240742-fa4a3f37-3b58-4724-97d4-a59c88ef7d50.png)

