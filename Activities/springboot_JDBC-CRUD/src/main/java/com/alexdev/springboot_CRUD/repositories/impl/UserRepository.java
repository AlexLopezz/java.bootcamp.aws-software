package com.alexdev.springboot_CRUD.repositories.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.utils.JDBCQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public User save(User user) {
        jdbc.update(con -> findByDNI(user.getDni())
                .map(u -> {
                    try {
                        PreparedStatement statement = con.prepareStatement(queries.user.get("update"));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        statement.setString(1, u.getName());
                        statement.setString(2, u.getLastName());
                        statement.setString(3, sdf.format(u.getDateBirth()));
                        statement.setLong(4, u.getProfession().getId());
                        statement.setString(5, u.getDni());

                        return statement;
                    } catch (SQLException exc) {
                        throw new RuntimeException(exc);
                    }
                })
                .orElseGet(() -> {
                    try {
                        PreparedStatement statement = con.prepareStatement(queries.user.get("save"));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        statement.setString(1, user.getDni());
                        statement.setString(2, user.getName());
                        statement.setString(3, user.getLastName());
                        statement.setString(4, sdf.format(user.getDateBirth()));
                        statement.setLong(5, user.getProfession().getId());

                        return statement;
                    } catch (SQLException exc) {
                        throw new RuntimeException(exc);
                    }
                }));

        return user;
    }

    @Override
    public Optional<User> findByDNI(String DNI) {
        return Optional.ofNullable(jdbc.queryForObject(queries.user.get("delete"),
                new Object[] {DNI}, new int[] {Types.VARCHAR},
                (rs, rowNum) -> User.builder()
                        .dni(rs.getString("dni"))
                        .name(rs.getString("name"))
                        .lastName(rs.getString("last_name"))
                        .dateBirth(rs.getDate("date_birth"))
                        .profession(Profession.builder()
                                .id(rs.getLong("prof_id"))
                                .name(rs.getString("prof_name"))
                                .build())
                        .build())
        );
    }


    @Override
    public void deleteByDNI(String DNI) {
        findByDNI(DNI)
                .ifPresent(u -> {
                    jdbc.update(con -> {
                        PreparedStatement ps = con.prepareStatement(queries.user.get("delete"));
                        ps.setString(1, u.getDni());

                        return ps;
                    });
                });
    }
}
