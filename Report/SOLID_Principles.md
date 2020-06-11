
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
   

