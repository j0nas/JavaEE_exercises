package no.jenjon13.reeddit.ejb.impl;

import no.jenjon13.reeddit.data.entities.SiteUser;
import no.jenjon13.reeddit.ejb.abstracts.EntityEJB;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SiteUserEJB extends EntityEJB<SiteUser> {
    public SiteUserEJB() {
        super(SiteUser.class);
    }
    
    public SiteUser getByName(String name) {
        final Query query = entityManager.createQuery("SELECT SiteUser FROM SiteUser WHERE username LIKE :name");
        final Query parametrizedQuery = query.setParameter("name", name);
        return (SiteUser) parametrizedQuery.getSingleResult();
    }
}
