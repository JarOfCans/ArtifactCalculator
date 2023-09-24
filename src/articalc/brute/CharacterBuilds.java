package articalc.brute;

import articalc.enums.*;
import articalc.enums.Characters;

import java.util.ArrayList;

import articalc.artifact.Artifact;
import articalc.character.*;

public abstract class CharacterBuilds {
	public ArrayList<Build> cb;
	public Characters character;
	
	public void Assign(Characters cha) {
		this.character = cha;
		cb = new ArrayList<Build>();
		assignBuilds(cb);
	}
	
	public abstract void assignBuilds(ArrayList<Build> cb);

	@Deprecated
	public float getValue(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getValue(art) * b.priority;
		}
		return value;
	}

	@Deprecated
	public float getFutureValue(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getFutureValue(art, true) * b.priority;
		}
		return value;
	}

	@Deprecated
	public float getOffValue(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getFutureOffPieceValue(art, true) * b.priority;
		}
		return value;
	}
	public float getValueUpdated(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getValueUpdated(art) * b.priority;
		}
		return value;
	}

	public float getFutureValueUpdated(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getFutureValueUpdated(art, true) * b.priority;
		}
		return value;
	}

	public float getOffValueUpdated(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getOffPieceValueUpdated(art) * b.priority;
		}
		return value;
	}

	public float getFutureOffValueUpdated(Artifact art) {
		float value = 0f;
		for (Build b: cb) {
			value += b.getFutureOffPieceValueUpdated(art, true) * b.priority;
		}
		return value;
	}
}
