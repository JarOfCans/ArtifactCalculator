package articalc.enums;

import articalc.brute.CharacterBuilds;
import articalc.builds.anemo.*;
import articalc.builds.cryo.*;
import articalc.builds.dendro.*;
import articalc.builds.electro.*;
import articalc.builds.geo.*;
import articalc.builds.hydro.*;
import articalc.builds.pyro.*;
import articalc.builds.other.*;

public enum Characters {
	Yae(new Yae(), 1f),
	Tighnari(new Tighnari(), 1f),
	Ganyu(new Ganyu(), 0.9f),
	Nahida(new Nahida(), 0.9f),
	Furina(new Furina(), 0.9f),
	Itto(new Itto(), 0.9f),
	Collei(new Collei(), 0.9f),
	Neuvillette(new Neuvillette(), 0.9f),
	Venti(new Venti(), 0.9f),
	Ei(new Ei(), 0.9f),
	HuTao(new HuTao(), 0.9f),
	Qiqi(new Qiqi(), 0.9f),
	Kazuha(new Kazuha(), 0.8f),
	Albedo(new Albedo(), 0.8f),
	Wanderer(new Wanderer(), 0.8f),
	Fischl(new Fischl(), 0.8f),
	Xingqui(new Xingqui(), 0.8f),
	Kokomi(new Kokomi(), 0.7f),
	Xiangling(new Xiangling(), 0.7f),
	Ayato(new Ayato(), 0.7f),
	Childe(new Childe(), 0.7f),
	Sucrose(new Sucrose(), 0.7f),
	Zhongli(new Zhongli(), 0.7f),
	Kuki(new Kuki(), 0.7f),
	Lynette(new Lynette(), 0.7f),
	Bennett(new Bennett(), 0.6f),
	Shenhe(new Shenhe(), 0.6f),
	Yoimiya(new Yoimiya(), 0.6f),
	Beidou(new Beidou(), 0.6f),
	Gorou(new Gorou(), 0.6f),
	Klee(new Klee(), 0.6f),
	Razor(new Razor(), 0.6f),
	Layla(new Layla(), 0.6f),
	Faruzan(new Faruzan(), 0.6f),
	YaoYao(new YaoYao(), 0.6f),
	Charlotte(new Charlotte(), 0.6f),
	Diona(new Diona(), 0.6f),
	Keqing(new Keqing(), 0.6f),
	Rosaria(new Rosaria(), 0.6f),
	Chongyun(new Chongyun(), 0.6f),
	Noelle(new Noelle(), 0.6f),
	Barbara(new Barbara(), 0.6f),
	Freminet(new Freminet()),
	Traveler(new MC()),
	YunJin(new YunJin()),
	Sara(new Sara()),
	Sayu(new Sayu()),
	Jean(new Jean()),
	Heizou(new Heizou()),
	Kaeya(new Kaeya()),
	Thoma(new Thoma()),
	Dehya(new Dehya()),
	Kirara(new Kirara()),
	Gaming(new Gaming()),
	Lisa(new Lisa()),
	Amber(new Amber()),
	Xinyan(new Xinyan()),
	Ningguang(new Ningguang()),
	Yanfei(new Yanfei()),
	Dori(new Dori()),
	Kaveh(new Kaveh()),
	Candace(new Candace()),
	Mika(new Mika()),
	Diluc(new Diluc()),
	Aloy(new Aloy()),
	Chevreuse(new Chevreuse()),
	Mona(new Mona(), 0.3f),
	Nilou(new Nilou(), 0.25f),
	Cyno(new Cyno(), 0.2f),
	Wriothesley(new Wriothesley(), 0.2f),
	Yelan(new Yelan(), 0.2f),
	Xianyun(new Xianyun(), 0.2f),
	Eula(new Eula(), 0.2f),
	Xiao(new Xiao(), 0.2f),
	Lyney(new Lyney(), 0.2f),
	Navia(new Navia(), 0.2f),
	Ayaka(new Ayaka(), 0.15f),
	Baizhu(new Baizhu(), 0.15f),
	Chiori(new Chiori(), 0.15f),
	Alhaitham(new Alhaitham(), 0.1f),
	;
	
	public CharacterBuilds cb;
	public float characterPriority;
	
	private Characters(CharacterBuilds cb, float pri) {
		this.cb = cb;
		this.characterPriority = pri;
		cb.Assign(this);
	}
	
	private Characters(CharacterBuilds cb) {
		this.cb = cb;
		this.characterPriority = 0.5f;
		cb.Assign(this);
	}
}
