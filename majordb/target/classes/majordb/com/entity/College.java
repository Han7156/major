package majordb.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;
public class College {
    /**
     * 学院id
     */
    @Id
    private Integer cid;

    /**
     * 学院名称
     */
    private String cname;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    /**
     * 获取学院id
     *
     * @return cid - 学院id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置学院id
     *
     * @param cid 学院id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取学院名称
     *
     * @return cname - 学院名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置学院名称
     *
     * @param cname 学院名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "College{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}