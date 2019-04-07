package com.dummy.myerp.testbusiness.business;


import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;


/**
 * Classe mère des classes de test d'intégration de la couche Business
 */
public abstract class BusinessTestCase {

    static {
        SpringRegistry.init();
    }

    /** {@link BusinessProxy} */
    private static final BusinessProxy BUSINESS_PROXY = SpringRegistry.getBusinessProxy();
    /** {@link TransactionManager} */
    private static final TransactionManager TRANSACTION_MANAGER = SpringRegistry.getTransactionManager();


    // ==================== Constructeurs ====================
    /**
     * Constructeur.
     */
    public BusinessTestCase() {
    }


    // ==================== Getters/Setters ====================
    public static BusinessProxy getBusinessProxy() {
        return BUSINESS_PROXY;
    }

    public static TransactionManager getTransactionManager() {
        return TRANSACTION_MANAGER;
    }
   /*
    @Test
    public void testgetListCompteComptable() {
    	ComptabiliteManager comptabiliteManager = SpringRegistry.getBusinessProxy().getComptabiliteManager();
    	
    	List<EcritureComptable> testList = comptabiliteManager.getListEcritureComptable();
    	EcritureComptable ecriture = testList.get(1);
    	System.out.println(ecriture.toString());
    	try {
			comptabiliteManager.checkEcritureComptable(ecriture);
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
}
