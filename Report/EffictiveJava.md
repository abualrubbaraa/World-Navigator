
## Effective Java 

  -This refference is amazing.. yes we may see some of it's explenation example very complex! but it rase the level of your 
  Design thinking and the way that should programming really be..
  
  ### ITEM 1:  CONSIDER STATIC FACTORY METHODS INSTEAD OF CONSTRUCTORS
  
  - One of the advantages in the book about static factory methods is the lack of **Naming** ability in constructors 	 and openability for it in the statis methods.. i really relt that while adding **.create** static method 
	  to the Game class, so when you are creating the Game object you really feel it rather than just Game()...

  - In Wall we used plain class as a null object pettern.
  
  ### ITEM 2: CONSIDER A BUILDER WHEN FACED WITH MANY CONSTRUCTOR PARAMETERS
  
  - Chest,Door,Game,Key and many more used Builders to help for their creation..
  - It's really usefull that you can see a **Name** for each parameter you sent, and i'ts really good
  that you can easly ignore other parameters.. 
  - In **Player** builder, you can give him a flashlight or not, you can also spicify his direction or leave it as default,
  you will set it anyway later maybe.. but for now, thanks for builders that helped here..
  
  ### ITEM 3: ENFORCE THE SINGLETON PROPERTY WITH A PRIVATE CONSTRUCTOR OR AN ENUM TYPE

   - In the project, Enums helped a lot spiceally for making the commands, think about it, the command is in a 
   way or another singelton, one instance of it can help everyone.. we have a lot of enums ..spiceally command enums.
   
  ### ITEM 5: PREFER DEPENDENCY INJECTION TO HARDWIRING RESOURCES
  
  - All the static functions is the classes dosn't need any dependency from that class, main used to 
  implement something like className which helped the other classes, or is in classes that really can work fully static,
  like the GameFileBuilder which is responsable for serializing and deserializing the games to files and saving them..
  
  ### ITEM 6 : AVOID CREATING UNNECESSARY OBJECTS
  
   - In many of our classes spiceally the Game, if there is an object that can be used in many methods
   ,we take this common use in one method to prevent the cost of new objects..
   - getNumberInRange(int from, int to)  method is responsable of all the Integer inputs in that class.. giving that almost every 
   method need Scanners in a way of another.. but yes, with good organization will be no unnecessary objects.
 
 ### ITEM 7: ELIMINATE OBSOLETE OBJECT REFERENCES

   - notNull() method may be the most popular in the project,, handling any null issue or the other types
    of Exceptions is very important.. even than sometimes you are sure about everything.

### ITEM 9: PREFER TRY-WITH-RESOURCES TO TRY-FINALLY

   -All the methods that uses try and catch are having them with resources, GameFileBuilder class
   have many of them since it is dealing with files :)
   
### ITEM 12: ALWAYS OVERRIDE TOSTRING
   - As the word (Always) means, every class in the project ovverrides the toString() method, just one 
   simple try to use the base toString() will show why to override it, any time that user will use toString he can see
   the base information that i provided rather than the class name with it's memory address..
   - In class Door for example :
   @Override
       public String toString() { return this.name + " Door";}
     
### ITEM 15: MINIMIZE THE ACCESSIBILITY OF CLASSES AND MEMBERS
   
   - In the program, most of the times you can't access anything excepty the interface method, 
   the program will cast the ocject to it and use your public implementation of that method.
   (Checkable)(item).check();
   - All Instance fields of public classes are private in the program..

### ITEM 16: IN PUBLIC CLASSES, USE ACCESSOR METHODS, NOT PUBLIC 
    
   - All the instances (private) can't be accesses or modified directly, they sometimes have setter or getters
   that will give the accessability in some conditions..
   - In class Mirror : public void setInside(Key key){
                               notNull(key);
                               this.itemIn=key; }
   -> only by calling setInside you can change it, ofcourse after applying notNull(); method wit will throw
   a new Exception if you send something null ... Or NullKey..
   -> without this, and by direct modification their will be a big problem if bad input entered.

### ITEM 18: FAVOR COMPOSITION OVER INHERITANCE

   - All the classes that contain other classes, it just have a container for it, and will recive it from outside
   (not inhereted, composed).
    private Key itemIn;
    public void setInside(Key key);
    -> so as you can see in Painting Class, it may have a key inside it, but it will recive it from out side
    and will not affect it by any chance..
    
### ITEM 20: PREFER INTERFACES TO ABSTRACT CLASSES   
    
  - After thinking, we didn't use any abstract class in out design,Interfaces was the hero, spiceally the One method ones.
  - Some times it may be hard to use interfaces in the cases that you have common behavior, but we would rather
  using the interface and handle that part alone, Some times we may face a problem in the future if the classes were abstract
  and we want to change there behaviors, but in interfaces, nothing set before.. just the method you need and you can implemented by your way.  
    
