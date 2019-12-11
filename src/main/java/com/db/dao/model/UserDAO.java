package com.db.dao.model;

import com.db.dao.DBEntityDAO;
import com.db.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * StationDAO was created to provide the DAO for Station do
 *
 * @author vitaly
 * @since 2.4.2 <br>
 * based on JDK 1.7 <br>
 * created at Nov 17, 2013
 */
@Component
public class UserDAO extends DBEntityDAO<User, String> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAO.class);


}
