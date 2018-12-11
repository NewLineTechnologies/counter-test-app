package net.nlt.app.counter.countertestapp.repository;

import net.nlt.app.counter.countertestapp.domain.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlHttpTraceRepository implements HttpTraceRepository {

    @Autowired
    private RequestInfoRepository requestInfoRepository;

    @Override
    public List<HttpTrace> findAll() {
        return null;
    }

    @Override
    public void add(HttpTrace trace) {
        HttpTrace.Request httpRequest = trace.getRequest();

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setMethod(httpRequest.getMethod());
        requestInfo.setTimestamp(trace.getTimestamp());
        requestInfo.setUri(httpRequest.getUri().toString());
        requestInfoRepository.save(requestInfo);
    }
}
