package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.Models.Comment;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
