package net.nlt.app.counter.countertestapp.repository;

import net.nlt.app.counter.countertestapp.domain.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestInfoRepository extends JpaRepository<RequestInfo, Long> {
}
