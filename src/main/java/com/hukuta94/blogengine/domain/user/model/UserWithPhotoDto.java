package com.hukuta94.blogengine.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class UserWithPhotoDto
{
    private int id;
    private String name;
    private String photo;
}
