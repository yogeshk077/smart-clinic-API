package com.smartclinic.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BaseDaoImpl {

    @Autowired
    private MongoTemplate mongoOperations;

    public BaseDaoImpl() {
    }

    public long generateSequence(String seqName) {
        DatabaseSequence counter = (DatabaseSequence)this.mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(seqName)), (new Update()).inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true), DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1L;
    }
}
