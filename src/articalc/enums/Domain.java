package articalc.enums;

public enum Domain {
	
	Bosses(Set.Gladiator, Set.Wanderers, true),
	ClearPool(Set.Noblesse, Set.Bloodstained, true),
	ValleyRemembrance(Set.Maiden, Set.Viridescent, true),
	Guyun(Set.ArchaicPetra, Set.Bolide, true),
	MidsummerCourtyard(Set.Thundersoother, Set.ThunderingFury, true),
	HiddenPalace(Set.Lavawalker, Set.Crimson, true),
	VindagnyrPeak(Set.Blizzard, Set.HeartOfDepth, true),
	RidgeWatch(Set.Tenacity, Set.Pale, true),
	MomijiDyed(Set.Shimenawa, Set.Emblem, true),
	SlumberingCourt(Set.Husk, Set.OceanHued, true),
	LostValley(Set.Vermillion, Set.Echoes, true),
	SolitaryEnlightenment(Set.Deepwood, Set.Gilded, false),
	GoldCity(Set.DesertPavilion, Set.ParadiseLost, false),
	MoltenIron(Set.Glow, Set.Nymph, false),
	Denouement(Set.Marechaussee, Set.Golden, false);
	
	
	
	public Set set1;
	public Set set2;
	public boolean StrongBoxable;
	
	Domain(Set set1, Set set2, boolean StrongBox) {
		this.set1 = set1;
		this.set1.coSet = set2;
		//System.out.println(this.set1.coSet);
		this.set2 = set2;
		this.set2.coSet = set1;
		this.StrongBoxable = StrongBox;
	}
	
}
