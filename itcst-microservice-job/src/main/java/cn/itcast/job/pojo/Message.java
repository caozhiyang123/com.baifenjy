package cn.itcast.job.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "content",columnDefinition="varchar(50) not null")
    private String content;

    @Column(name = "last_modified_time",columnDefinition="varchar(50) not null")
    private String lastModifiedTime;

    @Column(name = "created_time",columnDefinition="varchar(50) not null")
    private String createdTime;

    public void setObjectId(Long objectId)
    {
        this.objectId = objectId;
    }
    public Long getObjectId()
    {
        return objectId;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getLastModifiedTime()
    {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime)
    {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getCreatedTime()
    {
        return createdTime;
    }

    public void setCreatedTime(String createdTime)
    {
        this.createdTime = createdTime;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Message [objectId=" + objectId + ", content=" + content + ", lastModifiedTime=" + lastModifiedTime
                + ", createdTime=" + createdTime + "]";
    }
}