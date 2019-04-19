package com.dummy.myerp.testbusiness.business;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.technical.exception.NotFoundException;


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
    
    private static final DaoProxy CONSUMER_PROXY = SpringRegistry.getDaoProxy();


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
    
    public static DaoProxy getDaoProxy() {
        return CONSUMER_PROXY;
    }
   
    /*
    @Test
    public void test() {
    
    }
    */
}
