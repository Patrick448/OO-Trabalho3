public class Messenger {

    public static Letter sendLetter(User sender, User recipient, TextBody textBody, String date){
        Letter letter = new Letter(sender, recipient, textBody, date);
        sender.addLetter(letter);
        recipient.addLetter(letter);

        return letter;
    }
}
