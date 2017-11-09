package vn.ifisolution.fresher12.IOT_CTHV.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import vn.ifisolution.fresher12.IOT_CTHV.dto.ObjectPulse;

public interface ObjectRepositories extends CassandraRepository<ObjectPulse>{

}
