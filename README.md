# World-Navigator
### Hello! 
- This repo contains the source code for a World Navigator game.
- For more details see the Reports here :-

| Report Part | link |
| ----------- | ----------- |
| SOLID principles | https://github.com/abualrubbaraa/Report/Solid_Principles |
| Effictive Java | https://github.com/abualrubbaraa/Report/EffictiveJava |
| Design Patterns | https://github.com/abualrubbaraa/Report/DesignPatterns_DataStructures_Formating |
| Clean Code | https://github.com/abualrubbaraa/Report/CleanCode |
| Clean Code | https://github.com/abualrubbaraa/Report/MyExperience |



## Solid Principles
   - Since uncle Bob published that paper in 1995, everybody started to pay more and more attention to the Design.
   - In 2020, atfer 25 years of that resersh, we still see our selfes making many mistakes, but day after day we are getting better and better. 

   - In this page i am going to descuss my design for World Navigator Game, let's start..
   
   ##### 1. Single Responsibility principle.
   - My favorite principle, i think there is a reason that they added its letter in the beginning,the hole picture of your project and design will be more clear when you really 
   care about this principle..
   - In my Project -which is a **game** - it's more important to try to distinguish between everything and give it it's own 
   responsability , they prefere to make every object alone,less copling for sure and not that much care about memory(in the trade with performence ..).
   - Each class in the project is a stand a lone enitity, you can actually use it in different situations and projects.
   - In the Project you can find that the **Wall** with his ability to **contain** stuff on it, makes it really challengingm but with the help of **Interfaces** we will have may solutions.
   
   1. The Wall is a class that can **contain** object, not every object but mainly who we can **look** at them. When we look around us we will see that the wall 
   is an object who can be plain or have stuff on it(or connected to it). And that is exactly how i build my Wall class!     
    private Wallable wallContent;
    setWallContent(Wallable content);
    getWallContent();
    -> Wallable here is an interface that describes what you need in our game to be contained in the Wall.. it includes **look()** method, you remember this work right?  
    -> I hade a design firstly that i made the wallContent as an array, so the idea will be that the wall can contain many items on different positions, but in our game.. 1 item on the wall 
    had been considered to make it simpler since we are caring more about the Designing.
    
   2. Another beautiful class is **Painting** class, it's **Wallable** by the way and it's also **Checkable** for it's content..
    in our game we can consider that we will the Painting as a container too, it can have a **Key** inside it! Key here is containable right?
    -> The Room by implementing Wallable can be added to the wall! but nether it or the wall can touch the others stuff.. you can look and get the Painting (or it's content)if you are facing a door..
    private Key itemIn;
    the only instance Painting have, with can be empty so you can use the Room class in other situations as we said before..
    So, **Painting** tells you 2 main things :
        1. The image in it,which in our case will be just "Painting" when we **look** at it, so it implement lookable.
        2. The ability to contain a key in it, and since then we added **Checkable.ForContent** that will be responsable for this job.. (yes there is Cheackable sub interfaces).
    
   3. GameMap class is really nice too, you may be afraid when you hear it the first time remembering the days of implementing the Maps data structures,
    but we i thinked deeply in it i found it a little bit simple..
    -> the Map can have all the rooms in it, but since when we are dealing with a game look like a maze,
    the really important information for us is **Strarting** room and **Ending** one, build your rooms, connect them , save the start & end and everything will be alreight!  
    -> Items in the GameMap is stored uniquely too! It's something related to it (not for the Game or a Player), and 
    the reason of storing is the huge performance that retriving it will be (remember, its like a maze, and the room can't really do some **Not** in it's responsability).
    
    
   ##### 2. Open/Closed principle.
   
   - Some people may think that this principle is simple or maybe easy to check, just with some practice on the generaliztion concepts and maybe some **Behavioural**
    design patters.. but for me actually the hard part is to know when is the right time to stop thinking about what can be added / changed in the future,
    you have to take in considration your the real life situations and facts so it may help you to predect sometimes
   
   - In my project if you thought one day about adding something new, can be on a Wall, and maybe contain something,
   you can really add it with 2 moves, implement **lookable** and **Checkable** interfaces.. and the rest of the program will understand everything about your new
   item without any touch.. because if they want to see what's inside you, check method will give them everything that thay want..
   
   - I heard someone saying that what if i want to add a lock on this new item, so now i can't really act with the others since i added 2 seperate behaviours 
   that will affect each others ,, because if it's locked i can't get what inside! In this case you have many solutions actually not just one.. you have subInterfaces in the Checkable interface
   that can help you, and you have Lockable interface also to help if your behavioure is really different and may relate to others.
   
   ##### 3. Liskov substitution.
   
   - Althogh these no inhereted classes (except for **nullObjects** ofcourse) in this project, since this project doesn't have
   that much similarites so you consider this principle a lot(it will add challenge on how to make them similer in a right way..) , but
   this principle is very important since we may misunderstood the Inheretance sometimes while compairing with real life situations (which is not always right from the programming side).
   
   ##### 4. Interface Segregation principle.
   
   - Dealing with interfaces and how to use them right is something interesting.. once you finish your brain storming session trying to have
    **one** method interface that will help you, you will feel good while looking how much you inhanced your design..
   
   - In the project, even if you think that you are **Checkable** you still have to decide how you will behaviour be, there is 
   3 **Inner One Method Interfaces** that will help you each by it's way. 
   
   - You probably can see that all of the interfaces actually have 1 method, but considering Tradeble, you will see 3..
   and when i was thinking about it, when you say trade this will indecate both! buying and selling!
   - Firstly i made the interface like this 
    public interface Tradable {
        public ArrayList<Containable> getItems();
        public void sellItme();
        public void butItem();
    }
   And as you can see there is a problem here, imagine if we have in the future a class that have the ability
   to buy items? if we implemented the Trade we will have to deal with getItem and sellItem methods!
   - So after thinking, why not to make each one of the behaviors as a stand alone one? and we can make the interface extends another in the
   case of needing it! see the final decision ..
   public interface Tradable extends Buyable, Sellable {
       public ArrayList<Containable> getItems();
   }
   -> And as you can tell,, Buyable and Sellable contains **One** method represinting their behaviour.
    
   ##### 5. Dependency inversion principle.
   
   - Almost all the classes that may contact with each others is comunication with an general interface that will be implemented in each 
   class in a defferent way.. (Maybe not and then we can consider strategy patterns) ..
   - Not just interfaces, any kind of separation is considerer in this principle, if you are having a class that contains many diffrent objects 
   you have to make sure that they doesn't get linked or connected in a way or another ..
   - **Player** Class in the project is having different types of items inside it, but **Containable** interface took care of that,
   it have the functioinalities that they need to use inside the Player class and nothing else!
   
   

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
 

## Design Patterns , Data Structures and Formating
  * Design Patterns really helps in many situations.. and you may implement them without really knowing
  that you are! 
  * Mainly, Creational Design patterns were the heros in this project, Builder Pattern , Factory and Abstract Factory Methods , and Singelton.
  * The Design can really be consedered as MVC, we have Controller(Game) that gets the input, and pass it to the Backend which
  contains all the logic (GameMaps,Rooms,Players ...) ,and when it recieves the results it pass it to the Display part of that class.
  * I didn't separate the Controller from the view (for now),because in the case of Command Game, it may be hard ro consider that
  getting input from user(which is on command line two (with no difference from the display)) is not considered Displaying in a way or another..
  * In case we want to update the game maybe to Web application game, the creation of the **View** is so simple.. 
  because it is separated from the controller process already but in the same class.. 
  
  * Data Structures used in the Project is simple, Objects will include them selfs, and when we are dealing
  with the case of having more than one object saved, **Lists** were the heros.
  * Some people said,, Arrays is better and simpler, but as Effective Java tells, and as the experences that you went throw tells
  there is really many situations that the array will be very un useful..but, in class **Room** the Data structure that saves
  that values for the walls in the room is **Array** with default size **numberOfRooms** which is something have to be spicified in our game .. if you want to add walls you will simply change the number 
  of walls in the room,, add the new  directions in the Enum .. and everything will go okay ..
  * On the other side, that may be the only use of Arrays in the project.. **ArrayList** is used many times 
  to store the objects in it with the ability to shrink easly.. As is Chest content and many others..
  * **HashMap** is also used, when the case of having non integer based parameter like in Chest check method,
  it is used as a simple Mapping implementation of Map in java, initial capacity given is (1), because it is used mostly in that size,
  but as you know, if there is a need for more, it will automaticlly recponse..
    
  * With the grate plugins that you can add to Injelij IDE, one tap can do the job for you (day by day you get used to it).
  * Google-Java-Format plugin from google is used to check the format.   

## Clean Code 
 
  - As we may agree, reading Robert C. Martin book can get booring sometimes,i personally choosed to watch his vedio course discussing Clean Code book,
  along side with the information about moon ,itoms and more and more.. Clean code book really discuss with you many situations that
  you went throw, and gives you the solutions with the resasons.. 
  - After reading the book or watch the videos you will have in your back head alot of notes that you will 
  remember while programming your projects.. Now, i am going to duiscuss some parts of his book, the rest ether descusses before in Effective java
  or some avoid parts.   

#### Meaningful Names

 - All the names (classes, methods and instances) are picked curefull.
 
 - Use Intention-Revealing Names : In Calss Key :( private final String **relatedLock** ; ) you can tell for sure whats the intent of that variable, even when you are using getters for it, it will be understandable immedeatly .
 
 - MAKE MEANINGFUL DISTINCTIONS : Tradable Interface. getSellList() and getItems(), You can see here that you can use these methods in any Tradable class and you can tell what to retreve for them. (althoug its very general)
 
 - ADD MEANINGFUL CONTEXT : we considered this in every merthod we used in the project, all same contests will be grouped toghether so we will know
 what heppens ther easly.. 
 if (commandNumber == TradingCommands.Buy.asInt) runBuyProccess(seller, sellerItems);
           else if (commandNumber == TradingCommands.Sell.asInt) runSellProcess(seller);
           else if (commandNumber == TradingCommands.List.asInt) showItems(sellerItems);
           else if (commandNumber == TradingCommands.Finish.asInt) break;
 
 #### Functions 
 - Small : almost every function in the project is in the resonable range of function size.. you may found some exceptions in the main functions in Controllers .. they just call methods inside them, but their is a lot of sub methods some times..
 
 - DO ONE THING : very important note, we tried to really make every function dose whathis name tells, if their is sub 
 functionalities related to that function, it will be saperated in other stand alone ones and called.
 -> before we were thinking why to do this? is READABILITY that important?(readability :) ),will yes .. try to maintain your code if you are not having small do one thing job
 and see..
 
 - USE DESCRIPTIVE NAMES :- here is some examples from the project.. and let's guess what they do?
    showPlayerKeys();
    getWallContent();
    runForwardCommand();
 - Flag Arguments : there is no flag arguments at all in the project.. some people says, flag arguments == bad design..
 
 -Output Arguments : As the auther said, mainly any output can be passed to method for displaying/outputing it.. and in the project 
 by the simulation of MVC structure, controllers do the logic and sends results, controllers handle them and send them to view!  
 
 - COMMAND QUERY SEPARATION : every accessable instance  have a uniqe query, and that dosn't mean that the instance can't be accessed with other instances.
 
 - PREFER EXCEPTIONS TO RETURNING ERROR CODES : Their is no error codes in the project, if there is a mistake it will be handled by its related exception
 and that dons't include some specific  situations when dealing with command line input commands.. ("** command character entered not from the options **"")
 because it will send this message for him for example and waits for input again, it's not user friendly game to exit when he entered bad command spiceally in Command line game!
    
 #### Comments 
 
 - EXPLAIN YOURSELF IN CODE : if you can really think that the code you see in a comment (good names and understandable logic),
  that means your good, let's see this if  statement :-
  if (lootedKey.getDescription() == NullKey.description()) System.out.println("Empty");
  
  - Good Comments -> TODO Comments : their is one comment in the project, telling the programmer to 
    that this part of the class can be separated as frontend when needed ..  

