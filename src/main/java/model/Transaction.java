package model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity (name = "transactions")
public class Transaction {

    @Id
    @Column (name = "_id")
    private Integer id;

    @Column
    private String note;

    @Column (columnDefinition="long")
    private long datetime;

    @Column (columnDefinition="long")
    private long from_account_id;

    public Date getDatetimeH() {
        this.datetimeH = new Date(datetime);
        return datetimeH;
    }

    @DateTimeFormat(pattern = "HH:mm")
    @Transient
    private Date time;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Transient
    private Date datetimeH;

    public long getDatetime() {
        return datetime;
    }

    public Date getTime() {
        return getDatetimeH();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}' + "\r\n";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public void setNote(String note) {

        this.note = note;
    }

    public Integer getId() {

        return id;
    }

    public String getNote() {
        return note;
    }

    public long getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(long from_account_id) {
        this.from_account_id = from_account_id;
    }
}
