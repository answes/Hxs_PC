package sample.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 系统公告
 */
public class SystemMsg {
    private StringProperty id;
    private StringProperty content;
    private StringProperty time;
    private StringProperty title;
    private StringProperty state;
    private StringProperty type;

    public SystemMsg(String id,String title, String content, String time,String state,String type) {
        this.id = new SimpleStringProperty(id);
        this.content = new SimpleStringProperty(content);
        this.time = new SimpleStringProperty(time);
        this.title = new SimpleStringProperty(title);
        this.state = new SimpleStringProperty(state);
        this.type = new SimpleStringProperty(type);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
