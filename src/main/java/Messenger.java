public class Messenger {

    public static Letter sendLetter(User sender, User recipient, TextBody textBody, String date){
        if(sender==null){
            throw new IllegalArgumentException("sender argument must not be null.");
        }
        if(recipient==null){
            throw new IllegalArgumentException("recipient argument must not be null.");
        }
        if(textBody==null){
            throw new IllegalArgumentException("textBody argument must not be null.");
        }
        Letter letter = new Letter(sender, recipient, textBody, date);
        sender.addLetter(letter);
        recipient.addLetter(letter);

        return letter;
    }
}
