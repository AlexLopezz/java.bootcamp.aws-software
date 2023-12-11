package com.alexdev.springboot_CRUD.repositories.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.repositories.IProfessionRepository;
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
public class ProfessionRepository implements IProfessionRepository {
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    JDBCQueries queries;

    @Override
    public List<Profession> findAll() {
        Supplier<List<Profession>> supProfession = () -> jdbc.query(queries.profession.get("getAll"), (rs, rowNum) -> Profession.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .build());

        return supProfession.get();
    }

    @Override
    public Optional<Profession> findById(Long id) {
        return Optional.ofNullable(jdbc.queryForObject(
                queries.profession.get("find"),
                new Object[] {id}, new int[] {Types.BIGINT},
                (rs, rowNum) -> Profession.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build())
        );
    }

    @Override
    public void save(Profession profession) {
        jdbc.update(con -> Optional.of(profession.getId())
                .filter(id -> id > 0)
                .map(id -> {
                    try {
                        PreparedStatement statement = con.prepareStatement(queries.profession.get("update"));
                        statement.setString(1, profession.getName());
                        statement.setLong(2, id);


                        return statement;
                    } catch (SQLException exc) {
                        throw new RuntimeException(exc);
                    }
                })
                .orElseGet(() -> {
                    try {
                        PreparedStatement statement = con.prepareStatement(queries.profession.get("save"));
                        statement.setString(1, profession.getName());

                        return statement;
                    } catch (SQLException exc) {
                        throw new RuntimeException(exc);
                    }
                }));
    }

    @Override
    public void saveAll(List<Profession> professions) {
        professions.forEach(this::save);
    }
}
