public class TextBody {
    private String text;

    public TextBody() {
    }

    public TextBody(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isEmpty(){
        return text == null || text.isEmpty();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCharacters(int length){

        return text.substring(0, length);
    }


}
