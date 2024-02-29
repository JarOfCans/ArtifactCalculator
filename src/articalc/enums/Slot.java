package articalc.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import articalc.artifact.Artifact;

public enum Slot {
	flower("flower", 0),
	plume("plume", 1),
	sands("sands", 2),
	goblet("goblet", 3),
	circlet("circlet", 4);
	
	
	public String key;
	public int slot;
	public static HashMap<String, Slot> slotKey = new HashMap<String, Slot>();
	public ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

	Slot(String key, int slot) {
		this.key = key;
		this.slot = slot;
	}

	
	public static ArrayList<Stat> slotStats(Slot slot) {
		ArrayList<Stat> output;
		switch (slot) {
		case flower:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {Stat.HP}));
			break;
		case plume:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {Stat.ATK}));
			break;
		case sands:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {
					Stat.HPP,
					Stat.ATKP,
					Stat.DEFP,
					Stat.ER,
					Stat.EM}));
			break;
		case goblet:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {
					Stat.HPP,
					Stat.ATKP,
					Stat.DEFP,
					Stat.EM,
					Stat.Pyro,
					Stat.Electro,
					Stat.Cryo,
					Stat.Hydro,
					Stat.Dendro,
					Stat.Anemo,
					Stat.Geo,
					Stat.Physical}));
			break;
		case circlet:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {
					Stat.HPP,
					Stat.ATKP,
					Stat.DEFP,
					Stat.EM,
					Stat.CR,
					Stat.CD,
					Stat.HB}));
			break;
		default:
			output = new ArrayList<Stat>(Arrays.asList(new Stat[] {}));
		}
		return output;
	}
	
	public static float rarityMod(Slot slot, Stat stat) {
		ArrayList<Stat> output;
		switch (slot) {
		case flower:
		case plume:
			return .05f;
		case sands:
			switch (stat) {
			case ATKP:
				return .025f;
			case HPP:
			case DEFP:
				return .075f;
			case ER:
			case EM:
				return .0f;
			}
			return 0f;
		case goblet:
			switch (stat) {
			case HPP:
			case ATKP:
			case DEFP:
				return .075f;
			case EM:
			case Pyro:
			case Electro:
			case Cryo:
			case Hydro:
			case Dendro:
			case Anemo:
			case Geo:
			case Physical:
				return 0f;
			}
			return 0f;
		case circlet:
			switch (stat) {
			case HPP:
			case ATKP:
			case DEFP:
				return .075f;
			case EM:
				return 0f;
			case CR:
			case CD:
				return 0f;
			case HB:
				return 0.01f;
			}
			return 0f;
		default:
			return 0f;
		}
	}
	
	public static float getChance(Slot slot, Stat main) {
		switch (slot) {
		case flower:
		case plume:
			return 1f;
		case sands:
			switch (main) {
			case HPP:
				return .2668f;
			case DEFP:
			case ATKP:
				return .2666f;
			case EM:
			case ER:
				return .1f;
				default:
					return 0f;
			}
		case goblet:
			switch (main) {
			case HPP:
			case ATKP:
				return .1925f;
			case DEFP:
				return .19f;
			case EM:
				return .025f;
			case Pyro:
			case Electro:
			case Cryo:
			case Hydro:
			case Dendro:
			case Anemo:
			case Geo:
			case Physical:
				return .05f;
				default:
					return 0f;
			}
		case circlet:
			switch (main) {
			case HPP:
			case ATKP:
			case DEFP:
				return .22f;
			case EM:
				return .04f;
			case CR:
			case CD:
			case HB:
				return .1f;
				default:
					return 0f;
			}
		default:
			//How tf did we get here?
			return 0;
		}
	}
	
	static
	{
		for (Slot hoi: Slot.values()) {
			slotKey.put(hoi.key, hoi);
		}
	}
}
