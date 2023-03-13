package com.market.aaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = @Index(columnList = "refreshToken", name = "refresh_token_index"))
public class User {

    @Id
    @Column(updatable = false, unique = true, nullable = false, length = 40)
    private String userId;

    @Column(nullable = false, length = 255)
    @JsonIgnore
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> roles = new ArrayList<>();

    @Column(nullable = false, length = 40)
    private String company;

    @Column(unique = true)
    private String refreshToken;

    @Column(nullable = false, length = 1)
    private int loginFailCount;

}
