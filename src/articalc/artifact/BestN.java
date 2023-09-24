package articalc.artifact;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;

public class BestN {
	Build build;
	CharacterBuilds cb;
	boolean usingCB;
	boolean future;
	Artifact[][] artifacts;
	Artifact[][] offArtifacts;
	float[][] values;
	float[][] offValues;
	boolean fresh;
	int offPiece;
	/**
	 * 
	 * @param num = 1
	 */
	public BestN(int num, Build build, boolean future) {
		num = 1;
		artifacts = new Artifact[5][num];
		offArtifacts = new Artifact[5][num];
		values = new float[5][num];
		offValues = new float[5][num];
		this.build = build;
		usingCB = false;
		this.future = future;
		fresh = true;
	}
	/**
	 * 
	 * @param num = 1
	 */
	public BestN(int num, CharacterBuilds build, boolean future) {
		num = 1;
		artifacts = new Artifact[5][num];
		offArtifacts = new Artifact[5][num];
		values = new float[5][num];
		offValues = new float[5][num];
		this.cb = build;
		usingCB = true;
		this.future = future;
		fresh = true;
	}
	
	public void addArtifact(Artifact art) {
		float newValue;
		float newOffValue;
		if (usingCB) {
			newValue = (future)? cb.getFutureValueUpdated(art): cb.getValueUpdated(art);
			newOffValue = (future)? cb.getFutureOffValueUpdated(art): cb.getOffValueUpdated(art);
		} else {
			newValue = (future)? build.getFutureValueUpdated(art, true): build.getValueUpdated(art);
			newOffValue = (future)? build.getFutureOffPieceValueUpdated(art, future):build.getOffPieceValueUpdated(art);
		}
		//On pieces
		if (newValue >= values[art.slot.ordinal()][values[art.slot.ordinal()].length - 1]) {
			Artifact [] artArray = artifacts[art.slot.ordinal()];
			float[] valueArray = values[art.slot.ordinal()];
			for (int i = 0; i < valueArray.length; i++) {
				if (newValue >= valueArray[i]) {
					float tempf = valueArray[i];
					Artifact tempa = artArray[i];
					valueArray[i] = newValue;
					artArray[i] = art;
					newValue = tempf;
					//art = tempa;
					fresh = false;
				}
			}
		}
		//Off pieces
		//TODO 
		if (newOffValue >= offValues[art.slot.ordinal()][offValues[art.slot.ordinal()].length - 1]) {
			Artifact [] artArray = offArtifacts[art.slot.ordinal()];
			float[] valueArray = offValues[art.slot.ordinal()];
			for (int i = 0; i < valueArray.length; i++) {
				if (newOffValue >= valueArray[i]) {
					float tempf = valueArray[i];
					Artifact tempa = artArray[i];
					valueArray[i] = newOffValue;
					artArray[i] = art;
					newOffValue = tempf;
					//art = tempa;
					fresh = false;
				}
			}
		}
	}
	
	private void findBest() {
		if (!fresh) {
			float maxDif = offValues[0][0] - values[0][0];
			offPiece = 0;
			for (int i = 1; i < 5; i++) {
				float tempDif = offValues[i][0] - values[i][0];
				if (tempDif > maxDif) {
					offPiece = i;
				}
			}
		}
		fresh = true;
	}
	
	@Override
	public String toString() {
		if (!fresh) {
			findBest();
		}
		String output = "[";
		output += System.lineSeparator();
		for (int i = 0; i < artifacts.length; i++) {
			for (int j = 0; j < artifacts[i].length; j++) {
				output += System.lineSeparator();
				if (offPiece == i) {
					output += String.format(" %.2f%c %s", offValues[i][j]*100f, '%', offArtifacts[i][j]);
				} else {
					output += String.format(" %.2f%c %s", values[i][j]*100f, '%', artifacts[i][j]);
				}
			}
			output += System.lineSeparator() + "-----------";
		}
		output += System.lineSeparator();
		return output + "]";
	}
	
	public void inUse(int i) {
		if (!fresh) {
			findBest();
		}
		for (int s = 0; s < 5; s++) {
			for (int j = 0; j < Math.min(i, artifacts[s].length); j++) {
				if (offPiece == s) {
				offArtifacts[s][j].inUse = true;
				} else {
				artifacts[s][j].inUse = true;
				}
			}
		}
	}
}
