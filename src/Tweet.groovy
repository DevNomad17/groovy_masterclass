import java.time.LocalDateTime

class Tweet {
    String text
    LocalDateTime publish_date
    Integer likes
    Integer shares
    def comments = []

    Tweet(String text) {
        this.text = text
        this.likes = 0
        this.shares = 0
    }

    void publish() {
        this.publish_date = LocalDateTime.now()
        println(this)
    }

    void addComment(String strComment) {
        this.comments << strComment
    }

    void printComments() {
        println(this.comments)
    }


    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                ", publish_date=" + publish_date +
                ", likes=" + likes +
                ", shares=" + shares +
                '}';
    }
}