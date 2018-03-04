package edu.tamu.jcabelloc.maintsystem.entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class IssueIdGenerator implements IdentifierGenerator {
	
	private static final String PREFIX = "I";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		
		String maxRecord=  (String) arg0.createNativeQuery("Select max(a.IssueCode) from Issue a").getResultList().get(0);
		int maxRecordInt = 0;
		if (maxRecord != null) {
			maxRecordInt = Integer.valueOf(maxRecord.substring(1));
		}
		return PREFIX + String.format("%03d", maxRecordInt + 1); 
	}

}
