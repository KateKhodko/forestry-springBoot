package com.khodko.forestryspringBoot.repository;

import com.khodko.forestryspringBoot.entity.Forester;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomRepositoryCustomImpl implements CustomRepository{

    private final EntityManager em;

    @Override
    public List<Forester> findByName(String firstname, String lastname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Forester> cq = cb.createQuery(Forester.class);

        Root<Forester> forester = cq.from(Forester.class);
        List<Predicate> predicates = new ArrayList<>();

        if (firstname != null) {
            predicates.add(cb.like(forester.get("first_name"), firstname));
        }
        if (lastname != null) {
            predicates.add(cb.like(forester.get("last_name"), lastname));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}
