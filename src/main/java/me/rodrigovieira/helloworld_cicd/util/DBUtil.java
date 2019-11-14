package me.rodrigovieira.helloworld_cicd.util;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named
public class DBUtil {

	private static final String DB_ALIVE_SELECT = "Select 1";
    private static final String DB_ALIVE_RESULT = "1";

    @Inject
    EntityManager entityManager;

	public boolean isAlive() {
		Query query = entityManager.createNativeQuery(DB_ALIVE_SELECT);
		String resultado = query.getSingleResult().toString();
		return DB_ALIVE_RESULT.equals(resultado);
	}
}
