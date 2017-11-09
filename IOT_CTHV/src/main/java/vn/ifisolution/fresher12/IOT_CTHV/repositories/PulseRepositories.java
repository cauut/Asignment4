package vn.ifisolution.fresher12.IOT_CTHV.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vn.ifisolution.fresher12.IOT_CTHV.dto.Pulse;

public interface PulseRepositories extends CassandraRepository<Pulse>{

}
