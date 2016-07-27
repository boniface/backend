package backend.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2016/07/23.
 */

@javax.persistence.Entity
public class Story  implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private Date date;
    private String title;
    private String content;

    public Story(Builder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.date = builder.date;
        this.title = builder.title;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static class Builder{
        private long id;
        private Date date;
        private String title;
        private String content;

        public Builder id(long value){
            this.id = value;
            return this;
        }

        public Builder date(Date value){
            this.date = value;
            return this;
        }
        public Builder title(String value){
            this.title = value;
            return this;
        }
        public Builder content(String value){
            this.content = value;
            return this;
        }

        public Builder copy(Story value){
            this.id = value.id;
            this.content= value.content;
            this.title=value.title;
            this.date = value.date;
            return this;
        }

        public Story build(){
            return new Story(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        return id == story.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
