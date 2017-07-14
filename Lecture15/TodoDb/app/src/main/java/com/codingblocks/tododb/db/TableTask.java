package com.codingblocks.tododb.db;

/**
 * Created by harshit on 14/07/17.
 */

public interface TableTask {

    String TABLE_NAME = "task";

    String COLUMN_ID = "id";

    String COLUMN_TASK = "task";

    String COLUMN_IS_DONE = "isdone";

    String CREATE = " CREATE TABLE ";

    String COMMA = " , ";

    String LBR = " ( ";

    String RBR = " ) ";

    String TERMINATE = " ; ";

    String INT_PK_AUTOIC = " INTEGER PRIMARY KEY AUTOINCREMENT ";

    String TYPE_INTEGER = " INTEGER ";

    String TYPE_REAL = " REAL ";

    String TYPE_TEXT = " TEXT ";

    String SELECT_ALL = " SELECT * ";

    String FROM = " FROM ";

    String WHERE = " WHERE ";

    String WHEN_UPGRADING_FROM_1_2 = " null ";

    String[] PROJECTION = new String[]{
            COLUMN_ID,
            COLUMN_TASK,
            COLUMN_IS_DONE
    };

}
