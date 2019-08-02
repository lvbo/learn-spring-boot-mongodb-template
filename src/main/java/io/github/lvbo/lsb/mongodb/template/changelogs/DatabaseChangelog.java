package io.github.lvbo.lsb.mongodb.template.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoDatabase;

/**
 * @author lvbo
 */
@ChangeLog(order = "0001")
public class DatabaseChangelog {

    @ChangeSet(order = "0001", id = "addUserCollection", author = "lvbo")
    public void addUserCollection(MongoDatabase db){
        db.createCollection("user1");
    }

    @ChangeSet(order = "0002", id = "addRoleCollection", author = "lvbo")
    public void addRoleCollection(MongoDatabase db) {
        db.createCollection("role");
    }
}
