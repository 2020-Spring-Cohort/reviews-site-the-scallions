package org.wecancodeit.reviews.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.Models.HashTag;

import java.util.Optional;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {

    Optional<HashTag> findByName(String hashTagName);
}
