package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import data.dataHelper.impl.RankSystemDataTxtHelper;

public class RankSystemDataHelperTest {

	RankSystemDataTxtHelper rsd = new RankSystemDataTxtHelper();
	
	@Test
	public void testupdateRank() {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(5, 100);
		assertEquals(rsd.updateRank(map),true);
	}
	
	@Test
	public void testgetRank() {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(5, 100);
		assertEquals(map,rsd.getRanks());
	}

}
