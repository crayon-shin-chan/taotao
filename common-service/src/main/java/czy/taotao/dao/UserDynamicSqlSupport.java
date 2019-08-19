package czy.taotao.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.947+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.947+08:00", comments="Source field: user.id")
    public static final SqlColumn<Long> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.user_name")
    public static final SqlColumn<String> userName = user.userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.nick_name")
    public static final SqlColumn<String> nickName = user.nickName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.salt")
    public static final SqlColumn<String> salt = user.salt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.phone")
    public static final SqlColumn<String> phone = user.phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.email")
    public static final SqlColumn<String> email = user.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.create_user")
    public static final SqlColumn<Long> createUser = user.createUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.create_time")
    public static final SqlColumn<Date> createTime = user.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.update_user")
    public static final SqlColumn<Long> updateUser = user.updateUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.949+08:00", comments="Source field: user.update_time")
    public static final SqlColumn<Date> updateTime = user.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2019-08-19T21:57:22.947+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> salt = column("salt", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateUser = column("update_user", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public User() {
            super("user");
        }
    }
}