#### Formating 
  
  - UNCLE BOB’S FORMATTING RULES : okay, what about google-java-format?
  
### Objects and Data Structures

  - Hiding Structure : The design of the project dosn't enable you to get any other detail or information that you can have,
  also, by the  our project structure .. you will see your abstracted options only, call them and see the results ,, what happened there? only Backend knows..
  
  - DATA TRANSFER OBJECTS : Of course there is nothing like this in the project, but again, isn't that also a bad design when you see something like this?

### Error Handling

  - DON’T RETURN NULL
  - DON’T PASS NULL
            -> need to pass/return null ? did you saw our NullObjects? .. 
            
## World Navigator Project, Lessons and Experences.. 

### What can i say?
1. Over engineering is devil,  you have to keep in mind that Simple is always better .. sometimes the best design is to get it done.!

2.  "Best design is to get it done" ? , on the other hand .. if you build a good design and discussed all the situations if possible, you will see great results .. 

3. Don't overthink the future.. if their is a part in your project that you didn't know how you are going to deal with or to solve.. Just start doing it.. sometimes you will see that those parts are easiest that the rest of your project!

### Q&A

# How many designs did you build until you choose the last one?
 - Well , i can say (3)..  I really spend all the time exploring how to design and reading and watching are related useful resours .. but sometimes you just need to start going in details  so you can fill these gaps in your voision .. 
-> One of the designs that i had built  includeed  the following :
Wall with 2 sides .. 
Wall can be in two rooms , each one of them on a side.
Wall can have many items in many directions .. you have to spicify where to look ..
Items? items just need to implement **Lookable** interface which includes 
look();
runCommand(Command command);

but, while reading a game design book, they said the in game development .. its better always to separate everything ,even if it's not possible in reality (2 rooms connected by outside reference ). So i decided to change everything after taking that on considration ..

