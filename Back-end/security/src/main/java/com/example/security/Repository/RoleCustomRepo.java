package com.example.security.Repository;

import com.example.security.Entity.Account;
import com.example.security.Entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleCustomRepo {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Role> getRole(Account account){
        StringBuilder sql = new StringBuilder()
                .append("select r.name as name from account a join account_role ar on a.id = ar.account_id\n" +
                        "join role r on r.id = ar.roles_id");
        sql.append("Where 1=1 ");
        if(account.getUsername()!=null){
            sql.append("and username = :username");
        }
        NativeQuery<Role> query = ((Session) entityManager.getDelegate()).createNativeQuery(sql.toString());
        if(account.getUsername()!=null){
            query.setParameter("username",account.getUsername());
        }
        query.addScalar("name", StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(Role.class));
        return query.list();
    }
}
