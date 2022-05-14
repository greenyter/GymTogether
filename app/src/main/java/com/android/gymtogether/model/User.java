package com.android.gymtogether.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private String email;

    private String name;

    private String photoUrl;


}
