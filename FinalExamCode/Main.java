package FinalExamCode;
import java.util.Scanner;

public class Main {
    private static Organizer[] organizers;
    private static Member[] members;
    private static Event[] events;
    private static Review[] reviews;
    private static Scanner scanner = new Scanner(System.in);
    private static int memberPos = -1;
    private static int organizerPos = -1;


    public static void main(String[] args) {
        intializeData();
        createOrganizers();
        createMembers();
        crateEvents();
        createReviews();
        System.out.println("HngOut");
        System.out.println("Welcome to HngOut");
        while (true) {
            System.out.println("Please select an option");
            System.out.println("1. Sign up");
            System.out.println("2. Log in ");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if(memberPos != -1 && organizerPos != -1) {
                        System.out.println("Previously you have entered in " + members[memberPos].getName() + " " + organizers[organizerPos].getName());
                        System.out.println("Do you want to continue with which previous session? [1]member [2]organizator [3]new session");
                        int joinSession = scanner.nextInt();
                        if(joinSession == 1){
                            System.out.println("Welcome " + members[memberPos].getName());
                            memberMenu();
                        }
                        else if (joinSession == 2) {
                            System.out.println("Welcome " + organizers[organizerPos].getName());
                        } else if (joinSession == 3) {
                            memberPos = -1;
                            organizerPos = -1;

                        }
                    }
                    System.out.println("Sign up");
                    System.out.println("Please select an option");
                    System.out.println("1. Sign up as a member");
                    System.out.println("2. Sign up as an organizer");
                    System.out.println("3. Back");
                    int signUpOption = scanner.nextInt();
                    switch (signUpOption) {
                        case 1:
                            memberPos = signUpMember();
                            memberMenu();
                            break;
                        case 2:
                            organizerPos = signUpOrganizer();
                            organizerMenu();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Join previous session? (yes/no)[1]/[2]");
                    int joinSession = scanner.nextInt();
                    if(memberPos != -1 && organizerPos != -1) {
                        System.out.println("Previously you have entered in " + members[memberPos].getName() + " " + organizers[organizerPos].getName());
                        System.out.println("Do you want to continue with which previous session? [1]member [2]organizator [3]new session");
                        joinSession = scanner.nextInt();
                    }
                    if(memberPos != -1 && joinSession == 1){
                            System.out.println("Welcome " + members[memberPos].getName());
                            memberMenu();
                    }else if(organizerPos != -1 && joinSession == 2){
                            System.out.println("Welcome " + organizers[organizerPos].getName());
                            organizerMenu();
                    }
                    if(joinSession == 3){
                            memberPos = -1;
                            organizerPos = -1;
                            System.out.println("Log in");
                            System.out.println("Please select an option");
                            System.out.println("1. Log in as a member");
                            System.out.println("2. Log in as an organizer");
                            System.out.println("3. Back");
                            int logInOption = scanner.nextInt();
                            switch (logInOption) {
                                case 1:
                                    memberPos = logInMember();
                                    if (memberPos != -1) {
                                        System.out.println("Welcome " + members[memberPos].getName());
                                        memberMenu();
                                    } else {
                                        System.out.println("Invalid email or password");
                                    }
                                    break;
                                case 2:
                                    organizerPos = logInOrganizer();
                                    if (organizerPos != -1) {
                                        System.out.println("Welcome " + organizers[organizerPos].getName());
                                        organizerMenu();
                                    } else {
                                        System.out.println("Invalid email or password");
                                    }
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Invalid option");
                                    break;
                            }
                        }
                        break;

                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }




    }

    public static void organizerMenu(){
        //organizer can create an event
        //organizer can view all events
        //organizer can view all reviews
        //organizer can view all members in an event
        boolean loop = true;
        while(loop){
            System.out.println("Organizer Menu");
            System.out.println("Please select an option");
            System.out.println("1. Create an event");
            System.out.println("2. View all events");
            System.out.println("3. View all reviews");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewAllEvents();
                    System.out.println("Choose an event to view members");
                    int chosenEvent = scanner.nextInt();
                    viewAllMembers(events[chosenEvent]);
                    break;
                case 3:
                    viewAllEvents();
                    System.out.println("Enter event number to view reviews");
                    int eventNumber = scanner.nextInt();
                    viewEventReview(events[eventNumber]);
                    break;
                case 4:
                    System.out.println("Exited");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    public static void memberMenu(){
        //member can view all events
        //member can join event
        //member can leave a review
        boolean loop = true;
        while(loop){
            System.out.println("Member Menu");
            System.out.println("Please select an option");
            System.out.println("1. View all events");
            System.out.println("2. Join event");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            int eventNumber = -1;
            switch (option) {
                case 1:
                    viewAllEvents();
                    break;
                case 2:
                    eventNumber = joinEvent();
                    if(eventNumber != -1){
                        addReview(events[eventNumber]);
                    }
                    else {
                        System.out.println("Event is full");
                    }
                    break;
                case 3:
                    System.out.println("Exited");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void viewAllMembers(Event event){
        for (int i = 0; i < event.getCurrentMembers(); i++) {
            System.out.println( i+1 +"\t"+event.getMembers()[i].getName() +"\t" + event.getMembers()[i].getContactNumber());
        }
    }
    public static void viewAllEvents(){
        for (int i = 0; i < events.length; i++) {
            System.out.println(i +" " + events[i].getEventName() + "\n " + events[i].getDateAndTime() + "\n " + events[i].getLocation()+ "\n " + events[i].getMaxMembers());
        }
    }

    public static void addEvent(){
        System.out.println("Enter event banner");
        String eventBanner = scanner.nextLine();
        eventBanner = scanner.nextLine();
        System.out.println("Enter event name");
        String eventName = scanner.nextLine();
        System.out.println("Enter event category");
        String eventCategory = scanner.nextLine();
        System.out.println("Enter date and time");
        String dateAndTime = scanner.nextLine();
        System.out.println("Enter location");
        String location = scanner.nextLine();
        System.out.println("Enter max members");
        int maxMembers = scanner.nextInt();
        createEvent(eventBanner, eventName, eventCategory, dateAndTime, location, maxMembers, organizers[organizerPos]);
    }
    public static int joinEvent(){
        viewAllEvents();
        System.out.println("Enter event number to join");
        int eventNumber = scanner.nextInt();
        if(events[eventNumber].getCurrentMembers() < events[eventNumber].getMaxMembers()){
            Member[] temp = new Member[events[eventNumber].getCurrentMembers() + 1];
            for (int i = 0; i < events[eventNumber].getCurrentMembers(); i++) {
                temp[i] = events[eventNumber].getMembers()[i];
            }
            temp[events[eventNumber].getCurrentMembers()] = members[memberPos];
            events[eventNumber].setMembers(temp);
            events[eventNumber].setCurrentMembers(events[eventNumber].getCurrentMembers() + 1);
            return eventNumber;
        }else{
            System.out.println("Event is full");
            return -1;
        }
    }
    public static void addReview(Event event){
        //member can leave a review
        System.out.println("Enter review");
        String review = scanner.nextLine();
        review = scanner.nextLine();
        System.out.println("Enter rating");
        int rating = scanner.nextInt();
        Review review1 = new Review(review, rating, members[memberPos], event);
    }
    public static void viewReviews(){
        for (int i = 0; i < reviews.length; i++) {
            System.out.println(reviews[i].getReview() + "\n" + reviews[i].getRating() + "\n" + reviews[i].getMember().getName() + "\n" + reviews[i].getEvent().getEventName());
        }
    }
    public static void viewEventReview(Event event){
        for (int i = 0; i < reviews.length; i++) {
            if(reviews[i].getEvent().equals(event)){
                System.out.println(reviews[i].getReview() + "\n" + reviews[i].getRating() + "\n" + reviews[i].getMember().getName() + "\n" + reviews[i].getEvent().getEventName());
            }
        }

    }

    public static int signUpMember(){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        System.out.println("Enter your contact number");
        String contuctNumber = scanner.nextLine();
        Member member = new Member(name,email,password,contuctNumber);

        //add a new member to array members
        Member[] temp = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        int length = members.length;
        temp[members.length] = member;
        members = temp;
        return length;
    }
    public static int signUpOrganizer(){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        System.out.println("Enter your contact number");
        String contuctNumber = scanner.nextLine();
        System.out.println("Enter your CRN");
        int crn = scanner.nextInt();
        Organizer organizer = new Organizer(name,email,password,contuctNumber);
        organizer.setCrn(crn);
        //add a new organizer to array organizers
        Organizer[] temp = new Organizer[organizers.length + 1];
        for (int i = 0; i < organizers.length; i++) {
            temp[i] = organizers[i];
        }
        int length = organizers.length;
        temp[organizers.length] = organizer;
        organizers = temp;
        return length;
    }
    public static int logInMember(){
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (int i = 0; i < members.length; i++) {
            if (members[i].getEmail().equals(email) && members[i].getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }
    public static int logInOrganizer(){
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (int i = 0; i < organizers.length; i++) {
            if (organizers[i].getEmail().equals(email) && organizers[i].getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }


    public static void intializeData() {
        organizers = new Organizer[10];
        members = new Member[10];
        events = new Event[10];
        reviews = new Review[10];
    }
    public static void createOrganizers(){
        organizers[0] = new Organizer("John Doe", "johnDoe@gmail.com", "password", "1234567890");
        organizers[1] = new Organizer("Marika Elden", "god@gmail.com", "iamgod", "0987654321");
        organizers[2] = new Organizer("Radagon The Elden lord", "iamher@gmail.com", "iamher", "0987654321");
        organizers[3] = new Organizer("Godfrey The First Elden Lord", "HoraLoux@gmail.com", "firstlord", "0987654321");
        organizers[4] = new Organizer("Malenia Blade of Miquella", "ihateletmesoloher@gmail.com", "iamrot", "0987654321");
        organizers[5] = new Organizer("Promised consort Miquella", "iamgodRadahn@gmail.com", "iloveRadahn", "0987654321");
        organizers[6] = new Organizer("Radahn The promised corsort", "iamhardestbossinsouls@gmail.com", "ihateplayers", "0987654321");
        organizers[7] = new Organizer("Messmer the impaler", "impaler@gmail.com","embraceofmessmersflame", "0987654321");
        organizers[8] = new Organizer("Godwyn The golden", "iamchad@gmail.com", "deathblight", "0987654321");
        organizers[9] = new Organizer("Godrick the grafted", "gimmeurlimbs@gmail.com", "gimmeurlimbs", "0987654321");



    }
    public static void createMembers() {
        members[0] = new Member("John Doe", "johndoe@gmail.com", "password", "1234567890");
        members[1] = new Member("Tarnished soul", "nohitrun@gmail.com", "iamnewandonlylord", "0987654321");
        members[2] = new Member("blaid", "wof@gmail.com", "iamdog", "0987654321");
        members[3] = new Member("Roderika", "spirittailor@gmail.com", "iamtailor", "0987654321");
        members[4] = new Member("Gideon", "iamstalker@gmail.com", "iamstalker", "0987654321");
        members[5] = new Member("Melina", "iammaidenoftarnished@gmail.com", "iltarnished", "0987654321");
        members[6] = new Member("Black Smith", "smith@gmail.com", "iamblacksmith", "0987654321");
        members[7] = new Member("Millicent", "ikilledmysisters@gmail.com", "iamarmless", "0987654321");
        members[8] = new Member("D", "d@gmail.com", "iamd", "0987654321");
        members[9] = new Member("Radahn", "radahn@gmail.com", "iamradahn", "0987654321");
    }
    public static void crateEvents(){
        events[0] = new Event("banner1", "event1", "category1", "date1", "location1", 10, organizers[0]);
        events[1] = new Event("banner2", "event2", "category2", "date2", "location2", 10, organizers[1]);
        events[2] = new Event("banner3", "event3", "category3", "date3", "location3", 10, organizers[2]);
        events[3] = new Event("banner4", "event4", "category4", "date4", "location4", 10, organizers[3]);
        events[4] = new Event("banner5", "event5", "category5", "date5", "location5", 10, organizers[4]);
        events[5] = new Event("banner6", "event6", "category6", "date6", "location6", 10, organizers[5]);
        events[6] = new Event("banner7", "event7", "category7", "date7", "location7", 10, organizers[6]);
        events[7] = new Event("banner8", "event8", "category8", "date8", "location8", 10, organizers[7]);
        events[8] = new Event("banner9", "event9", "category9", "date9", "location9", 10, organizers[8]);
        events[9] = new Event("banner10", "event10", "category10", "date10", "location10", 10, organizers[9]);
    }
    public static void createReviews(){
        reviews[0] = new Review("This event was amazing", 5, members[0], events[0]);
        reviews[1] = new Review("This event was amazing", 5, members[1], events[1]);
        reviews[2] = new Review("This event was amazing", 5, members[2], events[2]);
        reviews[3] = new Review("This event was amazing", 5, members[3], events[3]);
        reviews[4] = new Review("This event was amazing", 5, members[4], events[4]);
        reviews[5] = new Review("This event was amazing", 5, members[5], events[5]);
        reviews[6] = new Review("This event was amazing", 5, members[6], events[6]);
        reviews[7] = new Review("This event was amazing", 5, members[7], events[7]);
        reviews[8] = new Review("This event was amazing", 5, members[8], events[8]);
        reviews[9] = new Review("This event was amazing", 5, members[9], events[9]);
    }

    public static void createEvent(String eventBanner, String eventName, String eventCategory, String dateAndTime, String location, int maxMembers, Organizer organizer) {
        Event event = new Event(eventBanner, eventName, eventCategory, dateAndTime, location, maxMembers, organizer);

        //add a new event to array events

        Event[]temp = new Event[events.length + 1];
        for (int i = 0; i < events.length; i++) {
            temp[i] = events[i];
        }
        temp[events.length] = event;
        events = temp;
    }
}
