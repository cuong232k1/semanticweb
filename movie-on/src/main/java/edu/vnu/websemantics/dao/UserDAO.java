package edu.vnu.websemantics.dao;

import edu.vnu.websemantics.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public boolean insertUserRegisterationDetails(User user);

	public User findUserByName(String userName);

}
