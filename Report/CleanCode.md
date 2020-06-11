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

