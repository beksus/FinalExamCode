package FinalExamCode;

public class Review {
    // this a review class for members to review the events they have attended and rate them. only organizer  can view the reviews
    private String review;
    private int rating;
    private Member member;
    private Event event;
    public Review(String review, int rating, Member member, Event event) {
        setReview(review);
        setRating(rating);
        setMember(member);
        setEvent(event);
    }
    public String getReview() {
        return review;
    }
    public int getRating() {
        return rating;
    }
    public Member getMember() {
        return member;
    }
    public Event getEvent() {
        return event;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
