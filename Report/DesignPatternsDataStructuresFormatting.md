## Design Patterns , Data Structures and Formatting
  * Design Patterns really helps in many situations.. and you may implement them without really knowing
  that you are! 
  * Mainly, Creational Design patterns were the heroes in this project, Builder Pattern , Factory and Abstract Factory Methods , and Singleton.
  * The Design can really be considered as MVC, we have Controller(Game) that gets the input, and pass it to the Backend which
  contains all the logic (GameMaps,Rooms,Players ...) ,and when it receives the results it pass it to the Display part of that class.
  * I didn't separate the Controller from the view (for now),because in the case of Command Game, it may be hard ro consider that
  getting input from user(which is on command line two (with no difference from the display)) is not considered Displaying in a way or another..
  * In case we want to update the game maybe to Web application game, the creation of the **View** is so simple.. 
  because it is separated from the controller process already but in the same class.. 
  
  * Data Structures used in the Project is simple, Objects will include them selfes, and when we are dealing
  with the case of having more than one object saved, **Lists** were the heroes.
  * Some people said,, Arrays is better and simpler, but as Effective Java tells, and as the experiences that you went throw tells
  there is really many situations that the array will be very un useful..but, in class **Room** the Data structure that saves
  that values for the walls in the room is **Array** with default size **numberOfRooms** which is something have to be specified in our game .. if you want to add walls you will simply change the number
  of walls in the room,, add the new  directions in the Enum .. and everything will go okay ..
  * On the other side, that may be the only use of Arrays in the project.. **ArrayList** is used many times 
  to store the objects in it with the ability to shrink easily.. As is Chest content and many others..
  * **HashMap** is also used, when the case of having non integer based parameter like in Chest check method,
  it is used as a simple Mapping implementation of Map in java, initial capacity given is (1), because it is used mostly in that size,
  but as you know, if there is a need for more, it will automatically response..
    
  * With the grate plugins that you can add to InjelIJ IDE, one tap can do the job for you (day by day you get used to it).
  * Google-Java-Format plugin from google is used to check the format.   

