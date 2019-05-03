package com.dummy.myerp.testbusiness.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import com.dummy.myerp.technical.exception.NotFoundException;

import org.junit.Assert;
import org.junit.BeforeClass;

public class ComptabiliteManagerIntegrationTest extends BusinessTestCase{
	
	public static ComptabiliteManager cm;
	
	public static ComptabiliteDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		cm = SpringRegistry.getBusinessProxy().getComptabiliteManager();
		dao = SpringRegistry.getDaoProxy().getComptabiliteDao();
	}
	
	@Test
	public void testAddReferenceExisting() {
		Integer dernierValeure = null;
		Integer dernierValeureApresFonction = null;
		EcritureComptable ecritureComptable = null;
		
		try {
			SequenceEcritureComptable sequenceEcriture = dao.getSequenceEcritureComptable("AC", 2016);
			dernierValeure = sequenceEcriture.getDerniereValeur();
			
			List<EcritureComptable> listEcriture = cm.getListEcritureComptable();
			ecritureComptable = listEcriture.get(0);
			
			cm.addReference(ecritureComptable);
			
			SequenceEcritureComptable sequenceEcritureApresFonction = dao.getSequenceEcritureComptable("AC", 2016);
			dernierValeureApresFonction = sequenceEcritureApresFonction.getDerniereValeur();
			
		} catch (NotFoundException e) {			
		}
				
		Assert.assertTrue(dernierValeure+1 == dernierValeureApresFonction);
		Assert.assertTrue(ecritureComptable.getReference().equals("AC-2016/00041"));
	}
	
	@Test
	public void testAddReferenceNew() {
		EcritureComptable nouvelleEcritureComptable;
		nouvelleEcritureComptable = new EcritureComptable();
		nouvelleEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
		nouvelleEcritureComptable.setDate(new Date());
		nouvelleEcritureComptable.setLibelle("Libelle");
		nouvelleEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
		nouvelleEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
		Integer derniereValeur = null;
        cm.addReference(nouvelleEcritureComptable);
        
        try {
			SequenceEcritureComptable nouvelleSequenceEcriture = dao.getSequenceEcritureComptable("AC", 2019);
			
			derniereValeur = nouvelleSequenceEcriture.getDerniereValeur();
			
		} catch (NotFoundException e1) {
		}
        Assert.assertTrue(derniereValeur == 1);
        Assert.assertEquals(nouvelleEcritureComptable.getReference(), "AC-2019/00001");
	}
}
