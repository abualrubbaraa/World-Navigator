package Controller;

import Backend.Enums.BaseCommands;
import Backend.Enums.Directions;
import Backend.Enums.ItemEnums.*;
import Backend.Enums.NavigationCommands;
import Backend.GameTools.GameMap;
import Backend.GameTools.MyTimer;
import Backend.GameTools.Player;
import Backend.GameTools.Room;
import Backend.Interfaces.*;
import Backend.Items.*;
import Backend.Items.NullObjects.EmptyKey;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private GameMap map;
    private Player player;
    private Room currentRoom;
    private MyTimer gameTimer;
    private int timeForGame;


    public Game(GameMap map, Player player, int timeForGame) {
        this.map = map;
        this.player = player;
        this.currentRoom = map.getStartRoom();
        this.timeForGame = timeForGame;
    }

    public void init() {

    }

    public void start() {

        System.out.println("Hello! Welcome to the game..\n Good Luck :) \n");
        gameTimer = new MyTimer(this.timeForGame);
        boolean finishGame = false;
        showMainOptions();

        while (!finishGame) {
            char commandEntered = getMainCommand();
            // if Navigations commands -> do then ask again until Base command.
            while (runNavCommand(commandEntered)) {
                commandEntered = getMainCommand();
            }
            runBaseCommand(commandEntered);
        }

    }


    // getting input
    private char getMainCommand() {
        Scanner in = new Scanner(System.in);
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();
            for (BaseCommands c : BaseCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            for (NavigationCommands c : NavigationCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            System.out.println("** command character entered not from the options **");
        }
    }

    private char getPaintingCommand() {
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();

            for (PaintingCommands c : PaintingCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            if (commandCharecter == 'b')
                return commandCharecter;
            System.out.println("** command character entered not from the options **");
        }
    }

    private char getMirrorCommand() {
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();

            for (MirrorCommands c : MirrorCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            if (commandCharecter == 'b')
                return commandCharecter;
            System.out.println("** command character entered not from the options **");
        }
    }

    private char getChestCommand() {
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();

            for (ChestCommands c : ChestCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            if (commandCharecter == 'b')
                return commandCharecter;

            System.out.println("** command character entered not from the options **");
        }
    }

    private char getDoorCommand() {
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();

            for (DoorCommands c : DoorCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            if (commandCharecter == 'b')
                return commandCharecter;

            System.out.println("** command character entered not from the options **");
        }
    }

    private char getSellerCommand() {
        char commandCharecter;
        while (true) {
            commandCharecter = getCharacter();

            for (SellerCommands c : SellerCommands.values())
                if (c.asChar == commandCharecter)
                    return commandCharecter;
            if (commandCharecter == 'b')
                return commandCharecter;
            System.out.println("** command character entered not from the options **");
        }
    }

    private char getCharacter() {
        Scanner in = new Scanner(System.in);
        String tempIn = in.next();
        while (tempIn.length() != 1) {
            System.out.println("Please enter valid command character ..");
            tempIn = in.next();
        }
        return tempIn.charAt(0);
    }

    private int getNumberInRange(int from, int to) {
        Scanner in = new Scanner(System.in);
        int commandNumber;
        boolean first = true;
        do {
            if (!first) {
                System.out.println("** number not in the range **");
            }
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            commandNumber = in.nextInt();
            if (first) {
                first = false;
            }

        } while (commandNumber < from || commandNumber > to);

        return commandNumber;
    }


    // running
    private boolean runNavCommand(char mainCommand) {

        if (mainCommand == NavigationCommands.Left.asChar) {
            this.player.moveLeft();
            System.out.println("Facing " + this.player.getPos());
            return true;
        }
        if (mainCommand == NavigationCommands.Right.asChar) {
            this.player.moveRight();
            System.out.println("Facing " + this.player.getPos());
            return true;
        }
        if (mainCommand == NavigationCommands.Forward.asChar) {
            System.out.println("Facing " + this.player.getPos());
            if (this.currentRoom.loofIfDoor(this.player.getPos())) {
                Door tempDoor = this.currentRoom.getIfDoor(this.player.getPos());
                if (!tempDoor.isLocked()) {
                    this.currentRoom = tempDoor.getSideRoom();
                    System.out.println("Entered new Room..");
                }
            }
            return true;
        }

        if (mainCommand == NavigationCommands.Backword.asChar) {
            System.out.println("Facing " + this.player.getPos());
            if (this.currentRoom.loofIfDoor(Directions.getOppositeDirection(this.player.getPos()))) {
                Door tempDoor = this.currentRoom.getIfDoor(Directions.getOppositeDirection(this.player.getPos()));
                if (!tempDoor.isLocked())
                    this.currentRoom = tempDoor.getSideRoom();
                System.out.println("Entered new Room..");
            }
            return true;
        }
        return false;
    }

    private void runBaseCommand(char mainCommand) {
        // Done
        if (mainCommand == BaseCommands.Look.asChar) {

            System.out.println("    *" + this.currentRoom.look(this.player.getPos(), this.player.getFlashlight()) + "*    ");
            if (!this.currentRoom.isDark(this.player.getFlashlight())) {
                runSubCommands(this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent());
            }
            return;
        }
        // Done
        if (mainCommand == BaseCommands.Use_Flashlight.asChar) {
            if (this.player.hasFlashlight())
                if (this.player.getFlashlight().switchFlashlight()) {
                    System.out.println(FlashLight.className() + " switched to " + ((this.player.getFlashlight().isLit() == true) ? "on" : "off"));
                    return;
                }
            System.out.println("You dosn't have Flashlight..");
        }
        // Done
        if (mainCommand == BaseCommands.Turn_Lights.asChar) {
            this.currentRoom.switchLights();
        }
        // Done
        if (mainCommand == BaseCommands.Player_Status.asChar) {
            displayPlayerStatus();
        }
        // not yet
        if (mainCommand == BaseCommands.Restart.asChar) {
            System.out.println("Restarting ..\n \n \n");
            start();
        }
        // Done
        if (mainCommand == BaseCommands.Quit.asChar) {
            System.out.println("Ending game ..");
            System.exit(1);
        }
    }

    private void runSubCommands(Wallable wall) {
        notNull(wall);
        String lookValue = wall.look();
        System.out.println(lookValue + " commands, please choose form them:- ");

        if (lookValue == Door.className()) {
            showDoorSubOptions();
            runDoorSubOptions();
        }
        if (lookValue == Painting.className()) {
            showPaintingSubOptions();
            runPaintingSubOptions();
        }
        if (lookValue == Mirror.className()) {
            showMirrorSubOptions();
            runMirrorSubOptions();
        }
        if (lookValue == Chest.className()) {
            showChestSubOptions();
            runChestSubOptions();
        }
        if (lookValue == Seller.className()) {
            showSelleSubOptions();
            runSellerSubOptions();
        }
    }


    private void runDoorSubOptions() {
        char subCommand = getDoorCommand();

        if (subCommand == DoorCommands.check.asChar) {
            if (((Checkable.ForOpenablility) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).check()) {
                System.out.println("Door is open");
                if (isLinkingEndRoom(((Door) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent())))
                    wonGame();
            } else
                System.out.println("Door is locked, " +
                        ((Door) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).getRequestedKey().getName() +
                        "key is needed to unlock");
        }
        if (subCommand == DoorCommands.open.asChar) {
            ((Door) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).open();

        }
        if (subCommand == DoorCommands.use_Key.asChar) {
            if (this.player.getKeys().size() > 0) {
                System.out.println("Which key you want? (please choose the number)");
                showPlayerKeys();
                int keyNumber = getNumberInRange(1, this.player.getKeys().size()) - 1;
                System.out.println(((Lockable) (this.currentRoom
                        .getWallInDirection(this.player.getPos())
                        .getWallContent()))
                        .useKey(this.player.getKeyNumber(keyNumber)));

                if( ((Checkable.ForOpenablility) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).check())
                    if(isLinkingEndRoom((Door) this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()))
                        wonGame();

            } else
                System.out.println("Player doesn't have any keys..");
        }

        if (subCommand == 'b')
            System.out.println("back to main menu..");
    }

    private void wonGame() {
        System.out.println("Congratulations!! You Won!!");
        System.out.println("Your time is "+this.gameTimer.getTimePassed());
        System.exit(1);
    }

    private boolean isLinkingEndRoom(Door door){
        if(door.getSideRoom()==this.map.getEndRoom())
            return true;
        else
            return false;
    }

    private void runPaintingSubOptions(){
        char subCommand = getPaintingCommand();
        if(subCommand == PaintingCommands.check.asChar){
            Key lootedKey = ((Checkable.ForContent)this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).check();
            if(lootedKey.getDescription() == EmptyKey.description())
                System.out.println("Empty");
            else{
                this.player.addItem(lootedKey);
                System.out.println("The "+lootedKey.getName()+" key was acquired");
            }
        }
        if(subCommand== 'b')
            System.out.println("back to main menu..");
    }
    private void runMirrorSubOptions() {
        char subCommand = getMirrorCommand();
        if(subCommand == MirrorCommands.check.asChar){
            Key lootedKey = ((Checkable.ForContent)this.currentRoom.getWallInDirection(this.player.getPos()).getWallContent()).check();
            if(lootedKey.getDescription() == EmptyKey.description())
                System.out.println("Empty");
            else{
                this.player.addItem(lootedKey);
                System.out.println("The "+lootedKey.getName()+" key was acquired");
            }
        }
        if(subCommand== 'b')
            System.out.println("back to main menu..");
    }
    private void runChestSubOptions() {
        char subCommand = getChestCommand();

        if(subCommand == ChestCommands.check.asChar){
            HashMap lockedContent = ((Checkable.ForLockedContent) this.currentRoom
                    .getWallInDirection(this.player.getPos())
                    .getWallContent())
                    .check();
            if((boolean)lockedContent.keySet().toArray()[0]) {

                if( ((ArrayList<Containable>)lockedContent.get(true)).size()==0)
                    System.out.println("Empty chest!");
                else{
                    this.player.addItems((ArrayList<Containable>) lockedContent.get(true));
                    System.out.println("Chest is looted, you got :- ");
                    for(Containable item:(ArrayList<Containable>)lockedContent.get(true)){
                        System.out.println(item.getDescription());
                    }
                }
            }
            else {
                System.out.println("chest closed "+((ArrayList<Containable>)lockedContent.get(false)).get(0).getName()+" key is needed to unlock");
            }
        }
        if(subCommand == ChestCommands.use_Key.asChar){
            if(this.player.getKeys().size() >0){
                System.out.println("Which key you want? (please choose the number)");
                showPlayerKeys();
                int keyNumber = getNumberInRange(1,this.player.getKeys().size())-1;
                System.out.println(((Lockable)(this.currentRoom
                        .getWallInDirection(this.player.getPos())
                        .getWallContent()))
                        .useKey(this.player.getKeyNumber(keyNumber)) );
            }
            else
                System.out.println("Player doesn't have any keys..");
        }
        if(subCommand== 'b')
            System.out.println("back to main menu..");
    }
    private void runSellerSubOptions() {
        char subCommand = getSellerCommand();

        if(subCommand == SellerCommands.trade.asChar){
            Tradable seller = ((Tradable)this.currentRoom
                    .getWallInDirection(this.player.getPos())
                    .getWallContent());
            ArrayList<Containable> sellerItems = seller.getItems();

            boolean finish = false;
            if(sellerItems.size()>0){
                showItems(sellerItems);
                while(!finish){
                    showTradeOptions();
                    int commandNumber = getNumberInRange(1,TradingCommands.values().length);
                    switch (commandNumber){
                        case 1:
                            runBuyProccess(seller,sellerItems);
                            break;
                        case 2:
                            runSellProcess(seller);
                            break;
                        case 3  :
                            showItems(sellerItems);
                            break;
                        case 4 :
                            finish =true;
                            break ;
                        default:
                            break;
                    }
                }
                System.out.println("back to main menu..\n");
            }
        }

        if(subCommand== 'b')
            System.out.println("back to main menu..");
    }

    private void runBuyProccess(Tradable seller,ArrayList<Containable> sellerItems) {

        showItems(sellerItems);
        System.out.println( (sellerItems.size()+1)+" -> exit\n");
        System.out.println("Please enter the item number..");

        int itemNumber = getNumberInRange(1,sellerItems.size()+1)-1;
        if(itemNumber == sellerItems.size()) {
            System.out.println("back to Trade menu..\n");
            return;
        }
        if( player.buyItem(sellerItems.get(itemNumber) ) ){
            System.out.println(sellerItems.get(itemNumber).getDescription()+" bought and acquired");
            seller.sellItem(sellerItems.get(itemNumber));
        }
        else
            System.out.println("return when you have enough gold");

    }
    private void runSellProcess(Tradable seller) {

        showItems(seller.getSellList());
        System.out.println( (seller.getSellList().size() +1)+" -> exit\n");

        System.out.println("Please enter the item number..");
        int selledItemNumber = getNumberInRange(1,seller.getSellList().size()+1)-1;

        if(selledItemNumber == seller.getSellList().size()) {
            System.out.println("back to Trade menu..\n");
            return;
        }
        Containable selledItem = (seller.getSellList().get(selledItemNumber));
        if(this.player.sellItem(selledItem)){
            seller.buyItem(selledItem);
            System.out.println(selledItem.getDescription()+ " sold..");
        }
        else{
            System.out.println("You don't have this item ..");
        }
    }


    // Display (Forntend or view)

    private void showItems(ArrayList<Containable> sellerItems){
        System.out.println("\n"+ Seller.className() + " have these items:- ");
        System.out.println("Item        Price");
        for(int i=0;i<sellerItems.size();i++)
            System.out.println((i+1)+") "+sellerItems.get(i).getDescription()+"    "+sellerItems.get(i).getPrice());
        System.out.println("    ***    ");
    }
    private void showDoorSubOptions(){
        for (int i=0 ; i < DoorCommands.values().length ; i++)
            System.out.println("    "+DoorCommands.values()[i].asChar+" -> "+DoorCommands.values()[i]);
        System.out.println("\n    b -> return to main menu");
    }
    private void showPaintingSubOptions(){
        for (int i = 0; i < PaintingCommands.values().length ; i++)
            System.out.println("    "+PaintingCommands.values()[i].asChar+" -> "+PaintingCommands.values()[i]);
        System.out.println("\n    b -> return to main menu");
    }
    private void showMirrorSubOptions(){
        for (int i = 0; i < MirrorCommands.values().length ; i++)
            System.out.println("    "+MirrorCommands.values()[i].asChar+" -> "+MirrorCommands.values()[i]);
        System.out.println("\n    b -> return to main menu");

    }
    private void showChestSubOptions(){
        for (int i = 0; i < ChestCommands.values().length ; i++)
            System.out.println("    "+ChestCommands.values()[i].asChar+" -> "+ChestCommands.values()[i]);
        System.out.println("\n    b -> return to main menu");

    }
    private void showSelleSubOptions(){
        for (int i = 0; i < SellerCommands.values().length ; i++)
            System.out.println("    "+SellerCommands.values()[i].asChar+" -> "+SellerCommands.values()[i]);
        System.out.println("\n    b -> return to main menu");

    }

    private void showPlayerKeys(){
        for (int i=0;i<this.player.getKeys().size();i++){
            System.out.println((i+1)+" -> "+this.player.getKeys().get(i).getDescription());
        }
    }
    private void showTradeOptions(){
        System.out.println("You have these options");
        for(int i=0;i<TradingCommands.values().length;i++){
            System.out.println(TradingCommands.values()[i].asInt +1 +" -> "+TradingCommands.values()[i]);
        }
    }
    private void showMainOptions() {
        System.out.println("    # Main options :-");
        displayNavigationCommands();
        diplayBaseCommands();
        System.out.println("    **************  ");

    }
    private void diplayBaseCommands() {
        for (BaseCommands command:BaseCommands.values()){
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
        System.out.println("    Time left :- "+ this.gameTimer.getTimeLeft() );
        System.out.println("    Your direction : "+this.player.getPos());
        System.out.println("    You have : "+ this.player.getMoney()+" of Gold!");
        System.out.println("    You have those items :-");
        for(Key item : this.player.getKeys())
            System.out.println("    "+item.getDescription());
        if(this.player.hasFlashlight())
            System.out.println("    "+FlashLight.className());

        System.out.println(" *** ");
        showMainOptions();
    }

    // Helpers
    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}

