package com.ar.alexdev.frontend_springboot.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Profession {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
