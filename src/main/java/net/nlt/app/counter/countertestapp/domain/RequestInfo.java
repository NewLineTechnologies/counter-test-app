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
@Table(name = "request_log")
public class RequestInfo {

    @Id
    @GeneratedValue
    private Long id;

    private Instant timestamp;

    private String method;

    private String uri;
}
