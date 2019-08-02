package io.github.lvbo.lsb.mongodb.template.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoDatabase;

/**
 * @author lvbo
 */
@ChangeLog(order = "0002")
public class DatabaseChangelog2 {

    @ChangeSet(order = "0001", id = "addUserGroupCollection", author = "lvbo")
    public void addUserCollection(MongoDatabase db){
        db.createCollection("user_group");
    }

    @ChangeSet(order = "0002", id = "addRoleGroupCollection", author = "lvbo")
    public void addRoleCollection(MongoDatabase db) {
        db.createCollection("role_group");
    }
}
