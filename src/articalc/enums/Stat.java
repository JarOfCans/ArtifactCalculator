package articalc.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public enum Stat {
	HP(.1364f, 298.75f, "hp", 508f),
	ATK(.1364f, 19.45f, "atk", 33f),
	DEF(.1364f, 23.15f, "def", 39f),
	HPP(.0909f, 5.83f, "hp_", 9.9f),
	ATKP(.0909f, 5.83f, "atk_", 9.9f),
	DEFP(.0909f, 7.29f, "def_", 12.4f),
	ER(.0909f, 6.48f, "enerRech_", 11f),
	EM(.0909f, 23.32f, "eleMas", 40f),
	Pyro("pyro_dmg_"),
	Electro("electro_dmg_"),
	Cryo("cryo_dmg_"),
	Hydro("hydro_dmg_"),
	Dendro("dendro_dmg_"),
	Anemo("anemo_dmg_"),
	Geo("geo_dmg_"),
	Physical("physical_dmg_"),
	CR(.0682f, 3.89f, "critRate_", 6.6f),
	CD(.0682f, 7.77f, "critDMG_", 13.2f),
	HB("heal_"),
	Burst("burst_dmg_"),
	Normal("normal_dmg_"),
	Skill("skill_dmg_"),
	NULL(null);
	
	public float subChance;
	public float subMax;
	public float twoSubs;
	public String key;
	public static HashMap<String, Stat> statKey = new HashMap<String, Stat>();
	public static ArrayList<Stat> subs() {
		ArrayList<Stat> output = new ArrayList<Stat>(Arrays.asList(new Stat[] {HP, ATK, DEF, HPP, ATKP, DEFP, ER, EM, CR, CD, NULL}));
		return output;
	}
	public static ArrayList<Stat> subsNotNULL() {
		ArrayList<Stat> output = new ArrayList<Stat>(Arrays.asList(new Stat[] {HP, ATK, DEF, HPP, ATKP, DEFP, ER, EM, CR, CD}));
		return output;
	}
	
	public static ArrayList<Stat> mains() {
		ArrayList<Stat> output = new ArrayList<Stat>(Arrays.asList(new Stat[] {HP,
				ATK,
				HPP,
				ATKP,
				DEFP,
				ER,
				EM,
				Pyro,
				Electro,
				Cryo,
				Hydro,
				Dendro,
				Anemo,
				Geo,
				Physical,
				CR,
				CD,
				HB}));
		return output;
	}
	
	Stat(String key) {
		subChance = 0f;
		subMax = 0f;
		this.key = key;
		twoSubs = 0f;
	}
	
	Stat(float subChance, float subMaxStat, String key, float twoSubs) {
		this.subChance = subChance;
		this.subMax = subMaxStat;
		this.key = key;
		this.twoSubs = twoSubs;
	}
	
	static
	{
		for (Stat hoi: Stat.values()) {
			statKey.put(hoi.key, hoi);
		}
	}
	
}
