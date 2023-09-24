package articalc.enums;

import java.util.HashMap;

public enum Set {
	Adventurer("Adventurer", false),
	Lucky("LuckyDog", false),
	Doctor("TravelingDoctor", false),
	Sojourner("ResolutionOfSojourner", false),
	Miracle("TinyMiracle", false),
	Berserker("Berserker", false),
	Instructor("Instructor", false),
	Exile("TheExile", false),
	Defender("DefendersWill", false),
	Brave("BraveHeart", false),
	MartialArtist("MartialArtist", false),
	Gambler("Gambler", false),
	Scholar("Scholar", false),
	/**
	 * Resistance Circlets. Using Destiny. idk what to do about the others
	 */
	Prayers("PrayersForDestiny", false),
	Gladiator("GladiatorsFinale", Stat.ATKP, true),
	Wanderers("WanderersTroupe", Stat.EM, true),
	Noblesse("NoblesseOblige", Stat.Burst, true),
	Bloodstained("BloodstainedChivalry", Stat.Physical, true),
	Maiden("MaidenBeloved", Stat.HB, true),
	Viridescent("ViridescentVenerer", Stat.Anemo, true),
	ArchaicPetra("ArchaicPetra", Stat.Geo, true),
	Bolide("RetracingBolide", true),
	Thundersoother("Thundersoother", true),
	ThunderingFury("ThunderingFury", Stat.Electro, true),
	Lavawalker("Lavawalker", true),
	Crimson("CrimsonWitchOfFlames", Stat.Pyro, true),
	Blizzard("BlizzardStrayer", Stat.Cryo, true),
	HeartOfDepth("HeartOfDepth", Stat.Hydro, true),
	Tenacity("TenacityOfTheMillelith", Stat.HPP, true),
	Pale("PaleFlame", Stat.Physical, true),
	Shimenawa("ShimenawasReminiscence", Stat.ATKP, true),
	Emblem("EmblemOfSeveredFate", Stat.ER, true),
	Husk("HuskOfOpulentDreams", Stat.DEFP, true),
	OceanHued("OceanHuedClam", Stat.HB, true),
	Vermillion("VermillionHereafter", Stat.ATKP, true),
	Echoes("EchoesOfAnOffering", Stat.ATKP, true),
	Deepwood("DeepwoodMemories", Stat.Dendro, true),
	Gilded("GildedDreams", Stat.EM, true),
	DesertPavilion("DesertPavilionChronicle", Stat.Anemo, true),
	ParadiseLost("FlowerOfParadiseLost", Stat.EM, true),
	Nymph("NymphsDream", Stat.Hydro, true),
	Glow("VourukashasGlow", Stat.HPP, true)
	,Marechaussee("MarechausseeHunter", Stat.Normal, true)
	,Golden("GoldenTroupe", Stat.Skill, true)
	
	
	
	;

	public String key;
	public Stat set2pc;
	public boolean fiveStar;
	public Set coSet;
	public static HashMap<String, Set> setKey = new HashMap<String, Set>();
	

	Set(String key, Stat set2pc, boolean fiveStar) {
		this.key = key;
		this.set2pc = set2pc;
		this.fiveStar = fiveStar;
	}

	Set(String key, boolean fiveStar) {
		this.key = key;
		this.set2pc = null;
		this.fiveStar = fiveStar;
	}
	static
	{
		for (Set hoi: Set.values()) {
			setKey.put(hoi.key, hoi);
		}
	}
}
