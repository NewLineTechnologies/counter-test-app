package net.nlt.app.counter.countertestapp.repository;

import net.nlt.app.counter.countertestapp.domain.LimitOverFlowLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitOverflowLogRepository extends JpaRepository<LimitOverFlowLog, Long> {
}
