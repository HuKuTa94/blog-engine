package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.vote.entity.VoteEntity;

import java.util.Collection;

/**
 * Base parent service class for all /api/post/* requests.
 * This class contains util-methods required for child services.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

class PostService
{
    long getLikeCount( Collection<VoteEntity> votes ) {
        return votes.stream()
                .filter( vote -> vote.getValue() > 0 )
                .count();
    }

    long getDislikeCount( Collection<VoteEntity> votes ) {
        return votes.stream()
                .filter( vote -> vote.getValue() < 0 )
                .count();
    }

    int getPageIndex( int offset, int limit ) {
        return offset / limit;
    }
}
