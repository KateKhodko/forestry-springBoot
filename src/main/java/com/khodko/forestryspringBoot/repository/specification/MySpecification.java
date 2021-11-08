package com.khodko.forestryspringBoot.repository.specification;

import com.khodko.forestryspringBoot.entity.Forester;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MySpecification {
    public static Specification<Forester> hasFirstName(String firstname) {
        return new Specification<Forester>() {
            @Override
            public Predicate toPredicate(Root<Forester> forester, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.like(forester.get("firstname"), "%" + firstname + "%");
            }
        };
    }

    public static Specification<Forester> hasLastName(String lastname) {
        return (forester, cq, cb) -> cb.like(forester.get("lastname"), "%" + lastname + "%");
    }
}
