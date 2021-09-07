public class Letter extends Entry{
    private User recipient;

    public Letter(User author, User recipient, TextBody textBody, String date) {
        super(author);
        if(recipient==null){
           throw new IllegalArgumentException("recipient argument must not be null.");
       }

        this.setTextBody(textBody);
        this.recipient = recipient;
        this.setDate(date);
    }

    public User getRecipient() {
        return recipient;
    }

}
