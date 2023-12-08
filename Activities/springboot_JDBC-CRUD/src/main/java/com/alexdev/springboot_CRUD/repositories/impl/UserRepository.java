package com.alexdev.springboot_CRUD.repositories.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.utils.JDBCQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    JDBCQueries queries;

    @Override
    public List<User> findAll() {
        Supplier<List<User>> supUser= () -> jdbc.query(queries.user.get("getAll"), (rs, rowNum) -> User.builder()
                .dni(rs.getString("dni"))
                .name(rs.getString("name"))
                .lastName(rs.getString("last_name"))
                .dateBirth(rs.getDate("date_birth"))
                .profession(Profession.builder()
                        .id(rs.getLong("prof_id"))
                        .name(rs.getString("prof_name"))
                        .build())
                .build());

        return supUser.get();
    }

    @Override
    public void save(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        findByDNI(user.getDni())
                .ifPresentOrElse(u -> {
                    jdbc.update(queries.user.get("update"),
                            user.getName(),
                            user.getLastName(),
                            sdf.format(user.getDateBirth()),
                            user.getProfession().getId(),
                            u.getDni()
                    );
                }, () -> {
                    jdbc.update(queries.user.get("save"),
                            user.getDni(),
                            user.getName(),
                            user.getLastName(),
                            sdf.format(user.getDateBirth()),
                            user.getProfession().getId()
                    );
                });
    }

    @Override
    public Optional<User> findByDNI(String DNI) {
        try {
            RowMapper<User> rw = (rs, rowNum) -> User.builder()
                    .dni(rs.getString("dni"))
                    .name(rs.getString("name"))
                    .lastName(rs.getString("last_name"))
                    .dateBirth(rs.getDate("date_birth"))
                    .profession(Profession.builder()
                            .id(rs.getLong("prof_id"))
                            .name(rs.getString("prof_name"))
                            .build())
                    .build();


            return Optional.ofNullable(jdbc.queryForObject(queries.user.get("find"), rw, DNI));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }


    @Override
    public void deleteByDNI(String DNI) {
        findByDNI(DNI)
                .ifPresent(u -> jdbc.update(queries.user.get("delete"), DNI));
    }
}
