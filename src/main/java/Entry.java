public class Entry implements TextDisplay{
    private TextBody textBody;
    private String date;
    private String title;
    private boolean statusPublic=false;
    private static int PREVIEW_LENGTH = 30;
    private User author;

    public Entry(String title, User author) {
        if(author==null){
            throw new IllegalArgumentException("author argument must not be null.");
        }
        this.title = title;
        this.author = author;

    }

    public Entry(User author) {
        if(author==null){
            throw new IllegalArgumentException("author argument must not be null.");
        }

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
        this.textBody = textBody;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public boolean isPublic() {
        return statusPublic;
    }

    public void setStatusPublic(boolean statusPublic) {
        this.statusPublic = statusPublic;
    }
}
