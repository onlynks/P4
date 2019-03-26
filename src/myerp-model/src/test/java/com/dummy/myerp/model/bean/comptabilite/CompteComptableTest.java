package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CompteComptableTest {

	@Test
	public void testGetByNumero() {
		CompteComptable compteComptable1 = new CompteComptable(1, "compteComptable1");
		CompteComptable compteComptable2 = new CompteComptable(2, "compteComptable2");
		CompteComptable compteComptable3 = null;
		
		List<CompteComptable> liste = new ArrayList<CompteComptable>();
		
		liste.add(compteComptable1);
		liste.add(compteComptable2);
		liste.add(compteComptable3);
		
		Assert.assertEquals(compteComptable2, CompteComptable.getByNumero(liste, 2));
		Assert.assertEquals(null, CompteComptable.getByNumero(liste, 4));
		Assert.assertNotEquals(compteComptable3, CompteComptable.getByNumero(liste, 2));
	}

}
