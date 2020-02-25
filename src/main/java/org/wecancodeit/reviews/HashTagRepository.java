package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {

    Optional<HashTag> findByName(String hashTagName);
}
