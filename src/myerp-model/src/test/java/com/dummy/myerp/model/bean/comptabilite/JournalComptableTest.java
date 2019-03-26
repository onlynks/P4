package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JournalComptableTest {

	@Test
	public void testGetByCode() {
		JournalComptable journalComptable1 = new JournalComptable("j1", "journalComptable1");
		JournalComptable journalComptable2 = new JournalComptable("j2", "journalComptable2");
		JournalComptable journalComptable3 = null;
		
		List<JournalComptable> liste = new ArrayList<JournalComptable>();
		
		liste.add(journalComptable1);
		liste.add(journalComptable2);
		liste.add(journalComptable3);
		
		Assert.assertEquals(journalComptable2, JournalComptable.getByCode(liste, "j2"));
		Assert.assertEquals(null, JournalComptable.getByCode(liste, "j4"));
		Assert.assertNotEquals(journalComptable3, JournalComptable.getByCode(liste, "j2"));
	}

}
