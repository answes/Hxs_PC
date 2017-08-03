package sample.bean;

/**
 * 系统公告
 */
public class SystemMsg {
    private String id;
    private String content;
    private String time;
    private String title;

    public SystemMsg(String id,String title, String content, String time) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
