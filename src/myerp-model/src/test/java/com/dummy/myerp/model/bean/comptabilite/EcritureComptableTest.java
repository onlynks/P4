package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class EcritureComptableTest {
	
	public static EcritureComptable Ecriture1;
	
	public static EcritureComptable Ecriture2;
	
	public static List<LigneEcritureComptable> listLigneEcriture = new ArrayList<>();

	@BeforeClass
	public static void setUpBeforeClass() {
		Ecriture1 = new EcritureComptable();
		
		
		Ecriture1.setLibelle("Equilibrée");
		Ecriture1.getListLigneEcriture().add(createLigne(1, "200.50", null));
		Ecriture1.getListLigneEcriture().add(createLigne(1, "100.50", "33"));
		Ecriture1.getListLigneEcriture().add(createLigne(2, null, "301"));
		Ecriture1.getListLigneEcriture().add(createLigne(2, "40", "7"));
		
		Ecriture2 = new EcritureComptable();
		
		Ecriture2.setLibelle("Non équilibrée");
		Ecriture2.getListLigneEcriture().add(createLigne(1, "10", null));
		Ecriture2.getListLigneEcriture().add(createLigne(1, "20", "1"));
		Ecriture2.getListLigneEcriture().add(createLigne(2, null, "30"));
		Ecriture2.getListLigneEcriture().add(createLigne(2, "1", "2"));		
	}
	
    private static LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
        BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
        BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
        String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
                                     .subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
        LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
                                                                    vLibelle,
                                                                    vDebit, vCredit);
        return vRetour;
    }

    @Test
    public void testIsEquilibree() {
       
        Assert.assertTrue(Ecriture1.toString(), Ecriture1.isEquilibree());

        Assert.assertFalse(Ecriture2.toString(), Ecriture2.isEquilibree());
    }
    
    @Test
    public void testGetTotalDebit(){
    	BigDecimal value1 = new BigDecimal("341.00");
    	
    	Assert.assertEquals(Ecriture1.getTotalDebit(), value1);
    	
    	BigDecimal value2 = new BigDecimal("31");
    	
    	Assert.assertEquals(Ecriture2.getTotalDebit(), value2);
    }
    
    @Test
    public void testGetTotalCredit(){
    	BigDecimal value1 = new BigDecimal("341");
    	
    	Assert.assertEquals(Ecriture1.getTotalCredit(), value1);
    	
    	BigDecimal value2 = new BigDecimal("33");
    	
    	Assert.assertEquals(Ecriture2.getTotalCredit(), value2);
    }
    
    

}
