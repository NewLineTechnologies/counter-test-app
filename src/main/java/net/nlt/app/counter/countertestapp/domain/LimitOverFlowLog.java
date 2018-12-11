package net.nlt.app.counter.countertestapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "counter_limit_log")
public class LimitOverFlowLog {

    @Id
    @GeneratedValue
    private Long id;

    private Instant timestamp;

    private Integer reachedLimitValue;
}
