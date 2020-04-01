package com.TimeTo.TimeTo;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Month {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Calendar calendar;
    @OneToMany(mappedBy = "month")
    private Collection<Day> days;

    public Month() {
    }

    public Long getId() {
        return id;
    }

    public Month(Calendar calendar, Collection<Day> days) {
        this.calendar = calendar;
        this.days = days;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Collection<Day> getDays() {
        return days;
    }
}