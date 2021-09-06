public class Comment implements TextDisplay{
    private TextBody textBody;
    private String date;
    private static int PREVIEW_LENGTH = 15;
    private User author;

    public Comment(TextBody textBody, String date, User author) {
        if(textBody==null || textBody.isEmpty()){
            throw new IllegalArgumentException("textBody argument must not be empty or null.");
        }
        if(author==null){
            throw new IllegalArgumentException("author argument must not be null.");
        }

        if(date.isEmpty() || date == null){
            throw new IllegalArgumentException("date argument must not be empty or null.");
        }

        this.textBody = textBody;
        this.date = date;
        this.author = author;
    }

    @Override
    public String createTextPreview() {
      return this.textBody.getCharacters(PREVIEW_LENGTH);
    }

    public TextBody getTextBody() {
        return textBody;
    }

    public void setTextBody(TextBody textBody) {
        if(textBody==null){
            throw new IllegalArgumentException("textBody argument must not be null.");
        }
        this.textBody = textBody;
    }

    public String getDate() {
        return date;
    }

}