###  ITEM 22: USE INTERFACES ONLY TO DEFINE TYPES
    
   - Just to mentions that there is no interfaces that contains any final value or we deal with it worngly be saving 
   data in it..
 
### ITEM 26: DON’T USE RAW TYPES

   - Yes, there is also no raw types in this program.. actually the hole design is build against this idea!
   - in **Chest** class you can see that is contains **Containable** objects.. and we used ArrayList to store them, let's look :-
    private ArrayList<Containable> chestContents;
    as you can see, if you would like to add something to the chest, it's spicified to be Containable.. 
    -> of course if you added bad input, addItem method will prevent this from happening ...
    
### ITEM 28: PREFER LISTS TO ARRAYS
    
   - We all know that arrays are good in general, but the idea of having **static** size is scary!
   - In this program we used Arraylists most of the times, extendable with the ability to control it..    
    
### ITEM 34: USE ENUMS INSTEAD OF INT CONSTANTS

   - 9 Enums used (at this time) in the program, it's very helpful spiceally if you want to set some details about your constant value!
   WEST(3); 
   public int asInt;
   Directions(int asInt) { this.asInt =asInt; }
    -> here you can see how it helped by by linking integer value to an enum to make it more useful!
    
### ITEM 35: USE INSTANCE FIELDS INSTEAD OF ORDINALS

  - When i first used Enums, i liked to ordinals because of the ease to use it, but the problems started to occure when
  you need to change there numbers..
  - All the enums in the program doesn't have ordinal(); we deleted them all ..
  
###  Item 49: Check parameters for validity

   - Every method have a validations private method to check the parameters..some times for finding nulls, and other times 
   for checking specific requirement..
   
   private Painting(Key key){ 
           Objects.requireNonNull(key);
   -> in this method .. we checked the parameter sent (Also by the use of the already existing Objects.requireNonNull method).
   
### Item 50: MAKE DEFENSIVE COPIES WHEN NEEDED
    
   - In this program we apply this in a different way, if you have the options to restarct the game, that means
   that you need your initial values back, but because of the problem of referencing,, we make a cope(AS .ser) file
   that will be used again to initialaize again safly ..
   public static Game create(String gameName, GameMap map, Player player, int timeForGame)  {
           Game newGame = new Game(gameName,map,player,timeForGame);
           GameFileBuilder.saveGameInfo(newGame);
           return newGame;}
   -> the problem of other solutions is that most of them required public constructor to create deference instance, but
   since why have this option we used it.

### ITEM 51: DESIGN METHOD SIGNATURES CAREFULLY
    
   - Method names are picked carefully, you can feel the harm by bad signatures by yourself when mainting or edition your code.
   - Most of them methods have **one** parameter.
   
### ITEM 54: RETURN EMPTY COLLECTIONS OR ARRAYS, NOT NULLS

   - We have at least 6 NullObjects that they can be send back if (null) state happend and we still sending somehting.
   - Empty Arraylist is sent when a **Chest** is empty and you asked for it's content!
    
### ITEM 58: PREFER FOR-EACH LOOPS TO TRADITIONAL FOR LOOPS
     
   - For-Each is used mainly in the project, ex from in Class Chest :-
   for (Containable item:chestContents) { Objects.requireNonNull(item); }
             
### ITEM 59: KNOW AND USE THE LIBRARIES
   
   - In the project, whenever their is a case that can be handled by a library, it was used..
   - Objects (cheching nulls for example), Timer (game timer) ...  
    
### ITEM 64: REFER TO OBJECTS BY THEIR INTERFACES

   - This is just an amazing note, while we are implementing an interface, and we are using that object 
   in a situation that uses the interface, the interface is used to refer always (All the design works with interface referencess).
    if ((Checkable.ForOpenablility) this.currentRoom
    .getWallInDirection(this.player.getDirection())
    .getWallContent()).check());
  -> in this example you can see how we really doesn't need to refer to the containing object spicefecly.. 
  because we are in a check command process.. just refer to **Cheackable**

### ITEM 69: USE EXCEPTIONS ONLY FOR EXCEPTIONAL CONDITIONS
### ITEM 72: FAVOR THE USE OF STANDARD EXCEPTIONS
### ITEM 77: DON’T IGNORE EXCEPTIONS

   - In the program, all the Exceptions used in STANDARD ones(They achieve the job!).
   - No Exception is ignored, some of them send a message, and some others send where exactly is the error..
 
