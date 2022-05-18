package edu.vnu.websemantics.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.vnu.websemantics.dao.UserDAO;
import edu.vnu.websemantics.model.User;

@Repository
@ComponentScan("edu.asu.websemantics.*")
@PropertySource("classpath:application-dev.properties")
public class UserDAOImpl implements UserDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	Environment env;


	@Override
	public boolean insertUserRegisterationDetails(User user) throws NullPointerException {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		User availableUser = findUserByName(user.getUsername());
		if (availableUser != null) {
			return false;
		}
		mongoTemplate.insert(user, env.getProperty("collectionName"));
		return true;
	}

	@Override
	public User findUserByName(String userName) throws NullPointerException {
		Query query = new Query(Criteria.where("username").is(userName));
		System.out.print(userName);
		System.out.print(mongoTemplate);
		return mongoTemplate.findOne(query, User.class, env.getProperty("collectionName"));
	}

}
