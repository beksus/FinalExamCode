package FinalExamCode;

public class Event {
    private String  eventBanner;
    private String  eventName;
    private String  eventCategory;
    private String dateAndTime;
    private String location;
    private int maxMembers;
    private int currentMembers;
    private Member[] members;
    private Organizer organizer;

    public Event(String eventBanner, String eventName, String eventCategory, String dateAndTime, String location, int maxMembers, Organizer organizer) {
        setEventBanner(eventBanner);
        setEventName(eventName);
        setEventCategory(eventCategory);
        setDateAndTime(dateAndTime);
        setLocation(location);
        setMaxMembers(maxMembers);
        setCurrentMembers(0);
        this.members = new Member[maxMembers];
        setOrganizer(organizer);
    }

    public String getEventBanner() {
        return eventBanner;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventCategory() {
        return eventCategory;
    }
    public String getDateAndTime() {
        return dateAndTime;
    }
    public String getLocation() {
        return location;
    }
    public int getMaxMembers() {
        return maxMembers;
    }
    public int getCurrentMembers() {
        return currentMembers;
    }
    public Member[] getMembers() {
        return members;
    }
    public Organizer getOrganizer() {
        return organizer;
    }


    public void setMembers(Member[] members) {
        this.members = members;
    }
    public void removeMember(Member member) {
        for (int i = 0; i < currentMembers; i++) {
            if (members[i].equals(member)) {
                for (int j = i; j < currentMembers - 1; j++) {
                    members[j] = members[j + 1];
                }
                currentMembers--;
                break;
            }
        }
    }
    public void addMembers(Member[] members) {
        for (int i = 0; i < members.length; i++) {
            addMember(members[i]);
        }
    }

    public void setCurrentMembers(int currentMembers) {
        this.currentMembers = currentMembers;
    }

    public void setEventBanner(String eventBanner) {
        this.eventBanner = eventBanner;
    }
    public int addMember(Member member) {
        if (currentMembers < maxMembers) {
            members[currentMembers] = member;
            currentMembers++;
            return 1;//success
        }
        return 0;//failed
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }


}
