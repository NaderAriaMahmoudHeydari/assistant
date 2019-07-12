package com.nader.aria.assistant_blue.entities.abstracts;

import com.nader.aria.assistant_blue.entities.enums.PriorityType;
import com.nader.aria.assistant_blue.entities.enums.ScheduleType;
import com.nader.aria.assistant_blue.entities.reminder.Reminder;

import javax.persistence.*;

@Entity
@Table(name="MEDICINE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="MEDICINE_TYPE" , discriminatorType = DiscriminatorType.STRING )
public abstract class Medicine extends BaseEntity {

    @Column(name="RANK")
    private Long rank;

    @Enumerated( EnumType.STRING )
    @Column(name="PRIORITY_TYPE")
    private PriorityType priorityType;

    @Enumerated( EnumType.STRING )
    @Column(name="SCHEDULE_TYPE")
    private ScheduleType scheduleType;

    @OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
    @JoinColumn(name="REMINDER_ID"  )
    private Reminder reminder;

    public Long getRank(){ return rank; }
    public void setRank(Long rank){ this.rank = rank; }

    public PriorityType getPriorityType(){ return priorityType; }
    public void setPriorityType(PriorityType priorityType){ this.priorityType = priorityType; }

    public ScheduleType getScheduleType(){ return scheduleType; }
    public void setScheduleType(ScheduleType scheduleType){ this.scheduleType = scheduleType; }

    public Reminder getReminder(){ return reminder; }
    public void setReminder(Reminder reminder){ this.reminder = reminder; }


}
