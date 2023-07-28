package com.example.exempmanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.exempmanagement.domain.Administrator;

@Repository
public class AdministratorRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;
    
    private final static RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
        Administrator admin = new Administrator();
        admin.setId(rs.getInt("id"));
        admin.setName(rs.getString("name"));
        admin.setMailAddress(rs.getString("mailAddress"));
        admin.setPassword(rs.getString("password"));
        return admin;
    };

    /**
     * 管理者情報を挿⼊する
     * @param admin
     * @return
     */
    public void insert(Administrator admin) {
        String insertSql = "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress, :password)";
        SqlParameterSource param = 
            new MapSqlParameterSource()
                .addValue("name", admin.getName())
                .addValue("mailAddress", admin.getMailAddress())
                .addValue("password", admin.getPassword());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String[] keyColumnNames = {"id"};
        template.update(insertSql, param, keyHolder, keyColumnNames);
        admin.setId(keyHolder.getKey().intValue());
        System.out.println(keyHolder.getKey()+"が割り当てられました");
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する
     * 1件も存在しない場合は null を返す
     * @param mailAddress
     * @param password
     * @return
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String findSql = "SELECT id, name, mail_address, password FROM administorators WHERE mail_address = :mailAddress AND password = :password;";
        SqlParameterSource param = 
            new MapSqlParameterSource()
                .addValue("mailAddress", mailAddress)
                .addValue("password", password);
        
        List<Administrator> administratorList = template.query(findSql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.size() == 0) {
            return null;
        }

        return administratorList.get(0);
    }
}
