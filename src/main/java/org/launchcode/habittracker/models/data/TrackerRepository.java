package org.launchcode.habittracker.models.data;

import org.launchcode.habittracker.models.Tracker;
import org.launchcode.habittracker.models.TrackerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TrackerRepository extends CrudRepository<Tracker, TrackerId> {
}
