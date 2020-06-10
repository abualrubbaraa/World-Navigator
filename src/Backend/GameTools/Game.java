package Backend.GameTools;

import Backend.Enums.Directions;
import Backend.Enums.ItemEnums.DoorCommands;
import Backend.Enums.MainCommands;
import Backend.Enums.NavigationCommands;
import Backend.Interfaces.Containable;
import Backend.Interfaces.Wallable;
import Backend.Items.*;

import java.util.Scanner;

public class Game {

    private Map map;
    private Player player;
    private Room currentRoom;

    public Game(Map map,Player player){
        this.map=map;
        this.player =player;
        this.currentRoom=map.getStartRoom();
    }
    public void init(){}

    public void start(){

        System.out.println("Hello! Welcome to the game");
        boolean finishGame = false;
        showMainOptions();

        while(!finishGame) {
            char commandEntered = getCharInput();

            while(checkIfNavCommand(commandEntered)){
                commandEntered = getCharInput();
            }

            checkIfMainCommand(commandEntered);

        }

    }


    private void checkIfMainCommand(char commandEntered)  {
        // not yet
        if(commandEntered == MainCommands.Look.asChar) {
            System.out.println(this.currentRoom.look(this.player.getPos(),this.player.getFlashlight()));
            if(! this.currentRoom.isDark(this.player.getFlashlight()) ){
                showSubOptions(this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent());
                boolean finishSuboptions = false;

                while(!finishSuboptions) {
                    char subCommand = getCharInput();
                }

            }
            return;
        }
        // Done
        if(commandEntered == MainCommands.Use_Flashlight.asChar) {
            if(this.player.hasFlashlight())
                if( this.player.getFlashlight().switchFlashlight() ){
                    System.out.println(FlashLight.className()+" switched to "+((this.player.getFlashlight().isLit()==true)?"on":"off"));
                    return;
                }
            System.out.println("You dosn't have Flashlight..");
        }
        // Done
        if(commandEntered == MainCommands.Turn_Lights.asChar) { this.currentRoom.switchLights(); }
        // Done
        if(commandEntered == MainCommands.Player_Status.asChar) { displayPlayerStatus(); }
        // not yet
        if(commandEntered == MainCommands.Restart.asChar) {
            System.out.println("Restarting ..\n \n \n");
            start();
        }
        // Done
        if(commandEntered == MainCommands.Quit.asChar) {
            System.out.println("Ending game ..");
            System.exit(1);
        }
    }

    private boolean checkIfNavCommand(char commandEntered) {

        if(commandEntered == NavigationCommands.Left.asChar){
            this.player.moveLeft();
            System.out.println("Facing "+this.player.getPos());
            return true;
        }
        if(commandEntered == NavigationCommands.Right.asChar){
            this.player.moveRight();
            System.out.println("Facing "+this.player.getPos());
            return true;
        }
        if(commandEntered == NavigationCommands.Forward.asChar){
            System.out.println("Facing "+this.player.getPos());
            if(this.currentRoom.loofIfDoor(this.player.getPos())){
                Door tempDoor = this.currentRoom.getIfDoor(this.player.getPos());
                if(!tempDoor.isLocked()){
                    this.currentRoom = tempDoor.getSideRoom();
                    System.out.println("Entered new Room..");
                }
            }
            return true;
        }

        if(commandEntered == NavigationCommands.Backword.asChar){
            System.out.println("Facing "+this.player.getPos());
            if( this.currentRoom.loofIfDoor(Directions.getOppositeDirection(this.player.getPos())) ){
                Door tempDoor =this.currentRoom.getIfDoor( Directions.getOppositeDirection(this.player.getPos() ) );
                if(!tempDoor.isLocked())
                    this.currentRoom = tempDoor.getSideRoom();
                    System.out.println("Entered new Room..");
            }
            return true;
        }
        return false;
    }


    private char getCharInput() {
        Scanner in = new Scanner(System.in);
        char commandCharecter;
        while(true) {
            String tempIn =in.next();
            while(tempIn.length()!=1){
                System.out.println("Please enter valid command character ..");
                tempIn = in.next();
            }
            commandCharecter=tempIn.charAt(0);
            for (MainCommands c : MainCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            for (NavigationCommands c : NavigationCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            System.out.println("** command character entered not from the options **");
        }
    }
    private int getInput(int from,int to,String msg){
        Scanner in = new Scanner(System.in);
        int commandNumber;
        boolean first=true;
        System.out.println(msg);
        do {
            if(!first){ System.out.println("** number not in the range **"); }
            while (!in.hasNextInt()) {
                System.out.println(msg);
                String input = in.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            commandNumber = in.nextInt();
            if(first) { first = false; }

        } while (commandNumber < from || commandNumber > to);
        return commandNumber;
    }

    private void showSubOptions(Wallable wall) {
        notNull(wall);
        System.out.println("You have these sub-options :-");
        String lookValue = wall.look();

        if(lookValue == Door.className()){
            for (int i=0 ; i < DoorCommands.values().length ; i++)
                System.out.println(DoorCommands.values()[i].asInt+" -> "+DoorCommands.values()[i]);
        }
        if(lookValue== Painting.class.toString()){

        }
        if(lookValue== Mirror.class.toString()){

        }
        if(lookValue== Chest.class.toString()){

        }
        if(lookValue== Seller.class.toString()){

        }


    }

    private void showMainOptions() {
        System.out.println("# Main options :-");
        displayNavigationCommands();
        diplayMainCommands();
        System.out.println("    **************  ");
    }
    private void diplayMainCommands() {
        for (MainCommands command:MainCommands.values()){
            System.out.println(command.asChar+" -> "+command);
        }
    }
    private void displayNavigationCommands(){
        for (NavigationCommands command:NavigationCommands.values()){
            System.out.println(command.asChar+" -> "+command);
        }
    }
    private void displayPlayerStatus(){
        System.out.println(" *** ");
        System.out.println("    Your direction : "+this.player.getPos());
        System.out.println("    You have : "+ this.player.getMoney()+" of Gold!");
        System.out.println("    You have those items :-");
        for(Containable item : this.player.getItems())
            System.out.println("    "+item.getDescription());
        if(this.player.hasFlashlight())
            System.out.println("    "+FlashLight.className());
        System.out.println(" *** ");
        showMainOptions();
    }
    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}

